package ifpb.dac.controlador;

import ifpb.dac.queue.Consumidor;
import ifpb.dac.queue.Produtor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;

/**
 *
 * @author Fatinha de Sousa
 */

@JMSDestinationDefinition(
        name = "java:global/jms/demoQueue",
        interfaceName = "javax.jms.Queue"
)
@JMSConnectionFactoryDefinition(
        name = "java:global/jms/demoConnectionFactory"
)

@Named(value = "controladorQueue")
@SessionScoped
public class ControladorQueue implements Serializable {

    private String mensagem = "1";

    @EJB
    private Produtor destino;

    @EJB
    private Consumidor leitor;

    public ControladorQueue() {
    }
    
    public String enviar() throws JMSException {
        destino.enviaMensagem(mensagem);
        mensagem = "";
        return null;
    }

    public String recebendoMensagem() throws JMSException {
        return leitor.recebeMessagem();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
