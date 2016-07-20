/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;
import sp.senac.ejb.UsuarioEJB;
import sp.senac.ejb.UsuarioEJBLocal;
import sp.senac.entidades.Usuario;
import sp.senac.mensagem.Mensagem;

/**
 *
 * @author Heitor
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario;

    @EJB
    private final UsuarioEJBLocal usuarioEJB = new UsuarioEJB();

    @ManagedProperty(value = "#{clienteBean}")
    private ClienteBean acao;

    public String telaLogin() {
        List<Usuario> usuarios = usuarioEJB.buscarTodosUsuarios();
        if (usuarios.size() < 1) {
            usuario = new Usuario();
            usuario.setId(new BigInteger("1"));
            usuario.setEmail("adm@gmail.com");
            usuario.setNome("Heitor Victor");
            usuario.setSenha("Heitor96");
            usuario.setTipo("Administrador");
            usuario.setEstatos(true);
            usuarioEJB.cadastrar(usuario);
        } else {
            usuarios.clear();
        }
        setUsuario(new Usuario());
        return "telaLogin";
    }

    public String logar() {
        setUsuario(new Usuario());
        List<Usuario> lista = usuarioEJB.buscarTodosUsuarios();
        for (Usuario user : lista) {
            System.err.println(usuario.getEmail() + " -- " + user.getEmail());
            if (usuario.getEmail().equals(user.getEmail())) {
                if (usuario.getSenha().equals(user.getSenha())) {
                    usuario = user;
                    if (user.getTipo().equalsIgnoreCase("Juridico")) {
                        acao.buscarDadosCliente("juridico", user.getJuridico().getId());
                    } else if (user.getTipo().equalsIgnoreCase("Fisico")) {
                        acao.buscarDadosCliente("fisico", user.getFisico().getId());
                    }
                    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                    session.setAttribute("usuario", user);
                    return "home";
                }
            } else {
                Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
                flash.put("mensagem", new Mensagem("Usuario não cadastrado ou senha incorreta", "danger"));
            }
        }
        return "telaLogin";
    }

    public String deslogar() {
        setUsuario(null);
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("usuario", null);
        return "home";
    }

    public boolean vazio() {
        return usuario == null;
    }

    public boolean logado() {
        return usuario != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setAcao(ClienteBean acao) {
        this.acao = acao;
    }
}
