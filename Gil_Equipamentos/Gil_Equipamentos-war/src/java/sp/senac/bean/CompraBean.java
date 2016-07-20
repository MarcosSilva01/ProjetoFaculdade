/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.bean;

import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import sp.senac.ejb.CarrinhoEJB;
import sp.senac.ejb.CarrinhoEJBLocal;
import sp.senac.ejb.ProdutoEJB;
import sp.senac.ejb.ProdutoEJBLocal;
import sp.senac.ejb.UsuarioEJB;
import sp.senac.ejb.UsuarioEJBLocal;
import sp.senac.ejb.VendaEJB;
import sp.senac.ejb.VendaEJBLocal;
import sp.senac.entidades.Carrinho;
import sp.senac.entidades.Compra;
import sp.senac.entidades.Produto;
import sp.senac.entidades.Usuario;
import sp.senac.entidades.Venda;
import sp.senac.mensagem.Mensagem;

/**
 *
 * @author felipe
 */
@ManagedBean
@SessionScoped
public class CompraBean implements Serializable {

    private BigInteger idProdutoTemp;
    private BigDecimal parcela;
    private Produto detalhesProd;
    private Carrinho cart;

    // tem que tirar essa anotação, senão ele da erro 
    //@ManagedProperty(value = "#{usuarioBean}")
    private Usuario usuario;

    private Venda venda;
    @EJB
    VendaEJBLocal vendaEJB = new VendaEJB();

    @EJB
    ProdutoEJBLocal prod = new ProdutoEJB();

    @EJB
    CarrinhoEJBLocal cartEJB = new CarrinhoEJB();
    // rapidão, preciso despertar blz
    @EJB
    UsuarioEJBLocal usuarioEJB = new UsuarioEJB();

    private ArrayList<Carrinho> itens = new ArrayList<>();
    private Compra compra = new Compra();
    private BigDecimal subTotal = new BigDecimal(0.0);
    private BigDecimal calcCep = new BigDecimal(0.0);
    private BigDecimal total = new BigDecimal(0.0);
    
    public void addCarrinho(int quantidade){
        adicionarProduto(detalhesProd.getId(), quantidade);
    }
    
    public void adicionarProduto(BigInteger idProduto, int quantidade) {
        cart = new Carrinho();
        Produto p = prod.obterProduto(idProduto);
        int cont = 0;
        if (!itens.isEmpty()) {
            List<Carrinho> carsToAdd = new ArrayList<>();
            for (Carrinho item : itens) {
                if (item.getIdProd() == p.getId()) {
                    item.setQuantidade(item.getQuantidade() + 1);
                    item.setValorTotal(item.getValorUnitario().multiply(new BigDecimal(item.getQuantidade())));
                    break;
                } else if (cont == itens.size() - 1) {
                    cart.setIdProd(p.getId());
                    cart.setImagem(p.getImagemProduto());
                    cart.setNome(p.getNome());
                    cart.setQuantidade(1);
                    cart.setValorUnitario(p.getValorVenda());
                    cart.setValorTotal(cart.getValorUnitario().multiply(new BigDecimal(cart.getQuantidade())));
                    carsToAdd.add(cart);
                }
                cont++;
            }
            itens.addAll(carsToAdd);
        } else {
            cart.setIdProd(p.getId());
            cart.setImagem(p.getImagemProduto());
            cart.setNome(p.getNome());
            cart.setQuantidade(1);
            cart.setValorUnitario(p.getValorVenda());
            cart.setValorTotal(cart.getValorUnitario().multiply(new BigDecimal(cart.getQuantidade())));
            itens.add(cart);
        }
       
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("mensagem", new Mensagem("Produto '" + p.getNome() + "' adicionado com sucesso", "success"));
    }

    public void removerProduto(BigInteger idProduto) {
        int cont = 0;
        if (!itens.isEmpty()) {
            for (Iterator<Carrinho> i = itens.iterator(); i.hasNext();) {
                Carrinho item = i.next();
                if (item.getIdProd() == idProduto) {
                    i.remove();
                }
            }
        }
    }

    public String finalizar(BigInteger id) {
        Usuario us = usuarioEJB.obterUsuario(id);

        List<Venda> lista = vendaEJB.listarVendas();
        if (lista == null || lista.size() < 1) {
            for (Carrinho item : itens) {
                venda = new Venda();
                if (us.getTipo().equalsIgnoreCase("Fisico")) {
                    venda.setFisico(us.getFisico());
                } else {
                    venda.setJuridico(us.getJuridico());
                }
                Produto produto = new Produto();
                produto.setId(item.getIdProd());
                venda.setProduto(produto);
                venda.setValorTotal(valorTotalCompra());
                vendaEJB.cadastrarPagamento(venda);
            }
            itens.clear();
            return "home";
        } else if (lista != null || lista.size() > 0) {
            for (Carrinho item : itens) {
                venda = new Venda();
                if (us.getTipo().equalsIgnoreCase("Fisico")) {
                    venda.setFisico(us.getFisico());
                } else {
                    venda.setJuridico(us.getJuridico());
                }
                venda.setQuantidade(BigInteger.valueOf(item.getQuantidade()));
                Produto produto = new Produto();
                produto.setId(item.getIdProd());
                venda.setProduto(produto);
                venda.setValorTotal(valorTotalCompra());
                vendaEJB.cadastrarPagamento(venda);
            }
            itens.clear();
            return "home";
        } else {
            return "pagamento";
        }
    }

    
    public BigDecimal subTotalCompra() {
        subTotal = new BigDecimal(0.0);
        for (Carrinho iten : itens) {
            subTotal = subTotal.add(iten.getValorTotal());
        }
        return subTotal;
    }
    
    

    public String detalhesProduto(BigInteger idProduto) {
        detalhesProd = new Produto();
        detalhesProd = prod.obterProduto(idProduto);
        return "detalhesProduto";
    }

    public BigDecimal getParcela() {
        parcela = detalhesProd.getValorVenda();
        BigDecimal divisor = new BigDecimal(6);
        return parcela.divide(divisor, 2, RoundingMode.CEILING);
    }

    public BigDecimal calcularCep(BigInteger idProduto) {
        calcCep = new BigDecimal(35.0);

        return calcCep;
    }

    public Produto getDetalhesProd() {
        return detalhesProd;
    }

    public void setDetalhesProd(Produto detalhesProd) {
        this.detalhesProd = detalhesProd;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public UsuarioEJBLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioEJBLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public BigDecimal valorTotalCompra() {
        return total = subTotal.add(calcCep);
    }

    public BigInteger getIdProdutoTemp() {
        return idProdutoTemp;
    }

    public CarrinhoEJBLocal getCartEJB() {
        return cartEJB;
    }

    public BigDecimal getTotal() {
        return valorTotalCompra();
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getSubTotal() {
        return subTotalCompra();
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getCalcCep() {
        return calcularCep(null);
    }

    public void setCalcCep(BigDecimal calcCep) {
        this.calcCep = calcCep;
    }

    public void setCartEJB(CarrinhoEJBLocal cartEJB) {
        this.cartEJB = cartEJB;
    }

    public void setIdProdutoTemp(BigInteger idProdutoTemp) {
        this.idProdutoTemp = idProdutoTemp;
    }

    public Compra getCompra() {
        return compra;
    }

    public ProdutoEJBLocal getProd() {
        return prod;
    }

    public void setProd(ProdutoEJBLocal prod) {
        this.prod = prod;
    }

    public Carrinho getCart() {
        return cart;
    }

    public void setCart(Carrinho cart) {
        this.cart = cart;
    }

    public ArrayList<Carrinho> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Carrinho> itens) {
        this.itens = itens;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}
