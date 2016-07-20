/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.bean;

import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import sp.senac.ejb.ClienteJuridicoEJBLocal;
import sp.senac.entidades.ClienteJuridico;

@ManagedBean
@SessionScoped
public class ClienteJuridicoBean implements Serializable {
    
    private ClienteJuridico clienteJuridico;
    @EJB
    private ClienteJuridicoEJBLocal clienteJuridicoEJB;
    
    public String telaCadastrarClienteJuridico() {
        setClienteJuridico(new ClienteJuridico());
        return "telaCadastrarClienteJuridico";
    }
    
    public String cadastrarCliente(){
        clienteJuridicoEJB.cadastrar(clienteJuridico);
        return "inicio";
    }

    public ClienteJuridico getClienteJuridico() {
        return clienteJuridico;
    }

    public void setClienteJuridico(ClienteJuridico clienteJuridico) {
        this.clienteJuridico = clienteJuridico;
    }

    public ClienteJuridicoEJBLocal getClienteJuridicoEJB() {
        return clienteJuridicoEJB;
    }

    public void setClienteJuridicoEJB(ClienteJuridicoEJBLocal clienteJuridicoEJB) {
        this.clienteJuridicoEJB = clienteJuridicoEJB;
    }

    public ClienteJuridicoBean() {
    }
    
}
