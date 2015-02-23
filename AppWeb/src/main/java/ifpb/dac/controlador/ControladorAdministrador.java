/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.controlador;

import edu.ifpb.dac.Administrador;
import edu.ifpb.dac.Prefeitura;
import ifpb.dac.service.AdministradorServiceIT;
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
@ManagedBean(name = "controladorAdministrador")
@SessionScoped
public class ControladorAdministrador implements Serializable{

    Administrador administrador;
    
    @EJB
    private AdministradorServiceIT ad;
    
    @EJB
    private DAOIT dao;
    
    @EJB
    private PrefeituraServiceIT ps;
    
    public ControladorAdministrador() {
        this.administrador = new Administrador();
    }
    
    
    public String login(){
        this.administrador = ad.login(administrador.getEmail(), administrador.getSenha());
        
        if(administrador != null){
            return "/sis/ambiente/admin/inicio.jsf?faces-redirect=true";
        } else{
            this.administrador = new Administrador();
            return null;
        }
        
    }
    
    
    public String atualizar(){
        dao.atualizar(this.administrador);
        return null;
    }
    
    
    public List<Prefeitura> prefeiturasPendentes(){
        return ps.prefeiturasPendentes();
    }
    
    public List<Prefeitura> prefeiturasAtivas(){
        return ps.todasPrefeituras();
    }    
    
    public String atualizarSituacao(Prefeitura p, String s){
        boolean situacao;
        System.out.println(s);
        
        if("inativo".compareToIgnoreCase(s) == 0){
            situacao = false;
        }else{
            situacao = true;
        }
        
        ps.atualizarSituacao(p, situacao);
        return null;
    }
    
    public String excluirPrefeitura(Prefeitura p){
        ps.excluir(p);
        return null;
    }
    
    
    public String logout() {
        this.administrador = new Administrador();
        return "/index.jsf?faces-redirect=true";
    }    

    
    
    
    
    
    
    
    
    
    
    
    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
}
