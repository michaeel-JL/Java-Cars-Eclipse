package Dominio;

import java.util.ArrayList;

import Persistencia.CamionDao;
import Persistencia.ExtraDao;

public class Extra {
	
	private int identificador;
	private String descripcion;
	private ExtraDao extradao;
	
	public Extra(int identificador, String descripcion) {
		this.identificador = identificador;
		this.descripcion = descripcion;
		extradao= new ExtraDao();
	}
	
	public Extra() {
		extradao= new ExtraDao();
		
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
		return "Extras (Identificador: " + identificador + ", Descripcion: " + descripcion + ")";
	}

	public ArrayList<Extra> leer() {
		return extradao.leer();
	}
	public void escribir(ArrayList<Extra> extra){
		extradao.escribir(extra);
	}
	

}
