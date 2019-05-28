package br.com.drogariaWeb.bean;

import br.com.drogariaWeb.dao.FabricanteDAO;
import br.com.drogariaWeb.domain.Fabricante;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "MBFabricante")

@ViewScoped
public class FabricanteBean {

    private Fabricante fabricante;
    private ListDataModel<Fabricante> itens;

    public ListDataModel<Fabricante> getItens() {
        return itens;
    }

    public void setItens(ListDataModel<Fabricante> itens) {
        this.itens = itens;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @PostConstruct
    public void prepararPesquisa() {
        try {
            FabricanteDAO dao = new FabricanteDAO();
            ArrayList<Fabricante> lista = dao.listar();
            itens = new ListDataModel<Fabricante>(lista);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void novo(){
        try {
        FabricanteDAO dao = new FabricanteDAO();
            dao.salvar(fabricante);
            
            ArrayList<Fabricante> lista = dao.listar();
            itens = new ListDataModel<Fabricante>(lista);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void prepareNew(){
        fabricante = new Fabricante();
    }

}