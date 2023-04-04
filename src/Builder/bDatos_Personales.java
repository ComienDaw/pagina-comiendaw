package Builder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bDatos_Personales extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAltura, textFieldPeso, textFieldEdad, textFieldPesoIdeal;
	
	JLabel lblTitulo, lblTituloDatos, lblGenero, lblAltura, lblPeso, lblEdad,  lblCm, lblKG, lblTituloObjetivo, lblPesoIdeal, lblObjetivo, lblAños, lblKGideal;	
	JCheckBox chckHombre, chckMujer, chck1kg, chck05kg, chckMin05kg, chckMax1kg;
	JButton btnCalcularKcal, btnConfirmar;
	JPanel panelDatos, panelObjetivos;
	
	aPantalla_Inicio pi;
	
	public void mostrar () {
		setVisible(true);
	}

 	public void inicialice() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitulo = new JLabel("Rellena los siguientes datos:");
		lblTitulo.setForeground(new Color(0, 128, 128));
		lblTitulo.setBackground(new Color(0, 128, 128));
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblTitulo.setBounds(10, 11, 405, 34);
		contentPane.add(lblTitulo);

		panelDatos = new JPanel();
		panelDatos.setBackground(new Color(245, 245, 220));
		panelDatos.setBounds(24, 80, 279, 373);
		contentPane.add(panelDatos);
		panelDatos.setLayout(null);

		lblTituloDatos = new JLabel("Datos personales:");
		lblTituloDatos.setForeground(new Color(0, 139, 139));
		lblTituloDatos.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblTituloDatos.setBounds(10, 11, 259, 33);
		panelDatos.add(lblTituloDatos);

		lblGenero = new JLabel("Genero:");
		lblGenero.setForeground(new Color(205, 133, 63));
		lblGenero.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblGenero.setBounds(10, 115, 113, 33);
		panelDatos.add(lblGenero);

		lblAltura = new JLabel("Altura");
		lblAltura.setForeground(new Color(205, 133, 63));
		lblAltura.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblAltura.setBounds(10, 202, 56, 33);
		panelDatos.add(lblAltura);

		lblPeso = new JLabel("Peso");
		lblPeso.setForeground(new Color(205, 133, 63));
		lblPeso.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblPeso.setBounds(10, 246, 56, 33);
		panelDatos.add(lblPeso);

		lblEdad = new JLabel("Edad");
		lblEdad.setForeground(new Color(205, 133, 63));
		lblEdad.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblEdad.setBounds(10, 290, 56, 33);
		panelDatos.add(lblEdad);

		chckHombre = new JCheckBox("Hombre");
		chckHombre.setFont(new Font("Arial Black", Font.PLAIN, 11));
		chckHombre.setBackground(new Color(238, 232, 170));
		chckHombre.setBounds(20, 155, 120, 23);
		panelDatos.add(chckHombre);

		chckMujer = new JCheckBox("Mujer");
		chckMujer.setFont(new Font("Arial Black", Font.PLAIN, 11));
		chckMujer.setBackground(new Color(238, 232, 170));
		chckMujer.setBounds(142, 155, 97, 23);
		panelDatos.add(chckMujer);

		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(68, 208, 102, 25);
		panelDatos.add(textFieldAltura);
		textFieldAltura.setColumns(10);

		textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(68, 252, 102, 25);
		panelDatos.add(textFieldPeso);

		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(68, 296, 102, 25);
		panelDatos.add(textFieldEdad);

		lblCm = new JLabel("cm.");
		lblCm.setForeground(new Color(0, 128, 128));
		lblCm.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblCm.setBounds(193, 207, 46, 22);
		panelDatos.add(lblCm);

		lblKG = new JLabel("kg.");
		lblKG.setForeground(new Color(0, 139, 139));
		lblKG.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblKG.setBounds(193, 251, 46, 22);
		panelDatos.add(lblKG);
		
		panelObjetivos = new JPanel();
		panelObjetivos.setForeground(new Color(245, 245, 220));
		panelObjetivos.setVisible(false);
		panelObjetivos.setBackground(new Color(245, 245, 220));
		panelObjetivos.setBounds(338, 80, 279, 373);
		contentPane.add(panelObjetivos);
		panelObjetivos.setLayout(null);
		
		lblTituloObjetivo = new JLabel("Objetivos:");
		lblTituloObjetivo.setBackground(new Color(240, 255, 240));
		lblTituloObjetivo.setForeground(new Color(0, 128, 128));
		lblTituloObjetivo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblTituloObjetivo.setBounds(10, 11, 259, 33);
		panelObjetivos.add(lblTituloObjetivo);
		
		lblPesoIdeal = new JLabel("Peso ideal:");
		lblPesoIdeal.setForeground(new Color(205, 133, 63));
		lblPesoIdeal.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblPesoIdeal.setBounds(10, 142, 113, 33);
		panelObjetivos.add(lblPesoIdeal);
		
		lblObjetivo = new JLabel("Objetivo semanal:");
		lblObjetivo.setForeground(new Color(0, 128, 128));
		lblObjetivo.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblObjetivo.setBounds(10, 186, 259, 33);
		panelObjetivos.add(lblObjetivo);
		
		chck1kg = new JCheckBox("1 kg. ");
		chck1kg.setBackground(new Color(204, 153, 102));
		chck1kg.setBounds(77, 256, 153, 23);
		panelObjetivos.add(chck1kg);
		
		chck05kg = new JCheckBox("0.5 kg (RECOMENDADO)");
		chck05kg.setBackground(new Color(153, 255, 102));
		chck05kg.setBounds(77, 282, 153, 23);
		panelObjetivos.add(chck05kg);
		 
		chckMin05kg = new JCheckBox("< 0.5 kg");
		chckMin05kg.setBackground(new Color(204, 153, 102));
		chckMin05kg.setBounds(77, 308, 153, 23);
		panelObjetivos.add(chckMin05kg);
		
		chckMax1kg = new JCheckBox("> 1kg.");
		chckMax1kg.setBackground(new Color(204, 51, 51));
		chckMax1kg.setBounds(77, 230, 153, 23);
		panelObjetivos.add(chckMax1kg);

		textFieldPesoIdeal = new JTextField();
		textFieldPesoIdeal.setColumns(10);
		textFieldPesoIdeal.setBounds(106, 148, 113, 25);
		panelObjetivos.add(textFieldPesoIdeal);
		
		lblKGideal = new JLabel("kg.");
		lblKGideal.setForeground(new Color(0, 128, 128));
		lblKGideal.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblKGideal.setBounds(229, 147, 46, 23);
		panelObjetivos.add(lblKGideal);

		lblAños = new JLabel("años.");
		lblAños.setForeground(new Color(0, 128, 128));
		lblAños.setFont(new Font("Arial Black", Font.ITALIC, 15));
		lblAños.setBounds(193, 295, 46, 22);
		panelDatos.add(lblAños);
	}

	public bDatos_Personales(aPantalla_Inicio pi) {
		this.pi = pi;
		inicialice();
		
		//BOTON PARA CONFIRMAR LOS DATOS PERSONALES
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setBackground(new Color(0, 128, 128));
		btnConfirmar.setForeground(new Color(245, 255, 250));
		btnConfirmar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelObjetivos.setVisible(true);
				panelDatos.setVisible(false);
			}
		});
		btnConfirmar.setBounds(142, 339, 127, 23);
		panelDatos.add(btnConfirmar);
		
		//BOTON PARA CALCULAR LAS KCAL.
		btnCalcularKcal = new JButton("CALCULAR");
		btnCalcularKcal.setBackground(new Color(0, 128, 128));
		btnCalcularKcal.setForeground(new Color(245, 255, 250));
		btnCalcularKcal.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnCalcularKcal.setBounds(135, 339, 134, 23);
		panelObjetivos.add(btnCalcularKcal);
		
		//*******************************************************************************************************************************************************
		//MARCAR EN EL CHECKBOX EL GENERO		
		if(chckHombre.isSelected()) {

		}else if(chckMujer.isSelected()) {
			
		}else {
			
		}

		//MARCAR EN EL CHECKBOX EL OBJETIVO SEMANAL (PERDIDA DE PESO) QUE QUIERES SEGUIR
		if(chckMax1kg.isSelected()) {
			
		}else if(chck1kg.isSelected()) {
			
		}else if(chck05kg.isSelected()) {
			
		}else if(chckMin05kg.isSelected()) {
			
		}else {
			
		}
		
		
//		int Kcal_mantenimiento;
		//FORMULA CALCULO KCAL SEGUN TU GENERO
			//HOMBRE
				//Kcal_mantenimiento = (10 x peso de Kg) + (6,25 x altura en cm) – (5 x edad en años) + 5;
			//MUJER
				//Kcal_mantenimiento = (10 x peso en kg) + (6,25 x altura en cm) – (5 x edad en años) – 161	
	}
}
