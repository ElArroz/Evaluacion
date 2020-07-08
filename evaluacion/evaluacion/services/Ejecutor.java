package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.Pantalla;
import model.Caguano;
import model.Carro;
import model.Huevo;
import model.Kromi;
import model.Tablero;
import model.Trupalla;

@SuppressWarnings("serial")
public class Ejecutor extends DefaultTableCellRenderer implements Tablero {
	int tam = 15;
	int x, y, out = 0, bonus = 0, pto = 0, puntos = 0;
	boolean res, bit;
	String tapa = "-", cordenada = "", msj = "", hit = null;
	private String matrixJuego[][] = new String[tam + 1][tam + 1]; 
	Carro carro = new Carro();
	Huevo huevo = new Huevo();
	private List<Carro> carros;
	private List<Huevo> huevos;
	Auxiliar aux = new Auxiliar();

	@Override
	public String generarMatrix() {

		for (int i = 0; i < tam + 1; i++) {
			for (int j = 0; j < tam + 1; j++) {
				this.getMatrixJuego()[i][j] = tapa;
			}
		}
		return null;
	}

	@Override
	public void mostrarMatrix() {
		DefaultTableModel model = (DefaultTableModel) Pantalla.tableroJuego.getModel(); // Jtable tableroJuego
		model.setRowCount(tam);

		for (int i = 0; i < tam; i++) {
			Pantalla.tableroJuego.setValueAt(i + 1, i, 0); // Encabezados filas 1 a 15
		}

		for (int i = 0; i < tam; i++) {
			for (int j = 1; j < tam + 1; j++) {
				System.out.println(getMatrixJuego()[i][j]);
				Pantalla.tableroJuego.setValueAt(getMatrixJuego()[i][j], i, j); // asignamos valores a Jtable
																				// tableroJuego
			}
		}
	}

	@Override
	public void setTablero(int x, int y, String letra) {
		this.getMatrixJuego()[x][y] = letra;
	}

	@Override
	public int[] generarCoordenadas(String tipo) {
		int cmax = 15, fmax = 15, ele = 3;
		if (tipo.equalsIgnoreCase("k")) {
			fmax = 13;
			ele = 1;
		} else if (tipo.equalsIgnoreCase("c")) {
			cmax = 15;
			ele = 2;
		}

		int columna = ThreadLocalRandom.current().nextInt(1, cmax);
		int fila = ThreadLocalRandom.current().nextInt(0, fmax);

		return new int[] { fila, columna, ele };
	}

	@Override
	public String convertirPos(int x, int y) {
		char col = (char) (64 + y);
		String pos = String.valueOf(col) + (x + 1);
		return pos;

	}

	@Override
	public String lanzarHuevo(int x, int y) {
		pto = 0;

		cordenada = convertirPos(x, y);
		switch (getMatrixJuego()[x][y]) {
		case "K":
			hit = "(K)";
			pto = 3;
			bit = destruiCarro(cordenada);
			if (bit) {
				pto = 13;
				avisar("Kromi destruida! \n 3 ptos y bonus de 10 ptos");
			} else {
				avisar("Impacto a Kromi! \n  3 ptos");
			}
			matrixJuego[x][y] = hit;
			break;

		case "C":
			hit = "(C)";
			pto = 2;
			bit = destruiCarro(cordenada);
			if (bit) {
				pto = 7;
				avisar("Cahuano destruida! \n 2 ptos y bonus de 5 ptos");
			} else {
				avisar("Impacto a Cahuano! \n +" + pto);
			}
			matrixJuego[x][y] = hit;
			break;

		case "T":
			hit = "(T)";
			pto = 1;
			avisar("Trupalla destruida! +" + pto);
			destruiCarro(cordenada);
			matrixJuego[x][y] = hit;
			break;

		case "-":
			hit = "H";
			matrixJuego[x][y] = hit;
			break;

		default:
			break;
		}
		puntos += pto;
		System.out.println("Resultado[" + hit + "] en cordenadas: " + cordenada + " Puntos: +" + pto);
		return hit;
	}

	@Override
	public int[] verificarCoordenadas(String tiro) {

		if (tiro.equals("arroz")) {
			List<Carro> carros = getCarros();
			for (Carro i : carros) {
				for (String j : i.posiciones) {
					System.out.println(j);
				}
			}
		}
		
		int number = 0;
		String laLetra = tiro.substring(0, 1);
		String elNumero = tiro.substring(1, tiro.length());
		int a = 0, b = 0, c = 0;
		
		if ((elNumero.replaceAll("[1234567890]", "")).length() == 0) {
			number = Integer.valueOf(elNumero);
		}

		if ((number > 0) && (number < 16) && (tiro.matches(".*[a-zA-Z].*"))) {
			char caracter = laLetra.toUpperCase().charAt(0);
			a = number - 1;
			b = caracter - 64;
			c = 1;
		}

		return new int[] { a, b, c };
	}

	@Override
	public String desplegarCarros() {
		this.carros = new ArrayList<>();

		do {
			int arre[] = generarCoordenadas("K");
			x = arre[0];
			y = arre[1];
			if (tapa.equals(getMatrixJuego()[x][y]) && tapa.equals(getMatrixJuego()[x + 1][y])
					&& tapa.equals(getMatrixJuego()[x + 2][y])) {
				setTablero(x, y, "K");
				setTablero(x + 1, y, "K");
				setTablero(x + 2, y, "K");
				Kromi kromi = new Kromi(); // Generer Instancia de kromi
				kromi.setAnioFabricacion(aux.RandomFabricacion());
				kromi.setMarca(aux.RandomMarca());
				kromi.setFechaIngreso(aux.RandomFecha() + (kromi.getAnioFabricacion() + 1));
				kromi.setCantidadOcupantes(ThreadLocalRandom.current().nextInt(1, 10));
				kromi.setDanio("SinDaño");
				kromi.posiciones.add(convertirPos(x, y));
				kromi.posiciones.add(convertirPos(x + 1, y));
				kromi.posiciones.add(convertirPos(x + 2, y));
				kromi.setEstado(3);
				this.carros.add(kromi); // agrego al arreglo de carros
				out = out + 1;
			}
		} while (out < 3);

		System.out.println("Kromis Listas (" + out + ")");
		out = 0;
		do {
			int arre[] = generarCoordenadas("C");
			x = arre[0];
			y = arre[1];
			if (tapa.equals(getMatrixJuego()[x][y]) && tapa.equals(getMatrixJuego()[x + 1][y])) {
				setTablero(x, y, "C");
				setTablero(x, y + 1, "C");
				Caguano caguano = new Caguano(); // Generer Instancia de Caguano
				caguano.setAlcanceTiro(ThreadLocalRandom.current().nextInt(2, 30));
				caguano.setColorConfeti(aux.RandomColor());
				caguano.setCantidadOcupantes(ThreadLocalRandom.current().nextInt(2, 6));
				caguano.setFechaIngreso(aux.RandomFecha() + aux.RandomFabricacion());
				caguano.setDanio("SinDaño");
				caguano.posiciones.add(convertirPos(x, y));
				caguano.posiciones.add(convertirPos(x, y + 1));
				caguano.setEstado(2);
				this.carros.add(caguano); // agrego al arreglo de carros
				out = out + 1;
			}

		} while (out < 5);

		System.out.println("Caguanos Listos (" + out + ")");
		out = 0;
		do {
			int arre[] = generarCoordenadas("T");
			x = arre[0];
			y = arre[1];
			if (tapa.equals(getMatrixJuego()[x][y])) {
				setTablero(x, y, "T");
				Trupalla trupalla = new Trupalla(); // Generer Instancia de Trupallas
				trupalla.setNivelArmadura(ThreadLocalRandom.current().nextInt(1, 6));
				trupalla.setNombreManipulador(aux.RandomNombre());
				trupalla.setCantidadOcupantes(ThreadLocalRandom.current().nextInt(1, 4));
				trupalla.setFechaIngreso(aux.RandomFecha() + aux.RandomFabricacion());
				trupalla.setDanio("SinDaño");
				trupalla.posiciones.add(convertirPos(x, y));
				trupalla.setEstado(1);
				this.carros.add(trupalla); // agrego al arreglo de carros (18)
				out = out + 1;
			}

		} while (out < 10);

		System.out.println("Trupallas Listas (" + out + ")");
		out = 0;
		return null;
	}

	@Override
	public List<Carro> getCarros() {
		return this.carros;
	}

	@Override
	public List<Huevo> getHuevos() {
		return this.huevos;
	}

	public String[][] getMatrixJuego() {
		return matrixJuego;
	}

	public void setMatrixJuego(String matrixJuego[][]) {
		this.matrixJuego = matrixJuego;
	}

	public void setPto(int pto) {
		this.pto = pto;
	}

	public int getPto() {
		return pto;
	}

	public boolean destruiCarro(String impacto) {
		boolean bonus = false;
		List<Carro> carros = getCarros();
		for (Carro i : carros) {
			for (String j : i.posiciones) {
				if (j.equals(impacto)) {
					i.setEstado(i.getEstado() - 1);
					i.setDanio("Dañada");
					if (i.getEstado() == 0) {
						bonus = true;
					}
				}
			}
		}
		return bonus;
	}

	public String avisar(String msj) {

		JOptionPane.showMessageDialog(null, msj);

		return null;
	}

}
