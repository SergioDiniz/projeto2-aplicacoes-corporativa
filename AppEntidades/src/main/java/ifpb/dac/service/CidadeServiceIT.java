/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.service;

import edu.ifpb.dac.Cidade;

/**
 *
 * @author Sergio Diniz
 */
public interface CidadeServiceIT {
    
    public Cidade pesquisarCidade(String nome, String estado);
    
    public Cidade atualizarObjCidade(Cidade cidade);
    
}
