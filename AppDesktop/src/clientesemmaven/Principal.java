/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesemmaven;

import edu.ifpb.dac.EnderecoUsuario;
import edu.ifpb.dac.Funcionario;
import edu.ifpb.dac.Prefeitura;
import edu.ifpb.dac.Usuario;
import ifpb.dac.service.Carrinho;
import ifpb.dac.service.DAOIT;
import ifpb.dac.service.FuncionarioServiceIT;
import ifpb.dac.service.PrefeituraServiceIT;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Ricardo Job
 */
public class Principal {


    public static void main(String[] args) {

        PrefeituraServiceIT pre = Conexoes.prefeituraService();
        FuncionarioServiceIT fun = Conexoes.funcionarioService();
        
        Prefeitura p = pre.pesquisarPorCodigo(302);
        Funcionario f = fun.buscarPorCPF("12345678");
        
//        p.getFuncionarios().size();
//        p.getFuncionarios().add(f);
                
        System.out.println(pre.vincular(p, f));
        

    }

}
