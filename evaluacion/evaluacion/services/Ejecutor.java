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
	int tam = 15; // tama�o tablero
	int x,y; //coordenadas
	int sum=0;
	boolean res,salir;
	String tapa = "-"; // caracter que tapa la celda //176
	String matrixJuego[][] = new String[tam + 1][tam + 1];  //Arreglo principal
	int punto = 0;
	// ArrayList Carro listarCarro = new Arraylist[];

	
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
		DefaultTableModel model = (DefaultTableModel) Pantalla.tableroJuego.getModel(); //Jtable tableroJuego
		model.setRowCount(tam);

		for (int i = 0; i < tam; i++) {
			Pantalla.tableroJuego.setValueAt(i + 1, i, 0); // Encabezados filas 1 a 15
		}

		for (int i = 0; i < tam; i++) {
			for (int j = 1; j < tam + 1; j++) {
System.out.println(matrixJuego[i][j]);
				Pantalla.tableroJuego.setValueAt(matrixJuego[i][j], i, j);  //asignamos valores a Jtable tableroJuego
			}
		}
	}
	
	
	public void setTablero(int x, int y, String letra) {
		this.matrixJuego[x][y] = letra;
	}
	

		
	@Override
	public int[] generarCoordenadas(String tipo) {
		int fmax = 15, cmax = 16, ele = 3;
		if (tipo.equalsIgnoreCase("k")) {
			fmax = 13;
			ele = 1;
		} else if (tipo.equalsIgnoreCase("c")) {
			cmax = 14;
			ele = 2;
		}

		int fila = ThreadLocalRandom.current().nextInt(0, fmax);
		int columna = ThreadLocalRandom.current().nextInt(0, cmax);

		return new int[] { fila, columna, ele };
	}

	

	/// por implementar
	
	
	@Override
	public ArrayList<Carro> listarCarro() {
		return null;

	}

	@Override
	public ArrayList<Huevo> listarHuevo() {
		return null;

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

		//Auxiliares aux = new Auxiliares(); aux.desplegarCarros().length

	/*	int estado = 0;
		//Carro.estado = 0;
		switch (matrixJuego[x][y]) {
		case 'K':
			punto += 3;
			setTablero(x, y, 'H'); // cambiar K por H
			for (int i = 0; i < matrixJuego[x][y]; i++) {// recorrer las instancias de carro - KROMI buscando x,y en el
															// arreglo de ubicaciones y luego Restar a estado -1
				if ( estado == 0) {// if estado es = 0 se suma +10 a punto
					punto += 10;

				}
			}

			break;
		case 'C':
			punto += 2;
			setTablero(x, y, 'H'); // cambiar C por H
			for (int i = 0; i < matrixJuego[x][y]; i++) {// recorrer las instancias de carro - Caguano buscando x,y en
															// el
															// arreglo de ubicaciones y luego Restar a estado -1
				if (estado == 0) {// if estado es = 0 se suma +10 a punto
					punto += 10;

				}
			}
			break;
		case 'T':
			punto += 1;
			setTablero(x, y, 'H'); // cambiar T por H
			for (int i = 0; i < matrixJuego[x][y]; i++) {// recorrer las instancias de carro - Trupalla buscando x,y en
															// el
															// arreglo de ubicaciones y luego Restar a estado -1
				if (estado == 0) {// if estado es = 0 se suma +10 a punto
					punto += 10;

				}
			}
			break;
		}
*/
		return punto;
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

	
	public String[][] getTablero() {  // dudoso ?
		return this.matrixJuego;
	}
	
	public boolean revisar (int x, int y){
		System.out.println(x+" "+y);
		System.out.println(matrixJuego[x][y]);
		if (tapa.equals(matrixJuego[x][y])) { //equalsIgnoreCase("k")
			return true;
			
		} else {
		
		return false;
		}
	}
	

	/*
	@Override
	public String getMatrix() {
		mostrarMatrix();
		return this.mensaje;
	}
*/
	
	public String desplegarCarros() {
		
		for (int i=0; i<3;i++) {
			int arre[] = generarCoordenadas("k");
			x = arre[0];
			y = arre[1];
			do {				
				if (tapa.equals(matrixJuego[x][y])) { 
					if (tapa.equals(matrixJuego[x+1][y])) {
						if (tapa.equals(matrixJuego[x+2][y])) {
							setTablero(x, y, "K");
							setTablero(x + 1, y, "K");
							setTablero(x + 2, y, "K");
							salir = true;
							break;
							// Generer Instancia de kromi
							// agrego al arreglo de carros (18)	
						}
					}
				}
			} while (!salir);
			sum=sum+1;
			System.out.println(sum);
		}
		
		System.out.println(res);
	return null;
		
	}
	
}
