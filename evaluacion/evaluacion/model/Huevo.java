package model;

import java.util.ArrayList;

public class Huevo {

	int fila;
	int columna;
	int puntaje;
	//ArrayList<String> realizarDisparos = new ArrayList<>();

	public Huevo() {
	}

	public Huevo(int fila, int columna, int puntaje) {
		this.fila = fila;
		this.columna = columna;
		this.puntaje = puntaje;
	}

	/*public void realizarDisparo(String realizarDisparo) {

		realizarDisparos.add(realizarDisparo);

	}

	public void consultarDisparos() {

		for (int i = 0; i < realizarDisparos.size(); i++)
			for (int j = 0; j < realizarDisparos.size() - 1; j++) {

				System.out.println(realizarDisparos.get(i));
				System.out.println(realizarDisparos.get(j));
			}

	}*/

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public String toString() {
		return "Huevo [fila=" + fila + ", columna=" + columna + ", puntaje=" + puntaje + "]";
	}

}
