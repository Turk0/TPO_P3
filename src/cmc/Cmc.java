
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
	List<Punto> caminoMinimoVoraz;
	private int densidadCaminoMinimoVoraz;
	
	public Cmc(MapaInfo mapa, CmcImple cmcImple) {
		this.mapa = mapa;
		this.cmcImple = cmcImple;
		obtenerCaminoMinimoVoraz();
		cmcImple.dibujarCamino(caminoMinimoVoraz);
	}
	
	private void obtenerCaminoMinimoVoraz() {
		Punto a = null;
		Punto b = null;
		caminoMinimoVoraz = new ArrayList<Punto>();
		densidadCaminoMinimoVoraz = 0;
		Iterator<Punto> iter = mapa.getPuntos().iterator();
		
		if (iter.hasNext()) {
			a = iter.next();
			while (iter.hasNext()) {
				b = iter.next();
				expandirPuntosContiguos(a, b);
				a = b;
			}
			
			mapa.enviarMensaje("Camino uniendo " + mapa.getPuntos().size() + " puntos");
		}
		
	}
	
	private void expandirPuntosContiguos(Punto a, Punto b) {
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
	
	private PriorityQueue<Punto> recuperarPuntosContiguos(Punto p) {
		PriorityQueue<Punto> contiguos = new PriorityQueue<Punto>(8);
		
		return contiguos;
	}

}
