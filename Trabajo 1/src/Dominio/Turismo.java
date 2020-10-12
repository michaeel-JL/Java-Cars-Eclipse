package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Persistencia.TurismoDao;
import Persistencia.VehiculoDao;

public class Turismo extends Vehiculo {
	private int num_puertas;
	private Extra extra;
	private TurismoDao turismodao;

	public Turismo(String matricula, String marca, String modelo, String color, double precio, int num_puertas, int extra) {
		super(matricula, marca, modelo, color, precio);
		this.num_puertas = num_puertas;
		turismodao = new TurismoDao();
	}
	
	public Turismo() {
		turismodao = new TurismoDao();
		
	}

	public int getNum_puertas() {
		return num_puertas;
	}
	

	public void setNum_puertas(int num_puertas) {
		this.num_puertas = num_puertas;
	}
	
	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

	public ArrayList<Vehiculo> leer() {
		return turismodao.leer();
	}

	public void escribir(ArrayList<Vehiculo> vehiculos){
		turismodao.escribir(vehiculos);
	}

	@Override
    public String toString() {
        return "Turismo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
                + ", precio= " + precio + ", num_puertas=" + num_puertas + ",extra=" +extra+"]";
    }

}
