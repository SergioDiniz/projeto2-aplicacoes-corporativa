/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.queue;


import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

/**
 *
 * @author Sergio Diniz
 */
@Stateless
@LocalBean
public class Produtor {
    
    @Inject
    private JMSContext context;
    
    @Resource(lookup = "java:global/jms/demoQueue")
    Queue canalDeDestino;
    
    public void enviaMensagem(String msg) throws JMSException{
        
        Message message = context.createTextMessage(msg);
        message.setStringProperty("MessageFormat", "Version 3.4");
        context.createProducer().send(canalDeDestino, message);
        
    }
}
