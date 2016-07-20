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
import sp.senac.entidades.Usuario;

/**
 *
 * @author Heitor
 */
@Stateless
public class UsuarioEJB implements UsuarioEJBLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void cadastrar(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public List<Usuario> buscarTodosUsuarios() {
        Query query = em.createNamedQuery("Usuario.findAll");
        return query.getResultList();
    }

    @Override
    public Usuario obterUsuario(BigInteger id) {
        Query query = em.createNamedQuery("Usuario.obeterUsuario");
        query.setParameter("id_Usuario", id);
        return (Usuario) query.getSingleResult();
    }

}
