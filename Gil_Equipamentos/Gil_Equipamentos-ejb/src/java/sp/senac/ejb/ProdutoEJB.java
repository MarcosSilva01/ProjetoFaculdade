/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sp.senac.ejb;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sp.senac.entidades.Produto;

/**
 *
 * @author marcos.fvsilva
 */
@Stateless
public class ProdutoEJB implements ProdutoEJBLocal {

    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public void cadastrarProduto(Produto produto) {
        em.persist(produto);
    }

    @Override
    public List<Produto> listarProdutos() {
        Query q = em.createNamedQuery("Produto.findAll");
        return q.getResultList();
    }

    @Override
    public List<Produto> buscarTodosProdutos() {
        Query query = em.createQuery("select p from Produto p");
        return query.getResultList();
    }

    @Override
    public Produto obterProduto(BigInteger id) {
        Query query = em.createNamedQuery("produto.obterProduto");
        query.setParameter("id_Produto", id);
        return (Produto) query.getSingleResult();
    }

    @Override
    public void editarProduto(Produto produto) {
        em.merge(produto);
    }

    @Override
    public void removerProduto(Produto produto) {
        em.merge(produto);
    }

    @Override
    public List<Produto> produtosAtivos() {
        Query query = em.createNamedQuery("produto.obterAtivo");
        query.setParameter("estatos", true);
        return query.getResultList();
    }

    @Override
    public List<Produto> produtosAtivosCategoria(String categoria) {
        Query query = em.createNamedQuery("produto.obterAtivoCategoria");
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }
    
}
