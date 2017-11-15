package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import app.Inicio;
import mapa.AreaColor;


public class PanelHerramientas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JList display;
	private DefaultListModel model;
	private JButton btnLimpiar;
	private JButton btnDibujar;
	private JButton btnCambiarColor;
	private JButton btnEliminarArea;
	private JComboBox cboC;
	private JRadioButton[] rb; 
	private JLabel lblX;
	private JLabel lblY;
	
	public PanelHerramientas() {
		super();
		configurar();
		Inicio.panelHerramientas = this;
	}
	
	public DefaultListModel getModel() {
		return model;
	}

	public Object getListSelected() {
		return display.getSelectedValue();
	}
	
	public void removeListSelected(Object o){
		model.removeElement(o);
	}
	
	public void setLblY(int d) {
		lblY.setText("D+: " + String.valueOf(d));
	}
	
	public void setLblX(int x, int y) {
		lblX.setText("X: " + String.valueOf(x) + "  Y: " + String.valueOf(y));
	}
	
	public void setLblY(String s) {
		lblY.setText(s);
	}
	
	public void setLblX(String s) {
		lblX.setText(s);
	}
	
	public int getRB() {
		return (rb[0].isSelected() ? 0 : 1);
	}
	
	public AreaColor getComboColor() {
		return ((AreaColor) cboC.getSelectedItem());
	}
	
	public JList getListArea() {
		return display;
	}

	private void configurar() {
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BorderLayout());
		
		JPanel pnlCmd = new JPanel();
		pnlCmd.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		pnlCmd.setLayout(new GridLayout(4, 2, 5, 5));
		
		JPanel pnlRB = new JPanel();
		pnlRB.setLayout(new FlowLayout(FlowLayout.LEFT));
		ButtonGroup grupo = new ButtonGroup();
		rb = new JRadioButton[2];
		rb[0] = new JRadioButton("Area");
		rb[1] = new JRadioButton("Punto");
		rb[0].setSelected(true);
		grupo.add(rb[0]);
		grupo.add(rb[1]);
		pnlRB.add(rb[0]);
		pnlRB.add(rb[1]);
		
		cboC = new JComboBox(AreaColor.values());
		cboC.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		btnDibujar = new JButton("Calcular camino");
		btnDibujar.addActionListener(new _Action_Dibujar());
		
		btnLimpiar = new JButton("Limpiar gráfico");
		btnLimpiar.addActionListener(new _Action_Limpiar()); 

		btnCambiarColor = new JButton("Cambiar color");
		btnCambiarColor.addActionListener(new _Action_Cambiar());
		
		btnEliminarArea = new JButton("Eliminar area");
		btnEliminarArea.addActionListener(new _Action_Eliminar());
		
		lblX = new JLabel("Coordenadas");
		lblY = new JLabel("Dendidad");
		lblX.setBorder(BorderFactory.createEtchedBorder());
		lblY.setBorder(BorderFactory.createEtchedBorder());
		lblX.setHorizontalAlignment(JLabel.CENTER);
		lblY.setHorizontalAlignment(JLabel.CENTER);
		
		pnlCmd.add(pnlRB);
		pnlCmd.add(cboC);
		pnlCmd.add(btnDibujar);
		pnlCmd.add(btnLimpiar);
		pnlCmd.add(btnCambiarColor);
		pnlCmd.add(btnEliminarArea);
		pnlCmd.add(lblX);
		pnlCmd.add(lblY);
				
		model = new DefaultListModel();
		display = new JList(model);
		display.setBorder(BorderFactory.createEtchedBorder());
		JScrollPane js = new JScrollPane(display);
		js.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		
		add(pnlCmd, BorderLayout.NORTH);
		add(js, BorderLayout.CENTER);
	}
}
