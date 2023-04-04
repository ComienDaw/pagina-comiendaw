package Clases;

public class Usuario {

	String nombre_usuario, contraseña;
	
	public Usuario(String nombre_usuario, String contraseña) {
		
		this.nombre_usuario = nombre_usuario;
		this.contraseña = contraseña;
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public void platos_propios(String nombre_plato, String ... ingredientes) {
		
	}

	public static void main(String[] args) {
		
		

	}

}