package personajes;

import grafica.EntidadGrafica;

import java.util.*;

import javax.swing.ImageIcon;

import logica.MaloThread;
import mapa.Escenario;

/**
 * 
 */
public class Rugulos extends Enemigo{

   /**
     * @param e
     */
    public Rugulos(Escenario e,int fila,int col) {
    	 // TODO implement here
    	super(e);
    	this.miCelda=e.getPosicion(fila, col);
    	miGrafica=new EntidadGrafica(this,fila,col,e.getGui());
    	
    	  
    	
    	//SETEO TODO CON LA MISMA IMAGEN! DESPUES HAY QUE PONERLE BIEN CADA UNA
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Rugulos.jpg")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Rugulos.jpg")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Rugulos.jpg")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Rugulos.jpg")));
       	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/Rugulos.jpg")));
    	
    }

    /**
     * 
     */
    public void morir() {
   	
        //try{
        	System.out.println("Murio Rugulos");
        	miHilo.detener();
        	miGrafica.setHilo(null);
        	miCelda.eliminarEnemigoDeLaCelda(this);
        	//miGrafica.Morir();
        	miEscenario.eliminarRugulos(this);
           	//miHilo.sleep(1000);    	
        	miGrafica.Eliminar();
        	miEscenario.sumarPuntos(15);
        	
        //}catch(InterruptedException e){}
        }
        
        public void SetHilo(MaloThread hilo)
        {
        	this.miHilo=hilo;
        	miGrafica.setHilo(hilo);
        }

    /**
     * 
     */
    public void mover() {

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
  

   
}