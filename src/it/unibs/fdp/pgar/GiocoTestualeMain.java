package it.unibs.fdp.pgar;

import java.io.File;
import java.io.FilenameFilter;
import java.util.LinkedList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class GiocoTestualeMain {

	public final static String ELABORAZIONE="Elaborazione del file in corso.....";
	public final static String ARRIVEDERCI="Programma terminato\nArrivederci!";
	
	//public final static String IMMETTI_LINK="Inserisci l'indirizzo della cartella contenente il progetto Rovine Perdute\n"+ "Esempio : C:\\Users\\Gentian\\Desktop\\Esame\\PgAr2018_Esame_GentianDedej\\PgAr2018_Esame_FileXML ";
	//public final static String TITOLO="Seleziona il file che vuoi convertire";
	
	public static void main(String[] args) {
			
			/**
			 * inizzializzazione degli oggetti utilizzati
			 */
			Read read=new Read();
			Storie storie=new Storie(); 
			//boolean uscita=true;
			//String nomeFile=null;
			 
			read.readFile("PgAr2018_Story_2.1.xml",storie);
		
			System.out.println(ELABORAZIONE);
			/**
			 * ciclo che setta tutti i vicini di ogni citta
			 */
			storie.visualizzaStorie(storie.listaStorie);
			//long endTime   = System.currentTimeMillis();
			//System.out.println("Tempo di esecuzione del programma: "+(double)(endTime - startTime)/1000+" secondi");
			   }
			 //}while (uscita);
				
}