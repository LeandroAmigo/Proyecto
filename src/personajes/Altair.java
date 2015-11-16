package personajes;

import grafica.EntidadGrafica;
import grafica.PanelEscenario;

import java.util.*;

import javax.swing.ImageIcon;

import logica.MaloThread;
import mapa.Celda;
import mapa.Escenario;

/**
 * 
 */
public class Altair extends Enemigo{

    
    /**
     * @param e
     */
    public Altair(Escenario e,int fila,int col) {
        // TODO implement here
    	super(e);
    	this.miCelda=e.getPosicion(fila, col);
    	miGrafica=new EntidadGrafica(this,fila,col,e.getGui());
    	
    	//SETEO TODO CON LA MISMA IMAGEN! DESPUES HAY QUE PONERLE BIEN CADA UNA
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Altair.jpg")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Altair.jpg")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Altair.jpg")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Altair.jpg")));
       	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/AltairMuerte.png")));
    	
    }


    /**
     * 
     */
    public void mover()
    {
        // TODO implement here
    	Random rnd = new Random();
		int dir = rnd.nextInt(4);
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
	
    }

    /**
     * 
     */
    public void morir()
    {
    try{
    	System.out.println("Murio ALTAIR");
    	miCelda.eliminarEnemigoDeLaCelda(this);
    	miGrafica.Morir();
    	miEscenario.eliminarAltair(this);
    	miHilo.sleep(0000);
    	miGrafica.Eliminar();
    	miHilo.detener();
    }catch(InterruptedException e){}
    }
    public void SetHilo(MaloThread hilo)
    {
    	this.miHilo=hilo;
    }
}