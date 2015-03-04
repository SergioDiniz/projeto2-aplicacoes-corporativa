/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.queue;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;

/**
 *
 * @author Sergio Diniz
 */
@Stateless
@LocalBean
public class Consumidor {
    
    @Inject
    @JMSConnectionFactory("java:global/jms/demoConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "java:global/jms/demoQueue")
    Queue canalDeComunicacao;
    
    public String recebeMessagem() throws JMSException {

        JMSConsumer consumer = context.createConsumer(canalDeComunicacao);
        String msg = consumer.receiveBody(String.class, 1000);
//        System.out.println("Message do Navegador: " + msg);

        String retorno = "";
        
        if (msg != null) {
            if (msg.equals("1")) {
                retorno = "";
            }else{
                retorno = "Erro ao efetuar login";
            }
        } 
        
        return retorno;
    }    
    
}
