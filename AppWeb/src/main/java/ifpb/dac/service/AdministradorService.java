/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.service;

import edu.ifpb.dac.Administrador;
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
@Remote(AdministradorServiceIT.class)
public class AdministradorService implements AdministradorServiceIT{

    @PersistenceContext (unitName = "jdbc/projeto2dac")
    private EntityManager em;        
    
    @Override
    public Administrador login(String email, String senha) {
        Query query =  em.createQuery("SELECT a FROM Administrador a WHERE a.email = :email AND a.senha = :senha ");
              query.setParameter("email", email);
              query.setParameter("senha", senha);
        
        List<Administrador> a = query.getResultList();
        
        if(a.size() > 0){
           return a.get(0);
        } 
        
        return null;        
    }
    
}
