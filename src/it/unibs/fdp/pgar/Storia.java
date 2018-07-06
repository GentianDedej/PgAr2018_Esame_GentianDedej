package it.unibs.fdp.pgar;

import java.util.ArrayList;

/**
 * Questa classe rappresenta una storia a bivi
 * @author Gentian
 *
 */
public class Storia {
	
	String titolo;
	int numeroParagrafi;
	ArrayList<Paragrafo> listaParagrafi;
	
	public Storia(String titolo,int numeroParagrafi)
	{
		this.titolo=titolo;
		this.numeroParagrafi=numeroParagrafi;
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

}