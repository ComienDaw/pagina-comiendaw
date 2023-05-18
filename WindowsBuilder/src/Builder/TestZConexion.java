package Builder;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

public class TestZConexion {

	//TEST 1: DE PRUEBA DEL MÉTODO DE INICIO DE SESIÓN EN LA APLICACIÓN
	@Test
	public void testinicioSesion() {

		boolean passwd;
		try {
			zConexion.conectar();
			passwd = zConexion.inicioSesion("admin1", "admin1");
			boolean resultadoesperado = true;

			assertEquals(resultadoesperado, passwd);
			zConexion.cerrar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	//TEST 2: DE PRUEBA DEL MÉTODO QUE NOS DEVUELVE EL NÚMERO MÁXIMO DE PLATOS FAVORITOS DEL USUARIO
	@Test
	public void testnumPlato() {

		int numero;
		try {
			zConexion.conectar();
			numero = zConexion.numPlato("admin1");
			int resultadoesperado = 7;

			assertEquals(resultadoesperado, numero);
			zConexion.cerrar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	//TEST 3: DE PRUEBA DEL MÉTOO QUE NOS DEVUELVE EL NÚMERO MÁXIMO DE COMENTARIOS HECHOS POR UN USUARIO
	@Test
	public void testnumComentario() {

		int numero;
		try {
			zConexion.conectar();
			numero = zConexion.numComentario("admin3");
			int resultadoesperado = 14;

			assertEquals(resultadoesperado, numero);
			zConexion.cerrar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	//TEST 4: DE PRUEBA DEL MÉTODO QUE NOS DEVUELVE EL PLATO MÁS CONSUMIDO POR EL USUARIO EN UNA FRANJA HORARIA
	@Test
	public void testplatos_Mas_Usados() {

		String ID;
		try {
			zConexion.conectar();
			ID = zConexion.platos_Mas_Usados("admin1", "DESAYUNO");
			String resultadoesperado = "Cerdo en salsa";

			assertEquals(resultadoesperado, ID);
			zConexion.cerrar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	//TEST 5: DE PRUEBA DEL MÉTODO QUE NOS DEVUELVE LOS TIPOS DE ALIMENTOS QUE HAY EN LA BASE DE DATOS
		@Test
		public void test_sacartipo() {

			ArrayList<Object> tipo = new ArrayList<>();
			try {
				zConexion.conectar();
				tipo = zConexion.sacarTipo();
				Object elemento1 = "MARISCO";
				Object elemento2 = "CARNE";
				Object elemento3 = "PASTA";
				Object elemento4 = "FRUTA";
				Object elemento5 = "LIPIDOS";
				Object elemento6 = "PESCADO";
				Object elemento7 = "VEGETALES";
				Object elemento8 = "SETAS";
				Object elemento9 = "CEREALES";
				Object elemento10 ="REFRESCO";
				ArrayList<Object> resultadoesperado = new ArrayList<>();
				resultadoesperado.add(0, elemento1);
				resultadoesperado.add(1, elemento2);
				resultadoesperado.add(2, elemento3);
				resultadoesperado.add(3, elemento4);
				resultadoesperado.add(4, elemento5);
				resultadoesperado.add(5, elemento6);
				resultadoesperado.add(6, elemento7);
				resultadoesperado.add(7, elemento8);
				resultadoesperado.add(8, elemento9);
				resultadoesperado.add(9, elemento10);
				assertEquals(resultadoesperado, tipo);
				zConexion.cerrar();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}



}
