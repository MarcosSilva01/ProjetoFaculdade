/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Heitor
 */
@Entity
@Table(name = "FUNCIONARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT c FROM Funcionario c"),
    @NamedQuery(name = "Funcionario.findById", query = "SELECT c FROM Funcionario c WHERE c.id = :id"),
    @NamedQuery(name = "Funcionario.findByDtNascimento", query = "SELECT c FROM Funcionario c WHERE c.dtNascimento = :dtNascimento"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT c FROM Funcionario c WHERE c.nome = :nome")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private BigInteger id;

    @Column(name = "EMAIL")//OK 
    @NotNull
    private String email;
    
    @Column(name = "SENHA")//OK 
    @NotNull
    private String senha;
    
    private String confSenha;//OK 
    
    @Column(name = "NOME")//OK 
    @NotNull
    private String nome;
    
    @Column(name = "NOME_PAI")//OK 
    @NotNull
    private String nomePai;
    
    @Column(name = "NOME_MAE")//OK 
    @NotNull
    private String nomeMae;
    
    @Column(name = "DATA_NASCIMENTO")//OK 
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtNascimento;
    
    @Column(name = "CPF")//OK 
    @NotNull
    private String cpf;
    
    @Column(name = "SEXO")//OK 
    @NotNull
    private String sexo;
    
    @Column(name = "NATURALIDADE")//OK 
    @NotNull
    private String naturalidade;
    
    @Column(name = "ESTADO_CIVIL")//OK 
    @NotNull
    private String estadoCivil;
    
    @Column(name = "TELEFONE")//OK 
    @NotNull
    private String telefone;
    
    @Column(name = "CELULAR")//OK 
    @NotNull
    private String celular;
    
    @Column(name = "RG")//OK 
    @NotNull
    private String rg;
    
    @Column(name = "CEP")//OK 
    @NotNull
    private String cep;
    
    @Column(name = "ENDERECO")//OK 
    @NotNull
    private String endereco;
    
    @Column(name = "NUMERO_RESIDENCIA")//OK 
    @NotNull
    private String numeroResidencia;
    
    @Column(name = "REFERENCIA")
    private String referencia;
    
    @Column(name = "COMPLEMENTO")
    private String complemento;
    
    @Column(name = "BAIRRO")
    @NotNull
    private String bairro;
    
    @Column(name = "CIDADE")
    @NotNull
    private String cidade;
    
    @Column(name = "ESTADO")
    @NotNull
    private String estado;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public String getConfSenha() {
        return confSenha;
    }

    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.entidades.Funcionario[ id=" + id + " ]";
    }
    
}
