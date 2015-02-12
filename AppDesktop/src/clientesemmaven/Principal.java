/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesemmaven;

import ifpb.dac.service.Carrinho;
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

    private static final String CARRINHO = "java:global/AppWeb/CarrinhoDeCompra";

    public static void main(String[] args) {

        ServiceLocator service = new ServiceLocator();
        Carrinho carrinho = service.lookup(CARRINHO, Carrinho.class);
        carrinho.add("Primeira instrução");
        carrinho.add("Segunda instrução");
        carrinho.finalizar();

        //Capturando uma nova instância
        carrinho = service.lookup(CARRINHO, Carrinho.class);
        carrinho.add("Terceira instrução");
        carrinho.finalizar();

    }

}
