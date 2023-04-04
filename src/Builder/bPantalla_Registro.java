package Builder;

import Clases.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bPantalla_Registro extends JFrame {

	private JTextField textUsuario, textCorreo, textFieldNombre, textFieldApellido;
	private JPasswordField textPassword, textPasswordOK;

	JPanel panel;           
	JScrollPane scrollPane;         
	JLabel lblCampoVacio, lblNewLabel, logoCD, lblUsuario, lblNewLabel_2, lblContraseña, lblNewLabel_4, lblErrorPassword, lblErrorCorreo, lblFondo, lblNombre, lblApellido;         
	JButton Boton_Registrarme;

	aPantalla_Inicio pi;
	private JLabel lblAtras;

	public void mostrar () {
		setVisible(true);
	}
	
	public void inicialice () {
		
		setTitle("JScrollPane Example");
		setSize(786, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		//        panel.setPreferredSize(new Dimension(500,400));    

		scrollPane = new JScrollPane(panel);
		panel.setLayout(null);

		lblCampoVacio = new JLabel("Campo vacio");
		lblCampoVacio.setVisible(false);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 128, 128));
		lblNombre.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNombre.setBounds(165, 149, 111, 18);
		panel.add(lblNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(205, 133, 63));
		lblApellido.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblApellido.setBounds(165, 193, 111, 18);
		panel.add(lblApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(295, 194, 176, 20);
		panel.add(textFieldApellido);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(295, 150, 176, 20);
		panel.add(textFieldNombre);
		lblCampoVacio.setForeground(new Color(255, 0, 0));
		lblCampoVacio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCampoVacio.setBounds(497, 238, 100, 14);
		panel.add(lblCampoVacio);
		
		lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel.setBounds(297, 90, 274, 40);
		panel.add(lblNewLabel);

		logoCD = new JLabel("");
		logoCD.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\logo_comiendawsintexto80x76.png"));
		logoCD.setBounds(328, 0, 128, 97);
		panel.add(logoCD);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(0, 128, 128));
		lblUsuario.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblUsuario.setBounds(165, 235, 111, 18);
		panel.add(lblUsuario);

		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(295, 236, 176, 20);
		panel.add(textUsuario);

		lblNewLabel_2 = new JLabel("Correo electrónico");
		lblNewLabel_2.setForeground(new Color(205, 133, 63));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_2.setBounds(135, 292, 150, 14);
		panel.add(lblNewLabel_2);

		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(295, 291, 176, 20);
		panel.add(textCorreo);

		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setForeground(new Color(0, 128, 128));
		lblContraseña.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblContraseña.setBounds(154, 339, 89, 14);
		panel.add(lblContraseña);   

		lblNewLabel_4 = new JLabel("Confirma contraseña");
		lblNewLabel_4.setForeground(new Color(205, 133, 63));
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_4.setBounds(120, 393, 165, 14);
		panel.add(lblNewLabel_4);

		textPassword = new JPasswordField();
		textPassword.setBounds(295, 338, 176, 20);
		panel.add(textPassword);

		textPasswordOK = new JPasswordField();
		textPasswordOK.setBounds(295, 392, 176, 20);
		panel.add(textPasswordOK);
		
		lblErrorPassword = new JLabel("Contraseña incorrecta");
		lblErrorPassword.setVisible(false);
		lblErrorPassword.setForeground(new Color(255, 0, 0));
		lblErrorPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErrorPassword.setBounds(497, 360, 236, 14);
		panel.add(lblErrorPassword);

		lblErrorCorreo = new JLabel("Correo no válido");
		lblErrorCorreo.setVisible(false);
		lblErrorCorreo.setForeground(new Color(255, 0, 0));
		lblErrorCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblErrorCorreo.setBounds(497, 293, 165, 14);
		panel.add(lblErrorCorreo);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		lblFondo = new JLabel("New label");
		lblFondo.setForeground(new Color(245, 255, 250));
		lblFondo.setBackground(new Color(245, 222, 179));
		lblFondo.setIcon(new ImageIcon("C:\\Users\\diurno\\Desktop\\JMA\\ZZZZPROYECTO\\Imagenes proyecto\\logo_comiendaw.png"));
		lblFondo.setBounds(-235, 21, 955, 450);
		panel.add(lblFondo);
	}

	public bPantalla_Registro(aPantalla_Inicio pi) {

		this.pi = pi;
		inicialice();

		Boton_Registrarme = new JButton("REGISTRARME");
		Boton_Registrarme.setBackground(new Color(0, 128, 128));
		Boton_Registrarme.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String contraseña = textPassword.getText();
				String contraseñaOK = textPasswordOK.getText();	
				String correo = textCorreo.getText();
				String com = correo.substring(correo.length()-4, correo.length());
				String es = correo.substring(correo.length()-3, correo.length());
				String usuario = textUsuario.getText();
				String nombre = textFieldNombre.getText();
				String apellido = textFieldApellido.getText();
				zConexion con = new zConexion ();

				if (!usuario.equals("") && correo.contains("@") == true && (com.equals(".com") || es.equals(".es"))) {
					
					//CORREO BIEN    
					if (contraseña.equals(contraseñaOK) && !contraseña.equals("")) {
						lblErrorPassword.setVisible(false);
						lblErrorCorreo.setVisible(false);
//						dp.setVisible(true);
						pi.dp.mostrar();
						setVisible(false);

						try {
							zConexion.ejecutarConsulta(usuario, nombre, apellido, correo, contraseña);
							Usuario usu = new Usuario(usuario, contraseña);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//CONTRASEÑA BIEN   				
					}else {
						lblErrorPassword.setVisible(true);
						lblErrorCorreo.setVisible(false);
						textPassword.setText("");;
						textPasswordOK.setText("");; 
						//MAL CONTRASEÑA		
					}}else if (contraseña.equals(contraseñaOK) && !contraseña.equals("")){
						lblErrorCorreo.setVisible(true);
						lblErrorPassword.setVisible(false);		
						//MAL CORREO
					}else {
						lblErrorCorreo.setVisible(true);
						lblErrorPassword.setVisible(true);
						textPassword.setText("");;
						textPasswordOK.setText("");; 
						//MAL LAS DOS
					}}
		});

		Boton_Registrarme.setForeground(new Color(245, 255, 250));
		Boton_Registrarme.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
		Boton_Registrarme.setBounds(306, 446, 165, 39);
		panel.add(Boton_Registrarme);
		
		lblAtras = new JLabel("New label");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				pi.mostrar();
				setVisible(false);
			}
		});
		lblAtras.setIcon(new ImageIcon("C:\\Users\\migue\\OneDrive\\Documentos\\FP\\PROYECTO FINAL PROGRA-ENTORNOS-BASES\\IMAGENES\\atras.png"));
		lblAtras.setBounds(690, 33, 33, 40);
		panel.add(lblAtras);


	}
}