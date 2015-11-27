package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.CONSTANTES;

public class ParedGrafica {
	protected JLabel grafico;
	protected JLabel graficoBomba;
	protected Icon [] misImagenes;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int fila;
	protected int columna;
	protected GUI gui;
	protected int MiImagen;
	//protected int explociones;
	
	public ParedGrafica(int x, int y,GUI gui)
	{	
		this.gui=gui;
		this.fila=y*ancho;
		this.columna=x*alto;
		//explociones=0;
		misImagenes=new Icon [4];
		misImagenes[0]=new ImageIcon(this.getClass().getResource("/Imagenes/Indestructible.png"));
		misImagenes[1]=new ImageIcon(this.getClass().getResource("/Imagenes/Destructible.png"));
		misImagenes[2]=new ImageIcon(this.getClass().getResource("/Imagenes/Transitable.jpg"));
		misImagenes[3]=new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.png"));
		
		gui.addPanelEscenario(getGrafico(), 0);
				
	}
	public void setGrafico(int Imagen)
	{	if(Imagen!=CONSTANTES.B_Explosion)
			MiImagen=Imagen;
		switch(Imagen)
		{
		case CONSTANTES.P_Indestructible:
				//if(grafico!=null)
				//	gui.removePanelEscenario(grafico);
				this.grafico.setIcon(misImagenes[0]); //=new JLabel(misImagenes[CONSTANTES.P_Indestructible]);
				this.grafico.setBounds(this.fila, this.columna, this.ancho, this.alto);
				//gui.addPanelEscenario(getGrafico(), 0);
				gui.getPanelEscenario().repaint();
				break;
		case CONSTANTES.P_Destructible:
				//if(grafico!=null)
				//	gui.removePanelEscenario(grafico);
				this.grafico.setIcon(misImagenes[1]);//this.grafico =new JLabel(misImagenes[CONSTANTES.P_Destructible]);
				this.grafico.setBounds(this.fila, this.columna, this.ancho, this.alto);
				//gui.addPanelEscenario(getGrafico(), 0);
				gui.getPanelEscenario().repaint();
				break;
		case CONSTANTES.P_Transitable:
				//if(grafico!=null)
				//	gui.removePanelEscenario(grafico);
				//this.grafico =new JLabel(misImagenes[CONSTANTES.P_Transitable]);
				this.grafico.setIcon(misImagenes[2]);
				this.grafico.setBounds(this.fila, this.columna, this.ancho, this.alto);				
				//gui.addPanelEscenario(getGrafico(), 0);
				gui.getPanelEscenario().repaint();
				break;
		case CONSTANTES.B_Explosion:
			if(graficoBomba!=null)
				gui.removePanelEscenario(graficoBomba);
			this.graficoBomba =new JLabel(misImagenes[CONSTANTES.B_Explosion]);
			this.graficoBomba.setBounds(this.fila, this.columna, this.ancho, this.alto);
			gui.addPanelEscenario(graficoBomba, 0);
			break;
		}
		
		
	}	
	
	public JLabel getGrafico() {
		if(grafico==null)
			grafico=new JLabel(misImagenes[CONSTANTES.P_Transitable]);
		return this.grafico;
	}
	
	public void Restaurar()
	{
		gui.removePanelEscenario(graficoBomba);
	
	
		if(MiImagen==CONSTANTES.P_Destructible)
		{				
			System.out.println("Entre a destruir una destructible");	
			setGrafico(CONSTANTES.P_Transitable);
			
		}
		
	}

}
