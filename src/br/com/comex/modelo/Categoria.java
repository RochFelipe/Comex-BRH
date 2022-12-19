package br.com.comex.modelo;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.comex.modelo.enun.TipoStatus;

@XmlRootElement
public class Categoria {
	
	
	protected int id;;
	protected String nome;
	protected TipoStatus status = TipoStatus.ATIVA;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public TipoStatus getStatus() {
		return status;
	}
	public void setId(int id) {
		this.id = id;
		
	}
	
	public Categoria(int id) {
		
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(TipoStatus status) {
		this.status = status;
	}

	public Categoria() {
		
	}
	public Categoria(String nome, TipoStatus ativa) {			
		
		/*if(nome==null || nome.substring(0,1).matches("[0-9]*")){
			throw new ComexException(nome+". Erro: Não pode começar com números de 0 à 9");
		}
		/if ( id < 0) {
		
		
		if (nome.length()<=3) {
			 throw new ComexException(nome+". Erro: Nome da categoria deve ser maior que 3 caracteres");
		}
		if (status==null || (TipoStatus.ATIVA != status) && (TipoStatus.INATIVA != status)) {
			 throw new ComexException(nome+". Erro: Status diferente de Ativa e Inativa");
		}*/		
		this.nome = nome;
		this.status = ativa;		
		
	}	

	@Override
	public String toString() {
		return "\nCategoria " + getNome() + " ("+getId() +" - "+getStatus() +")";
	}

}
