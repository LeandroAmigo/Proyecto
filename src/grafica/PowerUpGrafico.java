package grafica;


import javax.swing.Icon;

import javax.swing.JLabel;

public class PowerUpGrafico {
	
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	
	protected  int fila;
	protected int columna;
	
	protected GUI gui;
	
	public PowerUpGrafico(int fila, int columna,GUI gui) {
		this.fila=fila;
		this.columna=columna;					
		this.gui = gui;	
		this.grafico = new JLabel(imagen);
		this.gui.addPanelEscenario(this.grafico,0);
		
	}
	
	public void setImagen(Icon im)
	{
		imagen=im;
	}
	public void aparecer()
	{
		grafico.setIcon(imagen);
		this.grafico.setBounds(columna*ancho,fila*alto, ancho, alto);
		
	}
	
	public void desaparecer() {
		grafico.setIcon(null);
		this.gui.removePanelEscenario(this.grafico);
		
	}
	
}
