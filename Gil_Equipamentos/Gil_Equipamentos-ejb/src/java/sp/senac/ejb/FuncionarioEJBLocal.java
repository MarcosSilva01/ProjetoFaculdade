/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import java.util.List;
import javax.ejb.Local;
import sp.senac.entidades.Funcionario;

/**
 *
 * @author Heitor
 */
@Local
public interface FuncionarioEJBLocal {
    
    public void cadastrar(Funcionario funcionario);
    
    public List<Funcionario> listarTodos();
    
    public Funcionario buscarFuncionario();
    
    public void deletar(Funcionario funcionario);
    
    public void ativar(Funcionario funcionario);
}
