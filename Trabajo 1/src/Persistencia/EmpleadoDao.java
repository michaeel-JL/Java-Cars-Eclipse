package Persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Empleado;


public class EmpleadoDao {
	
	//Creamos contructor vacio
	public EmpleadoDao() {

	}
	//Creamos metodo para leer el fichero
	public ArrayList<Empleado> leerEmpleados() {
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		try {
		Scanner in = new Scanner(new FileReader("empleados.txt")); //Leemos el fichero
		in.next();
		int contador = in.nextInt();
		// Leer alumnos

		for (int i = 0; i < contador; i++) {
			in.next();
			String usuario = in.next();
			in.next();
			String password = in.next();

			Empleado empleado = new Empleado(usuario, password);
			empleados.add(empleado);
		}
		in.close();
		} catch (FileNotFoundException e) { //Por si el fichero no existe
			System.out.println("El fichero especificado no existe");
		} catch (IOException e) {
			System.out.println("Excepcion de entrada/salida:" + e.toString());
			System.out.println(e.getMessage());
		}
		return empleados;
	}

	//Creamos el metodo para escribir en el fichero
	public void escribirEmpleados(ArrayList<Empleado> empleados) {
		
		try {
			PrintWriter out = new PrintWriter(new FileWriter("empleados.txt")); //Decimos que fichero creemos escribir
			out.println("Empleado:");
			out.println(empleados.size());
			for (int i = 0; i < empleados.size(); i++) {
				out.println("Usuario:");
				out.println(empleados.get(i).getUsuario());
				out.println("Password:");
				out.println(empleados.get(i).getPassword());
			}
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero especificado no existe");
		} catch (IOException e) {
			System.out.println("Excepcion de entrada/salida:" + e.toString());
			System.out.println(e.getMessage());
		}

		
	}
	
	
	
	
	

}
