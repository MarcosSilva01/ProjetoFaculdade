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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SoftCoffee
 */
@Entity
@Table(name = "PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "produto.obterProduto", query = "SELECT p FROM Produto p WHERE p.id = :id_Produto"),
    @NamedQuery(name = "produto.obterAtivo", query = "SELECT p FROM Produto p WHERE p.estatos = :estatos"),
    @NamedQuery(name = "produto.obterAtivoCategoria", query = "SELECT p FROM Produto p WHERE p.estatos = 'true' AND p.categoria = :categoria")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_PRODUTO")
    private BigInteger id;

    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;

    @Column(name = "IMAGEM")
    private String imagemProduto;

    @Column(name = "CODIGO_BARRAS")
    private String codigoBarras;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DESCRICAO_BREVE")
    private String breveDescricao;

    @Column(name = "FABRICANTE")
    private String fabricante;

    @Column(name = "FORNECEDOR")
    private String fornecedor;

    @Column(name = "GASTO_PRODUTO")
    private BigDecimal gastoProduto;

    @Column(name = "VALOR_VENDA")
    private BigDecimal valorVenda;

    @Column(name = "LUCRO")
    private BigDecimal lucro;

    @Column(name = "MEDIDA")
    private String medida;

    @Column(name = "ALTURA")
    private String altura;

    @Column(name = "LARGURA")
    private String largura;

    @Column(name = "PROFUNDIDADE")
    private String profundidade;

    @Column(name = "COR")
    private String cor;

    @Column(name = "QTD_MINIMA")
    private int qtdMinima;

    @Column(name = "QTD_MAXIMA")
    private int qtdMaxima;

    @Column(name = "QUANTIDADE")
    private int quantidade;

    @OneToMany(mappedBy = "produto")
    @XmlTransient
    private List<ImagemProduto> imagens;

    @Column(name = "ESTATOS")
    private boolean estatos;

    public List<ImagemProduto> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemProduto> imagens) {
        this.imagens = imagens;
    }

    public Produto() {
    }

    public BigDecimal getGastoProduto() {
        return gastoProduto;
    }

    public void setGastoProduto(BigDecimal gastoProduto) {
        this.gastoProduto = gastoProduto;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getLucro() {
        return lucro;
    }

    public void setLucro(BigDecimal lucro) {
        this.lucro = lucro;
    }

    public Produto(BigInteger id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getBreveDescricao() {
        return breveDescricao;
    }

    public void setBreveDescricao(String breveDescricao) {
        this.breveDescricao = breveDescricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public String getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(String profundidade) {
        this.profundidade = profundidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public int getQtdMaxima() {
        return qtdMaxima;
    }

    public void setQtdMaxima(int qtdMaxima) {
        this.qtdMaxima = qtdMaxima;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public boolean isEstatos() {
        return estatos;
    }

    public void setEstatos(boolean estatos) {
        this.estatos = estatos;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.teste.Produto[ id=" + id + " ]";
    }

}
