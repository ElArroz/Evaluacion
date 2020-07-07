package model;


import java.util.ArrayList;
import java.util.List;
	

public interface Tablero {
	
	public List<Carro> getCarros(); 	
	public List<Huevo> getHuevos();	
	
						
	public String desplegarCarros(); 
	public String lanzarHuevo(int x, int y); 		//se cambia a boolean para verificar impacto
	public void mostrarMatrix();
	public String generarMatrix(); 					//Nuevo genera el tablero "vacio"
	
	public int calcularPuntaje(int x, int y);
	public int[] generarCoordenadas(String tipo);  	//Genera las coordenadas y usa parentesis porque es un método (averiguar) //carlos
	public int[] verificarCoordenadas(String tiro);//Revisa que las coordenadas esten bien y devuelve int columna, int fila o un error
	public void setTablero(int x, int y, String letra);
	
	public String convertirPos(int x, int y); 
}


