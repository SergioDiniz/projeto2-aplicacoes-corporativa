/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.controlador;

import edu.ifpb.dac.Funcionario;
import ifpb.dac.service.DAOIT;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Sergio Diniz
 */
@ManagedBean(name = "controladorFuncionario")
@SessionScoped
public class ControladorFuncionario implements Serializable{

    Funcionario funcionario;
    
    @EJB
    private DAOIT dao;
    
    public ControladorFuncionario() {
        funcionario = new Funcionario();
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
    
    
    
    
    
    
    
    
    
    
}
