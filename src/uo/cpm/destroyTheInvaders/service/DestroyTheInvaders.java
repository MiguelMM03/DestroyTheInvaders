package uo.cpm.destroyTheInvaders.service;

import java.util.ArrayList;
import java.util.List;

import uo.cpm.destroyTheInvaders.game.Juego;
import uo.cpm.destroyTheInvaders.model.Premio;
import uo.cpm.destroyTheInvaders.model.Ticket;
import uo.cpm.destroyTheInvaders.model.Tienda;
import uo.cpm.destroyTheInvaders.util.FileUtil;

public class DestroyTheInvaders {
	public static final int TICKET_NO_PUEDE_USARSE=1;
	public static final int TICKET_DE_OTRA_TIENDA=2;
	public static final int TICKET_INFERIOR_AL_PRECIO_MINIMO=3;
	private List<Ticket> tickets=new ArrayList<Ticket>();
	private Tienda tienda=new Tienda();
	private List<Premio> premios=new ArrayList<Premio>();
	private Juego juego=new Juego();
	
	public Juego getJuego() {
		return juego;
	}

	public DestroyTheInvaders() {
		inicializar();
		juego.inicializar();
	}

	public List<Premio> getPremios() {
		return premios;
	}
	public void reiniciar() {
		juego.inicializar();
	}

	public void inicializar() {
		FileUtil.loadTienda("files/config.dat", tienda);
		FileUtil.loadTickets("files/tickets.dat", tickets);
		FileUtil.loadPremios("files/premios.dat", premios);
	}
	public int reasonTicketInvalid(int numeroTicket) {
		Ticket t=getTicket(numeroTicket);
		if(t==null) {
			return TICKET_NO_PUEDE_USARSE;
		}
		else if(!t.getCodigoTienda().equals(tienda.getCodigo())) {
			return TICKET_DE_OTRA_TIENDA;
		}
		else if(t.getPrecio()<Ticket.PRECIO_MINIMO) {
			return TICKET_INFERIOR_AL_PRECIO_MINIMO;
		}else {
			return TICKET_NO_PUEDE_USARSE;
		}
	}
	private Ticket getTicket(int numeroTicket) {
		for(Ticket t : tickets) {
			if(t.getNumeroTicket()==numeroTicket) {
				return t;
			}
		}
		return null;
	}
	private Ticket isTheTicketValid(int numeroTicket) {
		if(tienda.getCodigo()==null) {
			return null;
		}
		for(Ticket t : tickets) {
			if(t.getNumeroTicket()==numeroTicket && t.getCodigoTienda().equals(tienda.getCodigo()) && t.getPrecio()>=Ticket.PRECIO_MINIMO) {
				return t;
			}
		}
		return null;
	}
	
	public boolean startGame( int numeroTicket) {
		Ticket t=isTheTicketValid( numeroTicket);
		if(t==null) {
			return false;
		}
		else {
			juego.iniciarPartida(t);
			tickets.remove(t);//Elimina el ticket de la lista, pero no modifica el fichero original
			return true;
		}
	}
	public void comenzarRonda() {
		juego.comenzarRonda();
	}
	public boolean colocarInvasor(int posicion, int fila, int columna) {
		return juego.colocarInvasor(posicion, fila, columna);
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public Tienda getTienda() {
		return tienda;
	}
	public void guardarPremios() {
		FileUtil.savePremioToFile(getJuego().getJugador(), tienda);
	}
	

}
