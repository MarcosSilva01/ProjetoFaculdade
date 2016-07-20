/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.bean;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import sp.senac.ejb.ProdutoEJB;
import sp.senac.ejb.ProdutoEJBLocal;
import sp.senac.ejb.VendaEJB;
import sp.senac.ejb.VendaEJBLocal;
import sp.senac.entidades.Produto;
import sp.senac.entidades.Venda;

/**
 *
 * @author Heitor
 */
@ManagedBean
@SessionScoped
public class VendaBean implements Serializable {

    private Venda venda;
    @EJB
    VendaEJBLocal vendaEJB = new VendaEJB();
    
    private Produto produto;
    @EJB
    ProdutoEJBLocal produtoEJB = new ProdutoEJB();
    
    public String chamar(){
        setVenda(new Venda());
        return "venda";
    }
    
    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public VendaEJBLocal getVendaEJB() {
        return vendaEJB;
    }

    public void setVendaEJB(VendaEJBLocal vendaEJB) {
        this.vendaEJB = vendaEJB;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public List lista(){
        return vendaEJB.listarVendas();
    }
    
    public void buscarProduto(BigInteger id){
        setProduto(new Produto());
        produto = produtoEJB.obterProduto(id);
    }
       
}
