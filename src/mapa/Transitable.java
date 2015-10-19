package mapa;

import java.util.*;

import personajes.Personaje;

/**
 * 
 */
public class Transitable extends Contenido{

   
    /**
     * 
     */
    public Transitable() {
        // TODO implement here
    }

    /**
     * @param c 
     * @param p
     */
    public void Recibir(Celda c, Personaje p) {
        // TODO implement here
    	if(!c.tieneBomba() )
    		p.setPosicion(c);
    }

    /**
     * @param c
     */
    public void Destruir(Celda c){
        // TODO implement here
    }

}