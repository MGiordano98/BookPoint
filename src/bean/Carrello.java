package bean;

import java.util.ArrayList;

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


	public void aggiungiAlCarrello(Libro libro, int quantit‡) {
		boolean trovato=false;
		for(Libro lib: libri) {
			if(lib.getIsbn().equalsIgnoreCase(libro.getIsbn())) {
				lib.setQuantit‡Selezionata(lib.getQuantit‡Selezionata() + quantit‡);
				trovato=true;
				break;
			}
		}
		if(!trovato) {
		libro.setQuantit‡Selezionata(quantit‡);
		libri.add(libro);
		totale= totale+(libro.getPrezzo()*quantit‡);
		}
	}

	public void aumentaQuantit‡(String isbn) {
		for(Libro temp : libri){

			if(temp.getIsbn().equalsIgnoreCase(isbn)){

				temp.setQuantit‡Selezionata(temp.getQuantit‡Selezionata()+1);
				totale= totale+ temp.getPrezzo();
				break;
			}
		}
	}

	public void diminuisciQuantit‡(String isbn) {
		for(Libro temp : libri){

			if(temp.getIsbn().equalsIgnoreCase(isbn)){

				temp.setQuantit‡Selezionata(temp.getQuantit‡Selezionata()-1);
				totale= totale- temp.getPrezzo();
				break;
			}
		}
	}

	public void rimuoviLibro(String isbn) {
		for(Libro temp : libri){

			if(temp.getIsbn().equalsIgnoreCase(isbn)){

				libri.remove(temp);
				totale= totale- (temp.getQuantit‡Selezionata() * temp.getPrezzo());
				break;
			}
		}
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
