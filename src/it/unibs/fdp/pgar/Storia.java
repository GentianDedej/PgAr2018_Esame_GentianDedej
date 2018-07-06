package it.unibs.fdp.pgar;

import java.util.ArrayList;

/**
 * Questa classe rappresenta una storia a bivi
 * @author Gentian
 *
 */
public class Storia implements Comparable<Storia> {
	
	String titolo;
	int numeroParagrafi;
	ArrayList<Paragrafo> listaParagrafi;
	
	public Storia(String titolo,int numeroParagrafi)
	{
		this.titolo=titolo;
		this.numeroParagrafi=numeroParagrafi;
		listaParagrafi=new ArrayList<Paragrafo>();
	}
	public Storia(String titolo)
	{
		this.titolo=titolo;
		listaParagrafi=new ArrayList<Paragrafo>();
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getNumeroParagrafi() {
		return numeroParagrafi;
	}
	public void setNumeroParagrafi(int numeroParagrafi) {
		this.numeroParagrafi = numeroParagrafi;
	}
	public ArrayList<Paragrafo> getListaParagrafi() {
		return listaParagrafi;
	}
	public void setListaParagrafi(ArrayList<Paragrafo> listaParagrafi) {
		this.listaParagrafi = listaParagrafi;
	}
	public Paragrafo trovaPrimoParagrafo() {
		for (int i = 0; i < listaParagrafi.size(); i++) {
			if(listaParagrafi.get(i).ID==0)
				return listaParagrafi.get(i);
		}
		return null;
	}
	/**
	 * metodo che esegue la storia;
	 * primo indica il primo elemento della storia
	 * p indica il paragrafo senza opzioni cioè l'ultimo della storia;
	 */
	public void eseguiStoria() {
		System.out.println(titolo);
		Paragrafo primo;
		primo=trovaPrimoParagrafo();
		Paragrafo p=primo.scegliOpzione();
		boolean fine=false;
		do {
			if(p.listaOpzioni.size()==0)
				fine=true;
			else
				p=p.scegliOpzione();
		}while(!fine);
		
	}
	public Paragrafo trovaParagrafo(int id) {
		for (int i = 0; i < listaParagrafi.size(); i++) {
			if(id==listaParagrafi.get(i).ID)
				return listaParagrafi.get(i);
		}
		return null;
	}
	public void aggiungiParagrafo(int id,String tipo) {
		listaParagrafi.add(new Paragrafo(id, tipo));
	}
	public String toString() {
		return titolo;
	}

	@Override
	public int compareTo(Storia arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
