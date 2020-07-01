package services;

public class Auxiliares {
	int x = 0;
	int y = 0;
	boolean salir = false;
	Ejecutor eje = new Ejecutor();

	public String desplegarCarros() {

		// Generar instancia de Kromi
		for (int i = 0; i < 2; i++) {
			Generar("K");

			do {
				if (eje.matrixJuego[x][y] == '·') {
					if (eje.matrixJuego[x + 1][y] == '·') {
						if (eje.matrixJuego[x + 2][y] == '·') {
							eje.setTablero(x, y, 'K');
							eje.setTablero(x + 1, y, 'K');
							eje.setTablero(x + 2, y, 'K');
							salir = true;
							// Generer Instancia de kromi

						}
					}
				}
			} while (!salir);
		}

		// Generar instancia de Caguano
		for (int i = 0; i < 4; i++) {
			Generar("C");

			do {
				if (eje.matrixJuego[x][y] == '·') {
					if (eje.matrixJuego[x][y + 1] == '·') {
						eje.setTablero(x, y, 'C');
						eje.setTablero(x, y + 1, 'C');
						salir = true;
						// Generer Instancia de caguano
					}
				}
			} while (!salir);
		}

		// Generar instancia de Trupalla

		for (int i = 0; i < 9; i++)
			Generar("T");
		do {
			if (eje.matrixJuego[x][y] == '.') {
				eje.setTablero(x, y, 'T');
				salir = true;
			}
		} while (!salir);

		return null;

	}

	public int[] Generar(String txt) {
		int arre[] = eje.generarCoordenadas(txt);
		x = arre[0];
		y = arre[1];
		return null;

	}

}
