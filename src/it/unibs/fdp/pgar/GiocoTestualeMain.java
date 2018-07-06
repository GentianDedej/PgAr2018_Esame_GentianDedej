package it.unibs.fdp.pgar;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class GiocoTestualeMain {

	public final static String ELABORAZIONE="Elaborazione del file in corso.....";
	public final static String ARRIVEDERCI="Programma terminato\nArrivederci!";
	public final static String MENU_TITOLO="MENU GIOCO TESTUALE";
	public final static String MSG_RICER_STORIE="SCRIVI IL NOME DELLA CITTA' DA TROVARE";
	static String[]voci= 
	{
		"VISUALIZZA STORIE ED ESEGUI",
		"RICERCA STORIE TRAMITE TITOLO",
		"ORDINA STORIE"
	};
	
	public static void main(String[] args) {
			
			/**
			 * inizzializzazione degli oggetti utilizzati
			 */
			Read read=new Read();
			Storie storie=new Storie(); 
			//boolean uscita=true;
			//String nomeFile=null;
			 
			read.readFile("C:\\Users\\Gentian\\Desktop\\Esame\\PgAr2018_Esame_GentianDedej\\PgAr2018_Esame_FileXML\\PgAr2018_Story_2.1.xml",storie);
		
			System.out.println(ELABORAZIONE);
			/**
			 * ciclo che setta tutti i vicini di ogni citta
			 */
			MyMenu menu=new MyMenu(MENU_TITOLO, voci);
			boolean fine = false;//serve per uscire dal menu
			
			do 
			{
				int voceSelezionata = menu.scegli();//vedi classe inputDati(serve a impostare la selezione del menu)
			
				switch ( voceSelezionata ) 
				{
				case 1:
					storie.visualizzaStorie(storie.listaStorie);
					break;
				case 2:
					Storia st=storie.ricercaStoria(InputDati.leggiStringa(MSG_RICER_STORIE));
					if(st.equals(null)) {
						System.out.println("STORIA NON TROVATA");
					}
					else
						st.eseguiStoria();
					break;
				case 0:
					fine=true;
					break;
				}
			}while(!fine);
			//long endTime   = System.currentTimeMillis();
			//System.out.println("Tempo di esecuzione del programma: "+(double)(endTime - startTime)/1000+" secondi");
			   }
			 //}while (uscita);
				
}