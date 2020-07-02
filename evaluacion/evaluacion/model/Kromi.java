package model;

public class Kromi extends Carro {
	
	int anioFabricacion;
	String marca;
	String p1, p2, p3;
	
	public Kromi() {
		// TODO Auto-generated constructor stub
	}

	public Kromi(int cantidadOcupantes, String fechaIngreso, String p1, String p2, String p3,  int estado, int anioFabricacion, String marca) {
		super(cantidadOcupantes, fechaIngreso, estado);
		this.anioFabricacion = anioFabricacion;
		this.marca = marca;
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Kromi [anioFabricacion=" + anioFabricacion + ", marca=" + marca + "]";
	}

		
}
