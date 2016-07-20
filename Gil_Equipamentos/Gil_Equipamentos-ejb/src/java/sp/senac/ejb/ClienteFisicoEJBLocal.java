/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;
import sp.senac.entidades.ClienteFisico;

/**
 *
 * @author felipe
 */
@Local
public interface ClienteFisicoEJBLocal {
    public void cadastrar(ClienteFisico fisico);
    public List<ClienteFisico> listarClientes();
    public ClienteFisico obterFisico(BigInteger id);
}
