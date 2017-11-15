package vista;

import grafico.Area;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Inicio;


public class _Action_Cambiar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		/*
		try {
			Area area = (Area) Inicio.panelHerramientas.getListSelected();
			
			if (area == null) {
				return;
			}
			
			area.setColor(Inicio.panelHerramientas.getComboColor());
			Inicio.getMapa().setArea(area);
			Inicio.panelHerramientas.getListArea().repaint();
		    Inicio.panelLienzo.getLienzo().setDibujo(area);
			Inicio.panelLienzo.getLienzo().repaint();
		} catch(ClassCastException e) {}
		*/
		
		Inicio.panelLienzo.getLienzo().setBackground(Inicio.panelHerramientas.getComboColor().getColor());
		Inicio.panelHerramientas.getListArea().repaint();
	}
}
