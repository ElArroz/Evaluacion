package services;

public class DiegoAux {
	static Ejecutor eje = new Ejecutor();
	boolean fin;
	int x;
	int y;
	char  tablero [][]= new char[15][15];

	
	public void desplegarCarros() {
	
		for(int i =0; i < tablero.length; i++) {
				int cord[] = eje.generarCoordenadas("K");
				//char col = (char) (64 + cord[1]);
			do {
				if(eje.matrixJuego[x][y] == '.') {
					if(eje.matrixJuego[x][y+1] == '.') {
						if(eje.matrixJuego[x][y+2] == '.') {
							eje.setTablero(cord[x], cord[y], 'K');
							eje.setTablero(cord[x + 1], cord[y], 'K');
							eje.setTablero(cord[x + 2], cord[y], 'K');
					}
				}
			}
			break;
		}while(!fin);
		}	
	}
	
/*	public  int[] GenerarCarros(String string) {
		int cord[] = eje.generarCoordenadas("K");
		char col = (char) (64 + cord[1]);
		int x = cord[0];
		int y = cord[1];
		return null;
	}*/
}


