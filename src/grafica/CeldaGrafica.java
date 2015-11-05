package grafica;


import javax.swing.Icon;

import javax.swing.JLabel;

import mapa.Contenido;
import grafica.PanelEscenario;

public class CeldaGrafica {

	protected JLabel miImagen;
	protected Icon misImagenes[];
	protected int cant;//Mantiene la cantidad de imagenes en el arreglo
	protected Contenido pared;
	protected int posX;
	protected int posY;
	protected ParedGrafica grafico;
	protected final int ancho = 32;
	protected final int alto = 32;
	
	protected PanelEscenario panel;
	
	public CeldaGrafica(int x, int y, PanelEscenario p, Contenido c)
	{
		this.posX=x;
		this.posY=y;
		this.panel = p;	
		this.pared=c;
		this.cant=0;
		this.misImagenes=new Icon [1] ;
		miImagen=new JLabel("/Imagenes/Destructible.jpg");
		this.panel.add(this.getGrafico(),1);
		panel.repaint();
	}
	
		
	public PanelEscenario obtenerPanel() {
		return this.panel;
	}
	
	public void setImagen(Icon i)
	{
		if(misImagenes.length!=cant)
		{
			misImagenes[cant]=i;
			cant++;
		}
		//sino tendria que lanzar un error de que no se puede almacenar mas imagenes
	}
	
	public JLabel getGrafico() {
		if(this.miImagen == null){
			this.miImagen = new JLabel(this.misImagenes[0]);
			this.miImagen.setBounds(this.posX,this.posY, this.ancho, this.alto);
		}
		return this.miImagen;
	}
	

}

