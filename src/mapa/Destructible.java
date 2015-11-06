package mapa;

import grafica.PanelEscenario;
import grafica.ParedGrafica;

import java.util.*;

import personajes.Personaje;

/**
 * 
 */
public class Destructible extends Contenido{

    /**
     * 
     */
    public Destructible(PanelEscenario panel,int fila, int columna) {
       	this.miPanel=panel;
    	this.miGrafica=new ParedGrafica(fila,columna,panel,1);
    }

    /**
     * @param c 
     * @param p
     */
    public void Recibir(Celda c, Personaje p) {
        // TODO implement here
    	if(p.atraviesaPared())
    		p.setPosicion(c);
    	    }

    /**
     * @param c
     */
    public void Destruir(Celda c) {
        // TODO implement here
    }

	

   
}