package model;

//import java.util.ArrayList;

public class Carro {
	
	public int cantidadOcupantes;
	public String fechaIngreso;
	public int estado;
	//ArrayList<Huevo> recibeDisparos = new ArrayList();
	
	public Carro() {
		super();
	}

	public Carro(int cantidadOcupantes, String fechaIngreso, int estado) {
		this.cantidadOcupantes = cantidadOcupantes;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}
	
	/*public void recibirDisparo(Huevo recibeDisparos) {
		
		recibeDisparos.add(recibeDisparos);
		
	}
	public void consultarDisparo() {
		for (int i = 0; i < recibeDisparo.length; i++) {
			
		}
		
	}
	public void hundirse() {
	
	}*/

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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
		return "Carro [cantidadOcupantes=" + cantidadOcupantes + ", fechaIngreso=" + fechaIngreso + ", estado=" + estado + "]";
	}

	
	
	
	
}

