package br.com.comex.main;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.ComexException;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.ProdutoIsento;
import br.com.comex.modelo.enun.TipoStatus;


public class MainProduto {
	public static void main (String[] args) {
		try {
			Categoria informatica = new Categoria("INFORMÁTICA",TipoStatus.ATIVA);		
			Categoria livros = new Categoria("LIVROS",TipoStatus.ATIVA);
			
			Produto produto1 = new Produto("Notebook Samsung", 3523.00, 1, informatica);
			System.out.printf(produto1.toString());
			System.out.printf("\n-------------------");
			Produto produto2 = new Produto("Clean Architecture", 102.90, 2, livros);
			System.out.printf(produto2.toString());
			System.out.printf("\n-------------------");
			Produto produto3 = new Produto("Monitor Dell 27",1889.00, 0, informatica);
			System.out.printf(produto3.toString());
			System.out.printf("\n-------------------");
			
			ProdutoIsento produtoIsento1 = new ProdutoIsento("Clean Architecture",102.90, 2, livros);
			System.out.printf(produtoIsento1.toString());
			System.out.printf("\n-------------------");
		}
		catch(ComexException ex){
			System.out.println("\nIh deu Erro!\n-> " + ex.getMessage());			
			System.out.println("-------------");
			System.out.println(ex.getStackTrace());
		}
		
		
				
		
		
		
		
		
		
		
		
		
		
		
	}
}