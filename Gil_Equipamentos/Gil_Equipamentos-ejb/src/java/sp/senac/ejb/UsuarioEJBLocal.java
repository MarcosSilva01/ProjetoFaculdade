/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.ejb;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;
import sp.senac.entidades.Usuario;

/**
 *
 * @author Heitor
 */
@Local
public interface UsuarioEJBLocal {
    
    public void cadastrar (Usuario usuario);
    
    public List<Usuario> buscarTodosUsuarios();
    
    public Usuario obterUsuario(BigInteger id);
}
