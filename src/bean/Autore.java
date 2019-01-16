package bean;

import java.io.Serializable;

public class Autore implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public Autore(String nome) {
		this.nome= nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
