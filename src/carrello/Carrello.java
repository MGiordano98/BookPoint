package carrello;

import java.util.ArrayList;

import bean.Libro;

public class Carrello {
	private ArrayList<Libro> libri;
	private double totale;

	public Carrello() {
		libri= new ArrayList<Libro>();
		totale= 0;
	}

	public Carrello(ArrayList<Libro> libri, double totale) {
		this.libri= libri;
		this.totale= totale;
	}

	public ArrayList<Libro> getLibri() {
		return libri;
	}

	public void setLibri(ArrayList<Libro> libri) {
		this.libri = libri;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}


	public boolean aggiungiAlCarrello(Libro libro, int quantit‡) {
		boolean trovato=false;
		boolean aggiunto=false;
		int quantit‡B=0;
		for(Libro lib: libri) {
			if(lib.getIsbn().equalsIgnoreCase(libro.getIsbn())) {
				quantit‡B= lib.getQuantit‡Selezionata();
				if((lib.getQuantit‡Selezionata()+quantit‡)< lib.getQuantit‡()) {
					lib.setQuantit‡Selezionata(lib.getQuantit‡Selezionata() + quantit‡);
				}else {
					lib.setQuantit‡Selezionata(lib.getQuantit‡());
				}
				trovato=true;
				aggiunto=true;
				break;
			}
		}
		if(!trovato) {
			libro.setQuantit‡Selezionata(quantit‡);
			libri.add(libro);
			aggiunto=true;
		}else {
			totale-= quantit‡B* libro.getPrezzo();
		}
		totale= totale+(libro.getPrezzo()*quantit‡);
				
		return aggiunto;
	}

	public boolean aumentaQuantit‡(String isbn) {
		boolean successo=false;
		for(Libro temp : libri){

			if(temp.getIsbn().equalsIgnoreCase(isbn)){
				if(temp.getQuantit‡Selezionata()<temp.getQuantit‡()) {
					temp.setQuantit‡Selezionata(temp.getQuantit‡Selezionata()+1);
					totale= totale+ temp.getPrezzo();
					successo=true;
					break;
				}
			}
		}
		
		return successo;
	}

	public boolean diminuisciQuantit‡(String isbn) {
		boolean successo=false;
		for(Libro temp : libri){

			if(temp.getIsbn().equalsIgnoreCase(isbn)){
				if(temp.getQuantit‡Selezionata()>1) {
					temp.setQuantit‡Selezionata(temp.getQuantit‡Selezionata()-1);
					totale= totale- temp.getPrezzo();
					successo=true;
					break;
				}
			}
		}
		return successo;
	}

	public boolean rimuoviLibro(String isbn) {
		boolean successo=false;
		for(Libro temp : libri){

			if(temp.getIsbn().equalsIgnoreCase(isbn)){

				libri.remove(temp);
				totale= totale- (temp.getQuantit‡Selezionata() * temp.getPrezzo());
				successo=true;
				break;
			}
		}
		return successo;
	}

	public Libro getLibro(String isbn) {
		for(Libro temp : libri) {
			if(temp.getIsbn().equalsIgnoreCase(isbn)){

				return temp;
			}
		}
		return null;
	}
}
