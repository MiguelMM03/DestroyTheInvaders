package uo.cpm.destroyTheInvaders.model;

public class Colonia {
	private int numeroInvasores=0;
	private int filaInicial;
	private int filaFinal;
	private int columnaFinal;
	private int columnaInicial;
	private boolean enFila;
	private Invasores invasorTipo;
	
	public Invasores getInvasorTipo() {
		return invasorTipo;
	}

	public void setInvasorTipo(Invasores invasorTipo) {
		this.invasorTipo = invasorTipo;
	}

	public Colonia() {
		
	}

	public int getNumeroInvasores() {
		return numeroInvasores;
	}

	public void setNumeroInvasores(int numeroInvasores) {
		this.numeroInvasores = numeroInvasores;
	}

	public int getFilaInicial() {
		return filaInicial;
	}

	public void setFilaInicial(int filaInicial) {
		this.filaInicial = filaInicial;
	}

	public int getFilaFinal() {
		return filaFinal;
	}

	public void setFilaFinal(int filaFinal) {
		this.filaFinal = filaFinal;
	}

	public int getColumnaFinal() {
		return columnaFinal;
	}

	public void setColumnaFinal(int columnaFinal) {
		this.columnaFinal = columnaFinal;
	}

	public int getColumnaInicial() {
		return columnaInicial;
	}

	public void setColumnaInicial(int columnaInicial) {
		this.columnaInicial = columnaInicial;
	}

	public boolean isEnFila() {
		return enFila;
	}

	public void setEnFila(boolean enFila) {
		this.enFila = enFila;
	}
	
	public boolean equals(Colonia c) {
		return(c.getColumnaFinal()==this.getColumnaFinal()&&
				c.getColumnaInicial()==this.getColumnaInicial()&&
				c.getFilaFinal()==this.getFilaFinal() && 
				c.getFilaInicial()==this.getFilaInicial() &&
				c.getInvasorTipo().getNombre().equals(this.getInvasorTipo().getNombre()) &&
				c.getNumeroInvasores()==this.getNumeroInvasores());
	}

}
