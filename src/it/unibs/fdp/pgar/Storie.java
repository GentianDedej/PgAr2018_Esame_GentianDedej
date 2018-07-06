package it.unibs.fdp.pgar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;


public class Storie{
	
	public final static String STORIE_TITOLO="STORIE A BIVI";
	
	ArrayList<Storia> listaStorie;
	public static final String MSG_TITOLO_STO="INSERISCI IL TITOLO DELLA STORIA";
	public static final String MSG_TIPO_PAR="INSERISCI IL TIPO DI PARAGAFO:\t scriver basic se si vuole quello di default ";
	public static final String MSG_AGG_PAR="VUOI AGGIUNGERE ALTRI PARAGRAFI? DIGITA Y/N";
	String []voci=
		{
			"AGGIUNGI STORIA"
		};
	
	public Storie() {
		listaStorie=new ArrayList<Storia>();
	}
	
	public ArrayList<Storia> ordinaAlf() {
		ArrayList<Storia> sorted = (ArrayList<Storia>) Arrays.asList(
                listaStorie.stream().sorted(
                    (s1, s2) -> s1.titolo.compareToIgnoreCase(s2.titolo)
                ).toArray(Storia[]::new)
            );
		return (ArrayList<Storia>)sorted;
		
	}
	
	public void ordinaNum() {
		Collections.sort(listaStorie);
				
	}
	public ArrayList<Storia> getListaStorie() {
		return listaStorie;
	}
	public void setListaStorie(ArrayList<Storia> listaStorie) {
		this.listaStorie = listaStorie;
	}
	public void visualizzaStorie(ArrayList<Storia> listaStorie) {
		
		this.listaStorie=listaStorie;
		
		MenuVisualizza menuVisuStorie = new MenuVisualizza(STORIE_TITOLO, listaStorie);
		boolean fine = false;//serve per uscire dal menu
		
		do 
		{
			int voceSelezionata = menuVisuStorie.scegli();//vedi classe inputDati(serve a impostare la selezione del menu)
		
			switch ( voceSelezionata ) 
			{
				default:
					if(voceSelezionata>listaStorie.size())
					{
						System.out.println("Operazione non riconosciuta.");
						 break;
					}
					else
						listaStorie.get(voceSelezionata-1).eseguiStoria();
						break;
				case 0:
					fine=true;
					break;
			}
		}while(!fine);
	}
	public Storia ricercaStoria(String titoloDaCercare) {
		
		try {
			for (int i = 0; i < listaStorie.size(); i++) {
				if(listaStorie.get(i).titolo.equals(titoloDaCercare)) 
					{
						return listaStorie.get(i);
					}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
				
				
				
	}
	public String toString() {
		return STORIE_TITOLO;
	}
	public void creazioneStoria() {
		
		MyMenu menu= new MyMenu(STORIE_TITOLO, voci);
		boolean fine = false;//serve per uscire dal menu
		int i=0;//i corisponde al numero di paragrafi per storia creati
		boolean fine_par=false;
		
		do 
		{
			int voceSelezionata = menu.scegli();//vedi classe inputDati(serve a impostare la selezione del menu)
			
			switch ( voceSelezionata ) 
			{
				case 1:
					String titolo=InputDati.leggiStringa(MSG_TITOLO_STO);
					listaStorie.add(new Storia(titolo));
					int j=0;
					do {
					ricercaStoria(titolo).aggiungiParagrafo(i,InputDati.leggiStringa(MSG_TIPO_PAR));
					j++;
					ricercaStoria(titolo).listaParagrafi.get(j).aggiungiOpzione();
					char c=InputDati.leggiChar(MSG_AGG_PAR);
					if(c=='n'||c=='N') {
						fine_par=true;
					}
					}while(!fine_par);

				default:
					System.out.println("Operazione non riconosciuta.");
				 break;
				case 0:
					fine=true;
					break;
			}

		}while(!fine);
	}
}