package personajes;

import grafica.EntidadGrafica;

import java.util.*;

import javax.swing.ImageIcon;

import bomba.Bomba;
import logica.MaloThread;
import mapa.Escenario;

/**
 * 
 */
public class Sirius extends Enemigo{
    /**
     * @param e 
     * @param b
     */
    public Sirius(Escenario e,int fila,int col) {
    	super(e);
    	velocidad=3;
    	this.miCelda=e.getPosicion(fila, col);
    	miGrafica=new EntidadGrafica(this,fila,col,e.getGui());
    	  
    	
    	//SETEO TODO CON LA MISMA IMAGEN! DESPUES HAY QUE PONERLE BIEN CADA UNA
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Sirius.png")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Sirius.png")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Sirius.png")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Sirius.png")));
       	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/SiriusMuerte.png")));
    }

    /**
     * 
     */
    public void mover()
    {
        // TODO implement here
    	Random rnd = new Random();
		int dir = rnd.nextInt(4);
		
		Bomberman b=miEscenario.getBomberman();
		int filaB=b.getPosicion().getFila();
		int colB=b.getPosicion().getColumna();
		if(filaB<=miCelda.getFila() && colB<=miCelda.getColumna())
		{
			if (dir>=2)
			{
				dir=2;
			}else
				dir=0;
		}else
			if(filaB<=miCelda.getFila() && colB>=miCelda.getColumna())
			{
				if (dir>=2)
				{
					dir=3;
				}else
					dir=0;
			}else
				if(filaB>=miCelda.getFila() && colB>=miCelda.getColumna())
				{
					if (dir>=2)
					{
						dir=3;
					}else
						dir=1;
				}else
					if (dir>=2)
					{
						dir=2;
					}else
						dir=1;
		
		
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
    public void morir()
    {
    	
    //try{
    	System.out.println("Murio Sirius");
    	miHilo.detener();
    	miGrafica.setHilo(null);
    	
    	miCelda.eliminarEnemigoDeLaCelda(this);
    	//miGrafica.Morir();
    	miEscenario.eliminarSirius(this);
       	//miHilo.sleep(1000);    	
    	miGrafica.Eliminar();
    	miEscenario.sumarPuntos(50);
    //}catch(InterruptedException e){}
    }
    
    public void SetHilo(MaloThread hilo)
    {
    	this.miHilo=hilo;
    	miGrafica.setHilo(hilo);
    }
}