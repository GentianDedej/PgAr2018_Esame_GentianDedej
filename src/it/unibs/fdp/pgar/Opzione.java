package it.unibs.fdp.pgar;
/**
 * 
 * @author Gentian
 *
 */

public class Opzione {
	
	String nome;
	Paragrafo collegamento;
	int id_collegamento;
	public Opzione(String nome,int id_collegamento) {
		this.nome=nome;
		this.id_collegamento=id_collegamento;
	}
	public Opzione(String nome)
	{
		this.nome=nome;
		collegamento=new Paragrafo();
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
	public String toString() {
		return nome;
	}
	

}
