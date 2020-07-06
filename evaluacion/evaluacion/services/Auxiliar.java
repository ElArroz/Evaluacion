package services;

import java.util.concurrent.ThreadLocalRandom;

public class Auxiliar {
	int anio=1990;
	String marca,color;
	String dia,mes,fecha;

	public int RandomFabricacion() {
		int anio = ThreadLocalRandom.current().nextInt(1990, 2020);
		return anio;
	}
	
	public String RandomMarca() {
		
		String[] marcas= {"Mercedes Benz","Jino Motors","Dimex","Cuatro Ases","Marcopolo","Metalpar","FAMAE","CAIO","MOWAG",
				"Rosenbauer","BAT","Dodge","Durango","Chevrolet"};
		int pos = ThreadLocalRandom.current().nextInt(0,marcas.length);
		return marcas[pos];
	}
	
	public String RandomFecha() {
		int d = ThreadLocalRandom.current().nextInt(1, 29);
		int m = ThreadLocalRandom.current().nextInt(1, 12);
		if (d<10) dia="0"+d;
		 else  dia=""+d;
		if (m<10) mes="0"+m;
		 else  mes=""+m;
		 
		return (dia+"/"+mes+"/");
	}
	
	public String RandomColor() {
		
		String[] color= {"Amarillo","Azul","Verde","Rojo","Morado","Multicolor","Gris","Violeta"};
		int pos = ThreadLocalRandom.current().nextInt(0,color.length);
		return color[pos];
	}
}
