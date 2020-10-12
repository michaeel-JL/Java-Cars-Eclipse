package Persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Extra;
import Dominio.Turismo;
import Dominio.Vehiculo;

public class TurismoDao {

	public TurismoDao() {

	}

	public ArrayList<Vehiculo> leer() {

		ArrayList<Vehiculo> turismos = new ArrayList<Vehiculo>();
		Extra e = new Extra();
		ArrayList<Extra> extras = e.leer();

		try {
			Scanner in = new Scanner(new FileReader("turismos.txt"));
			in.next();
			int contador = in.nextInt();
			
			// Leer turismo
			for (int i = 0; i < contador; i++) {
				in.nextLine();
				String matricula = in.next();
				in.nextLine();
				String marca = in.next();
				in.nextLine();
				String modelo = in.next();
				in.nextLine();
				String color = in.next();
				in.nextLine();
				double precio = in.nextDouble();
				in.nextLine();
				int num_puertas = in.nextInt();
				in.nextLine();
				int extra = in.nextInt();
				boolean encontrado = false;
				for (int j = 0; j < extras.size(); j++) {
					if (extras.get(j).getIdentificador() == extra) {
						e = extras.get(j);
						encontrado = true;
						break;
					}
				}

				if (encontrado == false) {
					e = new Extra(0, "Sin extra");
				}

				Vehiculo turismo = new Turismo(matricula, marca, modelo, color, precio, num_puertas, extra);
				turismos.add(turismo);

			}

			in.close();

		} catch (FileNotFoundException b) {
			System.out.println("El fichero no existe");
		} catch (IOException b) {
			System.out.println("Excepcion de entrada y salida" + b.toString());
			System.out.println(b.getMessage());
		}
		return turismos;

	}

	public void escribir(ArrayList<Vehiculo> vehiculos) {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter("turismos.txt"));
			out.println("turismos:");
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
				out.println(((Turismo) vehiculos.get(i)).getNum_puertas());
				out.println("extra: ");
				out.println(((Turismo) vehiculos.get(i)).getExtra());
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}