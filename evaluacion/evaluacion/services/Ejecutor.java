package services;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.omg.CORBA.portable.ValueBase;

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
	String coorde="";
	private String matrixJuego[][] = new String[tam + 1][tam + 1]; // Arreglo principal
	String hit=null;
	int pto = 0,puntos=0;
	Carro carro = new Carro();
	Huevo huevo = new Huevo();
	private List <Carro> carros;
	private List <Huevo> huevos;
	Auxiliar aux = new Auxiliar();
	
	
	@Override
	public String generarMatrix() {

		for (int i = 0; i < tam + 1; i++) {
			for (int j = 0; j < tam + 1; j++) {
				this.getMatrixJuego()[i][j] = tapa;
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
				System.out.println(getMatrixJuego()[i][j]);
				Pantalla.tableroJuego.setValueAt(getMatrixJuego()[i][j], i, j); // asignamos valores a Jtable tableroJuego
			}
		}
	}
	
	@Override
	public void setTablero(int x, int y, String letra) {
		this.getMatrixJuego()[x][y] = letra;
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
	public String convertirPos(int x, int y) {
		char col = (char) (64 + y);
		String pos= String.valueOf(col)+(x+1);
		return pos;

	}

	@Override
	public String lanzarHuevo(int x, int y) { 
		pto=0;	
		switch (getMatrixJuego()[x][y]) {
			case "K":
				hit="(K)";
				pto=3;
				break;
				
			case "C":
				hit="(C)";
				pto=2;
				break;
				
			case "T":
				hit="(T)";
				pto=1;
				break;
				
			case "-":
				hit="H";
				break;
	
			default:
				break;
		}
			puntos +=pto;
			coorde=convertirPos(x,y);
			matrixJuego[x][y]=hit;	
			System.out.println("Resultado["+hit+"] en Cordenadas: " + coorde + " Puntos: +"+pto);
		return hit;
	}
	
	@Override
	public int calcularPuntaje(int x, int y) {
		
		return puntos;
	}

	@Override
	public int[] verificarCoordenadas(String tiro) {
	
	int number=0;
	String laLetra = tiro.substring(0,1); 
	String elNumero = tiro.substring(1,tiro.length());
	int a=0,b=0,c=0;
				
		if ((elNumero.replaceAll("[1234567890]","")).length() ==0) {
			number=Integer.valueOf(elNumero);		
		}
		
		if ((number>0) && (number<16) && (tiro.matches(".*[a-zA-Z].*"))) {
			char caracter =  laLetra.toUpperCase().charAt(0);
			a=number-1; b=caracter-64; c=1;
		}
	
		
		return new int[] {a,b,c};
	}
	
	@Override
	public String desplegarCarros() {
		this.carros=new ArrayList<>();
			
			do {
				int arre[] = generarCoordenadas("K");
				x = arre[0]; y = arre[1];
				if (tapa.equals(getMatrixJuego()[x][y]) && tapa.equals(getMatrixJuego()[x + 1][y]) && tapa.equals(getMatrixJuego()[x + 2][y])) {
						setTablero(x, y, "K");
						setTablero(x + 1, y, "K");
						setTablero(x + 2, y, "K");
						Kromi kromi=new Kromi(); // Generer Instancia de kromi
							kromi.setAnioFabricacion(aux.RandomFabricacion());
							kromi.setMarca(aux.RandomMarca());
							kromi.setFechaIngreso(aux.RandomFecha()+(kromi.getAnioFabricacion()+1));
							kromi.setCantidadOcupantes(ThreadLocalRandom.current().nextInt(1, 10));
							kromi.setDanio("SinDaño");
							kromi.setP1(convertirPos(x,y));
							kromi.setP2(convertirPos(x+1,y));
							kromi.setP3(convertirPos(x+2,y));
						this.carros.add(kromi);	// agrego al arreglo de carros
						out = out+1;
					}
			} while (out<3);
			
		System.out.println("Kromis Listas ("+out+")");
		out=0;
			do {
				int arre[] = generarCoordenadas("C");
				x = arre[0]; y = arre[1];
				if (tapa.equals(getMatrixJuego()[x][y]) &&tapa.equals(getMatrixJuego()[x + 1][y])) {
						setTablero(x, y, "C");
						setTablero(x, y + 1, "C");
						Caguano caguano=new Caguano(); 	// Generer Instancia de Caguano
							caguano.setAlcanceTiro(ThreadLocalRandom.current().nextInt(2, 30));
							caguano.setColorConfeti(aux.RandomColor());
							caguano.setCantidadOcupantes(ThreadLocalRandom.current().nextInt(2, 6));
							caguano.setFechaIngreso(aux.RandomFecha()+aux.RandomFabricacion());
							caguano.setDanio("SinDaño");
							caguano.setP1(convertirPos(x,y));
							caguano.setP2(convertirPos(x,y+1));
						this.carros.add(caguano);		// agrego al arreglo de carros 
						out = out+1;
				}

			} while (out<5);
				
		System.out.println("Caguanos Listos ("+out+")");
		out=0;	
			do {
				int arre[] = generarCoordenadas("T");
				x = arre[0]; y = arre[1];
				if (tapa.equals(getMatrixJuego()[x][y])) {
					setTablero(x, y, "T");
					Trupalla trupalla=new Trupalla();	// Generer Instancia de Trupallas
						trupalla.setNivelArmadura(ThreadLocalRandom.current().nextInt(1, 6));
						trupalla.setNombreManipulador(aux.RandomNombre());
						trupalla.setCantidadOcupantes(ThreadLocalRandom.current().nextInt(1, 4));
						trupalla.setFechaIngreso(aux.RandomFecha()+aux.RandomFabricacion());
						trupalla.setDanio("SinDaño");
						trupalla.setP1(convertirPos(x,y));
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

	public String[][] getMatrixJuego() {
		return matrixJuego;
	}

	public void setMatrixJuego(String matrixJuego[][]) {
		this.matrixJuego = matrixJuego;
	}

	public void setPto(int pto) {
		this.pto=pto;
	}
	
	public int getPto() {
		return pto;
	}
	
	}
