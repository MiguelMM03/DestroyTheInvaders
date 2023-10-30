package uo.cpm.destroyTheInvaders.model;

import java.util.Random;

import uo.cpm.destroyTheInvaders.Main;
import uo.cpm.destroyTheInvaders.game.Juego;

public class Invasor {
	private Invasores invasor;
	
	public Invasor() {
		switch (Main.DEBUG) {
		case 0: 
			this.invasor=Invasores.values()[(new Random()).nextInt(Invasores.values().length)];
			break;
		case 1:
			this.invasor=Juego.CABECILLA;
			break;
		case 2:
			this.invasor=Invasores.Arquero;
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + Main.DEBUG);
		}
		
	}

	public Invasores getInvasorType() {
		return invasor;
	}

}
