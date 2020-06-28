package model;


import java.util.ArrayList;
	

public interface Tablero {
	
	public ArrayList<Carro> listarCarro(); 	
	public ArrayList<Huevo> listarHuevo();	
	//implementacion de carros
	public ArrayList<Caguano> listarCaguano();
	public ArrayList<Kromi> listarKromi();
	public ArrayList<Trupalla>listarTrupalla();
	
	public String crearCarro(); 					//revisar
	
	public String desplegarKromi(); 					//Nuevo revisar Victor
	public String desplegarCaguano(); 					//Nuevo revisar Victor
	public String desplegarTrupalla(); 					//Nuevo revisar Victor
	
	public boolean lanzarHuevo(int x, int y); 		//se cambia a boolean para verificar impacto
	public String mostrarMatrix();
	public String generarMatrix(); 					//Nuevo genera el tablero "vacio"
	public int calcularPuntaje(int x, int y);
	public int[] generarCoordenadas(String tipo);  	//Genera las coordenadas y usa parentesis porque es un método (averiguar) //carlos
	public String verificarCoordenadas(String tiro);//Revisa que las coordenadas esten bien y las pasa a numero
	public String getMatrix();
}


