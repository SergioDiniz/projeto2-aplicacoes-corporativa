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
import ifpb.dac.service.PrefeituraServiceIT;
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
            return "sis/ambiente/prefeitura/inicio.jsf";
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
        //Redireciona o usuário para tela de login efetuando o logout.  
        String loginPage = "/index.jsf";
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) context.getRequest();
        HttpSession session = (HttpSession) context.getSession(false);
        session.invalidate();
        try {
            context.redirect(request.getContextPath() + loginPage);
        } catch (IOException e) {
            //logger.error("Erro ao tentar redirecionar para página solicitada ao efetuar Logout: " + e.toString());  
        }

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
