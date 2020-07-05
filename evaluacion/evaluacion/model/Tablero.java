package model;


import java.util.ArrayList;
	

public interface Tablero {
	
	public ArrayList<Carro> listarCarro(); 	
	public ArrayList<Huevo> listarHuevo();	
	
	//implementacion de carros
	//public ArrayList<Caguano> listarCaguano();
	//public ArrayList<Kromi> listarKromi();
	//public ArrayList<Trupalla>listarTrupalla();
	
	public String crearCarro(String crearCarro); 					//revisar
	
	public String desplegarCarros(); 
	
	public boolean lanzarHuevo(int x, int y); 		//se cambia a boolean para verificar impacto
	public void mostrarMatrix();
	public String generarMatrix(); 					//Nuevo genera el tablero "vacio"
	public int calcularPuntaje(int x, int y);
	public int[] generarCoordenadas(String tipo);  	//Genera las coordenadas y usa parentesis porque es un m�todo (averiguar) //carlos
	public String verificarCoordenadas(String tiro);//Revisa que las coordenadas esten bien y devuelve int columna, int fila o un error
	public void setTablero(int x, int y, String letra);
	
	//public String getMatrix();
	
}


