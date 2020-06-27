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
		
	Ejecutor eje = new Ejecutor();
		
		System.out.println("\t \t \t    CAMPO DE BATALLA");
		
	eje.generarMatrix();
	
	//Ejemplo de Disparos de Huevos 
/*
	for (int i=0;i<5;i++) {
	int arre[]=eje.generarCoordenadas("h");	
	eje.setTablero(arre[0],arre[1],'H');
	}
*/	
	//eje.setTablero(1,5,'X'); //f1
	//eje.setTablero(2.setTabler,5,'K'); //f1
	//ejeo(3,5,'K'); //f1

		

/* codigo para desplegar Victor!	
	
int arre[]=eje.generarCoordenadas("K");	
	
  if Tablero[arre[0]],[arre[1]=='·' { //K
		  if Tablero[arre[0]+1],[arre[1]=='·'{
				  if Tablero[arre[0]+2],[arre[1]=='·'{
						  eje.setTablero(arre[0],arre[1],'X');
						  eje.setTablero(arre[0]+1,arre[1],'X');
						  eje.setTablero(arre[0]+2,arre[1],'X')
				  }
		  
  } 
  }	
*/	
	
	
	
	
	//eje.setTablero(arre[0],arre[1],'X');
	
	
	
	
	eje.mostrarMatrix();
	

	

	}
	 
}
