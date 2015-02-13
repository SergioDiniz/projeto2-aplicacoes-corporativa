/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.service;

import edu.ifpb.dac.*;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sergio Diniz
 */
@Stateless
@Remote(UsuarioServiceIT.class)
public class UsuarioService implements UsuarioServiceIT{
    
    @PersistenceContext (unitName = "jdbc/projeto2dac")
    private EntityManager em;          
    
    @Override
    public Usuario login(String email, String senha){
        
        Query query =  em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha ");
              query.setParameter("email", email);
              query.setParameter("senha", senha);
        
        List<Usuario> u = query.getResultList();
        
        if(u.size() > 0){
           return u.get(0);
        } 
        
        return null;
        
    }
    
    
    @Override
    public String novaDenuncia(Usuario usuario, String cidade, String estado, String rua, 
                                String numeroS, String bairro, String descricao){
        int numero = Integer.parseInt(numeroS);
        
        
        try {
            
            EnderecoDenuncia ed = new EnderecoDenuncia(bairro, numero, rua);
            CidadePK cpk = new CidadePK(cidade, estado);
            Cidade c = new Cidade(cpk);
            Denuncia d = new Denuncia(descricao, ed, c);
            
            usuario.novaDenuncia(d);
            
            em.persist(ed);
            em.persist(d);
            em.merge(usuario);
            
            
            
            
            
            return "ok";
        } catch (Exception e) {
        }
        
        
        return "ERRO";
    }
    
    
    @Override
    public List<Denuncia> minhasDenuncias(String email){
        
        Query query = em.createQuery("SELECT d from Usuario u JOIN u.denuncias d WHERE u.email = :email");
              query.setParameter("email", email);
        
        List<Denuncia> d = query.getResultList();
        
        if(d.size() > 0){
            return d;
        }
        
        return null;
        
    }
    
    public String excluir(Usuario usuario){
        
        try {
            usuario.setDenuncias(null);
        
            em.remove(em.merge(usuario));
            return "Removido com sucesso!";
        } catch (Exception e) {
        }

        
        
        return "ERRO!";
    }    
    
    
}
