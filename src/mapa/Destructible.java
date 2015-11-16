package mapa;


import grafica.PanelEscenario;
import grafica.ParedGrafica;

import java.util.*;

import logica.CONSTANTES;
import personajes.Bomberman;
import personajes.Enemigo;
import personajes.Personaje;

/**
 * 
 */
public class Destructible extends Contenido{

   
	/**
     * 
     */
    public Destructible(int fila, int columna) {
       	
    	this.fila=fila;
    	this.columna=columna;
    	
    }

    /**
     * @param c 
     * @param p
     */
    public void Recibir(Celda c, Bomberman b) {
        // TODO implement here
    	if(b.atraviesaPared()){
    		b.setPosicion(c);
    		if(c.tieneEnemigos())
    			b.morir();
    	}	
    }
    public void Recibir(Celda c, Enemigo e) {
        // TODO implement here
    	if(e.atraviesaPared())
    		e.setPosicion(c);
    	if(c.getBomberman()!=null)
    		c.getBomberman().morir();
    }
    	

    /**
     * @param c
     */
    public boolean Destruir(Celda c) {
        // TODO implement here
    	c.setContenido(new Transitable(fila,columna));
    	  	
       	return true;
    }

	

   
}