package model;


import java.util.ArrayList;
	

public interface Tablero {
	
	public ArrayList<Carro> listarCarro(); 	
	public ArrayList<Huevo> listarHuevo();	
	
	public String crearCarro(); //revisar
	public int lanzarHuevo();
	public String mostrarMatrix();
	public String generarMatrix(); //Nuevo genera el tablero "vacio"
	public int calcularPuntaje();
	public int[] generarCoordenadas(String tipo);  //Genera las coordenadas y usa parentesis porque es un método (averiguar) //carlos
	
}

