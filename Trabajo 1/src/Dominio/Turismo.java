package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Persistencia.TurismoDao;
import Persistencia.VehiculoDao;

public class Turismo extends Vehiculo {
	private int num_puertas;
	private TurismoDao turismodao;

	public Turismo(String matricula, String marca, String modelo, String color, Double precio, int num_puertas) {
		super(matricula, marca, modelo, color, precio);
		this.num_puertas = num_puertas;
		this.turismodao = turismodao;
	}
	
	public Turismo() {
		
	}

	public int getNum_puertas() {
		return num_puertas;
	}

	public void setNum_puertas(int num_puertas) {
		this.num_puertas = num_puertas;
	}

	public TurismoDao getTurismodao() {
		return turismodao;
	}

	public void setTurismodao(TurismoDao turismodao) {
		this.turismodao = turismodao;
	}

	public ArrayList<Vehiculo> leer() {
		return turismodao.leer();
	}

	public void escribir(ArrayList<Vehiculo> vehiculos) {
		turismodao.escribir(vehiculos);
	}

	@Override
	public String toString() {
		return "Turismo [num_puertas=" + num_puertas + ", turismodao=" + turismodao + "]";
	}

}
