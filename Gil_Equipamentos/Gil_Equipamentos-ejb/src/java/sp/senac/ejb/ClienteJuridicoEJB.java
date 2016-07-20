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
import sp.senac.entidades.ClienteJuridico;

/**
 *
 * @author felipe
 */
@Stateless
public class ClienteJuridicoEJB implements ClienteJuridicoEJBLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void cadastrar(ClienteJuridico juridico) {
        em.persist(juridico);
    }

    @Override
    public List<ClienteJuridico> listarClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClienteJuridico obterJuridico(BigInteger id) {
        Query query = em.createNamedQuery("juridico.obterJuridico");
        query.setParameter("id_Juridico", id);
        return (ClienteJuridico) query.getSingleResult();
    }

    @Override
    public ClienteJuridico obterJuridicoPorCNPJ(String cnpj) {
        Query query = em.createNamedQuery("juridico.obterPorCNPJ");
        query.setParameter("cnpj", cnpj);
        return (ClienteJuridico) query.getSingleResult();
    }

}
