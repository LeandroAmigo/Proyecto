package grafica;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import grafica.PanelEscenario;


public class ParedGrafica {
	
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected final int fila;
	protected final int columna;
	
	
	protected PanelEscenario panel;
	
	
	
	public ParedGrafica(int x, int y, PanelEscenario p,int tipoPared)
	{	
		this.panel = p;	
		this.fila=x*ancho;
		this.columna=y*alto;
		if(tipoPared==0)
			imagen=new ImageIcon(this.getClass().getResource("/Imagenes/Indestructible.png"));
		else
			if(tipoPared==1)
				imagen=new ImageIcon(this.getClass().getResource("/Imagenes/Destructible.png"));
			else
				imagen=new ImageIcon(this.getClass().getResource("/Imagenes/Transitable.png"));	
		
		this.grafico = new JLabel(imagen);
		this.grafico.setBounds(columna,fila, ancho, alto);
		this.panel.add(grafico, 0);
	}
	

}
