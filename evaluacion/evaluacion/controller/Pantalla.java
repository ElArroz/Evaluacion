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

public class Pantalla extends JFrame {

	private JPanel ventana;
	private JTable tableroJuego;

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

	
	
	public void mostrarMatriz() { //char matrix[][]
		//Ejecutor eje = new Ejecutor();
		//char matrixJuego[][] = eje.getTablero();
		int tam=15;
		
		DefaultTableModel model = (DefaultTableModel) tableroJuego.getModel();
		model.setRowCount(tam);
				
		for (int i = 1; i < tam+1; i++) {
			tableroJuego.setValueAt(i,i-1,0); //Encabezados filas 1 a 15
			
		}
		/*
		System.out.println();
		for (int i = 0; i < tam + 1; i++) {
			if (i != 0) {
				System.out.printf("%2d\t", i);
				}
			for (int j = 0; j < tam; j++) {
				System.out.print(this.tablero[i][j] + "   ");
				}
			System.out.println();
		}
		*/
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public Pantalla() {
		Ejecutor eje = new Ejecutor();
		
		setTitle("[ Batalla por Oscurilandia: A la conquista de la camara secreta ]");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		ventana = new JPanel();
		ventana.setToolTipText("");
		ventana.setBackground(Color.DARK_GRAY);
		ventana.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(ventana);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		
		JButton btnMostrarTablero = new JButton("Mostrar Tablero");
		btnMostrarTablero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			mostrarMatriz();
				}
		});
		
				
		GroupLayout gl_ventana = new GroupLayout(ventana);
		gl_ventana.setHorizontalGroup(
			gl_ventana.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ventana.createSequentialGroup()
					.addGroup(gl_ventana.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ventana.createSequentialGroup()
							.addGap(98)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ventana.createSequentialGroup()
							.addGap(309)
							.addComponent(btnMostrarTablero)))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		gl_ventana.setVerticalGroup(
			gl_ventana.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ventana.createSequentialGroup()
					.addGap(64)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnMostrarTablero, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(178))
		);
		
		
		eje.generarMatrix();
		eje.setTablero(1,5,'C'); 
		eje.setTablero(2,5,'T'); 
		eje.setTablero(3,5,'K'); 
		
		
		tableroJuego = new JTable();
		tableroJuego.setRowSelectionAllowed(false);
		tableroJuego.setForeground(Color.BLACK);
		tableroJuego.setBorder(null);
		tableroJuego.getTableHeader().setReorderingAllowed(false);
		tableroJuego.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
		tableroJuego.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"
			}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
					};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		for (int i = 0; i < 16; i++) {
			tableroJuego.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			tableroJuego.getColumnModel().getColumn(i).setResizable(false);
		
		}
		
		scrollPane.setViewportView(tableroJuego);
		ventana.setLayout(gl_ventana);
	}
	
}

