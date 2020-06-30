package model;

public class Trupalla extends Carro {
	
	int nivelArmadura;
	String nombreManipulador;
		
	public Trupalla() {
	}

	public Trupalla(int cantidadOcupantes, String fechaIngreso, int fila, int columna, int nivelArmadura, String nombreManipulador) {
		super(cantidadOcupantes, fechaIngreso, fila, columna);
		this.nivelArmadura = nivelArmadura;
		this.nombreManipulador = nombreManipulador;
	}

	public int getNivelArmadura() {
		return nivelArmadura;
	}

	public void setNivelArmadura(int nivelArmadura) {
		this.nivelArmadura = nivelArmadura;
	}

	public String getNombreManipulador() {
		return nombreManipulador;
	}

	public void setNombreManipulador(String nombreManipulador) {
		this.nombreManipulador = nombreManipulador;
	}

	@Override
	public String toString() {
		return "Trupalla [nivelArmadura=" + nivelArmadura + ", nombreManipulador=" + nombreManipulador + "]";
	}

}


