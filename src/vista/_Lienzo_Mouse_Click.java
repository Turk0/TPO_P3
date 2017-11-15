package vista;

import grafico.Area;
import grafico.Punto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import app.Inicio;

public class _Lienzo_Mouse_Click extends MouseAdapter {
	
	private Punto a;
	private Punto b;
	private Area area;

	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getButton() == event.BUTTON1) {
			a = new Punto(event.getX(), event.getY());
			if(Inicio.panelHerramientas.getRB() == 1) {
				Inicio.panelLienzo.getLienzo().setDibujo(a);
				Inicio.panelLienzo.getLienzo().repaint();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if (event.getButton() == event.BUTTON1 && Inicio.panelHerramientas.getRB() == 0) {
			b = new Punto(event.getX(), event.getY());
			area = new Area(a, b, Inicio.panelHerramientas.getComboColor());
			Inicio.getMapa().setArea(area);
			Inicio.panelHerramientas.getModel().addElement(area);
			Inicio.panelLienzo.getLienzo().setDibujo(area);
			Inicio.panelLienzo.getLienzo().repaint(); 
		}
	}
	
}
