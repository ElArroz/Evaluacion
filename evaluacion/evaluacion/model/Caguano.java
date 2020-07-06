package model;

public class Caguano extends Carro {
		
	int alcanceTiro;
	String colorConfeti;
	String p1;
	String p2;
	
	public Caguano() {
	}

	public Caguano(int cantidadOcupantes, String fechaIngreso, int estado, int alcanceTiro, String colorConfeti, String p1, String p2, String danio) {
		super(cantidadOcupantes, fechaIngreso, 2, danio);
		this.alcanceTiro = alcanceTiro;
		this.colorConfeti = colorConfeti;
		this.p1 = p1;
		this.p2 = p2;
	}
	

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
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
		return "Caguano [Alcance: " + alcanceTiro + ", Confeti: " + colorConfeti + "Pos : "+ p1 + ", " + p2 +
				", Ocupantes: " + cantidadOcupantes + ", Ingreso: " + fechaIngreso + ", Estado: " + danio
				+ "]";
	}
	
}

