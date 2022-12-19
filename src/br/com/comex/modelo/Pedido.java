package br.com.comex.modelo;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pedido {

	
	protected int id;
	protected String data;
	public Cliente cliente;

	public int getId() {
		return this.id;
	}

	public String getData() {
		return this.data;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setId(int id) {
		this.id = id;
		}

	public Pedido(int id) {
		this.id = id;

	}

	public Pedido(String data, Cliente cliente) {
		
		this.data = data;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "------------------\nPedido \nId: " + getId() + "\nData do Pedido: " + getData() + "\nNome do Cliente: "
				+ cliente.getNome() + "\n-----------------";
	}

	
}
