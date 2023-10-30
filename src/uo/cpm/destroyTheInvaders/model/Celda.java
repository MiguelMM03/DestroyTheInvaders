package uo.cpm.destroyTheInvaders.model;

public class Celda {
	private int fila;
	private int columna;
	private boolean isAvailable; //Indica si es una casilla que se puede ocupar o es una casilla obstaculo
	private Invasor invasor;
	
	public Celda(int fila, int columna, boolean isAvailable) {
		this.fila=fila;
		this.columna=columna;
		this.isAvailable=isAvailable;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Invasor getInvasor() {
		return invasor;
	}

	public void setInvasor(Invasor invasor) {
		this.invasor = invasor;
	}

	public void removeInvasor() {
		this.invasor=null;
	}
	
	
}
