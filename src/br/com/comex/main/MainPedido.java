package br.com.comex.main;

import java.text.SimpleDateFormat;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Pedido;

public class MainPedido {
	public static void main(String[] args) {
		try {
			SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
			Cliente cliente1 = new Cliente("Ana Carolina", "111.111.111-11", "81 9 88785225", "rua 123", "21", "CASA C", "Torrões", "Recife",
					"Pe");
			Cliente cliente2 = new Cliente("Elizabeth", "222.222.222-22", "81 9 87785825", "rua abc", "S/N", "CASA D", "Torre", "Recife",
					"Pe");
			Cliente cliente3 = new Cliente("Gabriela", "333.333.333-22", "82 9 87785825", "rua zxc", "04", "S/N", "Boa Viagem", "Recife",
					"Pe");
			
			Pedido pedido1 = new Pedido(spf.format(22-02-2022) ,cliente1);
			Pedido pedido2 = new Pedido(spf.format(19-10-2019) ,cliente2);
			Pedido pedido3 = new Pedido(spf.format(31-07-2022) ,cliente3);
			Pedido pedido4 = new Pedido(spf.format(26-02-2022) ,cliente1);
			
			System.out.println(pedido1.toString());
			System.out.println(pedido2.toString());
			System.out.println(pedido3.toString());
			System.out.println(pedido4.toString());
			
		}catch(IllegalArgumentException ex){
			System.out.println("\nIh deu Erro!\n-> " + ex.getMessage());			
			System.out.println("-------------");
		}
		
		
		
	}
}