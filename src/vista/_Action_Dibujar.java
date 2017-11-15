package vista;

import grafico.Area;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Inicio;


public class _Action_Dibujar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
			
		try {
			Area area = (Area) Inicio.panelHerramientas.getListSelected();
			
			if (area == null) {
				return;
			}
			
			Inicio.panelLienzo.getLienzo().setDibujo(area);
			Inicio.panelLienzo.getLienzo().repaint();
		} catch(ClassCastException e) {}
	
	}
}
