package model;

import java.util.ArrayList;

public class Huevo {

	String coordenada;
	int fila;
	int columna;
	int puntaje;
	

	public Huevo() {
	}

	public Huevo(String coordenada, int fila, int columna, int puntaje) {
		this.coordenada = coordenada;
		this.fila = fila;
		this.columna = columna;
		this.puntaje = puntaje;
	}
	
	public String getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}

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
		return "Huevo [Coordenada: "+ coordenada +" fila: " + fila + " columna: " + columna + " puntos: " + puntaje + "]";
	}

}
