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

	public Camion(String matricula, String marca, String modelo, String color, double precio, int capacidad_carga) {
		super(matricula, marca, modelo, color, precio);
		this.capacidad_carga = capacidad_carga;
		camiondao= new CamionDao();
	}
	
	public Camion() {
		camiondao= new CamionDao();
	}
	//Aqui se listan todos los getter y setter

	public int getCapacidad_carga() {
		return capacidad_carga;
	}

	public void setCapacidad_carga(int capacidad_carga) {
		this.capacidad_carga = capacidad_carga;
	}

	@Override
	public String toString() {
		return "Camion ( Matricula: " + matricula + ", Marca:" + marca + ", Modelo:" + modelo + ", Color: " + color
				+ ", Precio: " + precio + ", Capacidad de carga: " + capacidad_carga + " )";
	}
	//Creamos metodo de leer
	public ArrayList<Vehiculo> leer() {
		return camiondao.leer();
	}
	//Metodo de escribir
	public void escribir(ArrayList<Vehiculo> vehiculos) {
		camiondao.escribir(vehiculos);
	}


}
