package bean;

import java.io.Serializable;
import java.sql.Date;

public class CartaDiCredito implements Serializable{
	private static final long serialVersionUID = 1L;

	private String numCarta;
	private String intestatario;
	private Date data;
	private String cvv;
	
	
	
	public CartaDiCredito() {
		super();
	}

	public CartaDiCredito(String numCarta, String intestatario, Date data, String cvv) {
		super();
		this.numCarta = numCarta;
		this.intestatario = intestatario;
		this.data = data;
		this.cvv = cvv;
	}

	public String getNumCarta() {
		return this.numCarta;
	}

	/**
	 * 
	 * @param numCarta
	 */
	public void setNumCarta(String numCarta) {
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

	public String getCvv() {
		return this.cvv;
	}

	/**
	 * 
	 * @param cvv
	 */
	public void setCvv(String cvv) {
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