package controller;
/*
Las coordenadas se expresan como (x,y)
	X es una fila y se denota por una letra (A->O) 
	Y es una columna y se denota por un numero(1->15)

un ejemplo seria F10, A7, N14, M4

*/

import java.util.Scanner;

import services.Ejecutor;

public class Main {

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	//	Auxiliares ini = new Auxiliares();
		Ejecutor eje = new Ejecutor();
		
		System.out.println("\t \t \t    CAMPO DE BATALLA");
		
	eje.generarMatrix();
	
	//Ejemplo de Disparos de Huevos 
	/*
	for (int i=0;i<10;i++) {
	int arre[]=eje.generarCoordenadas("h");	
	eje.setTablero(arre[0],arre[1],'H');
	}
	*/
	eje.setTablero(1,5,'H');
	eje.mostrarMatrix();
	

	}
	 
}
