package br.com.comex.main;

import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.ComexException;

public class MainCliente {
	public static void main(String[] args) {
		try {
			Cliente cliente1 = new Cliente("Anna Carolina", "111.111.111-11", "(81) 9 8878-5225", "rua 123", "21", "CASA C", "Torrões", "Recife",
					"PE");
			Cliente cliente2 = new Cliente("Elizabeth", "222.222.222-22", "(81) 9 8778-5825", "rua abc", "S/N", "CASA D", "Torre", "Recife",
					"CE");
			Cliente cliente3 = new Cliente("Gabriela", "333.333.333-22", "(82) 9 8778-5825", "rua zxc", "04", "S/N", "Boa Viagem", "Recife",
					"SC");
			System.out.println(cliente1.toString());
			System.out.println("\n-----------------");
			System.out.println(cliente2.toString());
			System.out.println("\n-----------------");
			System.out.println(cliente3.toString());
			System.out.println("\n-----------------");
		}catch (ComexException ex){
			System.out.println("\nIh deu Erro!\n-> " + ex.getMessage());			
			System.out.println("-------------");
		}
		
	}
}
