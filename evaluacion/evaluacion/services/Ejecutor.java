package services;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.Carro;
import model.Huevo;
import model.Tablero;

public class Ejecutor implements Tablero {
	int tam = 15; // tamaño tablero
	char tapa = '·'; // caracter que tapa la celda //176
	char tablero[][] = new char[tam + 1][tam];

	@Override
	public ArrayList<Carro> listarCarro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Huevo> listarHuevo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String crearCarro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean lanzarHuevo(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String mostrarMatrix() {
		System.out.print(" \t"); // dejar un espacio en blanco

		for (int i = 0; i < tam; i++) {
			System.out.print((char) (i + 65) + "   "); // Llenamos la primera fila con letras 65 es "A"
		}
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
		return null;
	}

	@Override
	public int calcularPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] generarCoordenadas(String tipo) {
		int fmax = 16, cmax = 15, ele = 3;
		if (tipo.equalsIgnoreCase("k")) {
			fmax = 14;
			ele = 1;
		} else if (tipo.equalsIgnoreCase("c")) {
			cmax = 14;
			ele = 2;
		}

		int fila = ThreadLocalRandom.current().nextInt(1, fmax);
		int columna = ThreadLocalRandom.current().nextInt(0, cmax);

		return new int[] { fila, columna, ele };
	}

	@Override
	public String generarMatrix() {

		for (int i = 1; i < tam + 1; i++)
			for (int j = 0; j < tam; j++)
				this.tablero[i][j] = tapa;
		
		return null;
	}

	public void setTablero(int x, int y, char letra) {
		this.tablero[x][y] = letra;
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

}
