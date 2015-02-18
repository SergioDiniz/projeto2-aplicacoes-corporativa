/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import edu.ifpb.dac.Cidade;
import edu.ifpb.dac.CidadePK;
import edu.ifpb.dac.Prefeitura;
import ifpb.dac.service.CidadeServiceIT;
import ifpb.dac.service.DAOIT;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Sergio Diniz
 */
@ManagedBean (name = "controladorPrefeitura")
@SessionScoped
public class ControladorPrefeitura implements Serializable{
    
    Cidade cidade;
    CidadePK  cidadePK;
    Prefeitura prefeitura;
    
    @EJB
    private DAOIT dao;
    
    @EJB
    private CidadeServiceIT cs;

    public ControladorPrefeitura() {
        cidade = new Cidade();
        cidadePK = new CidadePK();
        prefeitura = new Prefeitura();
    }
    
    public String add(){


        try {
            cidade.setCidadePK(cidadePK);
            dao.salvar(cidade);
            cidade = cs.pesquisarCidade(cidadePK.getNomeCidade(), cidadePK.getSiglaEstado());
        } catch (Exception e) {
        }
        
        
        prefeitura.setCidade(cidade);
        
        dao.atualizar(prefeitura);
        
        cidade = new Cidade();
        cidadePK = new CidadePK();
        prefeitura = new Prefeitura();        
        
        return null;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public CidadePK getCidadePK() {
        return cidadePK;
    }

    public void setCidadePK(CidadePK cidadePK) {
        this.cidadePK = cidadePK;
    }

    public Prefeitura getPrefeitura() {
        return prefeitura;
    }

    public void setPrefeitura(Prefeitura prefeitura) {
        this.prefeitura = prefeitura;
    }
    
    
    
    
    
}
