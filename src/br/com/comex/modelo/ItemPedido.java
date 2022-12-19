package br.com.comex.modelo;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.comex.funcao.ValorQuantidade;
import br.com.comex.modelo.enun.TipoDesconto;

@XmlRootElement
public class ItemPedido implements ValorQuantidade {

	
	protected Produto produto;
	public Pedido pedido;
	protected int id;
	protected double preco_unitario;
	protected int quantidade;
	protected double desconto;
	protected TipoDesconto tipo_desconto = TipoDesconto.NENHUM;

	public Produto getProduto() {
		return this.produto;
	}

	public int getId() {
		return this.id;
	}

	public double getPrecoUnitario() {
		return this.preco_unitario;
	}

	public int getQtdItens() {
		return this.quantidade;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public double getDesconto() {
		return this.desconto;
	}

	public TipoDesconto getTipoDesconto() {
		return this.tipo_desconto;
	}

	public double getPreco() {
		return this.preco_unitario;
	}

	public int getQuantidade() {
		return this.quantidade;
	}
	
	public void setId(int id) {
		this.id = id;
		
	}

	public double PrecoTotalSDesconto() {
		return this.getPrecoUnitario() * this.getQtdItens();
	}

	public double CalculaDesconto() {
		if (this.getTipoDesconto() == TipoDesconto.PROMOCAO) {
			return 0.2;
		} else if (this.getQtdItens() >= 10 && this.getTipoDesconto() == TipoDesconto.QUANTIDADE) {
			return 0.1;
		}
		return 0;
	}

	public double TotalComDesconto() {
		return this.PrecoTotalSDesconto() - (this.getPrecoUnitario() * this.CalculaDesconto());
	}

	public ItemPedido(Integer id) {
		super();
		this.id = id;

	}

	public ItemPedido(Produto produto, double preco_unitario, int qtd_itens, Pedido pedido, double desconto
			) {
		
		this.produto = produto;
		this.preco_unitario = preco_unitario;
		this.quantidade = qtd_itens;
		this.pedido = pedido;
		this.desconto = this.getPrecoUnitario() * this.CalculaDesconto();
	}
	public ItemPedido(Produto produto, double preco_unitario, int qtd_itens, Pedido pedido,
			double desconto, TipoDesconto tipo_desconto) {
		
		this.produto = produto;
		this.preco_unitario = preco_unitario;
		this.quantidade = qtd_itens;
		this.pedido = pedido;
		this.tipo_desconto = tipo_desconto;
		this.desconto = this.getPrecoUnitario() * this.CalculaDesconto();
	}

	

	public String toString() {
		return "-------------\nNome do Cliente: " + pedido.cliente.getNome() + "\nItem Pedido: " + getId()
				+ "\nQuantidade de item: " + getQtdItens() + "\nValor do item: " + getPrecoUnitario()
				+ "\nValor total da compra: " + TotalComDesconto() + "\nDesconto aplicado: " + getDesconto()
				+ "\n-------------";
	}

	
}
