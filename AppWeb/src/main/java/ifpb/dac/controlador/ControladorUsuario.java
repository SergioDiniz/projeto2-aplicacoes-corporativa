package ifpb.dac.controlador;

import edu.ifpb.dac.EnderecoUsuario;
import edu.ifpb.dac.Usuario;
import ifpb.dac.service.Carrinho;
import ifpb.dac.service.DAOIT;
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
 * @author Ricardo Job
 */
@ManagedBean(name = "controlador")
@SessionScoped
public class ControladorUsuario implements Serializable {
   
    Usuario usuario;
    EnderecoUsuario eu;
    
    @EJB
    private DAOIT dao;

    public ControladorUsuario() {
        usuario = new Usuario();
        eu = new EnderecoUsuario();
    }
    

    public String add(){
        usuario.setEndereco(eu);
        dao.salvar(usuario);
        usuario = new Usuario();
        return null;
    }
    
    
    
    
    /*
    private String produto;

    @EJB
    private Carrinho carrinho;    

    public String add() {
        carrinho.add(produto);
        produto = new String();
        return null;
    }

    public String finalizar() {
        carrinho.finalizar();
        logout();
        return null;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
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
*/

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EnderecoUsuario getEu() {
        return eu;
    }

    public void setEu(EnderecoUsuario eu) {
        this.eu = eu;
    }
    
    
    
}
