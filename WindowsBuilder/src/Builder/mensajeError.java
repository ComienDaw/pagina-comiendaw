package Builder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Javier Martínez,Miguel Ángel de la Calle,Álvaro Martín
 * mensajeError va a mostrar el mensaje de error que se produzca en cualquier clase.
 * @param mensajeError muestra el texto con el tipo de error.
 * @param panelError muestra un panel con botones de opción.
 * @param infoError muestra una ventana emergente para mostrar información importante al usuario.
*/
public class mensajeError {

	JLabel mensajeError;
	JOptionPane panelError;
	JDialog infoError;

	 /**
	  * Método que muestra un mensaje de error en un panel con un temporizador para que se autocierre.
	  * @param PanelFrame muestra el panel en el que se mostrará el mensaje de error.
	  * @param mensaje muestra el mensaje de error que se mostrará al usuario.
	 */

	public mensajeError(JPanel PanelFrame, String mensaje){

		mensajeError = new JLabel(mensaje);
		mensajeError.setHorizontalAlignment(SwingConstants.CENTER);

		panelError = new JOptionPane(mensajeError, JOptionPane.PLAIN_MESSAGE);			//VENTANA DE ERROR (MENSAJE DE ERROR, SOLO MENSAJE)
		infoError = new JDialog();														//CONTIENE LA INFORMACION DEL JOPTIONPANE
		infoError.setUndecorated(true); 												//QUITAMOS LA BARRA SUPERIOR DEL JOPTIONPANEL
		infoError.setContentPane(panelError);
		infoError.pack();
		infoError.setLocationRelativeTo(PanelFrame);
		infoError.setVisible(true);

        Timer timer = new Timer(1500, new ActionListener() { 							//TEMPORIZADOR DEL MENSAJE PARA QUE SE AUTOCIERRE
            @Override
            public void actionPerformed(ActionEvent e) {
            	infoError.dispose();
            }
        });
        timer.setRepeats(false); 														//ESTABLECE QUE SALGA SOLO UNA VEZ EL TEMPORIZADOR
        timer.start(); 																	//INICIA EL TEMPORIZADOR
    }
}