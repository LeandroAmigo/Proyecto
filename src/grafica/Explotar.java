package grafica;


import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;


public class Explotar {
	
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;	
	protected int x;
	protected int y;
	protected GUI gui;

	public Explotar(GUI gui) {		
		this.gui=gui;
		this.imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.png"));	
		
		this.grafico = new JLabel(imagen);
	}
	
	public void explosionGrafica(LinkedList<Celda> c1)
	{
		
		for(int i=0; i<c1.size();i++)
		{	
			this.grafico.setBounds(c1.get(i).getColumna()*ancho, c1.get(i).getFila()*alto, ancho, alto);	
			this.gui.addPanelEscenario(grafico, 1);
		}	
		try {
				Thread.sleep(5000);
			}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0; i<c1.size();i++)
		{	
			this.grafico.setBounds(c1.get(i).getColumna()*ancho, c1.get(i).getFila()*alto, ancho, alto);	
			this.gui.removePanelEscenario(grafico);
		}	
		//this.gui.removePanelEscenario(this.grafico);
		this.gui.repaint();
	}

}

