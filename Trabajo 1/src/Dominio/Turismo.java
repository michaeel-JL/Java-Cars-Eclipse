package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Persistencia.TurismoDao;
import Persistencia.VehiculoDao;

public class Turismo extends Vehiculo {
	private int num_puertas;
	private int extra;
	private TurismoDao turismodao;

	public Turismo(String matricula, String marca, String modelo, String color, double precio, int num_puertas, int extra) {
		super(matricula, marca, modelo, color, precio);
		this.num_puertas = num_puertas;
		turismodao = new TurismoDao();
	}
	
	public Turismo() {
		turismodao = new TurismoDao();
		
	}
	
	//Creamos los getter y setters

	public int getNum_puertas() {
		return num_puertas;
	}
	

	public void setNum_puertas(int num_puertas) {
		this.num_puertas = num_puertas;
	}
	
	public int getExtra() {
		return extra;
	}

	public void setExtra(int extra) {
		this.extra = extra;
	}
	
	//creamos metodo leer

	public ArrayList<Vehiculo> leer() {
		return turismodao.leer();
	}
	//creamos metodo escribir

	public void escribir(ArrayList<Vehiculo> vehiculos){
		turismodao.escribir(vehiculos);
	}

	@Override
    public String toString() {
        return "Turismo ( Matricula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color
                + ", Precio: " + precio + ", Nº de puertas: " + num_puertas + ", Extra: " +extra+" )";
    }

}
