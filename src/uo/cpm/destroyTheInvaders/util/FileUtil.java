package uo.cpm.destroyTheInvaders.util;

import java.io.*;
import java.util.*;

import uo.cpm.destroyTheInvaders.model.Jugador;
import uo.cpm.destroyTheInvaders.model.Premio;
import uo.cpm.destroyTheInvaders.model.Ticket;
import uo.cpm.destroyTheInvaders.model.Tienda;



public abstract class FileUtil {

	public static void loadPremios(String nombreFicheroEntrada, List<Premio> listaPremios) {

		String linea;
		String[] datosPremios = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosPremios = linea.split("@");
				listaPremios.add(new Premio(datosPremios[0], datosPremios[1], datosPremios[2],
						datosPremios[3], Float.parseFloat(datosPremios[4])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	public static void loadTienda(String nombreFicheroEntrada, Tienda tienda) {
		String linea;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] datosTienda = linea.split("@");
				tienda.setCodigo(datosTienda[0]);
				tienda.setNombre(datosTienda[1]);
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	
	public static void loadTickets(String nombreFicheroEntrada, List<Ticket> listaTickets) {

		String linea;
		String[] datosTickets = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosTickets = linea.split("@");
				listaTickets.add(new Ticket(datosTickets[0], Integer.parseInt(datosTickets[1]), Double.parseDouble(datosTickets[2])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	

	public static void saveToFile(String nombreFicheroSalida, String txPedido) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFicheroSalida + ".dat"));
			fichero.write(txPedido);
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
	public static void savePremioToFile(Jugador j,Tienda t) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("files/entregas.dat",true));
			String str=j.getDni()+"@"+t.getCodigo();
			for(Premio p:j.getPremios()) {
				for(int i=0;i<p.getUnidades();i++)
					str=str+"@"+p.getCodigo();
			}
			fichero.write(str+"\n");
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}
