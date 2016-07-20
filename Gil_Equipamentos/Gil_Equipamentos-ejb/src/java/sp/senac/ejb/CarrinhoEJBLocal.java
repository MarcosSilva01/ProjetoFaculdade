/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import javax.ejb.Local;
import sp.senac.entidades.Carrinho;

/**
 *
 * @author felipe
 */
@Local
public interface CarrinhoEJBLocal {
   public void adicionar (Carrinho carrinho);
   
   public void  remover(Carrinho carrinho);
       
}