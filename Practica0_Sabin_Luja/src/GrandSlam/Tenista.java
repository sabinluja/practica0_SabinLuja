package GrandSlam;

import java.util.Comparator;

public class Tenista {
	
	private String nombre;
	private String nacionalidad;
	private int victoriasTotales;
	
	public Tenista(String nombre, String nacionalidad, int victoriasTotales) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.victoriasTotales = victoriasTotales;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getVictoriasTotales() {
		return victoriasTotales;
	}
	public void setVictoriasTotales(int victoriasTotales) {
		this.victoriasTotales = victoriasTotales;
	}

	
	public String toString() {
		return "Tenista [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", victoriasTotales=" + victoriasTotales
				+ "]";
	}
}
