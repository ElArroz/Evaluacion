package model;

public class Trupalla extends Carro {
	
	int nivelArmadura;
	String nombreManipulador;
	String p1;
		
	public Trupalla() {
	}

	public Trupalla(int cantidadOcupantes, String fechaIngreso, int estado, int nivelArmadura, String nombreManipulador, String p1) {
		super(cantidadOcupantes, fechaIngreso, estado);
		this.nivelArmadura = nivelArmadura;
		this.nombreManipulador = nombreManipulador;
		this.p1 = p1;
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


