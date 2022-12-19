package br.com.comex.funcao;

import java.util.List;

import br.com.comex.csv.PedidoCsv;

public class MontanteTotalVendas {
	public double calcularMontante(List<PedidoCsv> pedidos) {
		double somaTotal = 0;
		for (PedidoCsv pedidoCsv : pedidos) {
			somaTotal += Double.parseDouble(pedidoCsv.getPreco()) * Double.parseDouble(pedidoCsv.getQuantidade());
		}
		return somaTotal;
	}
}
