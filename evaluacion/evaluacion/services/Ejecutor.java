package services;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import model.Carro;
import model.Huevo;
import model.Tablero;

public class Ejecutor implements Tablero {

	
	@Override
	public ArrayList<Carro> listarCarro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Huevo> listarHuevo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String crearCarro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lanzarHuevo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String mostrarMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calcularPuntaje() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int[] generarCoordenadas(String tipo) {
		int fmax=14,cmax=14, ele=3;
			if (tipo.equalsIgnoreCase("k")) {
				fmax=12;
				ele=1;
				}
			else if (tipo.equalsIgnoreCase("c")) {
				cmax=13;
				ele=2;
				} 
								
		int fila = ThreadLocalRandom.current().nextInt(0, fmax);
		int columna = ThreadLocalRandom.current().nextInt(0, cmax);
		
		return new int[] {fila, columna, ele}; 
	}

	@Override
	public String generarMatrix() {
		int tam		=15; 	//tamaño tablero
		char tapa	='·'; 	//caracter que tapa la celda
		int	n		=0;
		char tablero[][];
		
		tablero = new char[tam+1][tam];
		
		for(int i = 1; i < tam+1; i++)
            for(int j=0; j < tam; j++) {
            	//n=n+1;
                tablero[i][j] = tapa;	//Integer.toString(n); //tapa;
            }
		
		//El trablero es i,j
		//El tablero empieza en 1,0    i=1 hasta i=14 
		//El tablero termina en 15,14  j=0 hasta j=14
		
		tablero[15][14]='K';
		
		System.out.print(" \t"); //dejar un espacio en blanco
		
		//Llenamos la primera fila con letras
		for(int i=0; i < tam; i++) {
            System.out.print( (char)(i + 65) + "   " ); //65 es "A"
        }
		System.out.println();
		
		 for(int i=0; i < tam+1; i++)
	        {
			 if (i!=0){
				 System.out.printf("%2d\t", i);
	            }	 
				 
			 for(int j=0; j < tam; j++)
	            {
	                System.out.print(tablero[i][j] + "   ");
	            }	 
			 System.out.println();
			 
			 }
		return null;
	}

	

}
