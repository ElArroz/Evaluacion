package model;

public class Kromi extends Carro {
	
	int anioFabricacion;
	String marca;
	
	public Kromi() {
		// TODO Auto-generated constructor stub
	}

	public Kromi(int cantidadOcupantes, String fechaIngreso, int fila, int columna, int anioFabricacion, String marca) {
		super(cantidadOcupantes, fechaIngreso, fila, columna);
		this.anioFabricacion = anioFabricacion;
		this.marca = marca;
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
