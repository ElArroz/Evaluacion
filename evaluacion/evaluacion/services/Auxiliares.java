package services;

import controller.Pantalla;
import model.Caguano;
import model.Kromi;
import model.Trupalla;

public class Auxiliares {

	Ejecutor eje = new Ejecutor();

	public String desplegarCarros() {  
		
		int arre[]=eje.generarCoordenadas(null);	//nose si null va aca 
		int x= arre[0]; 
		int y= arre[1];
		int salir = 0;
		
		//Generar instancia de Kromi
		for (int i = 0; i<2; i++) {
		do {
			if (eje.matrixJuego[x][y]=='·') { 					
				 if (eje.matrixJuego[x+1][y]=='·'){
					 if (eje.matrixJuego[x+2][y]=='·'){
						  eje.setTablero(x, y,'K');
						  eje.setTablero(x+1,y,'K');
						  eje.setTablero(x+2,y,'K');
						  Kromi.add(i); // no cacho porque no puedo agregar
						  salir = 1;
				 }		  
			} 
			}
		}while (salir ==0);
		}
		
		//Generar instancia de Caguano
		for (int i = 0; i<4; i++)	{
			do{
				if (eje.matrixJuego[x][y]=='·') { 					
					  if (eje.matrixJuego[x][y+1]=='·'){
						  eje.setTablero(x, y,'C');
						  eje.setTablero(x,y+1,'C');
						  Caguano.add(i);
						  salir = 1;
						  
					  }
					 }
				}while (salir == 0);
		}
		//Generar instancia de Trupalla
		
		for(int i = 0; i < 9; i++)
			do {
				if(eje.matrixJuego[x][y] == '.') {
					eje.setTablero(x, y, 'T');
					Trupalla.add(i);
					salir = 1;
				}
			}while(salir == 0);
				
	}
}
	
