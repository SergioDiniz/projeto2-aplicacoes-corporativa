/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.service;

import edu.ifpb.dac.Funcionario;
import edu.ifpb.dac.Prefeitura;
import java.util.List;

/**
 *
 * @author Sergio Diniz
 */
public interface PrefeituraServiceIT {
    
    public Prefeitura login(String email, String senha);
    
    public Funcionario pesquisarFuncionario(Prefeitura prefeitura, String cpf);
    
    public String cadastrarNaPrefeitura(Prefeitura prefeitura, Funcionario funcionario);
    
    public String vincular(Prefeitura prefeitura, Funcionario funcionario);
    
    public String desvincular(Prefeitura prefeitura, String cpf);
    
    public List<Prefeitura> prefeiturasPendentes();
    
    public Prefeitura pesquisarPorCodigo(int codigo);
    
    public String atualizarSituacao(Prefeitura prefeitura, boolean situacao);
    
    public String  excluir(Prefeitura prefeitura);
    
    public List<Prefeitura> todasPrefeituras();
    
    public Prefeitura atualizarObjPrefeitura(Prefeitura prefeitura);
    
    public List<Funcionario> funcionarios(Prefeitura prefeitura);
    
}
