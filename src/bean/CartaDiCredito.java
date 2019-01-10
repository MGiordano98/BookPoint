package bean;

import java.io.Serializable;
import java.sql.Date;

public class CartaDiCredito implements Serializable{
	private static final long serialVersionUID = 1L;

	private int numCarta;
	private String intestatario;
	private Date data;
	private int cvv;
	
	
	
	public CartaDiCredito() {
		super();
	}

	public CartaDiCredito(int numCarta, String intestatario, Date data, int cvv) {
		super();
		this.numCarta = numCarta;
		this.intestatario = intestatario;
		this.data = data;
		this.cvv = cvv;
	}

	public int getNumCarta() {
		return this.numCarta;
	}

	/**
	 * 
	 * @param numCarta
	 */
	public void setNumCarta(int numCarta) {
		this.numCarta = numCarta;
	}

	public String getIntestatario() {
		return this.intestatario;
	}

	/**
	 * 
	 * @param intestatario
	 */
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public Date getData() {
		return data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(Date data) {
		this.data= data;
	}

	public int getCvv() {
		return this.cvv;
	}

	/**
	 * 
	 * @param cvv
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public void getAttribute() {
		// TODO - implement CartaDiCredito.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement CartaDiCredito.setAttribute
		throw new UnsupportedOperationException();
	}

}