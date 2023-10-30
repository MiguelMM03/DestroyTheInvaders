package uo.cpm.destroyTheInvaders.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uo.cpm.destroyTheInvaders.model.Celda;
import uo.cpm.destroyTheInvaders.model.Colonia;
import uo.cpm.destroyTheInvaders.model.Invasor;
import uo.cpm.destroyTheInvaders.model.Invasores;
import uo.cpm.destroyTheInvaders.model.Jugador;
import uo.cpm.destroyTheInvaders.model.Tablero;
import uo.cpm.destroyTheInvaders.model.Ticket;

public class Juego {

	public static final int MAXIMO_DE_INVASORES_POR_RONDA=5;
	public static final int MINIMO_DE_INVASORES_PARA_FORMAR_COLONIA=3;
	public static final int NUMERO_ITERACIONES=10;
	public static final int INVASORES_CABECILLA_ELIMINADOS_PARA_VICTORIA=5;
	public static final Invasores CABECILLA=Invasores.MarioBros;
	
	/*
	 * Motivos de fin
	 */
	public static final byte CABECILLAS_ELIMINADOS=1;
	public static final byte FIN_ITERACIONES=2;
	public static final byte TODAS_CASILLAS_OCUPADAS=3;
	

	private Jugador jugador;
	private Ticket ticket;
	private Tablero tablero;
	private int numInvasores;
	private int iteracion;
	private Invasor invasorSeleccionado;
	private int invasoresColocadosEnLaIteracionActual;
	private boolean cabecillasEliminados=false;
	private List<Celda> invasoresColocadosIteracionActual=new ArrayList<>();
	private List<Colonia> colonias=new ArrayList<>();
	//Stats
	private int invasoresEliminados;
	private int combinaciones3;
	private int combinaciones4;
	private int combinaciones5;
	private int combinaciones6;
	private int combinaciones7;
	//invasores a colocar
	private Invasor[] invasores=new Invasor[MAXIMO_DE_INVASORES_POR_RONDA];
	
	
	public Juego() {
		inicializar();
	}
	public Invasor getInvasorSeleccionado() {
		return invasorSeleccionado;
	}
	
	public void setInvasorSeleccionado(Invasor invasorSeleccionado) {
		this.invasorSeleccionado = invasorSeleccionado;
	}


	public boolean checkPremiosEscogidos() {
		if(getJugador().getPuntosRestantes()>=0) {
			return true;
		}
		return false;
	}

	public int getNumInvasores() {
		return numInvasores;
	}
	public void reiniciarStats() {
		invasoresEliminados=0;
		combinaciones3=0;
		combinaciones4=0;
		combinaciones5=0;
		combinaciones6=0;
		combinaciones7=0;
	}

	public void setNumInvasores(int numInvasores) {
		this.numInvasores = numInvasores;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public int getIteracion() {
		return iteracion;
	}

	public Invasor[] getInvasores() {
		return invasores;
	}

	public void inicializar() {
		this.jugador=null;
		this.ticket=null;
		this.tablero=new Tablero();
		this.cabecillasEliminados=false;
		this.invasorSeleccionado=null;
		this.numInvasores=0;
		this.invasoresColocadosEnLaIteracionActual=0;
		this.invasoresColocadosIteracionActual.clear();
		this.iteracion=0;
		reiniciarStats();
	}

	public void iniciarPartida(Ticket ticket) {
		jugador=new Jugador(ticket);
		this.ticket=ticket;
		reiniciarStats();
		colocarAleatoriamenteInvasores();
		comenzarRonda();
	}
	
	private void colocarAleatoriamenteInvasores() {
		int fila=-1;
		int columna=-1;
		for(int i=0;i<MAXIMO_DE_INVASORES_POR_RONDA;i++) {
			boolean colocado=false;
			do {
				fila=(new Random()).nextInt(Tablero.ROWS);
				columna=(new Random()).nextInt(Tablero.COLUMNS);
				colocado=colocarInvasor(new Invasor(), fila, columna);
			}while(colocado==false);
		}
		
	}
	public void comenzarRonda() {
		iteracion++;
		invasoresColocadosEnLaIteracionActual=0;
		invasoresColocadosIteracionActual.clear();
		for(int i=0;i<MAXIMO_DE_INVASORES_POR_RONDA;i++) {
			invasores[i]=new Invasor();
		}
	}
	public boolean colocarInvasor(int invasor, int fila, int columna) {
		if(invasores[invasor]!=null && tablero.getTablero()[fila][columna].isAvailable() && tablero.getTablero()[fila][columna].getInvasor()==null){
			tablero.getTablero()[fila][columna].setInvasor(invasores[invasor]);
			invasores[invasor]=null;
			numInvasores++;
			invasoresColocadosEnLaIteracionActual++;
			invasoresColocadosIteracionActual.add(tablero.getTablero()[fila][columna]);
			setInvasorSeleccionado(null);
			checkFinalRonda();
			checkFinal();
			return true;
		}
		return false;
	}
	
	private boolean colocarInvasor(Invasor invasor, int fila, int columna) {
		if(invasor!=null && tablero.getTablero()[fila][columna].isAvailable() && tablero.getTablero()[fila][columna].getInvasor()==null){
			tablero.getTablero()[fila][columna].setInvasor(invasor);
			numInvasores++;
			checkFinalRonda();
			checkFinal();
			return true;
		}
		return false;
	}
	
	private void comprobarColonias() {
		for(Celda c :invasoresColocadosIteracionActual) {
			comprobarColonias(c.getFila(),c.getColumna());
		}
		eliminarColonias();
	}
	
	
	private void comprobarColonias(int fila, int columna) {
		if(getTablero().getTablero()[fila][columna].getInvasor()==null) {
			return;
		}
		coloniaEnColumna(fila, columna);
		coloniaEnFila(fila,columna);
	}

	private void eliminarColonias() {
		for(Colonia c:colonias) {
			sumarPuntos(c);
			if(c.isEnFila()) {
				for(int i=c.getFilaInicial();i<=c.getFilaFinal();i++) {
					if(tablero.getTablero()[i][c.getColumnaFinal()].getInvasor()!=null) {
						tablero.getTablero()[i][c.getColumnaFinal()].removeInvasor();
						invasoresEliminados++;
						numInvasores--;
					}
				}
			}
			else {
				for(int i=c.getColumnaInicial();i<=c.getColumnaFinal();i++) {
					if(tablero.getTablero()[c.getFilaFinal()][i].getInvasor()!=null) {
						tablero.getTablero()[c.getFilaFinal()][i].removeInvasor();
						invasoresEliminados++;
						numInvasores--;
					}
				}
			}
		}
		colonias.clear();
	}

	private void sumarPuntos(Colonia c) {
		double puntos;
		switch (c.getNumeroInvasores()) {
		case 3:
			puntos=50;
			combinaciones3++;
			break;
		case 4:
			puntos=200;
			combinaciones4++;
			break;
		case 5:
			puntos=1000;
			combinaciones5++;
			break;
		case 6:
			puntos=5000;
			combinaciones6++;
			break;
		case 7:
			puntos=10000;
			combinaciones7++;
			break;
		default:
			puntos=0;
		}
		if(c.getNumeroInvasores()>=INVASORES_CABECILLA_ELIMINADOS_PARA_VICTORIA && c.getInvasorTipo().equals(CABECILLA)) {
			cabecillasEliminados=true;
		}
		jugador.addPuntos(puntos);
		
	}

	public int getInvasoresEliminados() {
		return invasoresEliminados;
	}

	public int getCombinaciones3() {
		return combinaciones3;
	}

	public int getCombinaciones4() {
		return combinaciones4;
	}

	public int getCombinaciones5() {
		return combinaciones5;
	}

	public int getCombinaciones6() {
		return combinaciones6;
	}

	public int getCombinaciones7() {
		return combinaciones7;
	}

	private Colonia coloniaEnFila(int fila, int columna) {
		int num=0;
		int aux=0;
		int filaInicial = fila;
		int filaFinal = fila;
		while(fila-aux>=0 && tablero.getTablero()[fila-aux][columna].getInvasor()!=null&& tablero.getTablero()[fila][columna].getInvasor()!=null&&tablero.getTablero()[fila-aux][columna].getInvasor().getInvasorType().getNombre().equals(tablero.getTablero()[fila][columna].getInvasor().getInvasorType().getNombre()) && tablero.getTablero()[fila-aux][columna].isAvailable()) {
			filaInicial=fila-aux;
			num++;
			aux++;

		}
		
		aux=1;
		while(fila+aux<tablero.getTablero().length && tablero.getTablero()[fila+aux][columna].getInvasor()!=null&&tablero.getTablero()[fila][columna].getInvasor()!=null && tablero.getTablero()[fila+aux][columna].getInvasor().getInvasorType().getNombre().equals(tablero.getTablero()[fila][columna].getInvasor().getInvasorType().getNombre()) && tablero.getTablero()[fila+aux][columna].isAvailable()) {
			filaFinal=fila+aux;
			num++;
			aux++;

		}
		if(num>=MINIMO_DE_INVASORES_PARA_FORMAR_COLONIA) {
			Colonia c=new Colonia();
			c.setEnFila(true);
			c.setColumnaFinal(columna);
			c.setColumnaInicial(columna);
			c.setFilaFinal(filaFinal);
			c.setFilaInicial(filaInicial);
			c.setNumeroInvasores(num);
			c.setInvasorTipo(tablero.getTablero()[fila][columna].getInvasor().getInvasorType());
			checkColoniaEnListaYAdd(c);
			c.setInvasorTipo(tablero.getTablero()[fila][columna].getInvasor().getInvasorType());
			return c;
		}
		
		return null;
	}

	private Colonia coloniaEnColumna(int fila, int columna) {
		int num=0;
		int aux=0;
		int columnaInicial = columna;
		int columnaFinal = columna;
		while(columna-aux>=0 && tablero.getTablero()[fila][columna-aux].getInvasor()!=null&& tablero.getTablero()[fila][columna].getInvasor()!=null&& tablero.getTablero()[fila][columna-aux].getInvasor().getInvasorType().getNombre().equals(tablero.getTablero()[fila][columna].getInvasor().getInvasorType().getNombre()) && tablero.getTablero()[fila][columna-aux].isAvailable()) {
			columnaInicial=columna-aux;
			num++;
			aux++;

		}
		aux=1;
		while(columna+aux<tablero.getTablero().length && tablero.getTablero()[fila][columna+aux].getInvasor()!=null&& tablero.getTablero()[fila][columna].getInvasor()!=null&& tablero.getTablero()[fila][columna+aux].getInvasor().getInvasorType().getNombre().equals(tablero.getTablero()[fila][columna].getInvasor().getInvasorType().getNombre()) && tablero.getTablero()[fila][columna+aux].isAvailable()) {
			columnaFinal=columna+aux;
			num++;
			aux++;
		}
		if(num>=MINIMO_DE_INVASORES_PARA_FORMAR_COLONIA) {
			Colonia c=new Colonia();
			c.setEnFila(false);
			c.setFilaFinal(fila);
			c.setFilaInicial(fila);
			c.setColumnaFinal(columnaFinal);
			c.setColumnaInicial(columnaInicial);
			c.setNumeroInvasores(num);
			c.setInvasorTipo(tablero.getTablero()[fila][columna].getInvasor().getInvasorType());
			checkColoniaEnListaYAdd(c);
			return c;
		}
		
		return null;
	}

	
	private void checkColoniaEnListaYAdd(Colonia c) {
		for(Colonia colonia : colonias) {
			if(colonia.equals(c)) {
				return;
			}
		}
		colonias.add(c);
		
	}



	public boolean checkFinalRonda() {
		if(invasoresColocadosEnLaIteracionActual==MAXIMO_DE_INVASORES_POR_RONDA) {
			comprobarColonias();
			comenzarRonda();
			return true;
		}
		return false;
	}
	public byte checkFinal() {
		if(iteracion>NUMERO_ITERACIONES || iteracion==NUMERO_ITERACIONES && invasoresColocadosEnLaIteracionActual==MAXIMO_DE_INVASORES_POR_RONDA) {
			return FIN_ITERACIONES;
		}
		else if(numInvasores==Tablero.NUMERO_MAXIMO_DE_CASILLAS_DISPONIBLES) {
			jugador.removePuntos();
			return TODAS_CASILLAS_OCUPADAS;
		}
		else if(cabecillasEliminados) {
			jugador.addPuntos(20000);
			return CABECILLAS_ELIMINADOS;
		}
		return 0;
	}
	public byte getFinal() {
		if(iteracion>NUMERO_ITERACIONES || iteracion==NUMERO_ITERACIONES && invasoresColocadosEnLaIteracionActual==MAXIMO_DE_INVASORES_POR_RONDA) {
			return FIN_ITERACIONES;
		}
		else if(numInvasores==Tablero.NUMERO_MAXIMO_DE_CASILLAS_DISPONIBLES) {
			return TODAS_CASILLAS_OCUPADAS;
		}
		else if(cabecillasEliminados) {
			return CABECILLAS_ELIMINADOS;
		}
		return 0;
	}
	public boolean isFin() {
		switch(getFinal()) {
			case FIN_ITERACIONES:
				return true;
			case TODAS_CASILLAS_OCUPADAS:
				return true;
			case CABECILLAS_ELIMINADOS:
				return true;
			default:
				return false;
		}
	}
	public boolean win() {
		if(getJugador().getPuntos()==0) {
			return false;
		}
		switch(getFinal()) {
			case FIN_ITERACIONES:
				return true;
			case TODAS_CASILLAS_OCUPADAS:
				return false;
			case CABECILLAS_ELIMINADOS:
				return true;
			default:
				return false;
		}
	}
	
}
