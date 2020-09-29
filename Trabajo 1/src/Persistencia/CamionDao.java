package Persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Camion;
import Dominio.Vehiculo;

public class CamionDao {
	
	public CamionDao() {

	}
	
	public ArrayList<Vehiculo> leer()  {
		ArrayList<Vehiculo> personas = new ArrayList<Vehiculo>();
		try {
		Scanner in = new Scanner(new FileReader("camion.txt"));
		in.next();
		int contador = in.nextInt();
		// Leer camion

		for (int i = 0; i < contador; i++) {
			in.next();
			String Matricula = in.next();
			in.next();
			String Marca = in.next();
			in.next();
			String Modelo = in.next();
			in.next();
			String Color = in.next();
			in.next();
			int Capacidad = in.nextInt();
			in.next();
			Double Precio = in.nextDouble();
			in.next();
			Vehiculo vehiculo = new Camion(Matricula, Marca, Modelo, Color, Precio, Capacidad);
			personas.add(persona);
		}
		in.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero especificado no existe");
		} catch (IOException e) {
			System.out.println("Excepcion de entrada/salida:" + e.toString());
			System.out.println(e.getMessage());
		}
		return personas;
	}

}
