/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Heitor
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.obeterUsuario", query = "SELECT u FROM Usuario u WHERE u.id = :id_Usuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_USUARIO")
    private BigInteger id;

    @Column(name = "EMAIL")
    @NotNull
    private String email;

    @Column(name = "SENHA")
    @NotNull
    private String senha;

    @Column(name = "NOME")
    @NotNull
    private String nome;
    
    @Column (name = "TIPO")
    @NotNull
    private String tipo;

//    @Column(name = "ID_ADMINISTRADOR")
//    private BigInteger idAdministrador;
//
//    @Column(name = "ID_FUNCIONARIO")
//    private BigInteger idFuncionario;

    
    
    @OneToOne
    @JoinColumn(name = "ID_FISICO")
    private ClienteFisico fisico;
    
    @OneToOne
    @JoinColumn(name = "ID_JURIDICO")
    private ClienteJuridico juridico;
    
    @OneToOne
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;
   

//    @Column(name = "ID_JURIDICO")
//    private BigInteger idJuridico;
    // FAZER DESSE JEITO ABAIXO
//    @OneToOne
//    @JoinColumn(name = "ID_JURIDICO")
//    private ClienteJuridico clienteJuridico;
    //    @Column(name = "ID_FISICO")
//    private BigInteger idFisico;

    @Column(name = "ESTATOS")
    @NotNull
    private boolean estatos;

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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

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

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEstatos() {
        return estatos;
    }

    public void setEstatos(boolean estatos) {
        this.estatos = estatos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.entidades.Usuario[ id=" + id + " ]";
    }

}
