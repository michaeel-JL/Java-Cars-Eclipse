package Presentacion;

import Dominio.*;
import Persistencia.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		// Leemos todos los datos de los ficheros

		// Leemos empleados DIURNOS
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		Empleado empleado = new Empleado();
		empleados = empleado.leerEmpleados();

		// Leemos turismos
		ArrayList<Vehiculo> turismos = new ArrayList<Vehiculo>();
		Vehiculo turismo = new Turismo();
		turismos = turismo.leer();

		// Leemos camiones
		ArrayList<Vehiculo> camiones = new ArrayList<Vehiculo>();
		Vehiculo camion = new Camion();
		camiones = camion.leer();

		// Menú principal

		boolean seguir = true;

		empleado = login(empleado, empleados);
		System.out.println("Login correcto. Bienvenido " + empleado.getUsuario());

		do {
			try {
				System.out.println("Menú");
				System.out.println("1. Mostrar todos los vehiculos");
				System.out.println("2. Buscar un vehiculo");
				System.out.println("3. Añadir un vehiculo");
				System.out.println("4. Modificar un vehiculo");
				System.out.println("5. Eliminar un vehiculo");
				System.out.println("6. Mostrar todos los extras disponibles");
				System.out.println("7. Añadir un extra");
				System.out.println("8. Eliminar un extra");
				System.out.println("9. Log out");
				int opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					mostrarTodos(camion, turismo);
					break;
				case 2:
					buscarVehiculo(profesores, alumnos, sc);
					break;
				case 3:
					añadirVehiculo(profesores, alumnos, extras, sc);
					break;
				case 4:
					modificarVehiculo(profesores, alumnos, extras, sc); //HECHO 
					break;
				case 5:
					eliminarVehiculo(profesores, alumnos, sc);
					break;
				case 6:
					mostrarExtras(extras); //HECHO
					break;
				case 7:
					añadirExtra(extras, sc); //HECHO
					break;
				case 8:
					eliminarExtra(extras, sc); //HECHO
					break;
				case 9:
					seguir = false;
					System.out.println("Hasta pronto");
					break;
				default:
					System.out.println("Introduce un número de 1 a 9");
				}

			} catch (InputMismatchException e) {
				System.err.println("Introduce un número");
				sc.nextLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (seguir);
	}

	public static Empleado login(Empleado empleado, ArrayList<Empleado> empleados) {

		boolean login = false;
		String usuario;
		String password;
		boolean usuarioCorrecto = false;
		boolean passwordCorrecto = false;

		// bucle para indicar usuario y contraseña
		do {

			boolean user = false;

			do {

				try {
					System.out.print("\n Usuario: ");
					usuario = sc.next();
					user = true;
				} catch (InputMismatchException e) {
					System.err.println("Error - No se pueden introducir letras"); // Excepciones QUITAR ?
					sc.nextLine();
				}

			} while (user == false);

			System.out.print("\n Contraseña: ");
			password = sc.next();

			for (int i = 0; i < empleados.size(); i++) {

				if (i < empleados.size()) {
					if (usuario == empleados.get(i).getUsuario()) {
						usuarioCorrecto = true;
						if (password.equals(empleados.get(i).getPassword())) {
							passwordCorrecto = true;
							login = true;
							empleado = empleados.get(i);
							i = empleadosdiurnos.size() + empleadosnocturnos.size();// REVISAR
						}
					}
				} else {

				}
			}

			// Excepciones de usuario o contraseña incorrectos
			try {
				if (usuarioCorrecto == false)
					throw new excepcionUsuario();
				if (passwordCorrecto == false)
					throw new excepcionPassword();

			} catch (excepcionUsuario e) {
				System.err.println("111. Error. Login incorrecto");
				sc.nextLine();
			} catch (excepcionPassword e) {
				System.err.println("222. Error. Password incorrecto");
				sc.nextLine();

			}

		} while (login == false);
		return empleado;
	}

	public static void eliminarExtra(ArrayList<Extra> extras, Scanner sc) throws IOException {
		System.out.println("Indica el Id del extra: ");
		int id = sc.nextInt();
		boolean encontrado = false;
		for (int i = 0; i < extras.size(); i++) {
			if (extras.get(i).getIdentificador() == id) {
				extras.remove(i);
				Extra delExtra = new Extra();
				delExtra.escribir(extras);
				encontrado = true;
				break;
			}
		}

	}

	public static void añadirExtra(ArrayList<Extra> extras, Scanner sc) throws IOException {
		boolean seguir = false;
		int id = 0;
		do {
			seguir = false;
			try {
				mostrarExtras(extras);
				System.out.println("Introduzca el Id del Extra");
				id = sc.nextInt();
				for (int i = 0; i < extras.size(); i++) {
					if (extras.get(i).getIdentificador() == id) {
						System.out.println("Id repetido");
						seguir = true;
					}
				}
			} catch (InputMismatchException e) {
				System.err.println("Introduzce solo números");
				seguir = true;
				sc.nextLine();
			}
		} while (seguir);

		System.out.println("Introduzca la descripcion");
		String descripcion = sc.next();

		Extra newExtra = new Extra(id, descripcion);
		extras.add(newExtra);
		newExtra.escribir(extras);

	}

	public static void mostrarExtras(ArrayList<Extra> extras) {
		System.out.println("Extra");
		for (int i = 0; i < extras.size(); i++) {
			System.out.println(extras.get(i).toString());
		}

	}
	
	
	
	public static void modificarVehiculos(ArrayList<Vehiculo> camiones, ArrayList<Vehiculo> turismos, ArrayList<Extra> extras, Scanner sc) throws IOException {
		
		System.out.println("Indica la matrícula");
		String matricula = sc.next();
		boolean encontrado = false;
		
		for (int i = 0; i < camiones.size(); i++) {
			if (camiones.get(i).getMatricula().equals(matricula)) {
				System.out.println("¿Qué deseas modificar?");
				System.out.println("1. Matrícula");
				System.out.println("2. Marca");
				System.out.println("3. Modelo");
				System.out.println("4. Color");
				System.out.println("5. Precio");
				System.out.println("6. Capacidad de Carga");
				try {
				int opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Introduce la nueva Matrícula");
					String matricula_nueva = sc.next();
					camiones.get(i).setMatricula(matricula_nueva);
					break;
				case 2:
					System.out.println("Introduce la nueva Marca");
					String marca = sc.next();
					camiones.get(i).setMarca(marca);
					break;
				case 3:
					System.out.println("Introduce el nuevo modelo");
					String modelo = sc.next();
					camiones.get(i).setModelo(modelo);
					break;
				case 4:
					System.out.println("Introduce el nuevo color");
					String color = sc.next();
					camiones.get(i).setColor(color);
					break;
				case 5:
					boolean seguir = false;
					do {
						seguir = false;
						try {
							System.out.println("Introduce el nuevo precio");
							double precio = sc.nextDouble();
							camiones.get(i).setPrecio(precio);
							break;
						} catch (InputMismatchException e) {
							System.err.println("Introduzce solo números");
							sc.nextLine();
							seguir = true;
						}
					} while (seguir);
					break;
				case 6:
					seguir = false;
					do {
						seguir = false;
						try {
							System.out.println("Introduce la nueva capacidad de carga");
							int capacidad_carga = sc.nextInt();
							((Camion)camiones.get(i)).setCapacidad_carga(capacidad_carga);
							break;
						} catch (InputMismatchException e) {
							System.err.println("Introduzce solo números");
							sc.nextLine();
							seguir = true;
						}
					} while (seguir);
					break;
				}
				encontrado = true;
				Vehiculo modCamion = new Camion();
				modCamion.escribir(camiones);
				} catch (InputMismatchException e) {
					System.err.println("Introduzce solo números");
				}
				}
		}
		
		for (int i = 0; i < turismos.size(); i++) {
			if (turismos.get(i).getMatricula().equals(matricula)) {
				System.out.println("¿Qué deseas modificar?");
				System.out.println("1. Matricula");
				System.out.println("2. Marca");
				System.out.println("3. Modelo");
				System.out.println("4. Color");
				System.out.println("5. Precio");
				System.out.println("6. Numero de Puertas");
				System.out.println("7. Extras");

				try {
				int opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Introduce la nueva matricula");
					String matricula_nueva = sc.next();
					turismos.get(i).setMatricula(matricula_nueva);
					break;
				case 2:
					System.out.println("Introduce la nueva marca");
					String marca = sc.next();
					turismos.get(i).setMarca(marca);
					break;
				case 3:
					System.out.println("Introduce el nuevo Modelo");
					String modelo = sc.next();
					turismos.get(i).setModelo(modelo);
					break;
				case 4:
					System.out.println("Introduce el nuevo Color");
					String color = sc.next();
					turismos.get(i).setColor(color);
					break;
				case 5:
					boolean seguir = false;
					do {
						seguir = false;
						try {
							System.out.println("Introduce el nuevo precio");
							double precio = sc.nextDouble();
							turismos.get(i).setPrecio(precio);
							break;
						} catch (InputMismatchException e) {
							System.err.println("Introduzce solo números");
							sc.nextLine();
							seguir = true;
						}
					} while (seguir);
					break;
				case 6:
					boolean seguir_2 = false;
					do {
						seguir_2 = false;
						try {
							System.out.println("Introduce el numero de puertas");
							int num_puertas = sc.nextInt();
							((Turismo)turismos.get(i)).setNum_puertas(num_puertas);
							break;
						} catch (InputMismatchException e) {
							System.err.println("Introduzce solo números");
							sc.nextLine();
							seguir_2 = true;
						}
					} while (seguir_2);
					break;
				case 7:
					seguir = false;
					do {
						seguir = false;
						try {
							System.out.println("Introduce el nuevo Extra");
							int extra = sc.nextInt();
							encontrado=false;
							for(int j=0;j<extras.size();j++) {
								if(extras.get(j).getIdentificador() == extra) {
									encontrado=true;
									((Turismo)turismos.get(i)).setExtra(extras.get(j));
									break;
								}
							}
							if(encontrado==false) {
								Extra sinExtra = new Extra (0,"Sin extra");
								((Turismo)turismos.get(i)).setExtra(sinExtra);

							}
							break;
						} catch (InputMismatchException e) {
							System.err.println("Introduzce solo números");
							sc.nextLine();
							seguir = true;
						}
					} while (seguir);
					break;
				}
				Vehiculo modVehiculo = new Turismo();
				modVehiculo.escribir(turismos);
				} catch (InputMismatchException e) {
					System.err.println("Introduzce solo números");
				}
				}
		}
		
		if (encontrado == false) {
			System.out.printf("No existe el vehiculo con la matriucla %s\n", matricula);

		}
	}	
	
	
	
		
	public static void eliminarVehiculo(ArrayList<Vehiculo> camiones, ArrayList<Vehiculo> turismos, Scanner sc) throws IOException {
		System.out.println("Indica la matrícula");
		String matricula = sc.next();
		boolean encontrado = false;
		for (int i = 0; i < camiones.size(); i++) {
			if (camiones.get(i).getMatricula().equals(matricula)) {
				camiones.remove(i);
				Vehiculo delCamion = new Camion();
				delCamion.escribir(camiones);
				encontrado = true;
			}
		}
		for (int i = 0; i < turismos.size(); i++) {
			if (turismos.get(i).getMatricula().equals(matricula)) {
				turismos.remove(i);
				Vehiculo delTurismo = new Turismo();
				delTurismo.escribir(turismos);
				encontrado = true;
			}
		}
		if (encontrado == false) {
			System.out.printf("No existe el Vehiculo con la matricula %s\n", matricula);
		}
	}
	
	
	
	
	
	public static void buscarVehiculo(ArrayList<Vehiculo> camiones,ArrayList<Vehiculo> turismos, Scanner sc) {
		System.out.println("Indica la matricula");
		String matricula = sc.next();
		boolean encontrado = false;
		for (int i = 0; i < camiones.size(); i++) {
			if (camiones.get(i).getMatricula().equals(matricula)) {
				System.out.println(camiones.get(i).toString());
				encontrado = true;
			}
		}
		for (int i = 0; i < turismos.size(); i++) {
			if (turismos.get(i).getMatricula().equals(matricula)) {
				System.out.println(turismos.get(i).toString());
				encontrado = true;
			}
		}
		if (encontrado == false) {
			System.out.printf("No existe el vehiculo con la matricula %s\n", matricula);

		}
	}

	public static void mostrarTodos(ArrayList<Vehiculo> camiones, ArrayList<Vehiculo> turismos) {
		System.out.println("Camiones");
		for (int i = 0; i < camiones.size(); i++) {
			System.out.println(camiones.get(i).toString());
		}
		System.out.println("Turidmos");
		for (int i = 0; i < turismos.size(); i++) {
			System.out.println(turismos.get(i).toString());
		}
	}

}
