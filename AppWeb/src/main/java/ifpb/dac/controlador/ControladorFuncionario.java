/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.controlador;

import edu.ifpb.dac.Cidade;
import edu.ifpb.dac.CidadePK;
import edu.ifpb.dac.Denuncia;
import edu.ifpb.dac.EstadoDeAcompanhamento;
import edu.ifpb.dac.Funcionario;
import ifpb.dac.service.CidadeServiceIT;
import ifpb.dac.service.DAOIT;
import ifpb.dac.service.DenunciaServiceIT;
import ifpb.dac.service.FuncionarioServiceIT;
import java.io.IOException;
import java.io.Serializable;
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
@ManagedBean(name = "controladorFuncionario")
@SessionScoped
public class ControladorFuncionario implements Serializable{

    Funcionario funcionario;
    Cidade cidade;
    CidadePK cidadePK;
    Denuncia denuncia;
    EstadoDeAcompanhamento estadoDeAcompanhamento;
    
    
    @EJB
    private DAOIT dao;
    
    @EJB
    private FuncionarioServiceIT fs;
    
    @EJB
    private CidadeServiceIT cs;
    
    @EJB
    private DenunciaServiceIT ds;
    
    public ControladorFuncionario() {
        funcionario = new Funcionario();
        cidade = new Cidade();
        cidadePK = new CidadePK();
        denuncia = new Denuncia();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    public String add(){
        dao.salvar(funcionario);
        funcionario = new Funcionario();
        return null;
    }
    
    public String login(){
        this.funcionario = fs.login(funcionario.getEmail(), funcionario.getSenha(), 
                cidadePK.getNomeCidade(), cidadePK.getSiglaEstado());
        
        
        if(funcionario != null){
            
            this.cidade = cs.pesquisarCidade(cidadePK.getNomeCidade(), cidadePK.getSiglaEstado());
            
            return "/sis/ambiente/funcionario/inicio.jsf?faces-redirect=true";
        } else {
            cidadePK = new CidadePK();
            return null;
        }
        
    }
    
    public String atualizar(){
        dao.atualizar(funcionario);
        
        return null;
    }
    
    
    public String atualizarDenuncia(Denuncia d){
        this.denuncia = d;
        return "atualizar.jsf";
    }
    
    public String atualizarSituacaoDaDenuncia(){
        denuncia.setEstadoDeAcompanhamento(estadoDeAcompanhamento);
        
        ds.atualizarAcompanhamento(denuncia.getId(), estadoDeAcompanhamento, cidade);
        
        return null;
    }

    public String logout() {
        this.funcionario = new Funcionario();
        this.cidadePK = new CidadePK();
        return "/index.jsf?faces-redirect=true";
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

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public EstadoDeAcompanhamento getEstadoDeAcompanhamento() {
        return estadoDeAcompanhamento;
    }

    public void setEstadoDeAcompanhamento(EstadoDeAcompanhamento estadoDeAcompanhamento) {
        this.estadoDeAcompanhamento = estadoDeAcompanhamento;
    }
    
    
    
    
    
    
    
    
    
    
}
