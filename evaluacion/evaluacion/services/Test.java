package services;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ejecutor exe = new Ejecutor();
		
		char array[][] =  new char[15][15];
			
		exe.generarMatrix();
		
		array=exe.getTablero() ;
		
		
		
		System.out.println(array[1][1]);
		
	}

}
