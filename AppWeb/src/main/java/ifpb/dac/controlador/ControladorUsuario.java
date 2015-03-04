package ifpb.dac.controlador;

import edu.ifpb.dac.Cidade;
import edu.ifpb.dac.CidadePK;
import edu.ifpb.dac.Denuncia;
import edu.ifpb.dac.EnderecoDenuncia;
import edu.ifpb.dac.EnderecoUsuario;
import edu.ifpb.dac.Usuario;
import ifpb.dac.queue.Consumidor;
import ifpb.dac.queue.Produtor;
import ifpb.dac.service.Carrinho;
import ifpb.dac.service.DAOIT;
import ifpb.dac.service.DenunciaServiceIT;
import ifpb.dac.service.UsuarioServiceIT;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo Job
 */
@ManagedBean(name = "controladorUsuario")
@SessionScoped
public class ControladorUsuario implements Serializable {
   
    Usuario usuario;
    EnderecoUsuario eu;
    Cidade cidade;
    CidadePK cidadePK;
    Denuncia denuncia;
    EnderecoDenuncia ed;
    String cid;
    String est;    
    boolean resultadoPesquisa;
    
    
    @EJB
    private DAOIT dao;
    
    @EJB
    private UsuarioServiceIT us;
    
    @EJB
    private DenunciaServiceIT ds;
    
    
    @Inject
    ControladorQueue cq;
    
    public ControladorUsuario() {
        usuario = new Usuario();
        eu = new EnderecoUsuario();
        cidade = new Cidade();
        cidadePK = new CidadePK();
        denuncia = new Denuncia();
        ed = new EnderecoDenuncia();
        resultadoPesquisa = false;
        cid = "";
        est = "";
    }
    

    public String add(){
        usuario.setEndereco(eu);
        dao.salvar(usuario);
        usuario = new Usuario();
        eu = new EnderecoUsuario();
        return "/index.jsf?faces-redirect=true";
    }
    
    
    public String login() throws JMSException{
        this.usuario = us.login(usuario.getEmail(), usuario.getSenha());
        if (usuario != null){
            cq.setMensagem("1");
            return "/sis/ambiente/usuario/inicio.jsf?faces-redirect=true";
//            FacesContext.getCurrentInstance().getExternalContext().redirect(null);
        } else {
            loginErro();
            usuario = new Usuario();
            return null;
        }
        
    }
    
    
    public List<Denuncia> pesquisarCidade(){
        return ds.pesquisarPorCidade(cid, est);
    }
    
    public void resultadoPesquisa(){
        resultadoPesquisa = true;
    }
    
    public String novaDenuncia(){
        String resultado = us.novaDenuncia(usuario, cidadePK.getNomeCidade(), cidadePK.getSiglaEstado(), 
                   ed.getRua(), String.valueOf(ed.getNumero()), ed.getBairro(), denuncia.getDescricao());
        
        cidadePK = new CidadePK();
        ed = new EnderecoDenuncia();
        denuncia = new Denuncia();
        
        usuario.getDenuncias().add(denuncia);
        
        return "denunciasrealizadas.jsf" ;
    }
    
    
    public List<Denuncia> minhasDenuncias(){
        return us.minhasDenuncias(usuario.getEmail());
    }
    
    
    public String atualizar(){
        dao.atualizar(usuario);
        
        return null;
    }
    
    public String excluirConta(){
        us.excluir(usuario);
        
        logout();
        
        return "/index.jsf?faces-redirect=true";
    }
    
    public String logout(){
        this.usuario = new Usuario();
        this.eu = new EnderecoUsuario();
        this.cidade = new Cidade();
        this.cidadePK = new CidadePK();
        this.denuncia = new Denuncia();
        this.ed = new EnderecoDenuncia();
        this.resultadoPesquisa = false;
        this.cid = "";
        this.est = "";
        return "/index.jsf?faces-redirect=true";
    }
    
    public void mostrapagina() throws IOException{
        if(usuario.getEmail() == null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("../../../index.jsf");
        }
        
    }
    
    
    
    public String mensagemLogin() throws JMSException{
        return cq.recebendoMensagem();
    }
    
    public String loginErro() throws JMSException{
        cq.setMensagem("2");
        cq.enviar();
        return null;
    }
    
    
    

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

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public EnderecoDenuncia getEd() {
        return ed;
    }

    public void setEd(EnderecoDenuncia ed) {
        this.ed = ed;
    }
    

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public boolean isResultadoPesquisa() {
        return resultadoPesquisa;
    }

    public void setResultadoPesquisa(boolean resultadoPesquisa) {
        this.resultadoPesquisa = resultadoPesquisa;
    }
    
    
}
