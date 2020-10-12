package Presentacion;

import Dominio.*;
import Persistencia.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

class excepcionUsuario extends Exception {
}

class excepcionPassword extends Exception {
}

public class Principal {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		// Leemos todos los datos de los ficheros

		// Leemos empleados
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		Empleado empleado = new Empleado();
		empleados = empleado.leerEmpleados();

		// Leemos camiones
		ArrayList<Vehiculo> camiones = new ArrayList<Vehiculo>();
		Vehiculo camion = new Camion();
		camiones = camion.leer();
				
		//Leemos los extras
		ArrayList<Extra> extras = new ArrayList<Extra>();
		Extra extra = new Extra();
		extras = extra.leer();
		
		// Leemos turismos
		ArrayList<Vehiculo> turismos = new ArrayList<Vehiculo>();
		Vehiculo turismo = new Turismo();
		turismos = turismo.leer();

		System.out.println(empleados);
		// Menú principal

		boolean seguir = true;

		empleado = login(empleado, empleados);
		System.out.println("Login correcto. Bienvenido " + empleado.getUsuario());

		do {
			try {//Menú principal
				int opcion =Integer.parseInt(JOptionPane.showInputDialog("Menú \n"
                        + "1. Mostrar todos los vehiculos\n"+ "2. Buscar un vehiculo\n"+"3. Añadir un vehiculo\n"+
                        "4. Modificar un vehiculo\n"+"5. Eliminar un vehiculo\n"+ "6. Mostrar todos los extras disponibles\n"+
                        "7. Añadir un extra\n"+"8. Eliminar un extra\n"+"9. Log out"));

				
				//
				switch (opcion) {
				case 1:
					mostrarTodos(camiones, turismos); //HECHO
					break;
				case 2:
					buscarVehiculo(camiones, turismos); //HECHO
					break;
				case 3:
					anadirVehiculo(camiones, turismos, extras); //HECHO
					break;
				case 4:
					modificarVehiculo(camiones, turismos, extras); // HECHO
					break;
				case 5:
					eliminarVehiculo(camiones, turismos); //HECHO
					break;
				case 6:
					mostrarExtras(extras); // HECHO
					break;
				case 7:
					anadirExtra(extras); // HECHO
					break;
				case 8:
					eliminarExtra(extras); // HECHO
					break;
				case 9:
					seguir = false;
					System.out.println("Hasta pronto");
					break;
				default:
					System.out.println("Introduce un nÃºmero de 1 a 9");
				}

			} catch (InputMismatchException e) {
				System.err.println("Introduce un nÃºmero");
				sc.nextLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (seguir);
	}

	public static Empleado login(Empleado empleado, ArrayList<Empleado> empleados) {

		boolean login = false;
		String usuario = null;
		String password;
		boolean usuarioCorrecto = false;
		boolean passwordCorrecto = false;

		// bucle para indicar usuario y contraseÃ±a
		do {

            boolean user = false;

            do {

                  usuario = JOptionPane.showInputDialog("Indique su usuario: ");
                  user = true;


            } while (user == false);
             password = JOptionPane.showInputDialog("Indique su contraseña: ");


            for (int i = 0; i < empleados.size(); i++) {

                    if (usuario.equals(empleados.get(i).getUsuario())) {

                        usuarioCorrecto = true;
                        if (password.equals(empleados.get(i).getPassword())) {
                            passwordCorrecto = true;
                            login = true;
                            empleado = empleados.get(i);
                        }
                    }

            }
			// Excepciones de usuario o contraseÃ±a incorrectos
			try {
				if (usuarioCorrecto == false)
					throw new excepcionUsuario();
				if (passwordCorrecto == false)
					throw new excepcionPassword();

			} catch (excepcionUsuario e) {
				System.err.println("111. Error. Login incorrecto");
			} catch (excepcionPassword e) {
				System.err.println("222. Error. Password incorrecto");

			}
		} while (login == false);
		return empleado;
	}
	public static void eliminarExtra(ArrayList<Extra> extras) throws IOException {

        int id =Integer.parseInt(JOptionPane.showInputDialog("Indique el id"));

       boolean encontrado = false;
       for (int i = 0; i < extras.size(); i++) {
           if (extras.get(i).getIdentificador() == id) {
               extras.remove(i);
               Extra delExtra = new Extra();
               delExtra.escribir(extras);
               encontrado = true;
               JOptionPane.showMessageDialog(null, "Extra eliminado correctamente");
               break;
           }
       }

   }
	public static void anadirExtra(ArrayList<Extra> extras) throws IOException {
		boolean seguir = false;
		int id = 0;
		do {
			seguir = false;
			try {
				mostrarExtras(extras);
				id =Integer.parseInt(JOptionPane.showInputDialog("Indique el id del extras"));

				for (int i = 0; i < extras.size(); i++) {
					if (extras.get(i).getIdentificador() == id) {
						System.out.println("Id repetido");
						seguir = true;
					}
				}
			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(null, "Introduce solo números");
				seguir = true;
				sc.nextLine();
			}
		} while (seguir);
		String descripcion = JOptionPane.showInputDialog("Introduzca la descripcion");
		// Guardamos en extras el identificador y la descripción que nos ha dado el
		// usuario
		Extra newExtra = new Extra(id, descripcion);
		extras.add(newExtra);
		newExtra.escribir(extras);
		JOptionPane.showMessageDialog(null, "Extra añadido correctamente");

	}

	public static void mostrarExtras(ArrayList<Extra> extras) {
		for (int i = 0; i < extras.size(); i++) {
			System.out.println(extras.get(i).toString());
		}

	}

	public static void modificarVehiculo(ArrayList<Vehiculo> camiones, ArrayList<Vehiculo> turismos,
			ArrayList<Extra> extras) throws IOException {

		String matricula = JOptionPane.showInputDialog("Indica la matrícula");

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
						String matricula_nueva = JOptionPane.showInputDialog("Introduce la nueva matrícula");

						camiones.get(i).setMatricula(matricula_nueva);
							encontrado=true;

						break;
					case 2:
						String marca = JOptionPane.showInputDialog("Introduce la nueva Marca");

						camiones.get(i).setMarca(marca);
							encontrado=true;

						break;
					case 3:
						String modelo = JOptionPane.showInputDialog("Introduce el nuevo modelo");
						
						camiones.get(i).setModelo(modelo);
							encontrado=true;

						break;
					case 4:
						
						String color = JOptionPane.showInputDialog("Introduce el nuevo color");

						camiones.get(i).setColor(color);
							encontrado=true;

						break;
					case 5:
						boolean seguir = false;
						do {
							seguir = false;
							try {
								double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio:"));

								camiones.get(i).setPrecio(precio);
								break;
							} catch (InputMismatchException e) {
								JOptionPane.showMessageDialog(null, "Introduce solo números");
								sc.nextLine();
								seguir = true;
							}
						} while (seguir);
							encontrado=true;

						break;
					case 6:
						seguir = false;
						do {
							seguir = false;
							try {
								int capacidad_carga = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la capacidad de carga"));

								((Camion) camiones.get(i)).setCapacidad_carga(capacidad_carga);
								break;
							} catch (InputMismatchException e) {
								JOptionPane.showMessageDialog(null, "Introduce solo números");
								sc.nextLine();
								seguir = true;
							}
						} while (seguir);
							encontrado=true;

						break;
					}
					encontrado = true;
					Vehiculo modCamion = new Camion();
					modCamion.escribir(camiones);
				} catch (InputMismatchException e) {
					JOptionPane.showMessageDialog(null, "Introduce solo números");
				}
			}
		}

		for (int i = 0; i < turismos.size(); i++) {
			if (turismos.get(i).getMatricula().equals(matricula)) {
				System.out.println("¿Que deseas modificar?");
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
							encontrado=true;

						break;
					case 2:
						System.out.println("Introduce la nueva marca");
						String marca = sc.next();
						turismos.get(i).setMarca(marca);
							encontrado=true;

						break;
					case 3:
						System.out.println("Introduce el nuevo Modelo");
						String modelo = sc.next();
						turismos.get(i).setModelo(modelo);
							encontrado=true;

						break;
					case 4:
						System.out.println("Introduce el nuevo Color");
						String color = sc.next();
						turismos.get(i).setColor(color);
							encontrado=true;

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
								System.err.println("Introduzce solo numeros");
								sc.nextLine();
								seguir = true;
							}
						} while (seguir);
						     encontrado=true;

						break;
					case 6:
						boolean seguir_2 = false;
						do {
							seguir_2 = false;
							try {
								System.out.println("Introduce el numero de puertas");
								int num_puertas = sc.nextInt();
								((Turismo) turismos.get(i)).setNum_puertas(num_puertas);
								break;
							} catch (InputMismatchException e) {
								System.err.println("Introduzce solo números");
								sc.nextLine();
								seguir_2 = true;
							}
						} while (seguir_2);
						    encontrado=true;

						break;
					case 7:
						seguir = false;
						do {
							seguir = false;
							try {
								System.out.println("Introduce el nuevo Extra");
								int extra = sc.nextInt();
								encontrado = false;
								for (int j = 0; j < extras.size(); j++) {
									if (extras.get(j).getIdentificador() == extra) {
										encontrado = true;
										((Turismo) turismos.get(i)).setExtra(extras.get(i).getIdentificador());
										break;
									}
								}
								if (encontrado == false) {
									Extra sinExtra = new Extra(0, "Sin extra");
									((Turismo) turismos.get(i)).setExtra(sinExtra.getIdentificador());

								}
								break;
							} catch (InputMismatchException e) {
								System.err.println("Introduzce solo numeros");
								sc.nextLine();
								seguir = true;
							}
						} while (seguir);
							encontrado=true;

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

	public static void eliminarVehiculo(ArrayList<Vehiculo> camiones, ArrayList<Vehiculo> turismos) throws IOException {
        String matricula = JOptionPane.showInputDialog("Introduzca la matricula");

        boolean encontrado = false;
        for (int i = 0; i < camiones.size(); i++) {
            if (camiones.get(i).getMatricula().equals(matricula)) {
                camiones.remove(i);
                Vehiculo delCamion = new Camion();
                delCamion.escribir(camiones);
                encontrado = true;
                JOptionPane.showMessageDialog(null, "\nCamión eliminado correctamente");
            }
        }
        for (int i = 0; i < turismos.size(); i++) {
            if (turismos.get(i).getMatricula().equals(matricula)) {
                turismos.remove(i);
                Vehiculo delTurismo = new Turismo();
                delTurismo.escribir(turismos);
                encontrado = true;
                JOptionPane.showMessageDialog(null, "\nTurismo eliminado correctamente");
            }
        }
        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "No existe la matricula :"+ matricula);
        }
    }

	public static void buscarVehiculo(ArrayList<Vehiculo> camiones, ArrayList<Vehiculo> turismos) {
		mostrarTodos(camiones, turismos);
        String matricula  = JOptionPane.showInputDialog("Indica la matrícula");

		boolean encontrado = false;
		for (int i = 0; i < camiones.size(); i++) {
			if (camiones.get(i).getMatricula().equals(matricula)) {
				JOptionPane.showMessageDialog(null, camiones.get(i).toString());

				encontrado = true;
			}
		}
		for (int i = 0; i < turismos.size(); i++) {
			if (turismos.get(i).getMatricula().equals(matricula)) {
				JOptionPane.showMessageDialog(null, turismos.get(i).toString());
				encontrado = true;
			}
		}
		if (encontrado == false) {
			JOptionPane.showMessageDialog(null, "No existe el vehiculo con la matrícula " + matricula + "\n");

		}
	}

	public static void mostrarTodos(ArrayList<Vehiculo> camiones, ArrayList<Vehiculo> turismos) {
		System.out.println("Camiones");
		for (int i = 0; i < camiones.size(); i++) {
			System.out.println(camiones.get(i).toString());
		}
		System.out.println("Turismos");
		for (int i = 0; i < turismos.size(); i++) {
			System.out.println(turismos.get(i).toString());
		}
	}

	public static void anadirVehiculo(ArrayList<Vehiculo> camiones, ArrayList<Vehiculo> turismos,
			ArrayList<Extra> extras) throws IOException {
		boolean seguir = false;
		String matricula = "";
		do {
			seguir = false;
            matricula = JOptionPane.showInputDialog("Introduzca la matricula");

			for (int i = 0; i < camiones.size(); i++) {
				if (camiones.get(i).getMatricula().equals(matricula)) {
					JOptionPane.showMessageDialog(null, "Matrícula repetida");
					seguir = true;
				}
			}
			for (int i = 0; i < turismos.size(); i++) {
				if (turismos.get(i).getMatricula().equals(matricula)) {
					JOptionPane.showMessageDialog(null, "Matrícula repetida");
					seguir = true;
				}
			}

		} while (seguir);
		String marca = JOptionPane.showInputDialog("Introduce la marca:");
		String modelo = JOptionPane.showInputDialog("Introduce el modelo:");
		String color = JOptionPane.showInputDialog("Introduce el color:");
		Double precio = 0.0;
		do {
			seguir = false;
			try {
				precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio:"));

			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(null, "Introduce solo números");
				seguir = true;
				sc.nextLine();
			}
		} while (seguir);
		int tipo = 0;
		int capacidad_carga = 0;
		int num_puertas = 0;
		int extra = 0;
		do {
			tipo = Integer.parseInt(JOptionPane.showInputDialog("Quieres introducir un Camión(1) o Turismo(2)"));
			try {
				if (tipo == 1) {
					do {
						seguir = false;
						try {
							capacidad_carga = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la capacidad de carga"));
						} catch (InputMismatchException e) {
							JOptionPane.showMessageDialog(null, "Introduce solo números");
							seguir = true;
							sc.nextLine();
						}
					} while (seguir);
					Vehiculo newVehiculo = new Camion(matricula, marca, modelo, color, precio, capacidad_carga);
					camiones.add(newVehiculo);
					newVehiculo.escribir(camiones);
				} else if (tipo == 2) {
					do {
						seguir = false;
						try {
							num_puertas = Integer.parseInt(JOptionPane.showInputDialog("\n Introduce el número de puertas"));

						} catch (InputMismatchException e) {
							JOptionPane.showMessageDialog(null, "Introduce solo números");
							seguir = true;
							sc.nextLine();
						}
					} while (seguir);

					extra = 0;
					Extra ex = new Extra();
					do {
						seguir = false;
						try {
							extra = Integer.parseInt(JOptionPane.showInputDialog("\n Introduce el extra"));

							boolean encontrado = false;
							for (int j = 0; j < extras.size(); j++) {
								if (extras.get(j).getIdentificador() == extra) {
									encontrado = true;
									ex = extras.get(j);
								}
							}
							if (encontrado == false) {
								ex = new Extra(0, "Sin extra");

							}
						} catch (InputMismatchException e) {
							JOptionPane.showMessageDialog(null, "Introduce solo números");
							seguir = true;
							sc.nextLine();
						}
					} while (seguir);
					Vehiculo newVehiculo = new Turismo(matricula, marca, modelo, color, precio, num_puertas, extra);
					turismos.add(newVehiculo);
					newVehiculo.escribir(turismos);
				}

			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(null, "Introduce solo números");
				sc.nextLine();
			}
		} while (tipo < 1 || tipo > 2);

	}

}
