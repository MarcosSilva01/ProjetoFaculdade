/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import javax.ejb.Local;
import sp.senac.entidades.Compra;
import sp.senac.entidades.Produto;

/**
 *
 * @author felipe
 */
@Local
public interface CompraEJBLocal {
    public void realizarCompra(Compra compra);
    public void adicionarCarrinho(Produto produto);
}
