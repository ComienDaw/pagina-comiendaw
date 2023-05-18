package Clases;

public class Alimentos {

	double proteina, carbohidrato, grasas, kcal;
	String nombre, tipo, vitaminas;
	//INSTANCIA DE OBJETO PARA IR MODIFICANDO EN TODOS LOS FRAMES
	public static Alimentos al_actual = new Alimentos(0,0,0,0,"","","");

	public Alimentos(double proteina, double carbohidrato, double grasas, double kcal, String nombre, String tipo, String vitaminas) {
		this.proteina = proteina;
		this.carbohidrato = carbohidrato;
		this.grasas = grasas;
		this.kcal = kcal;
		this.nombre = nombre;
		this.tipo = tipo;
		this.vitaminas = vitaminas;
	}

	public double getProteina() {
		return proteina;
	}

	public void setProteina(double proteina) {
		this.proteina = proteina;
	}

	public double getCarbohidrato() {
		return carbohidrato;
	}

	public void setCarbohidrato(double carbohidrato) {
		this.carbohidrato = carbohidrato;
	}

	public double getGrasas() {
		return grasas;
	}

	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}

	public double getKcal() {
		return kcal;
	}

	public void setKcal(double kcal) {
		this.kcal = kcal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getVitaminas() {
		return vitaminas;
	}

	public void setVitaminas(String vitaminas) {
		this.vitaminas = vitaminas;
	}

	public static void main(String[] args) {



	}

}
