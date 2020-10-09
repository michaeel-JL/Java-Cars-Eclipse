package Dominio;

import java.util.ArrayList;

import Persistencia.EmpleadoDao;

public class Empleado {
	
	private String usuario;
	private String password;
	private EmpleadoDao empleadodao;
	
	public Empleado(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
		empleadodao= new EmpleadoDao();
	}
	
	public Empleado() {
		empleadodao= new EmpleadoDao();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Empleado [usuario=" + usuario + ", password=" + password + "]";
	}
	
	
	public ArrayList<Empleado> leerEmpleados(){
		return empleadodao.leerEmpleados();
	}
	public void escribirEmpleados(ArrayList<Empleado> personas){
		empleadodao.escribirEmpleados(personas);
	}
	

}
