package model;

import java.util.ArrayList;
import java.util.List;

public class Carro {

	public int cantidadOcupantes;
	public String fechaIngreso;
	public int estado;
	public String danio;
	public List<String> posiciones = new ArrayList<String>();

	public Carro() {
	}

	public Carro(int cantidadOcupantes, String fechaIngreso, List<String> posiciones,  int estado, String danio) {
		this.cantidadOcupantes = cantidadOcupantes;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
		this.danio = danio;
		this.posiciones = posiciones;
	}

	
	public List<String> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(List<String> posiciones) {
		this.posiciones = posiciones;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDanio() {
		return danio;
	}

	public void setDanio(String danio) {
		this.danio = danio;
	}

	public int getCantidadOcupantes() {
		return cantidadOcupantes;
	}

	public void setCantidadOcupantes(int cantidadOcupantes) {
		this.cantidadOcupantes = cantidadOcupantes;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Carro [cantidadOcupantes=" + cantidadOcupantes + ", fechaIngreso=" + fechaIngreso + ", daño=" + danio
				+ "]";
	}

}
