/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.service;

import edu.ifpb.dac.Funcionario;
import edu.ifpb.dac.Prefeitura;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sergio Diniz
 */
@Stateless
@Remote(PrefeituraServiceIT.class)
public class PrefeituraService implements PrefeituraServiceIT{

    @PersistenceContext (unitName = "jdbc/projeto2dac")
    private EntityManager em;      
    
    @Override
    public Prefeitura login(String email, String senha) {
        Query query =  em.createQuery("SELECT p FROM Prefeitura p WHERE p.email = :email AND p.senha = :senha ");
              query.setParameter("email", email);
              query.setParameter("senha", senha);
              
    
        List<Prefeitura> p = query.getResultList();
        
        if(p.size() > 0){
            p.get(0).getFuncionarios().size();
            return p.get(0);
        }

        return null;
    }

    @Override
    public Funcionario pesquisarFuncionario(Prefeitura prefeitura, String cpf) {
        Query query = em.createQuery("SELECT f FROM Prefeitura p JOIN p.funcionarios f WHERE p.email = :pEmail AND f.cpf = :fCpf");
              query.setParameter("pEmail", prefeitura.getEmail());
              query.setParameter("fCpf", cpf);
              
        List<Funcionario> pf = query.getResultList();        
        
        if (pf.size() > 0){
            pf.get(0).getPrefeituras().size();
            return  pf.get(0);
        }

        return null;
    }

    @Override
    public String cadastrarNaPrefeitura(Prefeitura prefeitura, Funcionario funcionario) {
        try {
            prefeitura.getFuncionarios().add(funcionario);
            em.merge(prefeitura);
            return "Cadastrado com Sucesso";
            
        } catch (Exception e) {
        }
        
        
        return "ERRO!";
    }

    @Override
    public String vincular(Prefeitura prefeitura, Funcionario funcionario) {
        
        Query query = em.createQuery("SELECT f FROM Prefeitura p JOIN p.funcionarios f WHERE p.email = :pEmail AND f.cpf = :fCpf");
              query.setParameter("pEmail", prefeitura.getEmail());
              query.setParameter("fCpf", funcionario.getCpf());
              
        List fs = query.getResultList();
        
        if (fs.size() > 0){
            return "Funcionario ja esta vinculado na prefeitura!";
        } else {
            cadastrarNaPrefeitura(prefeitura, funcionario);
            return "Vinculado com Sucesso!";
        }

//        return "ERRO!";
    }

    @Override
    public String desvincular(Prefeitura prefeitura, String cpf) {
        System.out.println(prefeitura.getNome() + " " + cpf);
        
        Funcionario funcionario = pesquisarFuncionario(prefeitura, cpf);
        
        
        if (funcionario != null){

                    prefeitura.getFuncionarios().remove(funcionario);
                    funcionario.getPrefeituras().remove(prefeitura);


                    em.merge(prefeitura);
                    em.merge(funcionario);


            return "Removido";

        } else {
            return "Funcionario não vinculado com a prefeitura.";
        }
              
//        return "ERRO!";
    }

    @Override
    public List<Prefeitura> prefeiturasPendentes() {
        Query query = em.createQuery("SELECT p from Prefeitura p WHERE p.ativo = false");
        List<Prefeitura> prefeituras = query.getResultList();
        
        if (prefeituras.size() > 0){
            return prefeituras;
        }
                
        return null;
    }

    @Override
    public Prefeitura pesquisarPorCodigo(int codigo) {
        Query query = em.createQuery("SELECT p from Prefeitura p WHERE p.id = :codigo");
              query.setParameter("codigo", codigo);
              
        List<Prefeitura> prefeituras = query.getResultList();
        
        if (prefeituras.size() > 0){
            prefeituras.get(0).getFuncionarios().size();
            return  prefeituras.get(0);
        }
        
        return null;
    }

    @Override
    public String atualizarSituacao(Prefeitura prefeitura, boolean situacao) {
        
        try {
        
            prefeitura.setAtivo(situacao);

            em.merge(prefeitura);

            return "Atualizado com Sucesso!";
            
        } catch (Exception e) {
        }
        
        return "ERRO!";
    }

    @Override
    public String excluir(Prefeitura prefeitura) {
        try {
            prefeitura.setFuncionarios(null);
            prefeitura.setCidade(null);

            em.remove(em.merge(prefeitura));
            
            return "Excluido com sucesso!";
            
        } catch (Exception e) {
        }
        
        
        
        return "ERRO!";
    }

    @Override
    public List<Prefeitura> todasPrefeituras() {
        Query query = em.createQuery("SELECT p FROM Prefeitura p WHERE p.ativo = true");
        
        List<Prefeitura> prefeituras = query.getResultList();
        
        if(prefeituras.size() > 0){
            return prefeituras;
        }
        
        return null;
    }

    @Override
    public Prefeitura atualizarObjPrefeitura(Prefeitura prefeitura) {
        em.refresh(em.merge(prefeitura));
        
        return prefeitura;
    }

    @Override
    public List<Funcionario> funcionarios(Prefeitura prefeitura) {
        Query query = em.createQuery("SELECT f FROM Prefeitura p JOIN p.funcionarios f WHERE p.id = :id");
        query.setParameter("id", prefeitura.getId());
        
        return query.getResultList();
        
    }
    
}
