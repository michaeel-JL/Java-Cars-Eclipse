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
			double Precio = in.nextDouble();
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
				out.println("capacidad: ");
				out.println(((Camion) vehiculos.get(i)).getCapacidad_carga());
				out.println("precio: ");
				String precio=vehiculos.get(i).getPrecio()+"";precio=precio.replace(".", ",");
				out.println(precio);
			
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}