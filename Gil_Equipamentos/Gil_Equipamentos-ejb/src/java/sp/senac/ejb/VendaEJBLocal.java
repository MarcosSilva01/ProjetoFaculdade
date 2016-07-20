/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import java.util.List;
import javax.ejb.Local;
import sp.senac.entidades.Venda;

/**
 *
 * @author Heitor
 */
@Local
public interface VendaEJBLocal {
    
    public void cadastrarPagamento(Venda pagamento);
    
    public List<Venda> listarVendas();
}
