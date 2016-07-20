/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import javax.ejb.Stateless;
import sp.senac.entidades.Compra;
import sp.senac.entidades.Produto;

/**
 *
 * @author felipe
 */
@Stateless
public class CompraEJB implements CompraEJBLocal {

    @Override
    public void realizarCompra(Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionarCarrinho(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
