/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sp.senac.ejb;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;
import sp.senac.entidades.Produto;

/**
 *
 * @author tiago.bscarton
 */
@Local
public interface ProdutoEJBLocal {
    
    public void cadastrarProduto(Produto produto);
    
    public List<Produto> listarProdutos();
    
    public List<Produto> buscarTodosProdutos();
    
    public Produto obterProduto(BigInteger id);
    
    public void editarProduto(Produto produto);
    
    public void removerProduto(Produto produto);
    
    public List<Produto> produtosAtivos();
    
    public List<Produto> produtosAtivosCategoria(String categoria);
}
