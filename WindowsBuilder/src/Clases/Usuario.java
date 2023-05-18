package Clases;

public class Usuario {

	String nombre_usuario, contraseña, genero;
	int altura, edad, kcal;


	public static Usuario user_actual = new Usuario("","");
	public static Usuario user_completo = new Usuario("","",0,0,0);

	public Usuario(String nombre_usuario, String contraseña) {
		this.nombre_usuario = nombre_usuario;
		this.contraseña = contraseña;
	}


	public Usuario(String nombre_usuario, String genero, int altura, int edad, int kcal) {
		this.nombre_usuario = nombre_usuario;
		this.genero = genero;
		this.altura = altura;
		this.edad = edad;
		this.kcal = kcal;
	}


	public int getKcal() {
		return kcal;
	}


	public void setKcal(int kcal) {
		this.kcal = kcal;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
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
