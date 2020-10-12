package Persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Camion;
import Dominio.Turismo;
import Dominio.Vehiculo;

public class CamionDao {
	
	public CamionDao() {

	}
	
	public ArrayList<Vehiculo> leer()  {
		ArrayList<Vehiculo> camiones = new ArrayList<Vehiculo>();
		
		try {
		Scanner in = new Scanner(new FileReader("camiones.txt"));
		in.nextLine();
		int contador = in.nextInt();
		// Leer camion

		for (int i = 0; i < contador; i++) {
			in.nextLine();
			String Matricula = in.next();
			in.nextLine();
			String Marca = in.next();
			in.nextLine();
			String Modelo = in.next();
			in.nextLine();
			String Color = in.next();
			in.nextLine();
			int Capacidad = in.nextInt();
			in.nextLine();
			double Precio = in.nextDouble();
			in.nextLine();
			Vehiculo camion = new Camion(Matricula, Marca, Modelo, Color, Precio, Capacidad);
			camiones.add(camion);
		}
		in.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero especificado no existe");
		} catch (IOException e) {
			System.out.println("Excepcion de entrada/salida:" + e.toString());
			System.out.println(e.getMessage());
		}
		return camiones;
	}
	
	
	
	public void escribir(ArrayList<Vehiculo> vehiculos) {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter("camiones.txt"));
			out.println("camiones:");
			out.println(vehiculos.size());
			for (int i = 0; i < vehiculos.size(); i++) {
				out.println("matricula: ");
				out.println(vehiculos.get(i).getMatricula());
				out.println("marca: ");
				out.println(vehiculos.get(i).getMarca());
				out.println("modelo: ");
				out.println(vehiculos.get(i).getModelo());
				out.println("color: ");
				out.println(vehiculos.get(i).getColor());
				out.println("precio: ");
				out.println(vehiculos.get(i).getPrecio());
				out.println("num puertas: ");
				out.println(((Camion) vehiculos.get(i)).getCapacidad_carga());
			
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}