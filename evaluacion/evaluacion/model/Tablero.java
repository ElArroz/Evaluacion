package model;


import java.util.ArrayList;
	

public interface Tablero {
	
	public ArrayList<Carro> listarCarro(Carro carros); 	
	public ArrayList<Huevo> listarHuevo(Huevo huevos);	
	
	//implementacion de carros
	//public ArrayList<Caguano> listarCaguano();
	//public ArrayList<Kromi> listarKromi();
	//public ArrayList<Trupalla>listarTrupalla();
	
	public String crearCarro(); 					//revisar
	
	public String desplegarKromi(); 					//Nuevo revisar Victor
	public String desplegarCaguano(); 					//Nuevo revisar Victor
	public String desplegarTrupalla(); 					//Nuevo revisar Victor
	
	public boolean lanzarHuevo(int x, int y); 		//se cambia a boolean para verificar impacto
	public void mostrarMatrix();
	public String generarMatrix(); 					//Nuevo genera el tablero "vacio"
	public int calcularPuntaje(int x, int y);
	public int[] generarCoordenadas(String tipo);  	//Genera las coordenadas y usa parentesis porque es un m�todo (averiguar) //carlos
	public String verificarCoordenadas(String tiro);//Revisa que las coordenadas esten bien y devuelve int columna, int fila o un error
	public String getMatrix();
	
}


