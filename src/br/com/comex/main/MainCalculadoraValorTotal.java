package br.com.comex.main;

import java.text.SimpleDateFormat;

import br.com.comex.funcao.CalculadoraValorTotal;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.enun.TipoStatus;

public class MainCalculadoraValorTotal {
	public static void main(String[] args) {
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");

		Categoria informatica = new Categoria("INFORMÁTICA", TipoStatus.ATIVA);
		Categoria livros = new Categoria("LIVROS", TipoStatus.INATIVA);

		Produto produto1 = new Produto("Notebook Samsung", 3523.00, 80, informatica);
		Produto produto2 = new Produto("Clean Architecture", 102.90, 52, livros);

		Cliente cliente1 = new Cliente("Ana Carolina", "111.111.111-11", "81 9 88785225", "rua 123", "21", "CASA C", "Torrões", "Recife",
				"Pe");
		Cliente cliente2 = new Cliente("Elizabeth", "222.222.222-22", "81 9 87785825", "rua abc", "S/N", "CASA D", "Torre", "Recife",
				"Pe");
		Cliente cliente3 = new Cliente("Gabriela", "333.333.333-22", "82 9 87785825", "rua zxc", "04", "S/N", "Boa Viagem", "Recife",
				"Pe");
		Pedido pedido1 = new Pedido(spf.format(22 - 02 - 2022), cliente1);
		Pedido pedido2 = new Pedido(spf.format(19 - 10 - 2019), cliente2);

		/*ItemPedido itempedido1 = new ItemPedido(produto1, produto1.getPrecoUnitario(), 1, pedido1,
				 TipoDesconto.PROMOCAO);
		ItemPedido itempedido2 = new ItemPedido(produto2, produto2.getPrecoUnitario(), 2, pedido2,
				TipoDesconto.NENHUM);*/

		CalculadoraValorTotal cvt = new CalculadoraValorTotal();
		
	/*	System.out.println("\nValor unitario: "+itempedido1.getPreco()+"\nQuantidade: "+itempedido1.getQuantidade()+"\nValores Totais: " + cvt.Calcula(itempedido1));
		System.out.println("\nValor unitario: "+produto2.getPreco()+"\nQuantidade: "+produto2.getQuantidade()+"\nValores Totais: " + cvt.Calcula(produto2));
	*/	
		
	}
}
