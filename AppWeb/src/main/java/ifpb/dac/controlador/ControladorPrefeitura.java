/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import edu.ifpb.dac.Cidade;
import edu.ifpb.dac.CidadePK;
import edu.ifpb.dac.Funcionario;
import edu.ifpb.dac.Prefeitura;
import ifpb.dac.service.CidadeServiceIT;
import ifpb.dac.service.DAOIT;
import ifpb.dac.service.PrefeituraServiceIT;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    
    @EJB
    private PrefeituraServiceIT ps;

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

    
    public String login(){
        this.prefeitura = ps.login(prefeitura.getEmail(), prefeitura.getSenha());
        
        if(this.prefeitura != null){
            return "/sis/ambiente/prefeitura/inicio.jsf?faces-redirect=true";
        } else {
            this.prefeitura = new Prefeitura();
            
            return null;
        }
        
    }
    
    public String atualizar(){
        dao.atualizar(prefeitura);
        return null;
    }
    
    public String excluirConta(){
        
        ps.excluir(prefeitura);
        
        logout();
        
        return null;
    }
    
    
    public String logout() {
        this.prefeitura = new Prefeitura();
        return "/index.jsf?faces-redirect=true";
    }    
    
    
    
    public String desvincularFuncionario(Funcionario f){
        ps.desvincular(this.prefeitura, f.getCpf());
        this.prefeitura.getFuncionarios().remove(f);
        return null;
    }
    
    
    public List<Funcionario> funcionarios(){
        return ps.funcionarios(this.prefeitura);
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
