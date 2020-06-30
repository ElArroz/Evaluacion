package services;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.table.DefaultTableModel;

import controller.Pantalla;
import model.Caguano;
import model.Carro;
import model.Huevo;
import model.Kromi;
import model.Tablero;
import model.Trupalla;

public class Ejecutor implements Tablero {
	int tam = 15; // tamaño tablero
	char tapa = '·'; // caracter que tapa la celda //176
	char matrixJuego[][] = new char[tam + 1][tam + 1];
	int punto = 0;
	String mensaje = "         ";
	
	//ArrayList Carro listarCarro = new Arraylist[];
	
	ArrayList<String> crearCarros = new ArrayList<String>();

	@Override
	public ArrayList<Carro> listarCarro(Carro crearCarro) {
		
		//Carro listarCarro[x][y] = new Carro[x][y];
		
		/*for(int i = 0; i< crearCarros; i++)
			
		if(tablero[i][j] instanceof Kromi)
		{
			
		}
		if(tablero[i][j] instanceof Caguano)
		{
			
		}
		if(tablero[i][j] instanceof Trupalla)
		{
			
		}*/
		
		return null;
		
	}

	@Override
	public ArrayList<Huevo> listarHuevo(Huevo huevos) {
		// Huevo.add(huevos);
		return null;

	}

	@Override
	public String crearCarro(String crearCarro) {
		
		crearCarros.addAll(crearCarros);
		
		return crearCarro;

		
	}

	@Override
	public boolean lanzarHuevo(int x, int y) { // con respecto al impacto (si le pego)
		if (matrixJuego[x][y] == '.')
			return false;
		else
			return true;
	}

	@Override
	public int calcularPuntaje(int x, int y) {

		switch (matrixJuego[x][y]) {
		case 'K':
			punto += 3;
			break;
		case 'C':
			punto += 2;
			break;
		case 'T':
			punto += 1;
			break;
		}
		if(lanzarHuevo(x,y) == true){  //nose si estara bien asi 
			punto = 'k' + 10;
		}else if(lanzarHuevo(x,y) == true)
		{
			punto = 'C' + 7;
		}
		return punto;
	}

	@Override
	public  void mostrarMatrix() { //TODO Averiguar como usar este metodo desde Ejecutor

		DefaultTableModel model = (DefaultTableModel) Pantalla.tableroJuego.getModel();
		model.setRowCount(tam);

		for (int i = 0; i < tam; i++) {
			Pantalla.tableroJuego.setValueAt(i + 1, i, 0); // Encabezados filas 1 a 15
		}

		for (int i = 0; i < tam; i++) {
			for (int j = 1; j < tam + 1; j++) {
				
				Pantalla.tableroJuego.setValueAt(matrixJuego[i][j], i, j);
			}
		}
	}
/*	public String mostrarMatrix() {
		
		
		
		/*
		  String txt = "  ";
		 
		System.out.print(" \t"); // dejar un espacio en blanco

		for (int i = 0; i < tam; i++) {
			System.out.print((char) (i + 65) + "   "); // Llenamos la primera fila con letras 65 es "A"
			this.mensaje = this.mensaje + (char) (i + 65) + "   ";
		}
		System.out.println();
		for (int i = 0; i < tam + 1; i++) {
			if (i != 0) {
				System.out.printf("%2d\t", i);
				if (i > 9)
					txt = "";
				this.mensaje = this.mensaje + "\n " + txt + i;
			}

			for (int j = 0; j < tam; j++) {
				System.out.print(this.tablero[i][j] + "   ");
				this.mensaje = this.mensaje + "    " + (this.tablero[i][j]);
			}
			System.out.println();

		}
		return null;
	}

*/
	@Override
	public int[] generarCoordenadas(String tipo) {
		int fmax = 15, cmax = 16, ele = 3;
		if (tipo.equalsIgnoreCase("k")) {
			fmax = 14;
			ele = 1;
		} else if (tipo.equalsIgnoreCase("c")) {
			cmax = 14;
			ele = 2;
		}

		int fila = ThreadLocalRandom.current().nextInt(0, fmax);
		int columna = ThreadLocalRandom.current().nextInt(1, cmax); 

		return new int[] {fila, columna, ele };
	}

	@Override
	public String generarMatrix() {

		for (int i = 0; i < tam + 1; i++)
			for (int j = 0; j < tam + 1; j++)
				this.matrixJuego[i][j] = tapa;

		return null;
	}

	public void setTablero(int x, int y, char letra) {
		this.matrixJuego[x][y] = letra;
	}

	@Override
	public String verificarCoordenadas(String tiro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String desplegarKromi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String desplegarCaguano() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String desplegarTrupalla() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public ArrayList<Caguano> listarCaguano() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public ArrayList<Kromi> listarKromi() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public ArrayList<Trupalla> listarTrupalla() { // TODO
	 * Auto-generated method stub return null; }
	 */

	@Override
	public String getMatrix() {
		mostrarMatrix();
		return this.mensaje;
	}

	public char[][] getTablero() {
		return matrixJuego;
	}



}
