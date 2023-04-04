package ComienDaw;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContadorCaracteres {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contador de Caracteres");
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea(10, 30);
        final int MAX_CARACT = 500;
        JLabel label = new JLabel("Caracteres: 0" + "/" + MAX_CARACT);

        label.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int labelWidth = label.getWidth();
                int textWidth = label.getFontMetrics(label.getFont()).stringWidth(label.getText());
                if (textWidth > labelWidth) {
                    int insertIndex = label.getText().lastIndexOf(" ", labelWidth);
                    if (insertIndex == -1) {
                        insertIndex = label.getText().length();
                    }
                    String labelText = label.getText().substring(0, insertIndex) + "<br>" + label.getText().substring(insertIndex);
                    label.setText("<html>" + labelText + "</html>");
                }
            }
        });

        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(textArea.getText().length() >= MAX_CARACT) {
                    e.consume();
                }
                label.setText("Caracteres: " + textArea.getText().length() + "/" + MAX_CARACT);
            }
        });

        panel.add(textArea);
        panel.add(label);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}

