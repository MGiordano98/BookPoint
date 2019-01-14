package bean;

import java.util.ArrayList;

public class Carrello {
	ArrayList<Libro> libri;
	
	public Carrello() {
		
	}
	
	public Carrello(ArrayList<Libro> libri) {
		this.libri= libri;
	}

	public ArrayList<Libro> getLibri() {
		return libri;
	}

	public void setLibri(ArrayList<Libro> libri) {
		this.libri = libri;
	}
	
	
}
