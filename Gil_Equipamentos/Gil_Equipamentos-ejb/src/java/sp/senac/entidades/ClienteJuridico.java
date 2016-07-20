/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "CLIENTE_JURIDICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "juridico.obterJuridico", query = "SELECT j FROM ClienteJuridico j WHERE j.id = :id_Juridico"),
    @NamedQuery(name = "juridico.obterPorCNPJ", query = "SELECT j FROM ClienteJuridico j WHERE j.cnpj = :cnpj")})

public class ClienteJuridico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_JURIDICO")
    private BigInteger id;

    @Column(name = "CNPJ")
    private String cnpj;
    
    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;
    
    @Column(name = "NOME_RESPONSAVEL")
    private String nomeResponsavel;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "SENHA")
    private String senha;
    
    @Column(name = "NOME_IMPRESSO")
    private String nomeImpressoCartao;

    @Column(name = "NUMERO_CARTAO")
    private String numeroCartao;

    @Column(name = "BANDEIRA_CARTAO")
    private String bandeiraCartao;

    @Column(name = "DATA_CARTAO")
    @Temporal(TemporalType.DATE)
    private Date dtCartao;

    @Column(name = "SEGURANCA_CARTAO")
    private int segurancaCartao;
    
    @Column (name = "CEP")
    private String cep;
        
    @Column(name = "ENDERECO")
    private String endereco;
    
    @Column(name = "NUMERO_EMPRESA")
    private String numeroEmpresa;
    
    @Column(name = "BAIRRO")
    private String bairro;
    
    @Column(name = "CIDADE")
    private String cidade;
    
    @Column(name = "ESTADO")
    private String estado;
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeImpressoCartao() {
        return nomeImpressoCartao;
    }

    public void setNomeImpressoCartao(String nomeImpressoCartao) {
        this.nomeImpressoCartao = nomeImpressoCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(String bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public Date getDtCartao() {
        return dtCartao;
    }

    public void setDtCartao(Date dtCartao) {
        this.dtCartao = dtCartao;
    }

    public int getSegurancaCartao() {
        return segurancaCartao;
    }

    public void setSegurancaCartao(int segurancaCartao) {
        this.segurancaCartao = segurancaCartao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroEmpresa() {
        return numeroEmpresa;
    }

    public void setNumeroEmpresa(String numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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
        if (!(object instanceof ClienteJuridico)) {
            return false;
        }
        ClienteJuridico other = (ClienteJuridico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.entidades.ClienteJuridico[ id=" + id + " ]";
    }
    
}
