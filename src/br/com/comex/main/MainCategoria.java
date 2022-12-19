package br.com.comex.main;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.enun.TipoStatus;


public class MainCategoria {
	 public static void main (String[] args) {
		try {
			Categoria informatica = new Categoria("IFORMATICA",TipoStatus.ATIVA);
			System.out.println(informatica.toString());	
			
			Categoria moveis = new Categoria("MOVEIS",TipoStatus.INATIVA);
			System.out.println(moveis.toString());
			
			Categoria livros = new Categoria("LIVROS",TipoStatus.ATIVA);
			System.out.println(livros.toString());
			
			
		}catch(IllegalArgumentException ex){
			System.out.println("\nIh deu Erro!\n-> " + ex.getMessage());			
			System.out.println("-------------");
		}
		
		
	 }
	 
	 
}
