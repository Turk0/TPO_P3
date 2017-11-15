package vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import app.Inicio;


public class _Lienzo_Mouse_Motion extends MouseMotionAdapter {
	
	@Override
	public void mouseMoved(MouseEvent event) {
		Inicio.panelHerramientas.setLblX(event.getX(), event.getY());
		Inicio.panelHerramientas.setLblY(Inicio.getMapa().getDensidad(event.getX(), event.getY()));
	}

}
