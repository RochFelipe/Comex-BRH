package br.com.comex.funcao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.comex.csv.PedidoCsv;

public class TotalCategorias {

	public int calcularCategorias(List<PedidoCsv> pedidos) {
		Set<String> categoriaQueJaApareceram = new HashSet<>();
		int teste = 0;
		for (PedidoCsv pedidosCsv : pedidos) {
			String categoria = pedidosCsv.getCategoria();
			categoriaQueJaApareceram.add(categoria);
			
		}
		teste = categoriaQueJaApareceram.size();
		return teste;
	}

}
