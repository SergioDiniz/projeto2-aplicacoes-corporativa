/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sergio Diniz
 */
@Stateless
@Remote(DAOIT.class)
public class DAO implements DAOIT{

    @PersistenceContext (unitName = "jdbc/projeto2dac")
    private EntityManager em;
    
    @Override
    public void salvar(Object object) {
        em.persist(object);
    }
    
}
