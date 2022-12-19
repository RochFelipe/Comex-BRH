package br.com.comex.main;

import java.text.SimpleDateFormat;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.enun.TipoStatus;

public class MainItemPedido {
	public static void main(String[] args) {
		try {
			SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");

			Categoria informatica = new Categoria("INFORMÁTICA", TipoStatus.ATIVA);
			Categoria moveis = new Categoria("MÓVEIS", TipoStatus.INATIVA);
			Categoria livros = new Categoria("LIVROS", TipoStatus.ATIVA);

			Produto produto1 = new Produto( "Notebook Samsung", 3523.00, 80, informatica);
			Produto produto2 = new Produto( "Clean Architecture", 102.90, 52, livros);
			Produto produto3 = new Produto( "Monitor Dell 27", 1889.00, 26, informatica);

			Cliente cliente1 = new Cliente("Ana Carolina", "111.111.111-11", "81 9 88785225", "rua 123", "21", "CASA C", "Torrões", "Recife",
					"Pe");
			Cliente cliente2 = new Cliente("Elizabeth", "222.222.222-22", "81 9 87785825", "rua abc", "S/N", "CASA D", "Torre", "Recife",
					"Pe");
			Cliente cliente3 = new Cliente("Gabriela", "333.333.333-22", "82 9 87785825", "rua zxc", "04", "S/N", "Boa Viagem", "Recife",
					"Pe");

			Pedido pedido1 = new Pedido( spf.format(22 - 02 - 2022), cliente1);
			Pedido pedido2 = new Pedido( spf.format(19 - 10 - 2019), cliente2);
			Pedido pedido3 = new Pedido( spf.format(31 - 07 - 2022), cliente3);
			Pedido pedido4 = new Pedido( spf.format(22 - 02 - 2022), cliente1);
			

			/*ItemPedido itempedido1 = new ItemPedido(produto1, produto1.getPrecoUnitario(), 1, pedido1,
					TipoDesconto.PROMOCAO);
			ItemPedido itempedido2 = new ItemPedido(produto2, produto2.getPrecoUnitario(), 2, pedido2,
					TipoDesconto.NENHUM);
			ItemPedido itempedido3 = new ItemPedido(produto1, produto1.getPrecoUnitario(), 1, pedido4,
					TipoDesconto.PROMOCAO);*/
			

			/*System.out.println(itempedido1.toString());
			System.out.println(itempedido2.toString());
			System.out.println(itempedido3.toString());*/


			
		}catch(IllegalArgumentException ex) {
			System.out.println("\nIh deu Erro!\n-> " + ex.getMessage());			
			System.out.println("-------------");
		}
		

	}
}
