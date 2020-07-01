package model;


public class Caguano extends Carro {

	int alcanceTiro;
	String colorConfeti;
	
	public Caguano() {
	}

	public Caguano(int cantidadOcupantes, String fechaIngreso, int fila, int columna, int estado, int alcanceTiro, String colorConfeti) {
		super(cantidadOcupantes, fechaIngreso, fila, columna, estado);
		this.alcanceTiro = alcanceTiro;
		this.colorConfeti = colorConfeti;
	}

	public int getAlcanceTiro() {
		return alcanceTiro;
	}

	public void setAlcanceTiro(int alcanceTiro) {
		this.alcanceTiro = alcanceTiro;
	}

	public String getColorConfeti() {
		return colorConfeti;
	}

	public void setColorConfeti(String colorConfeti) {
		this.colorConfeti = colorConfeti;
	}

	@Override
	public String toString() {
		return "Caguano [alcanceTiro=" + alcanceTiro + ", colorConfeti=" + colorConfeti + "]";
	}
	
}

