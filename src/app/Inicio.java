package app;

import javax.swing.*;

import vista.PanelLienzo;
import vista.PanelHerramientas;
import mapa.Mapa;
import java.awt.*;

public class Inicio {
	
	private static JFrame frame;
	public static PanelLienzo panelLienzo;
	public static PanelHerramientas panelHerramientas;
	private static Mapa mapa = new Mapa();
			
	public static Mapa getMapa() {
		return mapa;
	}
	
	public static void setMapa(Mapa mapa) {
		Inicio.mapa = mapa;
	}
	
	
	private static void show() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
	
	private static void components() {
		Container c = frame.getContentPane();
		c.add(new PanelLienzo(), BorderLayout.CENTER);	//Lienzo
		c.add(new PanelHerramientas(), BorderLayout.WEST);	//Toolbox
	} 
	
	public static void cerrarVentana() {
		frame.dispose();
		System.exit(0);
	}

    public static void main(String[] args) {
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	frame = new JFrame("Progra III");
            	components();
                show();
            }
        });
        
    }
}
