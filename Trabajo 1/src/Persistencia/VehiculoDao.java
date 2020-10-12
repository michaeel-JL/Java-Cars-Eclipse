package Persistencia;

import java.util.ArrayList;

import Dominio.Vehiculo;

public abstract class VehiculoDao {
	
	public VehiculoDao() {
	}
	
	abstract public ArrayList<Vehiculo> leer();
	abstract public void escribir(ArrayList<Vehiculo> vehiculos);	

}
