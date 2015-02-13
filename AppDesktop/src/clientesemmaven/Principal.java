/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesemmaven;

import edu.ifpb.dac.EnderecoUsuario;
import edu.ifpb.dac.Usuario;
import ifpb.dac.service.Carrinho;
import ifpb.dac.service.DAOIT;
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

    private static final String DAO = "java:global/AppWeb/DAO";

    public static void main(String[] args) {

        ServiceLocator service = new ServiceLocator();
        DAOIT dao = service.lookup(DAO, DAOIT.class);        
        
        EnderecoUsuario eu = new EnderecoUsuario("pb", "santa helena");
        Usuario u = new Usuario(eu, "pepi", "bcvbcvb", "lerolero");
        

        
        dao.salvar(u);
        

    }

}
