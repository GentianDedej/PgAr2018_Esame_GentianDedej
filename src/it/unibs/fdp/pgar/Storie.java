package it.unibs.fdp.pgar;

import java.util.ArrayList;
import java.util.Arrays;


public class Storie {
	
	public final static String STORIE_TITOLO="STORIE A BIVI";
	
	ArrayList<Storia> listaStorie;
	
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
	/*
	public ArrayList<Storia> ordinaNum() {
		ArrayList<Storia> sorted = (ArrayList<Storia>) Arrays.asList(
                listaStorie.stream().sorted(
                    (s1, s2) -> s1.listaParagrafi.size().
                ).toArray(Storia[]::new)
            );
		return (ArrayList<Storia>)sorted;
				
	}*/
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
						listaStorie.get(voceSelezionata).eseguiStoria();
				case 0:
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

}
