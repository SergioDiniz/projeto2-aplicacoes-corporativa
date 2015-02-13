/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.service;

import edu.ifpb.dac.Cidade;
import edu.ifpb.dac.CidadePK;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sergio Diniz
 */
@Stateless
@Remote(CidadeServiceIT.class)
public class CidadeService implements CidadeServiceIT{

    @PersistenceContext (unitName = "jdbc/projeto2dac")
    private EntityManager em;    
    
    
    @Override
    public Cidade pesquisarCidade(String nome, String estado) {
        CidadePK cidadePK = new CidadePK(nome, estado);
        return em.find(Cidade.class, cidadePK);
    }

    @Override
    public Cidade atualizarObjCidade(Cidade cidade) {
        em.refresh(em.merge(cidade));
        
        return cidade;
    }
    
}
