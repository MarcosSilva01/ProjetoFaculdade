/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "CARRINHO")
@NamedQueries({
    @NamedQuery(name = "Carrinho.findAll", query = "SELECT c FROM Carrinho c")})
public class Carrinho implements Serializable {

     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_CARRINHO")
    private BigInteger id;

    @Column(name = "ID_PRODUTO")
    @NotNull
    private BigInteger idProd;
    
    @Column (name = "TIPO_USUARIO")
    @NotNull
    private String tipoUsuario;
            
    @Column (name = "TIPO_PRODUTO")
    @NotNull
    private String tipoProduto;
    
    @OneToOne
    @JoinColumn(name = "ID_FISICO")
    private ClienteFisico fisico;
    
    @OneToOne
    @JoinColumn(name = "ID_JURIDICO")
    private ClienteJuridico juridico;
    
    @Column(name = "IMAGEM")
    @NotNull
    private String imagem;
    
    @Column (name = "PRODUTO")
    @NotNull
    private String nome;
    
    @Column(name = "QUANTIDADE")
    @NotNull
    private int quantidade;
    
    @Column(name = "VALOR_UNITARIO")
    @NotNull
    private BigDecimal valorUnitario;
    
    @Column(name = "VALOR_TOTAL")
    @NotNull
    private BigDecimal valorTotal;
    
    private List<Carrinho> lista;

    public ClienteFisico getFisico() {
        return fisico;
    }

    public void setFisico(ClienteFisico fisico) {
        this.fisico = fisico;
    }

    public ClienteJuridico getJuridico() {
        return juridico;
    }

    public void setJuridico(ClienteJuridico juridico) {
        this.juridico = juridico;
    }
    
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getIdProd() {
        return idProd;
    }

    public void setIdProd(BigInteger idProd) {
        this.idProd = idProd;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Carrinho> getLista() {
        return lista;
    }

    public void setLista(List<Carrinho> lista) {
        this.lista = lista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrinho)) {
            return false;
        }
        Carrinho other = (Carrinho) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.entidades.NovoEntity[ id=" + id + " ]";
    }
    
}
