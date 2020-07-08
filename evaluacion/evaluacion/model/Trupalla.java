package model;

import java.util.List;

public class Trupalla extends Carro {
	
	
	int nivelArmadura;
	String nombreManipulador;

		
	
	public Trupalla() {
	}

	public Trupalla(int cantidadOcupantes, String fechaIngreso, int estado, int nivelArmadura, String nombreManipulador, String p1, String danio, List<String> posiciones) {
		super(cantidadOcupantes, fechaIngreso, posiciones, estado, "SinDaño");
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
		return "Trupalla [Armadura: " + nivelArmadura + " Chofer: " + nombreManipulador 
				+ " Ocupantes: " + cantidadOcupantes + " Ingreso: " + fechaIngreso + 
				" Posicion: "+ posiciones +" Estado: " + danio + "]";
	}

}


