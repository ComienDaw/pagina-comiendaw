package Builder;

import Clases.Alimentos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class zConexion {

    private static String bd = "XE";
    private static String login = "proyecto";
    private static String password = "proyecto";
    private static String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
    static Connection connection;
    static PreparedStatement st;
    static Statement st2;
    static ResultSet rs;

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
    //CONSULTA PARA REGISTRAR USUARIOS EN LA TABLA PERSONAS DE LA BBDD ('BPANTALLA_REGISTRO)
    public static void ejecutarConsulta(String usuario, String nombre, String apellido, String correo, String contraseña) throws SQLException {
    	
    	String consulta = "Insert into PERSONAS values (?,?,?,?,?)";
        st = connection.prepareStatement(consulta);
       
        
        st.setString(1, usuario);
        st.setString(2, nombre);
        st.setString(3, apellido);
        st.setString(4, correo);
        st.setString(5, contraseña);
        
        st.executeUpdate();
        
        st.close();
    }
    
    //********************************************************************************************************************************************************************************************
  //CONSULTA PARA QUE UN USUARIO YA REGISTRADO PUEDA ACCEDER A SU CUENTA ('BPANTALLA_INICIO_SESION')
   
    public static boolean inicioSesion (String nombre_usuario, String contraseña_usuario) throws SQLException {
    String contraseña= "";
    st2= connection.createStatement(); 
    rs=st2.executeQuery("Select CONTRASEÑA from Personas where nombre_usuario = '" + nombre_usuario + "'"); 
    while(rs.next()) {
    contraseña = rs.getString("CONTRASEÑA");
    }
    st2.close();
    return contraseña.equals(contraseña_usuario);
    }

    
    //CONSULTA PARA TERMINAR REGISTRO CON LOS DATOS PERSONALES (SE QUIERO CONSEGUIR KCAL MANTENIMIENTO) ('BDATOS_PERSONALES')
    public static void datosPersonales(String genero, int altura, double peso, int edad) throws SQLException {
    	
    	String consulta = "Insert into USUARIOS (GENERO-, ALTURA, PESO, EDAD) values (?,?,?,?)";
        st = connection.prepareStatement(consulta);

        st.setString(1, genero);
        st.setInt(2, altura);
        st.setDouble(3, peso);
        st.setInt(4,edad);
        
        st.executeUpdate();
        
        st.close(); 	
    }
    
    //METODO QUE SUMARA LA CANTIDAD DE VALORES NUTRICIONALES QUE TIENE CADA PLATO (SUMA DE VALORES NUTRICIONALES DE LOS ALIMENTOS)
    public static void nutrientesPlato (Alimentos... al) throws SQLException {
    	
    	int grasas = 0, proteinas = 0, carbohidratos = 0, kilocalorias = 0;
    	
    	st=(PreparedStatement) connection.createStatement();
    	rs=st.executeQuery("Select GRASAS, PROTEINAS, CARBOHIDRATOS, KILOCALORIAS from ALIMENTOS");

    	while(rs.next()) {
    		grasas += rs.getInt("GRASAS");
    		proteinas += rs.getInt("PROTEINAS");
    		carbohidratos += rs.getInt("CARBOHIDRATOS");
    		kilocalorias += rs.getInt("KILOCALORIAS");
    	}

    }

    
    public static void cerrar() throws SQLException {
        if (rs != null)
            rs.close();
        if (st != null)
            st.close();
        if (connection != null)
            connection.close();
    }

    public static void main(String[] args) {
        conectar();
       
            try {
                cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
    }
}
