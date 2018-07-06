package it.unibs.fdp.pgar;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;


/**
 * Questa classe rappresenta un paragrafo della storia a bivi
 * @author Gentian
 *
 */

public class Paragrafo {
	
	int ID;
	String descrizione;
	ArrayList<Opzione> listaOpzioni;
	int numeroOpzioni;
	String tipo;
	public final static String TITOLO="PARAGRAFO";
	public final static String MSG_TESTO_OPZIONE="INSERISCI IL TESTO DEL OPZIONE";
	public final static String MSG_TESTO_ID="INSERISCI IL ID DEL PARAGAFO COLLEGATO";
	String []voci= 
	{
		"AGGIUNGI OPZIONE"	
	};
	
	public Paragrafo(int id,String tipo)
	{
		this.ID=id;
		this.tipo=tipo;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public ArrayList<Opzione> getListaOpzioni() {
		return listaOpzioni;
	}
	public void setListaOpzioni(ArrayList<Opzione> listaOpzioni) {
		this.listaOpzioni = listaOpzioni;
	}
	public int getNumeroOpzioni() {
		return numeroOpzioni;
	}
	public void setNumeroOpzioni(int numeroOpzioni) {
		this.numeroOpzioni = numeroOpzioni;
	}
	public Paragrafo scegliOpzione() {
		
		MenuVisualizza menu =new MenuVisualizza(descrizione, listaOpzioni,2);
		boolean fine = false;//serve per uscire dal menu
		
		do 
		{
			int voceSelezionata = menu.scegli();//vedi classe inputDati(serve a impostare la selezione del menu)
		
			switch ( voceSelezionata ) 
			{
				default:
					if(voceSelezionata>listaOpzioni.size()) {
						System.out.println("Operazione non riconosciuta.");
						 break;
					}
					else
						return listaOpzioni.get(voceSelezionata).collegamento;
				case 0:
					break;
			
			}//switch
		
		} while ( !fine );
		return null;
		
		
	}

	public void aggiungiOpzione() {
		MyMenu menu =new MyMenu(TITOLO, voci);
		boolean fine = false;//serve per uscire dal menu
		
		do 
		{
			int voceSelezionata = menu.scegli();//vedi classe inputDati(serve a impostare la selezione del menu)
		
			switch ( voceSelezionata ) 
			{
			case 1:
				listaOpzioni.add(new Opzione(InputDati.leggiStringa(MSG_TESTO_OPZIONE),InputDati.leggiIntero(MSG_TESTO_ID)));
				break;
			case 0:
				break;
			default:
				System.out.println("Operazione non riconosciuta.");
			 break;
			
			}

		} while ( !fine );
		
	}

}
