package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main2 {

	public static void main(String[] args) {
	JFrame ventana = new JFrame("ElArroz: MENU");
	JPanel panel = new JPanel();
	JButton botonSalir = new JButton("Salir"); 
	
	ventana.setSize(600,400);
	ventana.setVisible(true);
	ventana.add(panel);
	ventana.setLocationRelativeTo(null);
	ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	panel.add(botonSalir);
	
	botonSalir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ventana.dispatchEvent(new WindowEvent(ventana, WindowEvent.WINDOW_CLOSING));
			
		}
	});
	
	
	
	
	//JOptionPane.showMessageDialog (ventana,"test" ," [ ZONA DE BATALLA ]",JOptionPane.INFORMATION_MESSAGE );//,JOptionPane.WARNING_MESSAGE ,JOptionPane.PLAIN_MESSAGE
	}
}
