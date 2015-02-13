/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.service;

import edu.ifpb.dac.Cidade;
import edu.ifpb.dac.Denuncia;
import edu.ifpb.dac.EstadoDeAcompanhamento;
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
@Remote(DenunciaServiceIT.class)
public class DenunciaService implements DenunciaServiceIT{

    @PersistenceContext (unitName = "jdbc/projeto2dac")
    private EntityManager em; 
    
    @Override
    public List<Denuncia> pesquisarPorCidade(String cidade, String estado){
        Query query =  em.createQuery("SELECT d FROM Denuncia d WHERE d.cidade.CidadePK.nomeCidade = :cidade AND d.cidade.CidadePK.siglaEstado = :estado");
              query.setParameter("cidade", cidade);
              query.setParameter("estado", estado);
        
        List d = query.getResultList();
        
        if(d.size() > 0){
           return d;
        }         
        
        return null;
    }
    
    
    @Override
    public Denuncia pesquisarPorCodigo(int codigo, Cidade cidade){
        
        Query query = em.createQuery("SELECT d FROM Denuncia d WHERE d.id = :codigo AND d.cidade = :cidade");
              query.setParameter("codigo", codigo);
              query.setParameter("cidade", cidade);
        
        List<Denuncia> denuncias = query.getResultList();
              
        if (denuncias.size() > 0){
            return denuncias.get(0);
        }
        
        return null;
        
    }
    
    
    @Override
    public String atualizarAcompanhamento(int codigo, EstadoDeAcompanhamento acompanhamento, Cidade cidade){
        
        try {
            Denuncia d = pesquisarPorCodigo(codigo, cidade);

            d.setEstadoDeAcompanhamento(acompanhamento);

            em.merge(d);   
            
            return "Atualização realizada com sucesso.";
            
        } catch (Exception e) {
        }
        
        
        return "ERRO!";
        
    }    
    
}
