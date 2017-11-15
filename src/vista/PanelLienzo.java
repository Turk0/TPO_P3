package vista;

import grafico.DibujoTDA;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

import app.Inicio;


public class PanelLienzo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Lienzo lienzo;
	
	public PanelLienzo() {
		configurar();
		Inicio.panelLienzo = this;
	}
	
	public Lienzo getLienzo() {
		return lienzo;
	}

	private void configurar() {
		setBorder(BorderFactory.createEtchedBorder());
		lienzo = new Lienzo();
		lienzo.setSize(new Dimension(DibujoTDA.LARGO, DibujoTDA.ALTO));
		lienzo.setBackground(Color.lightGray);
		lienzo.addMouseListener(new _Lienzo_Mouse_Click());
		lienzo.addMouseMotionListener(new _Lienzo_Mouse_Motion());
		add(lienzo);
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent event) {
				Inicio.panelHerramientas.setLblX("Coordenadas");
				Inicio.panelHerramientas.setLblY("Densidad");
			}
		});
	}
	
}
