package logica;

import java.util.*;

import personajes.Bomberman;
import personajes.Personaje;
import mapa.Celda;
import mapa.Escenario;

/**
 * 
 */
public class Logica {
    /**
     * 
     */
    protected Escenario miEscenario;

    /**
     * @param e
     */
    public Logica(Escenario e) {
        // TODO implement here
    	miEscenario=e;
    }

    /**
     * @param c 
     * @param p
     */
    public void MoverArriba(Celda c, Personaje p) {
        // TODO implement here
    	if(c.getFila()!=0)
    	{	Celda ppos=c.getEscenario().getPosicion(c.getFila()-1, c.getColumna());//Almacena la posicion a la que se desea mover
	    	ppos.Recibir(p);
	    	p.getGraficos().moverArriba();
    	}
    }	

    /**
     * @param c 
     * @param p
     */
    public void MoverAbajo(Celda c, Personaje p) {
        // TODO implement here
	    if(c.getFila()!=30)	
	    {	Celda ppos=c.getEscenario().getPosicion(c.getFila()+1, c.getColumna());//Almacena la posicion a la que se desea mover
	    	ppos.Recibir(p);
	    	p.getGraficos().moverAbajo();
	    }	
    }

    /**
     * @param c 
     * @param p
     */
    public void MoverDerecha(Celda c, Personaje p) {
        // TODO implement here
    	if(c.getColumna()!=30)	
    	{
    		Celda ppos=c.getEscenario().getPosicion(c.getFila(), c.getColumna()+1);//Almacena la posicion a la que se desea mover
    	   	ppos.Recibir(p);
    	   	p.getGraficos().moverDerecha();
    	}
    } 	

    /**
     * @param c 
     * @param p
     */
    public void MoverIzquierda(Celda c, Personaje p) {
        // TODO implement here
    	if(c.getColumna()!=0)
    	{	
    		Celda ppos=c.getEscenario().getPosicion(c.getFila(), c.getColumna()-1);//Almacena la posicion a la que se desea mover
    		ppos.Recibir(p);
    		p.getGraficos().moverIzquierda();
    
    	}
    }
}