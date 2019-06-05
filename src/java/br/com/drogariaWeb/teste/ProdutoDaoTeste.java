package br.com.drogariaWeb.teste;

import br.com.drogariaWeb.dao.ProdutoDAO;
import br.com.drogariaWeb.domain.Fabricante;
import br.com.drogariaWeb.domain.Produto;
import java.sql.SQLException;
import org.junit.Test;

/**
 * @author Thermo
 */

public class ProdutoDaoTeste{
    @Test
    public void salvar() throws SQLException{
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
}
