package Dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Persistencia.VehiculoDao;

abstract public class Vehiculo {
	protected String matricula, marca, modelo, color;
	protected Double precio;
	private VehiculoDao vehiculodao;

	public Vehiculo(String matricula, String marca, String modelo, String color, Double precio) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
	}

	public Vehiculo() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public VehiculoDao getVehiculodao() {
		return vehiculodao;
	}

	public void setVehiculodao(VehiculoDao vehiculodao) {
		this.vehiculodao = vehiculodao;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ ", precio=" + precio + ", vehiculodao=" + vehiculodao + "]";
	}

	abstract public ArrayList<Vehiculo> leer();

	abstract public void escribir(ArrayList<Vehiculo> vehiculos);

}
