package uo.cpm.destroyTheInvaders.model;


public class Tablero {
	public static final int ROWS=7;
	public static final int COLUMNS=7;
	public static final int CENTRAL_POSITION=3;
	public static final int NUMERO_MAXIMO_DE_CASILLAS_DISPONIBLES=ROWS*COLUMNS-5;
	private Celda[][] tablero;
	
	
	public Tablero(){
		tablero=new Celda[ROWS][COLUMNS];
		for(int i=0;i<ROWS;i++) {
			for(int j=0;j<COLUMNS;j++) {
				if((i==CENTRAL_POSITION && j==CENTRAL_POSITION)||
					(i==0 && j==0)||
					(i==0 && j==COLUMNS-1)||
					(i==ROWS-1 && j==0)||
					(i==ROWS-1 && j==COLUMNS-1)) {
					tablero[i][j]=new Celda(i,j,false);
				}else {
					tablero[i][j]=new Celda(i,j,true);
				}
			}
		}
	}
	public Celda[] getFila(int columna) {
		Celda[] celdas=new Celda[ROWS];
		for(int i=0;i<ROWS;i++) {
			celdas[i]=tablero[i][columna];
		}
		return celdas;
	}
	public Celda[] getColumna(int fila) {
		Celda[] celdas=new Celda[COLUMNS];
		for(int i=0;i<COLUMNS;i++) {
			celdas[i]=tablero[fila][i];
		}
		return celdas;
	}


	public Celda[][] getTablero() {
		return tablero;
	}
}
