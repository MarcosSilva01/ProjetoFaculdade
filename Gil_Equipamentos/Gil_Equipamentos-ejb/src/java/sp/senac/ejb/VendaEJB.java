/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sp.senac.entidades.Venda;

/**
 *
 * @author Heitor
 */
@Stateless
public class VendaEJB implements VendaEJBLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void cadastrarPagamento(Venda pagamento) {
        em.persist(pagamento);
    }

    @Override
    public List<Venda> listarVendas() {
        Query query = em.createNamedQuery("venda.selectAll");
        return query.getResultList();
    }
   
}
