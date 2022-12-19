package br.com.comex.funcao;


import java.text.NumberFormat;
import java.util.List;

import br.com.comex.csv.PedidoCsv;

public class PedidoMaisBaratoEMaisCaro{
	public void compararBaratoECaro(List<PedidoCsv> pedidos) {
		double barato = Double.parseDouble(pedidos.get(0).getPreco()) ,caro = Double.parseDouble(pedidos.get(0).getPreco()), preco = 0;
		String maiorProduto = null,menorProduto = null;
				
		for(PedidoCsv pedidoCsv : pedidos) {
			preco = Double.parseDouble(pedidoCsv.getPreco()) * Double.parseDouble(pedidoCsv.getQuantidade());
			if(preco > caro) {
				caro = preco;
				maiorProduto = pedidoCsv.getProduto();
			}if(preco < barato) {
				barato = preco;
				menorProduto = pedidoCsv.getProduto();
			}
		}
		System.out.println("Pedido mais barato: "+NumberFormat.getCurrencyInstance().format(barato)+ " ("+menorProduto+")"
				+"\nPedido mais caro: "+NumberFormat.getCurrencyInstance().format(caro)+ " ("+maiorProduto+")");		
		
	}

		
}
