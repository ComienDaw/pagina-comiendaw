package Clases;

import java.util.ArrayList;

public class PlatosPredeterminados {

	static ArrayList<String> ingredientes = new ArrayList<>();
	static ArrayList<String> cantidades = new ArrayList<>();
	static ArrayList<String> nombres = new ArrayList<>();


	public static ArrayList<String> getNombres() {
		return nombres;
	}

	public static void setNombres(ArrayList<String> nombre) {
		nombres = nombre;
	}

	public static ArrayList<String> getIngredientes() {
		return ingredientes;
	}

	public static void setIngredientes(ArrayList<String> ingrediente) {
		ingredientes = ingrediente;
	}

	public static ArrayList<String> getCantidades() {
		return cantidades;
	}

	public static void setCantidades(ArrayList<String> cantidad) {
		cantidades = cantidad;
	}

	public static void main(String[] args) {

	}

}
