package br.com.drogariaWeb.bean;

import br.com.drogariaWeb.dao.FabricanteDAO;
import br.com.drogariaWeb.dao.ProdutoDAO;
import br.com.drogariaWeb.domain.Fabricante;
import br.com.drogariaWeb.domain.Produto;
import br.com.drogariaWeb.util.JSFUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Thermo
 */
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

    private ArrayList<Produto> itens;
    private ArrayList<Produto> itensFiltrados;
    private Produto produto;
    private ArrayList<Fabricante> combofabricante;

    public ArrayList<Produto> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ArrayList<Fabricante> getCombofabricante() {
        return combofabricante;
    }

    public void setCombofabricante(ArrayList<Fabricante> combofabricante) {
        this.combofabricante = combofabricante;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    public void carregarListagem() {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            itens = dao.listar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getLocalizedMessage());
        }

    }

    public void prepararNovo() {
        try {
            produto = new Produto();
            FabricanteDAO dao = new FabricanteDAO();
            combofabricante = dao.listar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getLocalizedMessage());
        }

    }

    public void novo() {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.salvar(produto);

            itens = dao.listar();
            JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }
    }

    public void excluir() {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            dao.excluir(produto);
            
            itens = dao.listar();
            JSFUtil.adicionarMensagemSucesso("Produto excluido com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }

    }
    
    public void prepararEditar(){
     try {
            FabricanteDAO dao = new FabricanteDAO();
            combofabricante = dao.listar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }
    
    }
    
    public void Editar(){
     try {
            ProdutoDAO dao = new ProdutoDAO();
            
            dao.editar(produto);
            itens = dao.listar();
            
            JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso.");
     } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.adicionarMensagemErro(ex.getMessage());
        }
  
    }
}
