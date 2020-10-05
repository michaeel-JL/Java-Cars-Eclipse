package Dominio;

import java.util.ArrayList;

public class Extra {
	
	private int identificador;
	private String descripcion;
	
	public Extra(int identificador, String descripcion) {
		this.identificador = identificador;
		this.descripcion = descripcion;
	}
	
	public Extra() {
		
	}

	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return "Extra [identificador=" + identificador + ", descripcion=" + descripcion + "]";
	}

	public ArrayList<Extra> leer() {
		return null;
	}
	

}
