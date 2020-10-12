package Persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Extra;

public class ExtraDao {
	
	//Creamos contructor vacio
	public ExtraDao() {


}
	//Creamos metodo para leer el fichero
	public ArrayList<Extra> leer(){
		ArrayList<Extra> extras=new ArrayList<Extra>();
		try {
			Scanner in=new Scanner(new  FileReader("extras.txt")); //Leemos el fichero
			in.next();
			int contador = in.nextInt();		
			for(int i=0;i<contador;i++) {
				in.next();
				int identificador=in.nextInt();
				in.next();
				String descripcion=in.next();
				Extra extra=new Extra(identificador,descripcion);
				extras.add(extra);
				
			}
			in.close();
		} catch(FileNotFoundException e) { //Por si el fichero no existe
			System.out.println("El fichero especificado no existe");
		} catch(IOException e) {
			System.out.println("Excepcion de entrada/salida" + e.toString());
			System.out.println(e.getMessage());
		}
		return extras;
	}
	
	//Creamos el metodo para escribir en el fichero
	public void escribir(ArrayList<Extra> extras) {
		try{
		PrintWriter out= new PrintWriter(new FileWriter("extras.txt")); //Decimos que fichero creemos escribir
		out.println("Extras: ");
		out.println(extras.size());
		for(int i =0;i<extras.size();i++) {
			out.println("identificador: ");
			out.println(extras.get(i).getIdentificador());
			out.println("descripcion: ");
			out.println(extras.get(i).getDescripcion());
		}
		out.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero especificado no existe");
		} catch(IOException e) {
			System.out.println("Excepcion de entrada/salida" + e.toString());
			System.out.println(e.getMessage());
		}
	}
}