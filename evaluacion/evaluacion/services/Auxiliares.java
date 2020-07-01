package services;

import controller.Pantalla;

public class Auxiliares {
	
	Ejecutor eje = new Ejecutor();
			
	public String desplegarCarros() {  //Usar por Victor
		//crear los carros 	3 Kromis(K) - 5 Cahuanos(C) - 10 Trupallas(T)	
		// llenar los arreglos
		
		
		for (int i = 0; i<2; i++)
		int salir=0;	
		do
			int arre[]=eje.generarCoordenadas("K");	
			int x= arre[0]; 
			int y= arre[1];
		
			
			if (eje.matrixJuego[x][y]=='·') { 					
					  if (eje.matrixJuego[x+1][y]=='·'){
							  if (eje.matrixJuego[x+2][y]=='·'){
									  eje.setTablero(x, y,'K');
									  eje.setTablero(x+1,y,'K');
									  eje.setTablero(x+2,y,'K');
									  kromi.add(i);
									  salir=1;
							  }		  
			} 
			}
			while (salir ==0)
			//Generar instancia de Kromi
			//Agregar a carros mediante add.....
		
			for (int i = 0; i<4; i++)
			int salir=0;	
			do
				if (eje.matrixJuego[x][y]=='·') { 					
					  if (eje.matrixJuego[x][y+1]=='·'){
						  eje.setTablero(x, y,'C');
						  eje.setTablero(x,y+1,'C');
						  cagunano.add(i);
						  salir=1;
						  
			 while (salir ==0)
			//Generar instancia de Caguano
			//Agregar a carros mediante add.....
	
			for (int i = 0; i<9; i++)
			int salir=0;	
			do
				if (eje.matrixJuego[x][y]=='·') { 					
					eje.setTablero(x, y,'K');
					trupalla.add(i);
					salir=1;
			while (salir ==0)	 
				//Generar instancia de Trupalla
				//Agregar a carros mediante add.....
			return null;
		}

*/
		return null;
		
	}
	
}
