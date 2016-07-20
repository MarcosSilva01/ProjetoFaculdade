/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import sp.senac.entidades.Carrinho;
import sp.senac.entidades.Produto;

/**
 *
 * @author felipe
 */
@Stateless
public class CarrinhoEJB implements CarrinhoEJBLocal {
    private EntityManager em;
    @Override
    public void adicionar(Carrinho carrinho) {
        em.persist(carrinho);
    }

    @Override
    public void remover(Carrinho carrinho) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
