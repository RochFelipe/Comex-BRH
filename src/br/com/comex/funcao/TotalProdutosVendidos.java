package br.com.comex.funcao;

import java.util.List;

import br.com.comex.csv.PedidoCsv;

public class TotalProdutosVendidos {	

	public int calcularProdutos(List<PedidoCsv> pedidos) {
		int somaProdutos = 0;
		
		for (int i=0 ; i <pedidos.size(); i++) {
			somaProdutos += Integer.valueOf(pedidos.get(i).getQuantidade()) ;
		}
		return somaProdutos;
	}
	
	
}
