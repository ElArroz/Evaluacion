package controller;

import java.util.Scanner;

import services.Auxiliares;
import services.Ejecutor;

public class Main {

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	//	Auxiliares ini = new Auxiliares();
		Ejecutor eje = new Ejecutor();
		
		System.out.println("\t \t \t    CAMPO DE BATALLA");
		
	eje.generarMatrix();
	
	//ejemplo de generacion 
	for (int i=0;i<10;i++) {
	int arre[]=eje.generarCoordenadas("h");	
	eje.setTablero(arre[0],arre[1],'H');
	}
	
	eje.mostrarMatrix();
	}
	
}
