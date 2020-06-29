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

import services.Ejecutor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class Pantalla extends JFrame {

	private JPanel ventana;
	private JTable tableroJuego;
	int tam = 15;
	static Ejecutor eje = new Ejecutor();
	char matrixJuego[][] = eje.getTablero();
	private JPanel panel;
	private JButton btnDesplegar;
	private JButton btnDisparoManual;
	private JButton btnDisparoAzar;
	private JButton btnFinPartida;
	private JButton btnSalir;
	private JButton btnJugar;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eje.generarMatrix();
					eje.setTablero(0, 5, 'K');
					eje.setTablero(1, 5, 'K');
					eje.setTablero(2, 5, 'K');

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
		//setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(560, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		ventana = new JPanel();
		ventana.setBackground(Color.DARK_GRAY);
		ventana.setBorder(new EmptyBorder(4, 4, 4, 4));
		setContentPane(ventana);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);

		GroupLayout gl_ventana = new GroupLayout(ventana);
		gl_ventana.setHorizontalGroup(gl_ventana.createParallelGroup(Alignment.LEADING).addGroup(gl_ventana
				.createSequentialGroup().addGap(16)
				.addGroup(gl_ventana.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
				.addContainerGap()));
		gl_ventana.setVerticalGroup(gl_ventana.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ventana.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE).addGap(10)));
		
		
		
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnDesplegar = new JButton("Desplegar Carros");
		btnDesplegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMatriz();
			}
		});
		panel.add(btnDesplegar);
		
				
		btnDisparoManual = new JButton("Disparo Manual");
		btnDisparoManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnDisparoManual);
				

		btnFinPartida = new JButton("Finalizar partida");
		btnFinPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnFinPartida);
		
		btnJugar = new JButton("JUGAR");
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnJugar);
		
		btnDisparoAzar = new JButton("Disparo Azar");
		btnDisparoAzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnDisparoAzar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				                // Se pide una confirmación antes de finalizar el programa
						int option = JOptionPane.showConfirmDialog(
							null, 
							"¿Estás seguro de que quieres cerrar la aplicación?",
							"Confirmación de cierre", 
							JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE);
						if (option == JOptionPane.YES_OPTION) {
							System.exit(0);
						}
				//	}
			//	});
			//	System.exit(0);
				
			/*	Main m = new Main();
				m.setVisible(true);
				m.setSize(560,450);
				setLocationRelativeTo(null);
				
				ventana.setVisible(false);
				dispose();
			*/	
			}
		});
		
		
		panel.add(btnSalir);
		

		tableroJuego = new JTable();
		tableroJuego.setRowSelectionAllowed(false);
		tableroJuego.setForeground(Color.BLACK);
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

		// tableroJuego.setRowHeight(20);

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
		ventana.setLayout(gl_ventana);
	}
}