package Persistencia;

import java.util.ArrayList;

import Dominio.Vehiculo;

public abstract class VehiculoDao {
	
	//Creamos contructor vacio
	public VehiculoDao() {
	}
	
	//Creamos los metodos abstractos para despue crearlas en las clases hija
	abstract public ArrayList<Vehiculo> leer();
	abstract public void escribir(ArrayList<Vehiculo> vehiculos);	

}
