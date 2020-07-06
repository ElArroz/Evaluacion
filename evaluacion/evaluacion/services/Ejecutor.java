package services;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controller.Pantalla;
import model.Caguano;
import model.Carro;
import model.Huevo;
import model.Kromi;
import model.Tablero;
import model.Trupalla;

public class Ejecutor extends DefaultTableCellRenderer implements Tablero {
	int tam = 15; // tamaño tablero
	int x, y; // coordenadas
	int out = 0;
	boolean res;
	String tapa = "-"; // caracter que tapa la celda 
	String matrixJuego[][] = new String[tam + 1][tam + 1]; // Arreglo principal
	int punto = 0;
	Carro carro = new Carro();
	Huevo huevo = new Huevo();
	private List <Carro> carros;
	private List <Huevo> huevos;
	Auxiliar aux = new Auxiliar();
	
	
	@Override
	public String generarMatrix() {

		for (int i = 0; i < tam + 1; i++) {
			for (int j = 0; j < tam + 1; j++) {
				this.matrixJuego[i][j] = tapa;
			}
		}
		return null;
	}

	@Override
	public void mostrarMatrix() {
		DefaultTableModel model = (DefaultTableModel) Pantalla.tableroJuego.getModel(); // Jtable tableroJuego
		model.setRowCount(tam);

		for (int i = 0; i < tam; i++) {
			Pantalla.tableroJuego.setValueAt(i + 1, i, 0); // Encabezados filas 1 a 15
		}

		for (int i = 0; i < tam; i++) {
			for (int j = 1; j < tam + 1; j++) {
				System.out.println(matrixJuego[i][j]);
				Pantalla.tableroJuego.setValueAt(matrixJuego[i][j], i, j); // asignamos valores a Jtable tableroJuego
			}
		}
	}
	
	@Override
	public void setTablero(int x, int y, String letra) {
		this.matrixJuego[x][y] = letra;
	}

	@Override
	public int[] generarCoordenadas(String tipo) {
		int cmax = 15, fmax = 15, ele = 3;
		if (tipo.equalsIgnoreCase("k")) {
			fmax = 13;
			ele = 1;
		} else if (tipo.equalsIgnoreCase("c")) {
			cmax = 15;
			ele = 2;
		}

		int columna = ThreadLocalRandom.current().nextInt(1, cmax);
		int fila = ThreadLocalRandom.current().nextInt(0, fmax);

		return new int[] { fila, columna, ele };
	}

	@Override
	public String crearCarro(String crearCarro) {
		return null;

	}

	@Override
	public boolean lanzarHuevo(int x, int y) { // con respecto al impacto (si le pego)
		if (matrixJuego[x][y] == ".")
			return false;
		else
			return true;
	}

	@Override
	public int calcularPuntaje(int x, int y) {

		// Auxiliares aux = new Auxiliares(); aux.desplegarCarros().length

		/*
		 * int estado = 0; //Carro.estado = 0; switch (matrixJuego[x][y]) { case 'K':
		 * punto += 3; setTablero(x, y, 'H'); // cambiar K por H for (int i = 0; i <
		 * matrixJuego[x][y]; i++) {// recorrer las instancias de carro - KROMI buscando
		 * x,y en el // arreglo de ubicaciones y luego Restar a estado -1 if ( estado ==
		 * 0) {// if estado es = 0 se suma +10 a punto punto += 10;
		 * 
		 * } }
		 * 
		 * break; case 'C': punto += 2; setTablero(x, y, 'H'); // cambiar C por H for
		 * (int i = 0; i < matrixJuego[x][y]; i++) {// recorrer las instancias de carro
		 * - Caguano buscando x,y en // el // arreglo de ubicaciones y luego Restar a
		 * estado -1 if (estado == 0) {// if estado es = 0 se suma +10 a punto punto +=
		 * 10;
		 * 
		 * } } break; case 'T': punto += 1; setTablero(x, y, 'H'); // cambiar T por H
		 * for (int i = 0; i < matrixJuego[x][y]; i++) {// recorrer las instancias de
		 * carro - Trupalla buscando x,y en // el // arreglo de ubicaciones y luego
		 * Restar a estado -1 if (estado == 0) {// if estado es = 0 se suma +10 a punto
		 * punto += 10;
		 * 
		 * } } break; }
		 */
		return punto;
	}

	@Override
	public String verificarCoordenadas(String tiro) {
		return null;
	}
	
	public String[][] getTablero() { // dudoso ?
		return this.matrixJuego;
	}
	
	@Override
	public String desplegarCarros() {
		this.carros=new ArrayList<>();
			
			do {
				int arre[] = generarCoordenadas("K");
				x = arre[0]; y = arre[1];
				if (tapa.equals(matrixJuego[x][y]) && tapa.equals(matrixJuego[x + 1][y]) && tapa.equals(matrixJuego[x + 2][y])) {
						setTablero(x, y, "K");
						setTablero(x + 1, y, "K");
						setTablero(x + 2, y, "K");
						Kromi kromi=new Kromi(); // Generer Instancia de kromi
							kromi.setAnioFabricacion(aux.RandomFabricacion());
							kromi.setMarca(aux.RandomMarca());
							kromi.setFechaIngreso(aux.RandomFecha()+(kromi.getAnioFabricacion()+1));
							kromi.setCantidadOcupantes(ThreadLocalRandom.current().nextInt(1, 10));
							kromi.setDanio("SinDaño");											
						this.carros.add(kromi);	// agrego al arreglo de carros
						out = out+1;
					}
			} while (out<3);
			
		System.out.println("Kromis Listas ("+out+")");
		out=0;
			do {
				int arre[] = generarCoordenadas("C");
				x = arre[0]; y = arre[1];
				if (tapa.equals(matrixJuego[x][y]) &&tapa.equals(matrixJuego[x + 1][y])) {
						setTablero(x, y, "C");
						setTablero(x, y + 1, "C");
						Caguano caguano=new Caguano(); 	// Generer Instancia de Caguano
							caguano.setAlcanceTiro(ThreadLocalRandom.current().nextInt(2, 30));
							caguano.setColorConfeti(aux.RandomColor());
							caguano.setCantidadOcupantes(ThreadLocalRandom.current().nextInt(2, 4));
							caguano.setFechaIngreso(aux.RandomFecha()+aux.RandomFabricacion());
							caguano.setDanio("SinDaño");
						this.carros.add(caguano);		// agrego al arreglo de carros 
						out = out+1;
				}

			} while (out<5);
				
		System.out.println("Caguanos Listos ("+out+")");
		out=0;	
			do {
				int arre[] = generarCoordenadas("T");
				x = arre[0]; y = arre[1];
				if (tapa.equals(matrixJuego[x][y])) {
					setTablero(x, y, "T");
					Trupalla trupalla=new Trupalla();	// Generer Instancia de Trupallas
						trupalla.setNivelArmadura(ThreadLocalRandom.current().nextInt(1, 6));
						
						trupalla.setCantidadOcupantes(ThreadLocalRandom.current().nextInt(1, 4));
						trupalla.setFechaIngreso(aux.RandomFecha()+aux.RandomFabricacion());
						trupalla.setDanio("SinDaño");
					this.carros.add(trupalla);			// agrego al arreglo de carros (18)
					out = out+1;
				}

			} while (out<10);

		System.out.println("Trupallas Listas ("+out+")");
		out=0;
		return null;
	}

	
	@Override
	public List<Carro> getCarros() {
		return this.carros;
	}

	
	@Override
	public List<Huevo> getHuevos() {
		return this.huevos;
	}


	}
