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
import sp.senac.entidades.ClienteFisico;

/**
 *
 * @author felipe
 */
@Stateless
public class ClienteFisicoEJB implements ClienteFisicoEJBLocal {

     @PersistenceContext
    private EntityManager em;    
    
    @Override
    public void cadastrar(ClienteFisico cliente) {
        em.persist(cliente);
    }

    @Override
    public List<ClienteFisico> listarClientes() {
        Query q = em.createNamedQuery("Cliente.findAll");
        return q.getResultList();
    }

    @Override
    public ClienteFisico obterFisico(BigInteger id) {
        Query query = em.createNamedQuery("fisico.obterFisico");
        System.out.println(query.getParameter("id_Fisico"));
        query.setParameter("id_Fisico", id);
        return (ClienteFisico) query.getSingleResult();
    }
}
