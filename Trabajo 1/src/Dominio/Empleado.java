package Dominio;

public class Empleado {
	
	private String usuario;
	private String password;
	
	public Empleado(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}
	
	public Empleado() {
		
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

}
