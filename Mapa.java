package Ejercicio1.LaOdisea;

import java.util.ArrayList;

public class Mapa {
private Ciudad [] ciudades;
private int [][] ady;
private boolean [][] sirena;

private int n;

public Mapa(int tamano){
	n= tamano;
	ciudades = new Ciudad [n];	
	ady = new int [n][n];
	sirena= new boolean[n][n];

	for (int i=0; i<n; i++){
		ciudades [i] = new Ciudad(i,"Ciudad" + i);
		for (int j=0; j<n; j++){
			ady[i][j] = 0;	//distancias default en 0
			sirena[i][j]=false;//sirenas defualt no estan
		}
	}
	
}


public int tamano(){
	return n;
}

public void asignarNombre(Integer ciudadID, String nombre){
	ciudades[ciudadID].Nombre = nombre;
}

public void agDist(int i, int j, int dist, boolean simetrico){ 
	ady[i][j] = dist;
	
	if (simetrico){
		ady[j][i] = dist;
				
	}
}

// distancia en tiempos nominales
public int dist(int i, int j){ 

return ady[i][j];
}

ArrayList<Ciudad> caminoMinimoProbable(int ciudadOrigen, int ciudadDestino){
	ArrayList<Ciudad> ret= new ArrayList<Ciudad>(); 
	//variables auxiliares
	int actual = ciudadOrigen;
	int cercano;
	int aux;
	//logica de la funcion
	ret.add(this.ciudades[ciudadOrigen]); //agrego la primer ciudad
	while (actual!=ciudadDestino)
	{
		cercano = distanciaMaxima()+1;//inicializo la distancia para comparar
		aux=-1;
		for (int j=0; j<this.tamano(); j++)//recorro todas las ciudades
			if(!ret.contains(this.ciudades[j]) && dist(actual,j)<=cercano && !sirena[actual][j]) //Si no pasé por la ciudad, es la más cercana, y no hay sirenas
			{			
					aux=j;
					cercano= dist(actual,j);
			}
			if (aux == -1)	 //Si no me moví porque había sirenas, me fijo de nuevo como si no hubiera sirenas
			for (int i=0; i<this.tamano(); i++)
				if(!ret.contains(this.ciudades[i]) && dist(actual,i)<=cercano)
				{			
					aux=i;
					cercano= dist(actual,i);
				}
		actual = aux;
		ret.add(ciudades[actual]);
	}
	return ret;
}

private int distanciaMaxima(){
	int ret = 0;
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++)
			if (ret<dist(i,j))
				ret = dist(i,j);
	return ret;
}

public int distancia(ArrayList<Ciudad> ciudades)
{
int total = 0;
for (int i = 0; i<ciudades.size()-1; i++)//me aseguro de recorrer el arraylist sin pasarme del mismo
{
	total += this.dist(ciudades.get(i).id, ciudades.get(i+1).id);//sumo las ciudades adyancentes
}

return total;//retorno la distancia
}

public void agregarSirena(int desde, int hasta)
{
	sirena[desde][hasta] = true;
	sirena[hasta][desde] = true;
	
}
}