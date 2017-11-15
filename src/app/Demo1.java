package app;

import mapa.*;
import grafico.*;

public class Demo1 {

	public static void main(String[] args) {
		
		Mapa m = new Mapa(5);
		Punto pO = new Punto(1, 1);
		Punto pD = new Punto(4, 4);
		Celda origen = new Celda(pO);
		Celda destino = new Celda(pD);
		Camino c = new Camino(origen, destino);
		
		//System.out.print(m.toString());
		System.out.print("Camino minimo:" + c.caminoMinimo().toString());
		//System.out.println(" \n\n"+m.imprimirColaPrioridad(c.adyacentes(origen)));
		
		
		
	}

}
