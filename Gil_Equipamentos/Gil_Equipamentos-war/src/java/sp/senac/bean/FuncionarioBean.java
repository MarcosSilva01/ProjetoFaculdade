package sp.senac.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sp.senac.ejb.FuncionarioEJB;
import sp.senac.ejb.FuncionarioEJBLocal;
import sp.senac.entidades.Funcionario;

@ManagedBean
@SessionScoped
public class FuncionarioBean {

    Funcionario funcionario = new Funcionario();
    @EJB
    FuncionarioEJBLocal funcionarioEJB = new FuncionarioEJB();

    public FuncionarioBean() {
    }

    public String telaCadastroFuncionario() {
        setFuncionario(new Funcionario());
        return "cadastroFuncionario";
    }

    public String cadastrar() {
        if (funcionario.getNome().trim() == null) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "", "Campo nome deve ser preenchido!"
                    )
            );
            return "cadastroFuncionario";
        } else {
            funcionarioEJB.cadastrar(funcionario);
            return "home";
        }
    }

    public String limpar() {
        this.funcionario = new Funcionario();
        return "cadastroFuncionario";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
