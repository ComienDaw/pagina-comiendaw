package Builder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import Clases.Personas;
import Clases.Usuario;

/**
 *
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * Pestaña que permite al usuario enviar un mensaje a los desarrolladores de la aplicación con comentarios, quejas o sugerencias sobre el funcionamiento de la misma, a modo de feedback.
 * Estos comentarios se almacenarán en la base de datos de la aplicación.
 * @param contentPane JPanel con las dimensiones de la ventana.
 * @param panel JPanel con los parámetros del programa.
 * @param lblLogo JLabel logo de la aplicación.
 * @param lblTitulo JLabel título de la pestaña.
 * @param lblRelleno_correo JLabel correo del usuario conectado.
 * @param lblTextoExplicativo JLabel proporciona información al usuario.
 * @param lblTumensaje JLabel mensaje introducido por el usuario.
 * @param btnAtras Botón para ir para atrás.
 * @param btnEnviar Botón para enviar el formulario.
 * @param textFieldMensaje JTextField caja de texto para que el usuario introduzca el mensaje.
 * @param mostrar muestra el mensaje de error.
 * @param numComentario número de comentario del usuario.
 */

public class fMensajes extends JFrame {

    private JPanel contentPane;
    JPanel panel;
    JLabel lblLogo, lblTitulo;
    private JLabel lblRelleno_correo;
    private JLabel lblCorreo;
    private JLabel lblTextoExplicativo;
    private JButton btnAtras,btnEnviar;
    private JLabel lblTumensaje;
    private JTextField textFieldMensaje;
    mensajeError mostrar;
    int numComentario;


    /**
	 * Método main que lanza esta pestaña
	 */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    fMensajes frame = new fMensajes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
	 * Método que permite volver al menú principal de la aplicación
	 */

  	public void cambioFrame1 () {
  		final cPantalla_Principal cPantalla_Principal = new cPantalla_Principal ();
  		cPantalla_Principal.setVisible(true);
  		dispose();
  	}

  	/**
	 * Método que inserta en la base de datos el comentario del usuario
	 * @param usuario parámetro 1, variable que contiene el nombre del usuario actual
	 * @param numComentario parámetro 2, variable que contiene el número total de comentarios que el usuario lleva realizados
	 * @param comentario parámetro 3, variable que contiene la cadena de texto del comentario del usuario
	 */

  	public void insert_comentario(String usuario , int numComentario, String comentario) throws SQLException{


  				String nombre_user= Usuario.user_actual.getNombre_usuario();

  					zConexion.insertComentario(nombre_user,numComentario,comentario);

  			}


  	/**
	 * Método que carga la interfaz gráfica de la ventana
	 */

    public void inicialice() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 643, 503);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        //LABEL CON EL LOGO DE LA APLICACIÓN
        lblLogo = new JLabel("New label");
        lblLogo.setIcon(new ImageIcon("./src/Imagenes_Proyecto/logo_comiendawsintexto80x76.png"));
        lblLogo.setBounds(22, 10, 78, 76);
        contentPane.add(lblLogo);

        //LABEL DEL TÍTULO DE LA PESTAÑA
        lblTitulo = new JLabel("ZONA DE MENSAJES");
        lblTitulo.setForeground(new Color(0, 128, 128));
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 30));
        lblTitulo.setBounds(127, 36, 357, 50);
        contentPane.add(lblTitulo);


        //LABEL QUE SE RELLENA AUTOMÁTICAMENTE CON EL CORREO DEL USUARIO CONECTADO
        lblRelleno_correo = new JLabel("New label");
        lblRelleno_correo.setFont(new Font("Arial Black", Font.BOLD, 14));
        lblRelleno_correo.setBackground(new Color(248, 248, 255));
        lblRelleno_correo.setBounds(240, 215, 226, 23);
        contentPane.add(lblRelleno_correo);

        //LABEL QUE INTRODUCE EL ESPACIO EN EL QUE APARECERÁ EL CORREO DEL USUARIO
        lblCorreo = new JLabel("Tu correo electrónico:");
        lblCorreo.setForeground(new Color(0, 128, 128));
        lblCorreo.setBackground(new Color(0, 128, 128));
        lblCorreo.setFont(new Font("Arial Black", Font.BOLD, 14));
        lblCorreo.setBounds(49, 215, 181, 23);
        contentPane.add(lblCorreo);

        //TEXTO EXPLICATIVO DEL FRAME
      		lblTextoExplicativo = new JLabel("<html><pre>Aquí podrás escribirnos cualquier duda o sugerencia que desees\n"
      				+"acerca de la aplicación. Nuestro equipo la recibirá e intentará\n"
      				+"contestarte lo antes posible a tu dirección de correo electrónico.\n"
      				+"¡Tu opinión es muy importante para seguir mejorando día a día!</pre></html>");

      		lblTextoExplicativo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
      		lblTextoExplicativo.setBounds(69, 10, 528, 278);
      		contentPane.add(lblTextoExplicativo);

      	//BOTÓN "ENVIAR"
      	btnEnviar = new JButton("ENVIAR");
        btnEnviar.setForeground(new Color(248, 248, 255));
        btnEnviar.setFont(new Font("Arial Black", Font.BOLD, 13));
        btnEnviar.setBackground(new Color(0, 128, 128));
        btnEnviar.setBounds(309, 389, 112, 34);
        contentPane.add(btnEnviar);

        //BOTÓN "ATRÁS"
        btnAtras = new JButton("ATRÁS");
        btnAtras.setForeground(new Color(248, 248, 255));
        btnAtras.setBackground(new Color(244, 164, 96));
        btnAtras.setFont(new Font("Arial Black", Font.BOLD, 13));
        btnAtras.setBounds(450, 389, 112, 34);
        contentPane.add(btnAtras);

        //LABEL "TU MENSAJE:"
        lblTumensaje = new JLabel("Déjanos tu mensaje:");
        lblTumensaje.setForeground(new Color(244, 164, 96));
        lblTumensaje.setFont(new Font("Arial Black", Font.BOLD, 14));
        lblTumensaje.setBounds(49, 266, 181, 23);
        contentPane.add(lblTumensaje);

      //CUADRO DE TEXTO PARA QUE EL USUARIO INTRODUZCA EL MENSAJE
        textFieldMensaje = new JTextField();
        textFieldMensaje.setFont(new Font("Arial", Font.BOLD, 12));
        textFieldMensaje.setForeground(new Color(0, 128, 128));
        textFieldMensaje.setBounds(49, 301, 519, 50);
        textFieldMensaje.setHorizontalAlignment(SwingConstants.LEFT); // Alinea el texto a la derecha
        textFieldMensaje.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); // Establece la dirección de escritura de derecha a izquierda
        contentPane.add(textFieldMensaje);


        /**
    	 * Método que establece el límite de caracteres que se puede escribir dentro del JTextField (500 caracteres)
    	 * @param fb FilterBypass evita la llamada al documento para cambiarlo.
    	 * @param offset int indica el índice del primer carácter que será modificado en el documento.
    	 * @param length int indica la longitud del texto introducido por el usuario.
    	 * @param text String texto introducido por el usuario.
    	 * @param currentLength int obtiene la longitud actual del documento antes de que se realice el reemplazo de texto.
    	 * @param newLength int
    	 * @param attrs AttributeSet manipula los atributos del estilo de un documento.
    	 */

        ((AbstractDocument) textFieldMensaje.getDocument()).setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                // Calcula la longitud del texto actual y del nuevo texto introducido por el usuario
                int currentLength = fb.getDocument().getLength();
                int newLength = currentLength + text.length() - length;

                // Si el nuevo texto supera el límite de caracteres, no lo permite y lanza un JOptionPane con el mensaje de error
                if (newLength <= 500) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    JOptionPane.showMessageDialog(fMensajes.this,
                            "El límite de caracteres es de 500. No se puede agregar más texto.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    /**
	 * Método que incluye la funcionalidad de todos los botones de la pantalla
	 */

        public fMensajes() {

        	inicialice();
        	zConexion.conectar();

        	//RELLENA EL LABEL DEL CORREO CON EL CORREO DEL USUARIO QUE ESTÁ CONECTADO
        	 lblRelleno_correo.setText(Personas.px_actual.getCorreo());

        	//FUNCIÓN DEL BOTÓN "ATRÁS"
        	 btnAtras.addMouseListener(new MouseAdapter() {
             	@Override
             	public void mouseClicked(MouseEvent e) {
             		cambioFrame1();
             	}
             });

        	 //FUNCIÓN DEL BOTÓN "ENVIAR"
        	 btnEnviar.addMouseListener(new MouseAdapter() {
           		@Override
           		public void mouseClicked(MouseEvent e) {
           			String nombre_user= Usuario.user_actual.getNombre_usuario();
           			String comentario =  textFieldMensaje.getText().toString();
    				try {
    					numComentario = zConexion.numComentario(nombre_user);
    					numComentario++;
    					insert_comentario(nombre_user,numComentario,comentario);
    					JOptionPane.showMessageDialog(contentPane, "Mensaje enviado con éxito");
    				} catch (SQLException e1) {
    					mostrar = new mensajeError(contentPane, "No se ha podido enviar el comentario.");
    				}

           		}
           	});

        }
    }


