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
	
	
	public ArrayList<Vehiculo> leer(){
		
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Extra e = new Extra();
		ArrayList<Extra> extras = e.leer();
		
		
		try {
			Scanner in=new Scanner(new FileReader("alumnos.txt"));
			in.next();
			int contador=in.nextInt();
			//Leer turismo
			for(int i=0;i<contador;i++) {
				in.next();
				String matricula=in.next();
				in.next();
				String marca=in.next();
				in.next();
				String modelo=in.next();
				in.next();
				String color=in.next();
				in.next();
				Double precio =in.nextDouble();
				in.next();
				int num_puertas=in.nextInt();
				in.next();		
				int extra=in.nextInt();
				boolean encontrado=false;
				for(int j=0;j<extras.size();j++) {
					if(extras.get(j).getIdentificador() == extra) {
						e=extras.get(j);
						encontrado=true;
						break;
					}
				}
				
				if(encontrado==false) {
					e=new Extra(0,"Sin extra");
				}
				
				Vehiculo turismo = new Turismo(matricula, marca, modelo, color, precio, num_puertas);
				vehiculos.add(turismo);
				
			}
			
			in.close();
			
		} catch (FileNotFoundException b) {
			System.out.println("El fichero no existe");
		} catch(IOException b) {
			System.out.println("Excepcion de entrada y salida" + b.toString());
			System.out.println(b.getMessage());
		}
		return vehiculos;
		
	}
	
	public void escribir(ArrayList<Vehiculo> vehiculos) throws IOException{
		PrintWriter out=new PrintWriter(new FileWriter("turismos.txt"));
		out.println("turismos:");
		out.println(vehiculos.size());
		for(int i=0;i<vehiculos.size();i++) {
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
			out.println(vehiculos.get(i).getNum_puertas);
			out.println("extra: ");
			out.println(((Turismo)vehiculos.get(i).getExtra().getIdentificador()));
//Falta extra
		}	
		out.close();
	}
}