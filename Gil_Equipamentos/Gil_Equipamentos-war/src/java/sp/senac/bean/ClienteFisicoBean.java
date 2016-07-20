/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sp.senac.bean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sp.senac.ejb.ClienteFisicoEJBLocal;
import sp.senac.entidades.ClienteFisico;

@ManagedBean
@SessionScoped
public class ClienteFisicoBean implements Serializable {

    private ClienteFisico clienteFisico;
    @EJB
    private ClienteFisicoEJBLocal clienteFisicoEJB;    
    
    private List<ClienteFisico> listarProdutos;
    
    public String telaCadastrarClienteFisico() {
        return "telaCadastrarClienteFisico";
    }
    
    public List<ClienteFisico> listarTodosProdutos() {
        return clienteFisicoEJB.listarClientes();
    }
    
    public String cadastrarCliente(){
        clienteFisicoEJB.cadastrar(clienteFisico);
        return "inicio";
    }
    
    /**
     * @return the cliente
     */
    public ClienteFisico getClienteFisico() {
        return clienteFisico;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteFisico cliente) {
        this.clienteFisico = cliente;
    }
    
    
    
    
}











