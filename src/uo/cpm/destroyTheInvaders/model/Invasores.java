package uo.cpm.destroyTheInvaders.model;

public enum Invasores {
	MarioBros("Mario","/img/mario.png",true),
	Luigi("Luigi","/img/luigi.png",false),
	Seta("Seta","/img/seta.png",false),
	Sonic("Sonic","/img/sonic.png",false),
	FantasmaBlanco("Fantasma","/img/fantasma.png",false),
	FantasmaRojo("Loquillo","/img/fantasmaRojo.png",false),
	Arquero("Arquero","/img/arquero.png",false),
	Pacman("Pacman","/img/pacman.png",false);
	
	private String nombre;

	private String direccionFoto;
	private boolean cabecilla;
	Invasores(String nombre, String direccionFoto, boolean cabecilla){
		this.nombre=nombre;
		this.direccionFoto=direccionFoto;
		this.cabecilla=cabecilla;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccionFoto() {
		return direccionFoto;
	}
	public boolean isCabecilla() {
		return cabecilla;
	}
}
