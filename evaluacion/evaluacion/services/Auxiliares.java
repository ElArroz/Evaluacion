package services;


public class Auxiliares {
	int x = 0;
	int y = 0;
	int sum=0;
	boolean salir = false;
	//char array[][] =  new char[15][15];
	Ejecutor eje = new Ejecutor();
	
	
	
	public String desplegarCarros () {
		
		// Generar instancia de Kromi
		for (int i = 0; i < 3; i++) {
			Generar("K");
		
		System.out.println(x+" "+y);
					
			do {
			
				if (Character.compare(eje.matrixJuego[x][y], '·') == 0 ? true : false) { //probar
					if (Character.compare(eje.matrixJuego[x+1][y], '·') == 0 ? true : false) {
						if (Character.compare(eje.matrixJuego[x+2][y], '·') == 0 ? true : false) {
							eje.setTablero(x, y, 'K');
							eje.setTablero(x + 1, y, 'K');
							eje.setTablero(x + 2, y, 'K');
							salir = true;
							break;
							// Generer Instancia de kromi
							// agrego al arreglo de carros (18)	
						}
					}
				}
			} while (!salir);
		}
		
		for (int i = 0; i < 5; i++) {
			Generar("C");
		
		System.out.println(x+" "+y);
					
			do {
			
				if (Character.compare(eje.matrixJuego[x][y], '·') == 0 ? true : false) { //probar
					if (Character.compare(eje.matrixJuego[x][y+1], '·') == 0 ? true : false) {
							eje.setTablero(x, y, 'C');
							eje.setTablero(x, y+1, 'C');
							salir = true;
							break;
							// Generer Instancia de kromi
							// agrego al arreglo de carros (18)	
						}
					}
				
			} while (!salir);
		}
	for (int i = 0; i < 10; i++) {
		Generar("T");
	
	System.out.println(x+" "+y);
				
		do {
		
			if (Character.compare(eje.matrixJuego[x][y], '·') == 0 ? true : false) { //probar
						eje.setTablero(x, y, 'T');
						salir = true;
						break;
						// Generer Instancia de kromi
						// agrego al arreglo de carros (18)	
					}
				
			
		} while (!salir);
	}
/*
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
