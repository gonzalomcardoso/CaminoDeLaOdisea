package Ejercicio1.LaOdisea;

public class Ciudad {
	Integer id;
	String Nombre;
	
public Ciudad(Integer id, String nombre){
	this.id = id;
	this.Nombre = nombre;
}

@Override
public String toString() {
	return  id + " " + Nombre;
}

}
