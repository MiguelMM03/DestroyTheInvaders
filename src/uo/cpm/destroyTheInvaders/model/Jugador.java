package uo.cpm.destroyTheInvaders.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private List<Premio> premios=new ArrayList<>();
	private String dni;
	private double puntos;
	private Ticket ticket;
	private double puntosRestantes;

	public Jugador(Ticket ticket) {
		this.dni=null;
		this.puntos=0;
		this.ticket=ticket;
	}
	public int getUnidadesPremio(Premio p) {
		for(Premio premio : premios) {
			if(premio.equals(p)) {
				return premio.getUnidades();
			}
		}
		return 0;
	}
	
	public List<Premio> getPremios() {
		return premios;
	}

	private void actualizarPuntosRestantes() {
		puntosRestantes=puntos;
		for(Premio p: premios) {
			puntosRestantes-=p.getPuntos()*p.getUnidades();
		}
	}
	public double getPuntosRestantes() {
		actualizarPuntosRestantes();
		return puntosRestantes;
	}

	public void setUnidadesPremio(Premio premio, int unidades) {
		for(Premio p : premios) {
			if(p.equals(premio)) {
				if(unidades==0) {
					premios.remove(p);
				}else {
					p.setUnidades(unidades);
				}
				return;
			}
		}
		premio.setUnidades(unidades);
		if(unidades!=0) {
			premios.add(premio);
		}
		actualizarPuntosRestantes();
	}

	public String getDni() {
		return dni;
	}

	public boolean setDni(String dni) {
		if(checkDni(dni)==false) {
			return false;
		}
		this.dni = dni;
		return true;
	}

	public double getPuntos() {
		return puntos;
	}

	public void addPuntos(double puntos) {
		this.puntos += puntos;
	}

	public Ticket getTicket() {
		return ticket;
	}
	public void removePuntos() {
		this.puntos=0;
	}
	private boolean checkDni(String dni) {
		if(dni.isBlank()) {
			return false;
		}
		return true;
		
	}

	

}
