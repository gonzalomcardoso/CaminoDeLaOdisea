package Ejercicio1.LaOdisea;

public class Test {

	public static void main(String[] args) {
		Mapa m2 = new Mapa(5);
		
		m2.asignarNombre(0, "00");
		m2.asignarNombre(1, "01");
		m2.asignarNombre(2, "02");
		m2.asignarNombre(3, "03");
		m2.asignarNombre(4, "04");
		
		m2.agregarSirena(4,3);
		
		m2.agDist(0, 1, 1, true);	// distancia desde 0 hasta 1 es igual a 1
		m2.agDist(0, 2, 2, true);
		m2.agDist(0, 3, 2, true);
		m2.agDist(0, 4, 2, true);
		m2.agDist(1, 2, 2, true);
		m2.agDist(1, 3, 2, true);
		m2.agDist(1, 4, 1, true);
		m2.agDist(2, 3, 2, true);
		m2.agDist(2, 4, 2, true);
		m2.agDist(3, 4, 1, true);
		
		System.out.println(m2.distancia(m2.caminoMinimoProbable(0, 3)));
		System.out.println(m2.caminoMinimoProbable(0,3));
		

	}

}
