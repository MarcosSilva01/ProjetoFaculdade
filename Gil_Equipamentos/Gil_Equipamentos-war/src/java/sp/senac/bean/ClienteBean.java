/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.bean;

import java.io.Serializable;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sp.senac.ejb.ClienteFisicoEJB;
import sp.senac.ejb.ClienteFisicoEJBLocal;
import sp.senac.ejb.ClienteJuridicoEJB;
import sp.senac.ejb.ClienteJuridicoEJBLocal;
import sp.senac.ejb.UsuarioEJB;
import sp.senac.ejb.UsuarioEJBLocal;
import sp.senac.entidades.ClienteFisico;
import sp.senac.entidades.ClienteJuridico;
import sp.senac.entidades.Usuario;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {
    // se tirar o new daqui ele buga, então como que vai fazer ? coloca aii novamente
    
    private ClienteJuridico juridico = new ClienteJuridico();
    private ClienteFisico fisico =  new ClienteFisico();
    private String confirmaSenha;
    
    @EJB
    private ClienteFisicoEJBLocal fisicoEJB;
    
    @EJB
    private ClienteJuridicoEJBLocal juridicoEJB;
    
    @EJB
    private UsuarioEJBLocal usuarioEJB = new UsuarioEJB();
    
    public String telaCadastrarClienteFisico() {
        setFisico(new ClienteFisico());
        fisico = new ClienteFisico();
        return "telaCadastrarClienteFisico";
    }
    
    public String telaCadastrarClienteJuridico() {
        setJuridico(new ClienteJuridico());
        juridico = new ClienteJuridico();
        return "telaCadastrarClienteJuridico";
    }
    
    public String cadastrarClienteFisico() {
        try {
            fisicoEJB.cadastrar(fisico);
            Usuario user = new Usuario();
            user.setFisico(fisico);
            user.setNome(fisico.getNome());
            user.setEmail(fisico.getEmail());
            user.setSenha(fisico.getSenha());
            user.setEstatos(true);
            user.setTipo("Fisico");
            usuarioEJB.cadastrar(user);
            return "home";
        } catch (Exception erro) {
            System.err.println("Erro: " + erro);
            return "telaCadastrarClienteFisico";
        }
    }
    
    public String cadastrarClienteJuridico() {
        try {
            juridicoEJB.cadastrar(juridico);
           
            Usuario user = new Usuario();
            user.setJuridico(juridico);
            user.setNome(juridico.getNomeResponsavel());
            user.setEmail(juridico.getEmail());
            user.setSenha(juridico.getSenha());
            user.setEstatos(true);
            user.setTipo("Juridico");
            usuarioEJB.cadastrar(user);
            
            return "home";
        } catch (Exception erro) {
            System.err.println("Erro: " + erro);
            return "telaCadastrarClienteJuridico";
        }
        
    }
    
    public String cadastrarFuncionario(){
        try {
            //juridicoEJB.cadastrar(juridico);
           
            Usuario user = new Usuario();
//            user.setJuridico(juridico);
//            user.setNome(juridico.getNomeResponsavel());
//            user.setEmail(juridico.getEmail());
//            user.setSenha(juridico.getSenha());
            user.setEstatos(true);
            user.setTipo("Funcionario");
            usuarioEJB.cadastrar(user);
            
            return "home";
        } catch (Exception erro) {
            System.err.println("Erro: " + erro);
            return "telaCadastrarFuncionario";
        }
        
    }
    
    public void limparCampos() {
        fisico = new ClienteFisico();
        juridico = new ClienteJuridico();
    }
    
    public void buscarDadosCliente(String tipo, BigInteger id){
        if(tipo.equals("juridico")){
            juridico = new ClienteJuridico();
            juridico = juridicoEJB.obterJuridico(id);
        }else{
            fisico = new ClienteFisico();
            fisico = fisicoEJB.obterFisico(id);
        }
    }
    
    public ClienteJuridico getJuridico() {
        return juridico;
    }
    
    public void setJuridico(ClienteJuridico juridico) {
        this.juridico = juridico;
    }
    
    public ClienteFisico getFisico() {
        return fisico;
    }
    
    public void setFisico(ClienteFisico fisico) {
        this.fisico = fisico;
    }
    
    public String getConfirmaSenha() {
        return confirmaSenha;
    }
    
    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
    
    public ClienteFisicoEJBLocal getFisicoEJB() {
        return fisicoEJB;
    }
    
    public void setFisicoEJB(ClienteFisicoEJBLocal fisicoEJB) {
        this.fisicoEJB = fisicoEJB;
    }
    
    public ClienteJuridicoEJBLocal getJuridicoEJB() {
        return juridicoEJB;
    }
    
    public void setJuridicoEJB(ClienteJuridicoEJBLocal juridicoEJB) {
        this.juridicoEJB = juridicoEJB;
    }
    
    public UsuarioEJBLocal getUsuarioEJB() {
        return usuarioEJB;
    }
    
    public void setUsuarioEJB(UsuarioEJBLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }
    
}
