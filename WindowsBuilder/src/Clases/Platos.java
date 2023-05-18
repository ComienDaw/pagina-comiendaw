package Clases;

import java.util.ArrayList;

public class Platos {

	String nombre_plato, tipo_plato, vitaminas;
	double proteina_total, carbohidrato_total, grasas_total, kcal_total;

	public static Platos plato_actual = new Platos("","",0.0,0.0,0.0,0.0,"");
	public static ArrayList<Platos> platos_usuario;

	public Platos(String nombre_plato, String tipo_plato, double proteina_total, double carbohidrato_total, double grasas_total, double kcal_total, String vitaminas) {
		this.nombre_plato = nombre_plato;
		this.tipo_plato = tipo_plato;
		this.proteina_total = proteina_total;
		this.carbohidrato_total = carbohidrato_total;
		this.grasas_total = grasas_total;
		this.kcal_total = kcal_total;
	}


	public static ArrayList<Platos> getPlatos_usuario() {
		return platos_usuario;
	}


	public static void setPlatos_usuario(ArrayList<Platos> platos_usuario) {
		Platos.platos_usuario = platos_usuario;
	}


	public String getVitaminas() {
		return vitaminas;
	}


	public void setVitaminas(String vitaminas) {
		this.vitaminas = vitaminas;
	}


	public String getNombre_plato() {
		return nombre_plato;
	}


	public void setNombre_plato(String nombre_plato) {
		this.nombre_plato = nombre_plato;
	}


	public String getTipo_plato() {
		return tipo_plato;
	}


	public void setTipo_plato(String tipo_plato) {
		this.tipo_plato = tipo_plato;
	}


	public double getProteina_total() {
		return proteina_total;
	}


	public void setProteina_total(double proteina_total) {
		this.proteina_total = proteina_total;
	}


	public double getCarbohidrato_total() {
		return carbohidrato_total;
	}


	public void setCarbohidrato_total(double carbohidrato_total) {
		this.carbohidrato_total = carbohidrato_total;
	}


	public double getGrasas_total() {
		return grasas_total;
	}


	public void setGrasas_total(double grasas_total) {
		this.grasas_total = grasas_total;
	}


	public double getKcal_total() {
		return kcal_total;
	}


	public void setKcal_total(double kcal_total) {
		this.kcal_total = kcal_total;
	}


	public static Platos getPlato_actual() {
		return plato_actual;
	}


	public static void setPlato_actual(Platos plato_actual) {
		Platos.plato_actual = plato_actual;
	}


	public static void main(String[] args) {



	}


}
