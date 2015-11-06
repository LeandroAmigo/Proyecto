package personajes;

import grafica.EntidadGrafica;
import grafica.PanelEscenario;

import java.util.*;

import javax.swing.ImageIcon;

import mapa.Celda;
import mapa.Escenario;

/**
 * 
 */
public class Altair extends Enemigo{

    
    /**
     * @param e
     */
    public Altair(Escenario e,int fila,int col,PanelEscenario panel) {
        // TODO implement here
    	super(e);
    	this.miCelda=e.getPosicion(fila, col);
    	miGrafica=new EntidadGrafica(this,fila,col,panel);
    	//SETEO TODO CON LA MISMA IMAGEN! DESPUES HAY QUE PONERLE BIEN CADA UNA
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Altair.jpg")));
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Altair.jpg")));
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Altair.jpg")));
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Altair.jpg")));
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Altair.jpg")));
    	
    }


    /**
     * 
     */
    public void mover()
    {
        // TODO implement here
    	Random rnd = new Random();
		int dir = rnd.nextInt(4);
		Celda aux=this.miCelda;
		switch (dir) {
			case 0 : //Movimiento arriba
				
				miEscenario.getLogica().MoverArriba(miCelda, this);
				
				
				break;
			case 1 ://movimiento abajo
					miEscenario.getLogica().MoverAbajo(miCelda, this);
					
					
				break;
			case 2 ://movimiento izquierda
					miEscenario.getLogica().MoverIzquierda(miCelda, this);
					
				
					break;
			case 3 ://movimiento derecha
				
				miEscenario.getLogica().MoverDerecha(miCelda, this);
				
				
				break;
		}
		if(aux.getFila()!=this.miCelda.getFila() || aux.getColumna()!=this.miCelda.getColumna())
		{
			aux.eliminarEnemigoDeLaCelda(this);
			this.miCelda.setEnemigo(this);
			if(this.miCelda.getBomberman()!=null)
				this.miCelda.getBomberman().morir();
			
		}
		
		
    }

    /**
     * 
     */
    public void morir(){};
}