package model;

import java.util.List;

public class Caguano extends Carro {
		
	int alcanceTiro;
	String colorConfeti;
	
	
	public Caguano() {
	}

	public Caguano(int cantidadOcupantes, String fechaIngreso, int estado, int alcanceTiro, String colorConfeti, List<String> posiciones, String danio) {
		super(cantidadOcupantes, fechaIngreso, posiciones, estado, danio);
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
		return "Caguano  [Alcance: " + alcanceTiro + " Confeti: " + colorConfeti + 
				" Ocupantes: " + cantidadOcupantes + " Ingreso: " + fechaIngreso +
				" Posicion: "+ posiciones +" Estado: " + danio + "]";
	}
	
}

