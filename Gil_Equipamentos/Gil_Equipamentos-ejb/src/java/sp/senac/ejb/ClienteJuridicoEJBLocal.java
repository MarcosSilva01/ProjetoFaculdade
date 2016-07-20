/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;
import sp.senac.entidades.ClienteJuridico;

/**
 *
 * @author felipe
 */
@Local
public interface ClienteJuridicoEJBLocal {

    public void cadastrar(ClienteJuridico juridico);

    public List<ClienteJuridico> listarClientes();

    public ClienteJuridico obterJuridico(BigInteger id);
    
    public ClienteJuridico obterJuridicoPorCNPJ(String cnpj);
}
