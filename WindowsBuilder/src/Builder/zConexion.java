package Builder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Clases.Alimentos;
import Clases.Personas;
import Clases.Platos;
import Clases.Usuario;

/**
 *
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Clase donde se establece la conexión a una base de datos Oracle.
 * @param bd especifica el nombre de la base de datos Oracle.
 * @param login especifica el nombre de usuario que se utilizará para conectarse a la base de datos.
 * @param password especifica la contraseña que se utilizará para conectarse a la base de datos.
 * @param url es la url de conexión a la base de datos.
 * @param connection almacena la conexión a la base de datos Oracle.
 * @param ps ejecuta las consultas a la base de datos.
 * @param st variable que abre y cierra la conexión a la base de datos
 * @param rs almacena los resultados de las  consultas a la base de datos.
 */

public class zConexion {

    private static String bd = "XE";
    private static String login = "proyecto";
    private static String password = "proyecto";
    private static String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
    static Connection connection;
    static PreparedStatement ps; 	//INSERT, DELETE Y UPDATE
    static Statement st; 			//SELECT
    static ResultSet rs;

    /**
   	 * Método para ejecutar la conexión a la base de datos.
   	 */

    public static void conectar() {


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, login, password);
            if (connection != null) {
                System.out.println("Conexion realizada correctamente");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
   	 * Método para cerrar la conexión con la base de datos.
   	 */

    public static void cerrar() throws SQLException {
        if (rs != null)
            rs.close();
        if (ps != null)
            ps.close();
        if (connection != null)
            connection.close();
    }


//**********************************************************************************************************************************************************************************************
//****INSERT****

    /**
   	 * Método para insertar datos en la tabla "PERSONAS" de la base de datos.
   	 * @param consulta realiza la consulta de inserción.
   	 * @param usuario nombre de usuario que se va a insertar en la tabla.
   	 * @param nombre nombre de la persona que se va a insertar en la tabla.
   	 * @param apellido apellido de la persona que se va a insertar en la tabla.
   	 * @param correo correo electrónico de la persona que se va a insertar en la tabla.
   	 * @param contraseña contraseña de la persona que se va a insertar en la tabla.
   	 */

    public static void insertPersonas(String usuario, String nombre, String apellido, String correo, String contraseña) throws SQLException {

    	String consulta = "Insert into PERSONAS values (?,initcap(?),initcap(?),?,?)";
        ps = connection.prepareStatement(consulta);


        ps.setString(1, usuario);
        ps.setString(2, nombre);
        ps.setString(3, apellido);
        ps.setString(4, correo);
        ps.setString(5, contraseña);

        ps.executeUpdate();

        ps.close();
    }

    /**
   	 * Método para insertar datos en la tabla "USUARIOS" de la base de datos.
   	 * @param consulta realiza la consulta de inserción.
   	 * @param nombre nombre de la persona que se va a insertar en la tabla.
   	 * @param genero género del usuario que se va a insertar en la tabla.
   	 * @param altura altura del usuario que se va a insertar en la tabla.
   	 * @param peso peso del usuario que se va a insertar en la tabla.
   	 * @param edad edad del usuario que se va a insertar en la tabla.
   	 * @param imc índice de masa corporal del usuario.
   	 * @param kcal_diarias calorías diarias recomendadas para el usuario que se va a insertar en la tabla.
   	 */

    public static void insertUsuarios(String nombre, String genero, int altura, double peso, int edad, double imc, double kcal_diarias) throws SQLException {

    	String consulta = "Insert into USUARIOS (NOMBRE_USUARIO_USUARIOS, PESO, ALTURA, GENERO, EDAD, IMC, KCAL_DIARIAS) values (?,?,?,?,?,?,?)";

        ps = connection.prepareStatement(consulta);

        ps.setString(1, nombre);
        ps.setDouble(2, peso);
        ps.setInt(3, altura);
        ps.setString(4, genero);
        ps.setInt(5,edad);
        ps.setDouble(6, imc);
        ps.setDouble(7,kcal_diarias);

        ps.executeUpdate();

        ps.close();
    }

    /**
   	 * Método para insertar datos en la tabla "PLATOS" de la base de datos.
   	 * @param nombre_plato nombre del plato que se va a insertar en la tabla.
   	 * @param totalProt cantidad total de proteínas en el plato que se va a insertar en la tabla
   	 * @param totalCarbo cantidad total de carbohidratos en el plato que se va a insertar en la tabla.
   	 * @param totalGrasas cantidad total de grasas en el plato que se va a insertar en la tabla.
   	 * @param totalKcal total de calorías en el plato que se va a insertar en la tabla.
   	 * @param totalVit vitaminas que se encuentran en el plato que se va a insertar en la tabla.
   	 * @param numPlato número de plato que se va a insertar en la tabla.
   	 */

    public static void insertPlatos (String nombre_plato, double totalProt, double totalCarbo, double totalGrasas, double totalKcal, String totalVit, int numPlato) throws SQLException{

    	String consulta = "Insert into PLATOS (ID_PLATO,TOTAL_PROTEINAS,TOTAL_CARBOHIDRATOS,TOTAL_GRASAS,TOTAL_KILOCALORIAS, TOTAL_VITAMINAS, NUM_PLATO ) values (?,?,?,?,?,?,?)";
        ps = connection.prepareStatement(consulta);

        ps.setString(1, nombre_plato);
        ps.setDouble(2, totalProt);
        ps.setDouble(3, totalCarbo);
        ps.setDouble(4, totalGrasas);
        ps.setDouble(5, totalKcal);
        ps.setString(6, totalVit);
        ps.setInt(7, numPlato);

        ps.executeUpdate();


        ps.close();
    }

  //REGISTRAR LOS PLATOS QUE EL USUARIO GUARDA COMO FAVORITOS (TAMBIEN LA HORA DEL DIA QUE LO USAN)

    /**
	 * Método para insertar datos en la tabla "COMEN" de la base de datos.
	 * @param id_plato identificador del plato que se va a agregar al registro de comidas.
	 * @param nombre_user nombre del usuario que está agregando el plato al registro de comidas.
	 * @param esFavorito indica si el plato agregado es un favorito del usuario (1) o no (0).
	 * @param kcal_diarias calorías diarias recomendadas para el usuario que se va a insertar en la tabla.
	 * @param hora  almacena la hora actual.
	 * @param horaPlato almacena el momento del día en el que se consume el plato (DESAYUNO, COMIDA, CENA).
	 */

    public static void insertComen(String id_plato, String nombre_user, int esFavorito) throws SQLException {

    	LocalTime horaActual = LocalTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
    	int hora = Integer.parseInt(horaActual.format(formatter));
    	String horaPlato = "";

    	if (hora > 7 && hora < 12) {
    		horaPlato = "DESAYUNO";
    	}else if (hora > 13 && hora < 17) {
    		horaPlato = "COMIDA";
    	}else if (hora > 20 && hora < 23) {
    		horaPlato = "CENA";
    	}else {
    		horaPlato = "OTROS";
    	}

    	String consulta = "Insert into COMEN (NOMBRE_USUARIO, ID_PLATO, PLATO_FAVORITO, HORA) values (?,?,?,?)";

        ps = connection.prepareStatement(consulta);

        ps.setString(1, nombre_user);
        ps.setString(2, id_plato);
        ps.setInt(3, esFavorito);
        ps.setString(4, horaPlato);

        ps.executeUpdate();

        ps.close();
    }

	/**
	 * Método para insertar datos en la tabla "FORMAN" de la base de datos.
	 * @param nombre_Plato nombre del plato que contiene el alimento que se va a insertar.
	 * @param nombre_alimento nombre del alimento que se va a insertar en el plato.
	 * @param cantidad cantidad de ese alimento que se va a agregar en el plato.
	 * @param consulta realiza la consulta de inserción.
	 */

    public static void insertForman (String nombre_Plato, String nombre_alimento, int cantidad) throws SQLException {


    	String consulta = "Insert into FORMAN values (?,?,?)";

        ps = connection.prepareStatement(consulta);

        ps.setString(1, nombre_Plato);
        ps.setString(2, nombre_alimento);
        ps.setInt(3, cantidad);


        ps.executeUpdate();


        ps.close();
    }

    /**
   	 * Método para insertar datos en la tabla "COMENTARIOS" de la base de datos.
   	 * @param nombre_usuario nombre del usuario que hace el comentario.
   	 * @param num_comentario número de comentario que se está relizando.
   	 * @param comentario contenido del comentario que se está relizando.
   	 * @param consulta realiza la consulta de inserción.
   	 */

  	public static void insertComentario (String nombre_usuario, int num_comentario, String comentario) throws SQLException {


  	    	String consulta =  "INSERT INTO COMENTARIOS VALUES (?, ?, ?, SYSDATE)";

  	        ps = connection.prepareStatement(consulta);

  	        ps.setString(1, nombre_usuario);
  	        ps.setInt(2, num_comentario);
  	        ps.setString(3, comentario);


  	        ps.executeUpdate();


  	        ps.close();

  	    }

//**********************************************************************************************************************************************************************************************
//****UPDATE****

  	 /**
  		 * Método para actualizar el peso en la tabla "USUARIO" de la base de datos.
  		 * @param pesoActual peso actual del usuario que se desea actualizar en la base de datos.
  		 * @param nombreUser nombre del usuario al que se desea actualizar su peso en la base de datos.
  		 * @param IMC  índice de masa corporal actual del usuario que se desea actualizar en la base de datos.
  		 * @param consulta realiza la consulta de UPDATE.
  		 */

    public static void updatePeso(double pesoActual, String nombreUser, double IMC) throws SQLException{

    	String consulta = "Update USUARIOS set PESO = ?, IMC = ?  where NOMBRE_USUARIO_USUARIOS = '" + nombreUser +"'";

        ps = connection.prepareStatement(consulta);

        ps.setDouble(1, pesoActual);
        ps.setDouble(2, IMC);

        ps.executeUpdate();

        ps.close();
    }


    /**
   	 * Método para actualizar el peso y el plan del usuario en la tabla "USUARIO" de la base de datos.
   	 * @param pesoActual peso actual del usuario que se desea actualizar en la base de datos.
   	 * @param nombreUser nombre del usuario al que se desea actualizar su peso en la base de datos.
   	 * @param IMC  índice de masa corporal actual del usuario que se desea actualizar en la base de datos.
   	 * @param kcalMantenimiento número de calorías diarias de mantenimiento actual del usuario a actualizar.
   	 * @param consulta realiza la consulta de UPDATE.
   	 */

    public static void updatePesoIMC(double pesoActual, String nombreUser, double IMC, int kcalMantenimiento) throws SQLException {

    	String consulta = "Update USUARIOS set PESO = ?, IMC = ?, KCAL_DIARIAS = ?  where NOMBRE_USUARIO_USUARIOS = '" + nombreUser +"'";

        ps = connection.prepareStatement(consulta);

        ps.setDouble(1, pesoActual);
        ps.setDouble(2, IMC);
        ps.setInt(3, kcalMantenimiento);

        ps.executeUpdate();

        ps.close();
    }

    /**
   	 * Método para actualizar la contraseña del usuario en la tabla "USUARIO" de la base de datos.
   	 * @param nombreUser nombre de usuario de la persona.
   	 * @param contraseñaNueva nueva contraseña que se quiere establecer para el usuario indicado en nombreUser.
   	 * @param consulta realiza la consulta de UPDATE.
   	 */

    public static void updateContraseña (String nombreUser, String contraseñaNueva) throws SQLException {

    	String consulta = "Update PERSONAS set CONTRASENA = ? where NOMBRE_USUARIO = '" + nombreUser +"'";

        ps = connection.prepareStatement(consulta);

        ps.setString(1, contraseñaNueva);

        ps.executeUpdate();

        ps.close();

    }


//**********************************************************************************************************************************************************************************************
//****SELECT****

    /**
   	 * Método para verificar el inicio de sesión de un usuario ya registrado.
   	 * @param nombre_usuario nombre de usuario del usuario que intenta iniciar sesión.
   	 * @param contraseña_usuario contraseña ingresada por el usuario que intenta iniciar sesión.
   	 */

    public static boolean inicioSesion (String nombre_usuario, String contraseña_usuario) throws SQLException {

    	String contraseña= "";
    	st= connection.createStatement();
    	rs=st.executeQuery("Select CONTRASENA from Personas where NOMBRE_USUARIO= '" + nombre_usuario + "'");

    	while(rs.next()) {
    	contraseña = rs.getString("CONTRASENA");
    	}
    	st.close();
    	return  contraseña.equals(contraseña_usuario);
    }


    /**
   	 * Método para conseguir los valores nutricionales de cada alimento.
   	 * @param nombre nombre del alimento del cual se desea obtener información nutricional (grasas, proteinas, carbohidratos, kilocalorias).
   	 */

    public static void nutrientesAlimentos (String nombre) throws SQLException {

    	double grasas = 0, proteinas = 0, carbohidratos = 0, kilocalorias = 0;
    	String vitaminas="", tipo="";

    	st= connection.createStatement();
    	rs=st.executeQuery("Select TIPO, VITAMINAS, GRASAS, PROTEINAS, CARBOHIDRATOS, KILOCALORIAS from ALIMENTOS where upper(nombre)= '" + nombre +"'");

    	while(rs.next()) {
    	tipo=rs.getString("TIPO");
    	vitaminas=rs.getString("VITAMINAS");
    	grasas=rs.getDouble("GRASAS");
    	proteinas=rs.getDouble("PROTEINAS");
    	carbohidratos=rs.getDouble("CARBOHIDRATOS");
    	kilocalorias=rs.getDouble("KILOCALORIAS");
    	}


    	Alimentos.al_actual.setProteina(proteinas);
    	Alimentos.al_actual.setCarbohidrato(carbohidratos);
    	Alimentos.al_actual.setKcal(kilocalorias);
    	Alimentos.al_actual.setGrasas(grasas);
    	Alimentos.al_actual.setVitaminas(vitaminas);
    	Alimentos.al_actual.setTipo(tipo);

    	st.close();

    	}

    /**
	 * Método para mostrar los tipos de alimento.
	 */

    public static ArrayList<Object> sacarTipo () throws SQLException {

    	ArrayList<Object> tipo = new ArrayList<>();

    	st=connection.createStatement();
    	rs=st.executeQuery("Select distinct TIPO from ALIMENTOS");

    	while(rs.next()) {
    		tipo.add(rs.getString("TIPO"));
    	}
    	st.close();

    	return tipo;
    }

    /**
   	 * Método para mostrar los alimentos de cada tipo.
   	 * @param tipo indica el tipo de alimentos que se desea buscar en la base de datos.
   	 */

    public static ArrayList<Object> nombreAlimentos(String tipo) throws SQLException {

    	ArrayList<Object> nombre = new ArrayList<>();

    	st=connection.createStatement();
    	rs=st.executeQuery("Select NOMBRE from ALIMENTOS where upper(TIPO)= '" + tipo + "'");

    	while(rs.next()) {
    		nombre.add(rs.getString("NOMBRE"));
    	}
    	st.close();

    	return nombre;
    }

    /**
	 * Método que sumará la cantidad de valores nutricionales que tiene cada plato (suma de valores nutricionales de los alimentos)
	 * @param al número de objetos de tipo Alimentos
	 */
    public static void nutrientesCantidad (Alimentos... al) throws SQLException {

    	int grasas = 0, proteinas = 0, carbohidratos = 0, kilocalorias = 0;

    	st=connection.createStatement();
    	rs=ps.executeQuery("Select GRASAS, PROTEINAS, CARBOHIDRATOS, KILOCALORIAS from ALIMENTOS");

    	while(rs.next()) {
    		grasas += rs.getInt("GRASAS");
    		proteinas += rs.getInt("PROTEINAS");
    		carbohidratos += rs.getInt("CARBOHIDRATOS");
    		kilocalorias += rs.getInt("KILOCALORIAS");
    	}
    	st.close();

    }

    /**
   	 * Método para sacar el número de platos favoritos que tiene el usuario.
   	 * @param nombre_users nombre del usuario para el cual se desea obtener el número máximo de platos consumidos.
   	 */

    public static int numPlato (String nombre_user) throws SQLException {

    	int num_plato = 0;
    	st=connection.createStatement();
    	rs=st.executeQuery("Select NVL(MAX(NUM_PLATO),0) from PLATOS join COMEN on PLATOS.ID_PLATO=COMEN.ID_PLATO where NOMBRE_USUARIO='"+nombre_user+"'");

    	while(rs.next()) {
    		num_plato = rs.getInt(1);
    	}
    	st.close();
    	return num_plato;
    }

    /**
   	 * Método que crea los paneles de los platos guardados.
   	 * @param nombre_usuario nombre del usuario al que se le buscará los platos.
   	 * @param num_plato_izq número mínimo de plato .
   	 * @param num_plato_derch número máximo de plato.
   	 * @param id_plato identificador del plato.
   	 */

    public static ArrayList<Platos> generarPanelPlatos(String nombre_usuario, int num_plato_izq, int num_plato_derch) throws SQLException  {

    	Platos.platos_usuario = new ArrayList<>();

    	String id_plato = "";
    	double total_prot = 0, total_carbo = 0, total_gras = 0, total_kcal = 0;

    	st= connection.createStatement();
    	rs=st.executeQuery("SELECT DISTINCT P.ID_PLATO, P.TOTAL_PROTEINAS, P.TOTAL_CARBOHIDRATOS, P.TOTAL_GRASAS, P.TOTAL_KILOCALORIAS from PLATOS P join COMEN C on P.ID_PLATO=C.ID_PLATO where C.NOMBRE_USUARIO = '"
    	+ nombre_usuario + "' and P.NUM_PLATO between " + num_plato_izq + " and " + num_plato_derch);

    	while(rs.next()) {
    		id_plato = rs.getString("ID_PLATO");
    		total_prot = rs.getDouble("TOTAL_PROTEINAS");
    		total_carbo = rs.getDouble("TOTAL_CARBOHIDRATOS");
    		total_gras = rs.getDouble("TOTAL_GRASAS");
    		total_kcal = rs.getDouble("TOTAL_KILOCALORIAS");

    		Platos.platos_usuario.add(new Platos(id_plato,"",total_prot,total_carbo,total_gras,total_kcal, ""));
    	}
    	st.close();
    	return Platos.platos_usuario;
    }

    /**
   	 * Método para recuperar los datos del usuario activo.
   	 * @param nombreUser usuario del que se desea recuperar los datos personales (altura, edad, kilocalorias y género).
   	 */

    public static void recuperarDatosPersonales(String nombreUser) throws SQLException {

    	int altura = 0, edad = 0, kcal = 0;
    	String genero = "";

    	st= connection.createStatement();
    	rs=st.executeQuery("select ALTURA, GENERO, EDAD, KCAL_DIARIAS from USUARIOS where NOMBRE_USUARIO_USUARIOS = '" + nombreUser + "'");

    	while(rs.next()) {
    		altura = rs.getInt("ALTURA");
    		genero = rs.getString("GENERO");
    		edad = rs.getInt("EDAD");
    		kcal = rs.getInt("KCAL_DIARIAS");


    		Usuario.user_completo.setNombre_usuario(nombreUser);
    		Usuario.user_completo.setAltura(altura);
    		Usuario.user_completo.setGenero(genero);
    		Usuario.user_completo.setEdad(edad);
    		Usuario.user_completo.setKcal(kcal);

    	}

    	st.close();

    }

    /**
   	 * Método para recuperar información nutricional de los platos que un usuario ha comido en el día actual y actualiza los datos (vitaminas, grasas, proteinas, carbohidratos, kilocalorias).
   	 * @param nombreUser recibe el nombre de usuario y almacena los datos (grasas, proteinas, carvohidratos y kilocarias) recuperados de la tabla "COMEN".
   	 */

    public static void recuperaTablaComen (String nombreUser) throws SQLException {

    	String vitaminas = "";
    	double grasas=0, proteinas=0, carbohidratos=0, kcal=0;

    	st= connection.createStatement();
    	rs=st.executeQuery("select TOTAL_VITAMINAS, TOTAL_GRASAS, TOTAL_PROTEINAS, TOTAL_CARBOHIDRATOS, TOTAL_KILOCALORIAS from PLATOS P join COMEN C on P.ID_PLATO=C.ID_PLATO where NOMBRE_USUARIO = '" + nombreUser + "' and to_date(DIA) = to_date(sysdate)");


    	while(rs.next()) {
    		vitaminas += rs.getString("TOTAL_VITAMINAS");
    		grasas += rs.getDouble("TOTAL_GRASAS");
    		proteinas += rs.getDouble("TOTAL_PROTEINAS");
    		carbohidratos += rs.getDouble("TOTAL_CARBOHIDRATOS");
    		kcal += rs.getDouble("TOTAL_KILOCALORIAS");

    	}

		//faltan vitaminas
		Platos.plato_actual.setGrasas_total(grasas);
		Platos.plato_actual.setProteina_total(proteinas);
		Platos.plato_actual.setCarbohidrato_total(carbohidratos);
		Platos.plato_actual.setKcal_total(kcal);

    	st.close();
    }


//**********************************************************************************************************************************************************************************************

    /**
	 * Método que recupera los datos peronales de una persona.
	 * @param nombre_user recupera los datos personales de una persona dado su nombre de usuario y los almacena en un objeto de tipo Personas (nombre, apellido y correo).
	 */

    public static void datosPersona(String nombre_user) throws SQLException {

    	String nombre ="", apellido = "", correo = "";

    	st= connection.createStatement();
    	rs=st.executeQuery("Select NOMBRE, APELLIDOS, CORREO_ELECTRONICO from Personas where NOMBRE_USUARIO = '" + nombre_user + "'");

    	while(rs.next()) {
    		nombre = rs.getString("NOMBRE");
    		apellido = rs.getString("APELLIDOS");
    		correo = rs.getString("CORREO_ELECTRONICO");


    		Personas.px_actual.setUsuario(nombre_user);
    		Personas.px_actual.setNombre(nombre);
    		Personas.px_actual.setApellido(apellido);
    		Personas.px_actual.setCorreo(correo);
    	}
    }

    /**
	 * Método que recupera los platos más usados del usuario.
	 * @param nombre_user nombre de usuario donde se muestran los platos más usados.
	 * @param tipo hora del día específica de los platos (DESAYUNO, COMIDA, CENA)
	 */

    public static String platos_Mas_Usados(String nombre_user, String tipo) throws SQLException {

    	String platoFav ="";

    	st= connection.createStatement();
    	rs=st.executeQuery("Select ID_PLATO from COMEN where HORA = '" + tipo + "' and NOMBRE_USUARIO = '" + nombre_user
    			+"' group by NOMBRE_USUARIO, ID_PLATO having count(*) in (Select max(count(*)) from COMEN where HORA = '" + tipo + "' and NOMBRE_USUARIO = '" + nombre_user + "' group by ID_PLATO)");

    	while(rs.next()) {
    		platoFav = rs.getString("ID_PLATO");
    	}

    	return platoFav;
    }

    /**
	 * Método para sacar el numero de comentarios que tiene el usuario.
	 * @param nombre_user nombre de usuario donde se muestran los platos más usados.
	 */

    public static int numComentario (String nombre_user) throws SQLException {

    	int num_comentario = 0;
    	st=connection.createStatement();
    	rs=st.executeQuery("Select MAX(ID_COMENTARIO) from COMENTARIOS where NOMBRE_USUARIO_USUARIOS='"+ nombre_user +"'");

    	while(rs.next()) {
    		num_comentario = rs.getInt(1);
    	}
    	st.close();
    	return num_comentario;
    }



  //*******************************************************************************************************************************************************************************************

    /**
	 * Método main que lanza esta clase
	 */
    public static void main(String[] args) throws SQLException {
        conectar();

            try {
                cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
