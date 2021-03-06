/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import edu.ifpb.dac.Cidade;
import edu.ifpb.dac.CidadePK;
import edu.ifpb.dac.Denuncia;
import edu.ifpb.dac.Funcionario;
import edu.ifpb.dac.Prefeitura;
import ifpb.dac.service.CidadeServiceIT;
import ifpb.dac.service.DAOIT;
import ifpb.dac.service.DenunciaServiceIT;
import ifpb.dac.service.FuncionarioServiceIT;
import ifpb.dac.service.PrefeituraServiceIT;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
    Funcionario funcionario;
    boolean funcionarioCadastrado;
    boolean funcionarioVinculado;
    boolean funcionarioNovo;
    String CPFPesquisaF;

    
    
    @EJB
    private DAOIT dao;
    
    @EJB
    private CidadeServiceIT cs;
    
    @EJB
    private PrefeituraServiceIT ps;
    
    @EJB
    private FuncionarioServiceIT fs;
    
    public ControladorPrefeitura() {
        cidade = new Cidade();
        cidadePK = new CidadePK();
        prefeitura = new Prefeitura();
        funcionarioCadastrado = false;
        funcionarioNovo = false;
        funcionarioVinculado = false;
        CPFPesquisaF = "";
        funcionario = new Funcionario();
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
        
        return "/index.jsf?faces-redirect=true";
    }

    
    public String login(){
        this.prefeitura = ps.login(prefeitura.getEmail(), prefeitura.getSenha());
        
        if(this.prefeitura != null){
            
            if(prefeitura.isAtivo() == true){
                return "/sis/ambiente/prefeitura/inicio.jsf?faces-redirect=true";
            }
            
            return null;
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
        this.cidade = new Cidade();
        this.cidadePK = new CidadePK();
        this.prefeitura = new Prefeitura();
        this.funcionarioCadastrado = false;
        this.funcionarioNovo = false;
        this.funcionarioVinculado = false;
        this.CPFPesquisaF = "";
        this.funcionario = new Funcionario();
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
    

    public void pesquisarCPFFuncionario(){
        
        Funcionario f = fs.buscarPorCPF(CPFPesquisaF);
        
        if(f != null){
            funcionarioNovo = false;
            funcionarioCadastrado = true;
        } else{
            funcionarioNovo = true;
            funcionarioCadastrado = false;
        }
        
        
        
    }
    
    public List<Funcionario> funcionarioPesquisaCPF(){
        List<Funcionario> fus = new ArrayList<>();
        fus.add(fs.buscarPorCPF(CPFPesquisaF));
        return fus;
    }
    
    
    public String vincularFuncionario(){
        Funcionario f = fs.buscarPorCPF(CPFPesquisaF);
        ps.vincular(prefeitura, f);
        prefeitura.getFuncionarios().add(f);
        return "funcionarios.jsf";
    }
    
    
    
    public String cadastrarNovoFuncionario(){
        funcionario.setCpf(CPFPesquisaF);
        dao.salvar(funcionario);
        funcionario = fs.buscarPorCPF(CPFPesquisaF);
        ps.cadastrarNaPrefeitura(prefeitura, funcionario);
        
        prefeitura.getFuncionarios().add(funcionario);
        
        funcionario = new Funcionario();
        CPFPesquisaF = "";
        return "funcionarios.jsf";
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

    public boolean isFuncionarioCadastrado() {
        return funcionarioCadastrado;
    }

    public void setFuncionarioCadastrado(boolean funcionarioCadastrado) {
        this.funcionarioCadastrado = funcionarioCadastrado;
    }

    public boolean isFuncionarioVinculado() {
        return funcionarioVinculado;
    }

    public void setFuncionarioVinculado(boolean funcionarioVinculado) {
        this.funcionarioVinculado = funcionarioVinculado;
    }

    public boolean isFuncionarioNovo() {
        return funcionarioNovo;
    }

    public void setFuncionarioNovo(boolean funcionarioNovo) {
        this.funcionarioNovo = funcionarioNovo;
    }

    public String getCPFPesquisaF() {
        return CPFPesquisaF;
    }

    public void setCPFPesquisaF(String CPFPesquisaF) {
        this.CPFPesquisaF = CPFPesquisaF;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
    
    
    
    
    
    
}
