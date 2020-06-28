package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Pantalla extends JFrame {

	private JPanel Ventana;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 // Crear the frame.
	 
	public Pantalla() {
		setTitle("ElArroz: MENU");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		Ventana = new JPanel();
		Ventana.setToolTipText("");
		Ventana.setBackground(Color.GRAY);
		Ventana.setBorder(new EmptyBorder(5, 5, 5, 5));
		Ventana.setLayout(new BorderLayout(0, 0));
		setContentPane(Ventana);
	}

}
