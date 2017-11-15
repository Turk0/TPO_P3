package vista;

import grafico.LimpiarArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Inicio;
import mapa.Mapa;


public class _Action_Limpiar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Inicio.panelHerramientas.getModel().clear();
		Lienzo lienzo = Inicio.panelLienzo.getLienzo();
		lienzo.setDibujo(new LimpiarArea());
		lienzo.repaint();
		Inicio.setMapa(new Mapa());
	}

}
