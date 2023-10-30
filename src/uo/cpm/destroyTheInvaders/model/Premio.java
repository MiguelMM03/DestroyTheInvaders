package uo.cpm.destroyTheInvaders.model;

public class Premio {

	private String codigo;
	private String categoria;
	private String denominacion;
	private float puntos;
	private String descripcion;
	private int unidades;

	public Premio(String codigo, String denominacion, String descripcion, String categoria, float puntos) {
		this.codigo = codigo;
		this.categoria=categoria;
		this.denominacion = denominacion;
		this.puntos=puntos;
		this.descripcion=descripcion;
		this.unidades=0;
	}

	public Premio(Premio otroArticulo) {
		this(otroArticulo.codigo, otroArticulo.denominacion, otroArticulo.descripcion, otroArticulo.categoria,
				otroArticulo.puntos);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public float getPuntos() {
		return puntos;
	}

	public void setPuntos(float puntos) {
		this.puntos = puntos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String toString() {
		String strArticulo;
		strArticulo = this.categoria + " - " + this.denominacion + " - " + this.puntos + " pts";
		return strArticulo;
	}

	
}
