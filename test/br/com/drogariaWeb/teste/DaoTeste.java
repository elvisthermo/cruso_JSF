package br.com.drogariaWeb.teste;

import br.com.drogariaWeb.dao.ProdutoDAO;
import br.com.drogariaWeb.domain.Fabricante;
import br.com.drogariaWeb.domain.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Thermo
 */
public class DaoTeste {

    @Test
//    @Ignore
    public void salvar() throws SQLException {
        Produto p = new Produto();
        p.setDescricao("nova comprimidos");
        p.setPreco(2.55);
        p.setQuantidade(13L);

        Fabricante f = new Fabricante();
        f.setCodigo(6l);

        p.setFabricante(f);

        ProdutoDAO dao = new ProdutoDAO();
        dao.salvar(p);

    }

    @Test
    @Ignore
    public  void Listar() throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        
        ArrayList<Produto> lista = dao.listar();
    
        for(Produto p: lista){
            System.out.println("Codigo = "+p.getCodigo());
            System.out.println("Descricap do produto = "+p.getDescricao());
            System.out.println("Preço = "+p.getPreco());
            System.out.println("Quantidade = "+p.getQuantidade());
            System.out.println("Codigo do Fabricante = "+p.getFabricante().getCodigo());
            System.out.println("Descricao Fabricante = "+p.getFabricante().getDescricao());
            System.out.println("--------------------------------------------------");
        }
    }
    
    @Test
    @Ignore
    public void excluir() throws SQLException{
        Produto p = new Produto();
        p.setCodigo(2L);
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.excluir(p);
        
    }
    
    @Test
    public void editar() throws SQLException{
        Produto p = new Produto();
        p.setCodigo(1L);
        p.setDescricao("cataroflan");
        p.setPreco(18.70);
        p.setQuantidade(70L);
        
        Fabricante f = new Fabricante();
        f.setCodigo(8L);
        p.setFabricante(f);

        ProdutoDAO dao = new ProdutoDAO();
        dao.editar(p);
        
    }

}
