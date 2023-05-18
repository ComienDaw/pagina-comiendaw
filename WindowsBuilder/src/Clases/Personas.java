package Clases;

public class Personas {

	String contraseña, correo, usuario, nombre, apellido;

	public static Personas px_actual = new Personas("","","","","");

	public Personas(String usuario, String nombre, String apellido, String correo, String contraseña) {
		this.contraseña = contraseña;
		this.correo = correo;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public static Personas getPx_actual() {
		return px_actual;
	}

	public static void setPx_actual(Personas px_actual) {
		Personas.px_actual = px_actual;
	}



}
