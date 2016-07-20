/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import sp.senac.ejb.ProdutoEJBLocal;
import sp.senac.entidades.Produto;
import javax.servlet.http.Part;
import sp.senac.mensagem.Mensagem;

@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable {

    private String categoria;
    private Produto produto;
    @EJB
    private ProdutoEJBLocal produtoEJB;
    private List<Produto> listaProdutos;

    private Part imagem;

    public String obterProduto(BigInteger id) {
        produto = produtoEJB.obterProduto(id);
        return "alterarProd";
    }

    public String alterarProduto() {
        produtoEJB.editarProduto(produto);
        // mano dps se coloca return pra lista de produtos
        return "home";
    }

    private String obterNomeArquivo() {
        if (imagem != null) {
            String partHeader = imagem.getHeader("content-disposition");
            for (String content : partHeader.split(";")) {
                if (content.trim().startsWith("filename")) {
                    String nomeArquivo
                            = content.substring(content.indexOf('=') + 1)
                            .trim().replace("\"", "");
                    int lastFilePartIndex = nomeArquivo.lastIndexOf("\\");
                    if (lastFilePartIndex > 0) {
                        return nomeArquivo.substring(lastFilePartIndex,
                                nomeArquivo.length());
                    }
                    return nomeArquivo;
                }
            }
            // vdd, por isso fiquei indeciso antes
            // assim tem que cadastrar, ai você manda buscar pelo cnpj, ele vai te trazer o objeto
            // assim você pode pegar o id do cara, vou arrumar
        }
        return null;
    }

    private void salvarImagem(String nomeImagem) {
//C:\Users\Heitor\Documents\NetBeansProjects\Gil Equipamentos\Gil Equipamentos-war\web\resources\imgProduto
//C:\Users\Heitor\Documents\NetBeansProjects\Gil_Equipamentos\Gil_Equipamentos-war\web\resources\imgProduto
        String diretorioDestino = "C:" + File.separator + "Users"
                + File.separator + "Heitor" + File.separator + "Documents" + File.separator
                + "NetBeansProjects" + File.separator + "Gil_Equipamentos" + File.separator + "Gil_Equipamentos-war" + File.separator
                + "web" + File.separator + "resources" + File.separator + "imgProduto" + File.separator;
        File arquivo = new File(diretorioDestino + nomeImagem);

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = getImagem().getInputStream();
            outputStream = new FileOutputStream(arquivo);

            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            //TODO: LOGAR ERRO
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    //TODO: LOGAR ERRO
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    //TODO: LOGAR ERRO
                }
            }
        }

    }

    public Part getImagem() {
        return imagem;
    }

    public void setImagem(Part imagem) {
        this.imagem = imagem;
    }

    public String telaCadastrarProduto() {
        setProduto(new Produto());
        return "telaCadastrarProduto";
    }

    public String telaListaProduto() {
        return "telaListaProduto";
    }

    public List<Produto> listarTodosProdutos() {
        return produtoEJB.produtosAtivosCategoria(categoria);
    }

    public List<Produto> listAllProds() {
        return produtoEJB.buscarTodosProdutos();
    }
    
    public String desativar(BigInteger id) {
        produto = produtoEJB.obterProduto(id);
        produto.setEstatos(false);
        produtoEJB.editarProduto(produto);
        // Coloca o return para a lista de produtos, não sei o nome q ta la kkk , preguiça
        return "home";
    }

    public String ativar(BigInteger id) {
        produto = produtoEJB.obterProduto(id);
        produto.setEstatos(true);
        produtoEJB.editarProduto(produto);
        return "home";
    }

    public String cadastrarProduto() {

        String nomeArquivo = obterNomeArquivo();
        if (nomeArquivo != null && nomeArquivo.trim().length() > 0) {
            salvarImagem(nomeArquivo);
            produto.setImagemProduto(nomeArquivo);
            produto.setEstatos(true);
            getProdutoEJB().cadastrarProduto(getProduto());
            
            Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("mensagem", new Mensagem("Produto '" + produto.getNome() + "' cadastrado com sucesso", "success"));
            return "Home.xhtml";
        }
        return "telaListaProduto";

    }

    public String removerOProduto(BigInteger idP) {
        produto = produtoEJB.obterProduto(idP);
        produto.setEstatos(false);
        getProdutoEJB().removerProduto(produto);
        return "inicio";
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the produtoEJB
     */
    public ProdutoEJBLocal getProdutoEJB() {
        return produtoEJB;
    }

    /**
     * @param produtoEJB the produtoEJB to set
     */
    public void setProdutoEJB(ProdutoEJBLocal produtoEJB) {
        this.produtoEJB = produtoEJB;
    }

    public String getCategoria() {
        return categoria;
    }

    public String setCategoria(String categoria) {
        this.categoria = categoria;
        return "telaListaProduto";
    }
}
