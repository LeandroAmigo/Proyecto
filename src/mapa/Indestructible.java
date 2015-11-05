package mapa;


import grafica.PanelEscenario;
import grafica.ParedGrafica;
import java.util.*;
import personajes.Personaje;

/**
 * 
 */
public class Indestructible extends Contenido{
    /**
     * 
     */
    public Indestructible(PanelEscenario panel,int fila, int columna) {
        // TODO implement here
    	this.miPanel=panel;
    	this.miGrafica=new ParedGrafica(fila,columna,panel,0);
    	
    }

    /**
     * @param c 
     * @param p
     */
    public void Recibir(Celda c, Personaje p) {
        // TODO implement here
    }

    /**
     * @param c
     */
    public void Destruir(Celda c) {
        // TODO implement here
    }

}