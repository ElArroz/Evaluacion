package model;


public class Caguano extends Carro {

	int alcanceTiro;
	String colorConfeti;
	String p1;
	String p2;
	
	public Caguano() {
	}

	public Caguano(int cantidadOcupantes, String fechaIngreso, int estado, int alcanceTiro, String colorConfeti, String p1, String p2) {
		super(cantidadOcupantes, fechaIngreso, estado);
		this.alcanceTiro = alcanceTiro;
		this.colorConfeti = colorConfeti;
		this.p1 = p1;
		this.p2 = p2;
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

