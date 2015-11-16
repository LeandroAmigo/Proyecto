package mapa;


import grafica.PanelEscenario;
import grafica.ParedGrafica;

import java.util.*;

import personajes.Bomberman;
import personajes.Enemigo;
import personajes.Personaje;

/**
 * 
 */
public class Indestructible extends Contenido{
    /**
     * 
     */
    public Indestructible(int fila, int columna) {
        // TODO implement here
      	this.fila=fila;
    	this.columna=columna;
    	
    }

    /**
     * @param c 
     * @param p
     */
    public void Recibir(Celda c, Bomberman p) { }
    public void Recibir(Celda c, Enemigo e){}

    /**
     * @param c
     */
    public boolean Destruir(Celda c) {
        // TODO implement here
    	return false;
    }

}