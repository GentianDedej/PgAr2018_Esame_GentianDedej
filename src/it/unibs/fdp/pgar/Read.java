package it.unibs.fdp.pgar;

import java.io.FileInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class Read {
	/**metodo che legge un file passato come @param filename
	 * e aggiunge le storie che legge,settando i vari attributi
	 * @param cities
	 */
	public void readFile(String filename,Storie listaStorie) 
	{
		 
		 String attribute=null;
		 int numSto=0;
		 int numPar=0;
		 int numOpz=0;
		 boolean first=true;
		 
		 
			try 
			{
				
				XMLInputFactory xmlif=XMLInputFactory.newInstance();
		        XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename,new FileInputStream(filename));
		        
		        while(xmlr.hasNext()) 
		        {
		        	
		            switch(xmlr.getEventType())
		            {
		            
		            case XMLStreamConstants.START_DOCUMENT:
		            {		            
		            	System.out.println("Start Read Doc "+filename);
		            	
		            	break;
		            }
	        	
	        case XMLStreamConstants.START_ELEMENT:
	        	
	        	attribute=xmlr.getLocalName().trim();
	        	switch (attribute) 
	        	{
	           
				
				case ("story"):
				/**
				 * lettura degli attributi del story
				 */
				if(first==false) {
					numSto++;
				}
				String titolo=xmlr.getAttributeValue(0);
				int numeroParagrafi=Integer.parseInt(xmlr.getAttributeValue(1));
				
				listaStorie.listaStorie.add(new Storia(titolo,numeroParagrafi));
			
					break;
				case ("paragraph"):
					/**
					 * lettura degli attributi di paragraph
					 */
					if(first==false) {
						numPar++;
						
					}
					int id=Integer.parseInt(xmlr.getAttributeValue(0));
					String tipo=xmlr.getAttributeValue(1);
					listaStorie.listaStorie.get(numSto).listaParagrafi.add(new Paragrafo(id,tipo));
					first=true;
					numOpz=0;
				
						break;
				case ("description"):
					/**
					 * lettura del testo della descrizione
					 */
					listaStorie.listaStorie.get(numSto).listaParagrafi.get(numPar).descrizione=xmlr.getElementText();
					
					break;
				case ("option"):
					/**
					 * lettura opzioni
					 */
					
					String s=xmlr.getElementText().trim();
					//System.out.println(xmlr.getAttributeValue(0));
					//int linkto=Integer.parseInt(xmlr.getAttributeValue(0)); <--- non so il perchè non reisco a recuperare il valore del linkto del paragrafo collegato
					
					
					listaStorie.listaStorie.get(numSto).listaParagrafi.get(numPar).listaOpzioni.add(new Opzione(s));
					
					numOpz++;
					break;

					
	
				default:
					break;
				}
	        	
			          
	        	break;	            	
	       	
	        default:
	        	break;
	        }
	        xmlr.next();
	    }
	   
	   
		        System.out.println("End Read Doc "+filename+"\n");
	}
			catch(Exception e)
			{
				System.err.println("Error detected");
				System.err.println(e.getMessage());
	        }
	}


}

