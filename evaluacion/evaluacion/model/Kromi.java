package model;

import java.util.List;

public class Kromi extends Carro {
			
	int anioFabricacion;
	String marca;

	
	public Kromi() {
		}

	public Kromi(int cantidadOcupantes, String fechaIngreso, int estado, int anioFabricacion, String marca, String danio, List<String> posiciones) {
		super(cantidadOcupantes, fechaIngreso, posiciones, estado, danio);
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
		return "Kromi    [Fab: " + anioFabricacion + ", Marca: " + marca + 
				" Ocupantes: " + cantidadOcupantes + " Ingreso :" + fechaIngreso +
				" Posicion: "+ posiciones +" Estado: "	+ danio + "]";
	}

		
}
