
package cmc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import graficos.Punto;
import mapa.MapaInfo;


public class Cmc {
	
	private MapaInfo mapa;
	private CmcImple cmcImple;
	List<Punto> caminoMinimoVoraz; //lista de puntos que se dibujara luego en mapa. Se llena desde caminoMinimo (ponele)
	private int densidadCaminoMinimoVoraz;
	
	
	Nodo nodo; //listado de puntos a evaluar. El que iria se agrega al caminoMinimo. Si llegamos a q no va, se saca de caminoMinimo
	List<Nodo> camino; 
	List<Punto> potencial;
	
	
	
	public Cmc(MapaInfo mapa, CmcImple cmcImple) {
		this.mapa = mapa;
		this.cmcImple = cmcImple;		
		obtenerCaminoMinimo();
		cmcImple.dibujarCamino(caminoMinimoVoraz);
	}
	
	private void obtenerCaminoMinimo() {
		Punto a = null;
		Punto b = null;
		caminoMinimoVoraz = new ArrayList<Punto>();
		densidadCaminoMinimoVoraz = 0;
		Iterator<Punto> iter = mapa.getPuntos().iterator();
		
		if (iter.hasNext()) {
			a = iter.next();
			while (iter.hasNext()) {
				b = iter.next();
				expandirPuntosContiguosVoraz(a, b);
				calculoCaminoMinimoEntrePuntos(a,b);
				a = b;
			}
			
			mapa.enviarMensaje("Camino uniendo " + mapa.getPuntos().size() + " puntos");
		}
		
	}
	
	private void calculoCaminoMinimoEntrePuntos(Punto a, Punto b){		
		
		Nodo nodo = new Nodo(a);		
		
	}
	
	private PriorityQueue<Punto> calcularVecinos(Punto anterior, Punto actual){
		PriorityQueue<Punto> vecinos = new PriorityQueue<Punto>(8);
		for (int x = actual.x - 1; x <= actual.x + 1; x++){
			for(int y = actual.y - 1; y <= actual.y + 1; y++){
				if ((x != actual.x && y != actual.y) && ( anterior != null || (x != anterior.x && y != anterior.y))){
					//agregar un nuevo punto a la cola ordenada
				}
			}
		}
		return vecinos;
	}


/*
 * 1  método Dijkstra(Grafo,origen):
2      creamos una cola de prioridad Q
3      agregamos origen a la cola de prioridad Q
4      mientras Q no este vacío:
5          sacamos un elemento de la cola Q llamado u
6          si u ya fue visitado continuo sacando elementos de Q    
7          marcamos como visitado u
8          para cada vértice v adyacente a u en el Grafo:
9              sea w el peso entre vértices ( u , v )  
10             si v no ah sido visitado:
11                Relajacion( u , v , w )

1  método Relajacion( actual , adyacente , peso ):
2      si distancia[ actual ] + peso < distancia[ adyacente ]
3         distancia[ adyacente ] = distancia[ actual ] + peso
4         agregamos adyacente a la cola de prioridad Q
*/
	
	
	private void expandirPuntosContiguosVoraz(Punto a, Punto b) {
		Punto p = null;
		
		if (a.x < b.x) {
			for (int x = a.x ; x < b.x; x++) {
				p = new Punto(x, a.y);
				caminoMinimoVoraz.add(p);
				densidadCaminoMinimoVoraz += mapa.getDensidad(p);
			}
		} else {
			for (int x = a.x ; x > b.x; x--) {
				p = new Punto(x, a.y);
				caminoMinimoVoraz.add(p);
				densidadCaminoMinimoVoraz += mapa.getDensidad(p);				
			}
		}
		
		if (a.y < b.y) {
			for (int y = a.y ; y < b.y; y++) {
				p = new Punto(b.x, y);
				caminoMinimoVoraz.add(p);
				densidadCaminoMinimoVoraz += mapa.getDensidad(p);
			}
		} else {
			for (int y = a.y ; y > b.y; y--) {
				p = new Punto(b.x, y);
				caminoMinimoVoraz.add(p);
				densidadCaminoMinimoVoraz += mapa.getDensidad(p);
			}
		}
	}

}
