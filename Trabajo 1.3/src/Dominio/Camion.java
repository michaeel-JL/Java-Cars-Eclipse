package Dominio;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;

import Persistencia.CamionDao;
import Persistencia.TurismoDao;
import Persistencia.VehiculoDao;

public class Camion extends Vehiculo {
	private int capacidad_carga;
	private CamionDao camiondao;

	public Camion(String matricula, String marca, String modelo, String color, Double precio, int capacidad_carga) {
		super(matricula, marca, modelo, color, precio);
		this.capacidad_carga = capacidad_carga;
		camiondao= new CamionDao();
	}
	
	public Camion() {
		camiondao= new CamionDao();
	}


	public int getCapacidad_carga() {
		return capacidad_carga;
	}

	public void setCapacidad_carga(int capacidad_carga) {
		this.capacidad_carga = capacidad_carga;
	}

	@Override
	public String toString() {
		return "Camion [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ ", precio= " + precio + ", capacidad_carga=" + capacidad_carga + "]";
	}

	public ArrayList<Vehiculo> leer() {
		return camiondao.leer();
	}

	public void escribir(ArrayList<Vehiculo> vehiculos) {
		camiondao.escribir(vehiculos);
	}


}