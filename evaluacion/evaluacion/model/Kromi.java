package model;

public class Kromi extends Carro {
			
	int anioFabricacion;
	String marca;
	String p1;
	String p2;
	String p3;
	
	public Kromi() {
		}

	public Kromi(int cantidadOcupantes, String fechaIngreso, String p1, String p2, String p3,  int estado, int anioFabricacion, String marca, String danio) {
		super(cantidadOcupantes, fechaIngreso, 3, danio);
		this.anioFabricacion = anioFabricacion;
		this.marca = marca;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP3() {
		return p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
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
		return "Kromi [Fab: " + anioFabricacion + ", Marca: " + marca + ", Pos : "+ p1 + ", " + p2 + ", "
				+ p3 + ", Ocupantes: " + cantidadOcupantes + ", Ingreso :" + fechaIngreso + ", Estado: "
				+ danio + "]";
	}

		
}
