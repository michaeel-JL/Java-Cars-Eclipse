package Presentacion;

import Dominio.*;
import Persistencia.*;

import java.io.IOException;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws IOException {
		// Leemos todos los datos de los ficheros

		// Leemos empleados DIURNOS
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		Empleado empleado1 = new EmpleadoDiurno();
		empleadosdiurnos = empleado1.leerEmpleados();

		// Leemos turismos
		ArrayList<vehiculo> turismos = new ArrayList<vehiculo>();
		vehiculo pro1 = new turismo();
		turismo_ = pro1.leerProductos();

		// Leemos camiones
		ArrayList<vehiculo> camiones = new ArrayList<vehiculo>();
		vehiculo pro2 = new camion();
		camion_ = pro2.leerProductos();

	}
}
