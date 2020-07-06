package controller;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Main extends JFrame {

	private JPanel inicio;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public Main() {
		setTitle("[ Batalla por Oscurilandia ]");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(560, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		inicio = new JPanel();
		inicio.setBackground(Color.DARK_GRAY);
		inicio.setBorder(new EmptyBorder(4, 4, 4, 4));
		setContentPane(inicio);
			
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/img/fondoHuevos.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnIniciarJuego = new JButton("INICIAR");
		btnIniciarJuego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				Pantalla m = new Pantalla();
				m.setVisible(true);
				m.setSize(560,450);
				setLocationRelativeTo(null);
				
				inicio.setVisible(false);
				dispose();
			}
		});
		btnIniciarJuego.setFont(new Font("Stencil", Font.BOLD, 20));

		
		
		GroupLayout gl_inicio = new GroupLayout(inicio);
		gl_inicio.setHorizontalGroup(
			gl_inicio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inicio.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_inicio.createParallelGroup(Alignment.LEADING)
						.addComponent(btnIniciarJuego, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_inicio.setVerticalGroup(
			gl_inicio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_inicio.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnIniciarJuego, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		inicio.setLayout(gl_inicio);
	}
}
