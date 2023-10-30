package uo.cpm.destroyTheInvaders.model;

public enum Idioma {
	
	Español("es","ESPAÑOL"), English("en","ENGLISH");
	
	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	private String codigo;
	private String nombre;

	Idioma(String codigo, String nombre) {
		this.codigo=codigo;
		this.nombre=nombre;
	}
}
	


