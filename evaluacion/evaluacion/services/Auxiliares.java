package services;

import controller.Pantalla;

public class Auxiliares {
	
	Ejecutor eje = new Ejecutor();
			
	public String desplegarCarros() {  //Usar por Victor
		//crear los carros 	3 Kromis(K) - 5 Cahuanos(C) - 10 Trupallas(T)	
		// llenar los arreglos
		
		
		//for (int i = 0; i<3; i++)
		 int salir=0;	
		//do
			int arre[]=eje.generarCoordenadas("K");	
			int x= arre[0]; 
			int y= arre[1];
		
			
			if (eje.matrixJuego[x][y]=='·') { 					
					  if (eje.matrixJuego[x+1][y]=='·'){
							  if (eje.matrixJuego[x+2][y]=='·'){
									  eje.setTablero(x, y,'K');
									  eje.setTablero(x+1,y,'K');
									  eje.setTablero(x+2,y,'K');
									  salir=1;
							  }		  
			} 
			}
			//while (salir ==0)
			//Generar instancia de Kromi
			//Agregar a carros mediante add.....
			//Fin for
		/*	
			int arre[]=eje.generarCoordenadas("C");	

			if Tablero[arre[0]],[arre[1]=='·' { //C
					  if Tablero[arre[0]],[arre[1]+1]=='·'{
									  eje.setTablero(arre[0],arre[1],'C');
									  eje.setTablero(arre[0],arre[1]+1],'C');
							  }
					  
			} 
			}

			int arre[]=eje.generarCoordenadas("T");	

			if Tablero[arre[0]],[arre[1]=='·' { //K
									  eje.setTablero(arre[0],arre[1],'T');
							  }
					  
			} 
			}
			
			return null;
		}

*/
		return null;
		
	}
	
}
