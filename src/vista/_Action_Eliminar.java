package vista;

import grafico.Area;
import grafico.LimpiarArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Inicio;


import mapa.AreaColor;

public class _Action_Eliminar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			Area area = (Area) Inicio.panelHerramientas.getListSelected();
			
			if (area == null) {
				return;
			}
			
			Inicio.panelHerramientas.removeListSelected(area);
			area.setColor(AreaColor.BLANCO);
			Inicio.getMapa().setArea(area);
		    Inicio.panelLienzo.getLienzo().setDibujo(new LimpiarArea(area));
			Inicio.panelLienzo.getLienzo().repaint();
		} catch(ClassCastException e) {}
		
	}
}
