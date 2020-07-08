package controller;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.Carro;
import model.Huevo;
import services.Ejecutor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Pantalla extends JFrame {

	private JPanel ventana;
	public static JTable tableroJuego;
	int tam = 15;
	int puntos = 0;
	String msj="", pos ="";
	static Ejecutor eje = new Ejecutor();
	String matrixJuego[][] = eje.getMatrixJuego();
	String local[][] = new String[tam + 1][tam + 1];
	Huevo huevo = new Huevo();
	private List<Huevo> huevos;
	private JButton btnDesplegar;
	private JButton btnMostrarTablero;
	private JButton btnDisparar;
	private JButton btnFinPartida;
	private JButton btnSalir;
	private JButton btnJugar;
	private JLabel imgFondo;
	private JLabel txtTitulo;

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

	public void mostrarMatrizLocal() {

		DefaultTableModel model = (DefaultTableModel) tableroJuego.getModel();
		model.setRowCount(tam);

		for (int i = 0; i < tam; i++) {
			tableroJuego.setValueAt(i + 1, i, 0); // Encabezados filas 1 a 15
		}

		for (int i = 0; i < tam; i++) {
			for (int j = 1; j < tam + 1; j++) {
				tableroJuego.setValueAt(local[i][j], i, j);
			}
		}
	}

	public Pantalla() {

		setTitle("[A la conquista de la camara secreta ]");
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

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); // aca puedo pintar!
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < 16; i++) {
			tableroJuego.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			tableroJuego.getColumnModel().getColumn(i).setResizable(false);
		}

		for (int i = 0; i < tam + 1; i++) {
			for (int j = 0; j < tam + 1; j++) {
				local[i][j] = "·";
			}
		}

		scrollPane.setViewportView(tableroJuego);
		ventana.setLayout(null);

		txtTitulo = new JLabel("PUNTAJE ");
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTitulo.setVisible(false);
		txtTitulo.setForeground(Color.ORANGE);
		txtTitulo.setBounds(242, 299, 67, 20);
		ventana.add(txtTitulo);

		JLabel txtLabel = new JLabel("0");
		txtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		txtLabel.setVisible(false);
		txtLabel.setFont(new Font("Stencil", Font.PLAIN, 26));
		txtLabel.setForeground(Color.ORANGE);
		txtLabel.setBounds(252, 317, 36, 32);
		ventana.add(txtLabel);
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
				eje.desplegarCarros();
				mostrarMatrizLocal();
				btnJugar.setVisible(true);

			}
		});

// Boton Jugar
		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(16, 360, 165, 50);
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnJugar.setVisible(false);
		ventana.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnDisparar.setVisible(true);
				btnMostrarTablero.setVisible(true);
				btnFinPartida.setVisible(true);
				btnDesplegar.setVisible(false);
				btnJugar.setVisible(false);
				imgFondo.setVisible(true);
				txtLabel.setVisible(true);
				txtTitulo.setVisible(true);

			}
		});

//Boton Mostrar Estadisticas
		btnMostrarTablero = new JButton("Mostrar");
		btnMostrarTablero.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		btnMostrarTablero.setBounds(367, 299, 73, 50);
		btnMostrarTablero.setVisible(false);
		ventana.add(btnMostrarTablero);
		btnMostrarTablero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//array nn = eje.
				
				for(Carro i : eje.getCarros()) { //sacar las posiciones
					if (i.equals(i.posiciones)) {
						msj+="xxx";
					}else {
						msj+=i+"\n";
					}
				}
				
				//replaceAll("[1234567890]", "")
				
				eje.avisar(msj);
					
					
					msj="";
				
				for(Huevo j : huevos) {
					msj+=""+j+"\n";
					eje.avisar(msj);
					msj="";
				}
			
		}
			
		});

//Boton Disparar
		btnDisparar = new JButton("DISPARAR");
		btnDisparar.setBounds(192, 360, 165, 50);
		btnDisparar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisparar.setVisible(false);
		ventana.add(btnDisparar);
		this.huevos = new ArrayList<>();

		btnDisparar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int x = 0, y = 0, z = 0;
				int option = JOptionPane.showConfirmDialog(null, "¿Disparo aleatorio?", "LANZAR HUEVO",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {

					int posi[] = eje.generarCoordenadas("H");
					x = posi[0];
					y = posi[1];
					z = 1;

					local[x][y] = eje.lanzarHuevo(x, y);
					pos = eje.convertirPos(x, y);

				} else {
					String cordenada = JOptionPane.showInputDialog("Ingresa coordenada (Ejemplo: A1)");

					int[] posi = eje.verificarCoordenadas(cordenada);

					if (posi[2] == 1) {
						x = posi[0];
						y = posi[1];
						z = 1;
						local[x][y] = eje.lanzarHuevo(x, y);
						pos = cordenada.toUpperCase();
					}

				}

				if (z == 1) {
					Huevo huevo = new Huevo(); 
					huevo.setCoordenada(pos);
					huevo.setFila(x);
					huevo.setColumna(y);
					huevo.setPuntaje(eje.getPto());
					huevos.add(huevo); 
					puntos = puntos + eje.getPto(); 
					String puntaje = String.valueOf(puntos);
					txtLabel.setText(puntaje);
					mostrarMatrizLocal();

				} else {
					System.out.println("Cordenadas INCORRECTAS");
				}

			}
		});

//Boton FinPartida
		btnFinPartida = new JButton("Finalizar");
		btnFinPartida.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		btnFinPartida.setBounds(459, 299, 73, 50);
		btnFinPartida.setVisible(false);
		ventana.add(btnFinPartida);
		btnFinPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int option = JOptionPane.showConfirmDialog(null, "Vas a finalizar la partida: ¿Estas seguro?",
						"FINALIZAR PARTIDA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {

					for (int i = 0; i < tam; i++) {
						for (int j = 1; j < tam + 1; j++) {
							tableroJuego.setValueAt(eje.getMatrixJuego()[i][j], i, j);
						}
					}

					eje.getCarros().forEach(carro -> System.out.println("    " + carro));
					huevos.forEach(huevo -> System.out.println("    " + huevo));
					
					eje.avisar("Reiniciando");
					
					Main main = new Main();
					main.setVisible(true);
					main.setSize(560, 450);
					setLocationRelativeTo(null);
					ventana.setVisible(false);
					
					dispose();

				} else {

				}
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