package it.unibs.fdp.pgar;
/**
 * 
 * @author Gentian
 *
 */

public class Opzione {
	
	String nome;
	Paragrafo collegamento;
	
	public Opzione(String nome)
	{
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Paragrafo getCollegamento() {
		return collegamento;
	}
	public void setCollegamento(Paragrafo collegamento) {
		this.collegamento = collegamento;
	}
	

}
