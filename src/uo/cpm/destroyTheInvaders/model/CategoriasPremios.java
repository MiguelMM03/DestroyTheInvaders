package uo.cpm.destroyTheInvaders.model;

public enum CategoriasPremios {

	Videojuegos("Videojuegos"), Consolas("Consolas"), Accesorios("Accesorios"), Todas("Todas");
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	private CategoriasPremios(String nombre) {
		this.nombre=nombre;
	}
}
