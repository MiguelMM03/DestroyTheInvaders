package uo.cpm.destroyTheInvaders.model;

public class Ticket {
	public static final double PRECIO_MINIMO=20;
	private String codigoTienda;
	private int numeroTicket;
	private double precio;
	
	public Ticket(String codigoTienda, int numeroTicket, double precio) {
		this.codigoTienda=codigoTienda;
		this.numeroTicket=numeroTicket;
		this.precio=precio;
	}

	public String getCodigoTienda() {
		return codigoTienda;
	}

	public void setCodigoTienda(String codigoTienda) {
		this.codigoTienda = codigoTienda;
	}

	public int getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
