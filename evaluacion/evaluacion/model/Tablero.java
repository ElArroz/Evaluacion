package model;


import java.util.ArrayList;
	

public interface Tablero {
	
	public ArrayList<Carro> listarCarro(); 	
	public ArrayList<Huevo> listarHuevo();	
	
	public String crearCarro(); 					//revisar
	public boolean lanzarHuevo(int x, int y); 		//se cambia a boolean para verificar impacto
	public String mostrarMatrix();
	public String generarMatrix(); 					//Nuevo genera el tablero "vacio"
	public int calcularPuntaje();
	public int[] generarCoordenadas(String tipo);  	//Genera las coordenadas y usa parentesis porque es un método (averiguar) //carlos
	public String verificarCoordenadas(String tiro);//Revisa que las coordenadas esten bien y las pasa a numero
}

