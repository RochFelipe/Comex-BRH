package br.com.comex.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {

	protected int id;
	protected String nome;
	protected String cpf;
	protected String telefone;
	protected String rua;
	protected String numero;
	protected String complemento;
	protected String bairro;
	protected String cidade;
	protected String estado;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setId(int id) {
		this.id = id;

	}

	public Cliente(int id) {

		this.id = id;
	}

	public Cliente() {
	}

	public Cliente(String nome, String cpf, String telefone, String rua, String numero, String complemento,
			String bairro, String cidade, String estado) {
		if (nome.substring(0).matches("[0-9]")) {
			throw new ComexException(nome + ". Erro: Nome do cliente não pode começar com números de 0 à 9");
		}
		
		/*
		 * if (id < 0) { throw new
		 * ComexException(nome+". Erro: Id  do cliente não deve ser menor 0"); }
		 
		if (nome.length() <= 5) {
			throw new ComexException(nome + ". Erro: Tamanho do nome do cliente que está invalido");
		}
		if (cpf.length() <= 11 && cpf.length() >= 14) {
			throw new ComexException(nome + ". Erro: Tamanho do CPF está errado");
		}
		if (!cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")) {
			throw new ComexException(nome + ". Erro: A formatação do CPF está errada. Ex: 000.000.000-00");
		}
		if (telefone.length() <= 11 && telefone.length() >= 16) {
			throw new ComexException(nome + ". Erro: Telefone é inválido");
		}

		if (rua == null || rua.length() <= 5) {
			throw new ComexException(nome + ". Erro: Rua está inválida");
		}
		if (numero == null || numero.length() <= 1) {
			throw new ComexException(nome + ". Erro: Numero do endereço errado");
		}
		if (complemento.length() <= 2) {
			throw new ComexException(nome + ". Erro: Complemento está errado");
		}
		if (bairro == null || bairro.length() <= 1) {
			throw new ComexException(nome + ". Erro: Bairro do errado");
		}
		if (cidade == null || cidade.length() <= 1) {
			throw new ComexException(nome + ". Erro: Cidade errada");
		}
		if (estadoVerificado(estado) != true) {
			throw new ComexException(nome + ". Erro: Estado não encontrado");
		}
		if (estado == null || estado.length() != 2) {
			throw new ComexException(nome + ". Erro: Estado errado");
		}
		*/

		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "------------------ \nCliente: " + getNome() + "\nId do Cliente: " + getId() + "\nCPF do cliente: "
				+ getCpf() + "\nTelefone: " + getTelefone() + "\nRua: " + getRua() + "\nNúmero do endereço: "
				+ getNumero() + "\nComplemento do endereço: " + getBairro() + "\nCidade: " + getCidade() + "\nEstado: "
				+ getEstado();
	}

	public boolean estadoVerificado(String ev) {
		ev.toLowerCase();
		if (ev == "AC" || ev == "AL" || ev == "AP" || ev == "AM" || ev == "BA" || ev == "CE" || ev == "DF" || ev == "ES"
				|| ev == "GO" || ev == "MA" || ev == "MT" || ev == "MS" || ev == "MG" || ev == "PA" || ev == "PB"
				|| ev == "PR" || ev == "PE" || ev == "PI" || ev == "RJ" || ev == "RN" || ev == "RS" || ev == "RO"
				|| ev == "RR" || ev == "SC" || ev == "SP" || ev == "SE" || ev == "TO") {
			return true;
		} else {
		}
		return false;
	}
}
