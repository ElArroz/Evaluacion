package model;

public class Trupalla extends Carro {
	
	
	int nivelArmadura;
	String nombreManipulador;
	String p1;
		
	
	public Trupalla() {
	}

	public Trupalla(int cantidadOcupantes, String fechaIngreso, int estado, int nivelArmadura, String nombreManipulador, String p1, String danio) {
		super(cantidadOcupantes, fechaIngreso, 1, danio);
		this.nivelArmadura = nivelArmadura;
		this.nombreManipulador = nombreManipulador;
		this.p1 = p1;
	}
	

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
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
		return "Trupalla [Armadura: " + nivelArmadura + ", Chofer=" + nombreManipulador + ", Ubicación: " + p1
				+ ", Ocupantes: " + cantidadOcupantes + ", Ingreso: " + fechaIngreso + ", Estado: " + danio
				+ "]";
	}

}


