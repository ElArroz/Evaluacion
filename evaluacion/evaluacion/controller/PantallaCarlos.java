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
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;

public class PantallaCarlos extends JFrame {

	private JPanel ventana;
	private JTable tableroJuego;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCarlos frame = new PantallaCarlos();
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
	public PantallaCarlos() {
		Ejecutor eje = new Ejecutor();
		
		setTitle("[ Batalla por Oscurilandia: A la conquista de la camara secreta ]");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(530, 515);
		setLocationRelativeTo(null);
		ventana = new JPanel();
		ventana.setToolTipText("");
		ventana.setBackground(new Color(51, 102, 0));
		ventana.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(ventana);
		
		JScrollPane pantalla = new JScrollPane();
		pantalla.setEnabled(false);
		
		
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
		
		pantalla.setViewportView(tableroJuego);
		
		JPanel menu = new JPanel();
		menu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 153, 51), new Color(0, 204, 0), new Color(0, 102, 0), new Color(0, 102, 51)));
		menu.setBackground(new Color(0, 153, 51));
		
		JPanel datos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) datos.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setHgap(2);
		
		JPanel Logo = new JPanel();
		GroupLayout gl_ventana = new GroupLayout(ventana);
		gl_ventana.setHorizontalGroup(
			gl_ventana.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ventana.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ventana.createParallelGroup(Alignment.TRAILING)
						.addComponent(menu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
						.addComponent(pantalla, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
						.addGroup(gl_ventana.createSequentialGroup()
							.addComponent(Logo, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(datos, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_ventana.setVerticalGroup(
			gl_ventana.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ventana.createSequentialGroup()
					.addContainerGap()
					.addComponent(pantalla, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ventana.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(Logo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(datos, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(menu, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("** PONER ESTADISTICAS O INFO DEL JUEGO **");
		datos.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("** PONER IMAGEN **");
		Logo.add(lblNewLabel_1);
		menu.setLayout(new GridLayout(2, 0, 5, 5));
		
		JButton btnOpcion1CrearJuego = new JButton("Crear Juego");
		btnOpcion1CrearJuego.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		menu.add(btnOpcion1CrearJuego);
		
		btnOpcion1CrearJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			// crear juego
				}
		});
		
		JButton btnOpcion2IniciarPartida = new JButton("Iniciar Partida");
		btnOpcion2IniciarPartida.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		menu.add(btnOpcion2IniciarPartida);
		
		btnOpcion2IniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//iniciar ataque, llamar a metodo	
			}
		});
		
		JButton btnOpcion3Disparar = new JButton("Disparar");
		btnOpcion3Disparar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnOpcion3Disparar.setBackground(new Color(255, 102, 0));
		menu.add(btnOpcion3Disparar);
		
		btnOpcion3Disparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//Disparar	
			}
		});
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 18));
		
		JButton btnOpcion4MostrarTablero = new JButton("Mostrar Tablero");
		btnOpcion4MostrarTablero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mostrarMatriz();	
			}
		});
		
		btnOpcion4MostrarTablero.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		menu.add(btnOpcion4MostrarTablero);
		
		JCheckBox chckbxDisparoAleatorio = new JCheckBox("Disparo Aleatorio");
		chckbxDisparoAleatorio.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		chckbxDisparoAleatorio.setSelected(true);
		menu.add(chckbxDisparoAleatorio);
		ventana.setLayout(gl_ventana);
	}
}

