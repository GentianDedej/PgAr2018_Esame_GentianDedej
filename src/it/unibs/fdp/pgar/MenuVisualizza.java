package it.unibs.fdp.pgar;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
/**
 * questa classe è la modifica della classe MyMenu della libreria Mylib
 * @author Fondamenti di programmazione
 *
 */
public class MenuVisualizza {
	final private static String CORNICE = "--------------------------------";
	  final private static String VOCE_USCITA = "0\tEsci";
	  final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";

	  private String titolo;
	  private ArrayList<Storia> voci;
	  private ArrayList<Opzione> opzioni;

	  public MenuVisualizza (String titolo, ArrayList<Storia> voci)
	  {
		  this.titolo=titolo;
		  this.voci=voci;
		  
	  }

	  public MenuVisualizza (String titolo, ArrayList<Opzione> opzioni,int a) {
		  this.titolo=titolo;
		  this.opzioni=opzioni;
	  }
	public int scegli ()
	  {
		stampaMenu();
		return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, voci.size());	 
	  }
			
	  public void stampaMenu ()
	  {
		System.out.println(CORNICE);
		System.out.println(titolo);
		System.out.println(CORNICE);
	    for (int i=0; i<voci.size(); i++)
		 {
		  System.out.println( (i+1) + "\t" + voci.get(i));
		 }
	    System.out.println();
		System.out.println(VOCE_USCITA);
	    System.out.println();
	  }
	  public int scegliOpzione ()
	  {
		stampaMenu();
		return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, 0, opzioni.size());	 
	  }
			
	  public void stampaMenuOpzioni ()
	  {
		System.out.println(CORNICE);
		System.out.println(titolo);
		System.out.println(CORNICE);
	    for (int i=0; i<voci.size(); i++)
		 {
		  System.out.println( (i+1) + "\t" + opzioni.get(i));
		 }
	    System.out.println();
		System.out.println(VOCE_USCITA);
	    System.out.println();
	  }
			
	}

