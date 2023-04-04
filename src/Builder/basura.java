package Builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class basura extends JFrame{

	JFrame frame;
	private JTextField textUsuario;
	private JTextField textCorreo;
	private JTextField textPassword;
	private JPasswordField textPasswordOK;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					basura window = new basura();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public basura() {
		initialize();
	}

	private void initialize() {
		 
		
				frame = new JFrame();
				frame.getContentPane().setForeground(new Color(0, 0, 0));
				frame.getContentPane().setBackground(new Color(240, 230, 140));
				frame.setBounds(100, 100, 643, 503);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
	//SOLO TEXTO TÍTULO.......................................................
				JLabel lblNewLabel = new JLabel("REGISTRO");
				lblNewLabel.setForeground(new Color(0, 0, 0));
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
				lblNewLabel.setBounds(238, 42, 250, 23);
				frame.getContentPane().add(lblNewLabel);
	//SOLO TEXTO..............................................................
				JLabel lblNewLabel_1 = new JLabel("Usuario");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_1.setBackground(new Color(0, 0, 0));
				lblNewLabel_1.setForeground(new Color(0, 0, 0));
				lblNewLabel_1.setBounds(44, 135, 128, 14);
				frame.getContentPane().add(lblNewLabel_1);
	//SOLO TEXTO..............................................................
				JLabel lblNewLabel_2 = new JLabel("Correo electrónico");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_2.setForeground(new Color(0, 0, 0));
				lblNewLabel_2.setBounds(44, 212, 128, 14);
				frame.getContentPane().add(lblNewLabel_2);
	//SOLO TEXTO..............................................................
				JLabel lblNewLabel_3 = new JLabel("Contraseña");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_3.setForeground(new Color(0, 0, 0));
				lblNewLabel_3.setBounds(44, 280, 128, 14);
				frame.getContentPane().add(lblNewLabel_3);
	//SOLO TEXTO..............................................................
				JLabel lblNewLabel_4 = new JLabel("Confirma contraseña");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_4.setForeground(new Color(0, 0, 0));
				lblNewLabel_4.setBounds(44, 351, 154, 14);
				frame.getContentPane().add(lblNewLabel_4);
	//VERIFICADO EN VERDE......................................................
				JLabel lblVerificado1 = new JLabel("Verificado");
				lblVerificado1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblVerificado1.setVisible(false);
				lblVerificado1.setForeground(new Color(0, 204, 0));
				lblVerificado1.setBounds(442, 212, 67, 14);
				frame.getContentPane().add(lblVerificado1);
	//VERIFICADO EN VERDE......................................................
				JLabel lblVerificado3 = new JLabel("Verificado");
				lblVerificado3.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblVerificado3.setVisible(false);
				lblVerificado3.setForeground(new Color(0, 204, 0));
				lblVerificado3.setBounds(442, 351, 67, 14);
				frame.getContentPane().add(lblVerificado3);
	//VERIFICADO EN VERDE......................................................
				JLabel lblVerificado2 = new JLabel("Verificado");
				lblVerificado2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblVerificado2.setVisible(false);
				lblVerificado2.setForeground(new Color(0, 204, 0));
				lblVerificado2.setBounds(442, 280, 67, 14);
				frame.getContentPane().add(lblVerificado2);
	//AÑADIR EL NOMBRE DE USUARIO..............................................
				textUsuario = new JTextField();
				textUsuario.setBounds(206, 126, 212, 32);
				frame.getContentPane().add(textUsuario);
				textUsuario.setColumns(10);		
	//AÑADIR CONTRASEÑA.......................................................
				textPassword = new JPasswordField();
				textPassword.setBounds(208, 271, 210, 32);
				frame.getContentPane().add(textPassword);
				textPassword.setColumns(10);
	//AÑADIR CONFIRMACION CONTRASEÑA..........................................
				textPasswordOK = new JPasswordField();
				textPasswordOK.setBounds(208, 342, 210, 32);
				frame.getContentPane().add(textPasswordOK);
				textPassword.setColumns(10);
	//ERROR AL INTRODUCIR MAL LA CONTRASEÑA...................................
				JLabel lblErrorPassword = new JLabel("La contraseña no es válida");
				lblErrorPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblErrorPassword.setVisible(false);
				lblErrorPassword.setForeground(new Color(255, 0, 0));
				lblErrorPassword.setBounds(238, 385, 284, 14);
				frame.getContentPane().add(lblErrorPassword);
	//CONFIRMACION DEL CORREO ELECTRÓNICO.....................................
				textCorreo = new JTextField();
				textCorreo.setBounds(208, 203, 210, 32);
				frame.getContentPane().add(textCorreo);
				textCorreo.setColumns(10);	
	//ERROR EN EL CORREO ELECTRÓNICO
				JLabel lblErrorCorreo = new JLabel("El correo no es válido");
				lblErrorCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblErrorCorreo.setVisible(false);
				lblErrorCorreo.setForeground(Color.RED);
				lblErrorCorreo.setBounds(442, 212, 128, 14);
				frame.getContentPane().add(lblErrorCorreo);
	//CONTRASEÑA Y CONFIRMACION...............................................
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnRegistrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String contraseña = textPassword.getText();
			String contraseñaOK = textPasswordOK.getText();	
			String correo = textCorreo.getText();
			String com = correo.substring(correo.length()-4, correo.length());
			String es = correo.substring(correo.length()-3, correo.length());
			if (correo.contains("@") == true && (com.equals(".com") || es.equals(".es"))) {
				lblVerificado1.setVisible(true);
			if (contraseña.equals(contraseñaOK) && !contraseña.equals("")) {
				lblVerificado2.setVisible(true);
				lblVerificado3.setVisible(true);
				lblErrorPassword.setVisible(false);
				lblErrorCorreo.setVisible(false);
			}else {
				lblErrorPassword.setVisible(true);
				lblVerificado2.setVisible(false);
				lblVerificado3.setVisible(false);
				lblErrorCorreo.setVisible(false);
				textPassword.setText("");;
				textPasswordOK.setText("");; 
			}}else if (contraseña.equals(contraseñaOK) && !contraseña.equals("")){
				lblErrorCorreo.setVisible(true);
				lblErrorPassword.setVisible(false);
				lblVerificado1.setVisible(false);
				lblVerificado2.setVisible(true);
				lblVerificado3.setVisible(true);				
			}else {
				lblErrorCorreo.setVisible(true);
				lblErrorPassword.setVisible(true);
				lblVerificado1.setVisible(false);
				lblVerificado2.setVisible(false);
				lblVerificado3.setVisible(false);
				textPassword.setText("");;
				textPasswordOK.setText("");; 
			}}});
				btnRegistrar.setForeground(new Color(0, 0, 0));
				btnRegistrar.setBounds(248, 410, 115, 43);
				frame.getContentPane().add(btnRegistrar);

		
	}
}

