package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import services.Auxiliares;
import services.DiegoAux;
import services.Ejecutor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.JToolBar;
import java.awt.Cursor;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class Pantalla extends JFrame {

	private JPanel ventana;
	public static JTable tableroJuego;
	int tam = 15;
	int puntos = 0;
	
	static Ejecutor eje = new Ejecutor();
	static Auxiliares aux = new Auxiliares();
	static DiegoAux daux = new DiegoAux();
	
	char matrixJuego[][] = eje.getTablero();
	private JButton btnDesplegar;
	private JButton btnMostrarTablero;
	private JButton btnDisparar;
	private JButton btnFinPartida;
	private JButton btnSalir;
	private JButton btnJugar;
	private JLabel imgFondo;

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

	public void mostrarMatriz() {

		DefaultTableModel model = (DefaultTableModel) tableroJuego.getModel();
		model.setRowCount(tam);

		for (int i = 0; i < tam; i++) {
			tableroJuego.setValueAt(i + 1, i, 0); // Encabezados filas 1 a 15
		}

		for (int i = 0; i < tam; i++) {
			for (int j = 1; j < tam + 1; j++) {
				tableroJuego.setValueAt(matrixJuego[i][j], i, j);
			}
		}
	}

	public Pantalla() {

		setTitle("[ Batalla por Oscurilandia: A la conquista de la camara secreta ]");
		// setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(556, 449);
		setResizable(false);
		setLocationRelativeTo(null);
		ventana = new JPanel();
		ventana.setBackground(Color.DARK_GRAY);
		ventana.setBorder(new EmptyBorder(4, 4, 4, 4));
		setContentPane(ventana);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 10, 516, 265);
		scrollPane.setEnabled(false);

		tableroJuego = new JTable();
		tableroJuego.setRowSelectionAllowed(false);
		tableroJuego.setVisible(false);
		tableroJuego.setBorder(null);
		tableroJuego.getTableHeader().setReorderingAllowed(false);
		tableroJuego.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableroJuego.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		DefaultTableModel model = (DefaultTableModel) tableroJuego.getModel();
		model.setRowCount(tam);

		for (int i = 0; i < tam; i++) {
			tableroJuego.setValueAt(i + 1, i, 0); // Encabezados filas 1 a 15
		}

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < 16; i++) {
			tableroJuego.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			tableroJuego.getColumnModel().getColumn(i).setResizable(false);

		}

		scrollPane.setViewportView(tableroJuego);
		ventana.setLayout(null);
		ventana.add(scrollPane);

		imgFondo = new JLabel("");
		imgFondo.setIcon(new ImageIcon(Pantalla.class.getResource("/img/Huevo2.png")));
		imgFondo.setBounds(16, 299, 165, 111);
		imgFondo.setVisible(false);
		ventana.add(imgFondo);

//Boton Desplegar
		btnDesplegar = new JButton("Desplegar Carros");
		btnDesplegar.setBounds(16, 299, 165, 50);
		ventana.add(btnDesplegar);
		btnDesplegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableroJuego.setVisible(true);
				eje.generarMatrix();
				/*int cord[] = eje.generarCoordenadas("K");
				if(eje.getTablero().length == '.') {
					eje.setTablero(cord[0], cord[1], 'K');
					eje.setTablero(cord[1], cord[1], 'K');
					eje.setTablero(cord[2], cord[1], 'K');
					int x = cord[0];
					int y = cord[1];
				}*/
				
				//char col = (char) (64 + cord[1]);
				
				
				daux.desplegarCarros();
			
				//aux.desplegarCarros();  //K,C,T
				
				
				
				/*
				eje.setTablero(0, 5, 'K');
				eje.setTablero(1, 5, 'K');
				eje.setTablero(2, 5, 'K');
				 */
				
				mostrarMatriz();
			}
		});

// Boton Jugar
		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(16, 360, 165, 50);
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 18));
		ventana.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnDisparar.setVisible(true);
				btnMostrarTablero.setVisible(true);
				btnFinPartida.setVisible(true);
				btnDesplegar.setVisible(false);
				btnJugar.setVisible(false);
				imgFondo.setVisible(true);

			}
		});

//Boton MostrarTablero
		btnMostrarTablero = new JButton("Mostrar Tablero");
		btnMostrarTablero.setBounds(192, 299, 165, 50);
		btnMostrarTablero.setVisible(false);
		ventana.add(btnMostrarTablero);
		btnMostrarTablero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMatriz();
			}
		});

//Boton Disparar
		btnDisparar = new JButton("DISPARAR");
		btnDisparar.setBounds(192, 360, 165, 50);
		btnDisparar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisparar.setVisible(false);
		ventana.add(btnDisparar);
		btnDisparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int option = JOptionPane.showConfirmDialog(null, "¿Disparo aleatorio?", "LANZAR HUEVO",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					int cord[] = eje.generarCoordenadas("H");
					eje.setTablero(cord[0], cord[1], 'H');
					char col = (char) (64 + cord[1]);
					int x = cord[1];
					int y = cord[0];
					System.out
							.println("Cordenadas al azar " + String.valueOf(col) + (y + 1) + " (" + x + "," + y + ")");
				} else {
					String cord = JOptionPane.showInputDialog("Ingresa coordenada (Ejemplo: A1)");
					// enviar a verificar
					System.out.println("Se ingresa coordenadas " + cord + " y se llama auxilia lanza huevo");

				}
				// llamar auxiliar;

			}
		});

//Boton FinPartida
		btnFinPartida = new JButton("Finalizar partida");
		btnFinPartida.setBounds(367, 299, 165, 50);
		btnFinPartida.setVisible(false);
		ventana.add(btnFinPartida);
		btnFinPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO finPardida
			}
		});

//Boton Salir
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(367, 360, 165, 50);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 18));
		ventana.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Se pide una confirmación antes de finalizar el programa
				int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cerrar la aplicación?",
						"Confirmación de cierre", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

	}
}