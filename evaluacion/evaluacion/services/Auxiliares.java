package services;


public class Auxiliares {
	int x = 0;
	int y = 0;
	int sum=0;
	boolean salir = false;
	Ejecutor eje = new Ejecutor();
	
	
	
	
	public String desplegarCarros() {
		char array[][] =  new char[15][15];
		// Generar instancia de Kromi
	//	for (int i = 0; i < a-1; i++) {
			Generar("K");
		//	eje.generarMatrix();
		System.out.println(x+" "+y);
		
		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				
				 array = eje.matrixJuego;
				System.out.println(array[i][j]);
			}
		}
			
		
			/*	
			do {
			 sum=sum+1;
				System.out.println(x+" "+y+" "+sum);
				
				
				if (eje.matrixJuego[x][y] == '·') {
					if (eje.matrixJuego[x + 1][y] == '·') {
						if (eje.matrixJuego[x + 2][y] == '·') {
							eje.setTablero(x, y, 'K');
							eje.setTablero(x + 1, y, 'K');
							eje.setTablero(x + 2, y, 'K');
							salir = true;
							break;
							// Generer Instancia de kromi

						}
					}
				}
			} while (!salir);
		}

		// Generar instancia de Caguano
		for (int i = 0; i < b-1; i++) {
			Generar("C");

			do {
				if (eje.matrixJuego[x][y] == '·') {
					if (eje.matrixJuego[x][y + 1] == '·') {
						eje.setTablero(x, y, 'C');
						eje.setTablero(x, y + 1, 'C');
						salir = true;
						break;
						// Generer Instancia de caguano
					}
				}
			} while (!salir);
		}

		// Generar instancia de Trupalla

		for (int i = 0; i < c-1; i++)
			Generar("T");
		do {
			if (eje.matrixJuego[x][y] == '.') {
				eje.setTablero(x, y, 'T');
				salir = true;
				break;
			}
		}   while (!salir);
*/
		return null;

	}

	public int[] Generar(String txt) {
		int arre[] = eje.generarCoordenadas(txt);
		x = arre[0];
		y = arre[1];
		return null;

	}

}
