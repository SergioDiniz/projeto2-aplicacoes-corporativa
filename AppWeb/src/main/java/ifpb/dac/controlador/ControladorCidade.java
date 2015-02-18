/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.controlador;

import edu.ifpb.dac.Cidade;
import edu.ifpb.dac.CidadePK;
import ifpb.dac.service.DAOIT;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Sergio Diniz
 */
@ManagedBean(name = "controladorCidade")
@SessionScoped
public class ControladorCidade implements Serializable{
    
    CidadePK cidadePK;
    
    Cidade cidade;
    
    @EJB
    private DAOIT dao;

    public ControladorCidade() {
        cidadePK = new CidadePK();
        cidade = new Cidade();
    }

    
    public String add(){
        cidade.setCidadePK(cidadePK);
        dao.salvar(cidade);
        cidade = new Cidade();
        cidadePK = new CidadePK();
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    public CidadePK getCidadePK() {
        return cidadePK;
    }

    public void setCidadePK(CidadePK cidadePK) {
        this.cidadePK = cidadePK;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
    
}
