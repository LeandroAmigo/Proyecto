package mapa;


import grafica.EntidadGrafica;

//import grafica.CeldaGrafica;
import grafica.PanelEscenario;
import grafica.ParedGrafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.CONSTANTES;
import personajes.Bomberman;
import personajes.Enemigo;
import personajes.Personaje;

/**
 * 
 */
public class Transitable extends Contenido{
	 
	
 
    /**
     * 
     */
    public Transitable(int fila,int col) {
        // TODO implement here
    	this.fila=fila;
    	this.columna=columna;  	
    }

    /**
     * @param c 
     * @param p
     */
    public void Recibir(Celda c,Bomberman b) {
    	
    	b.getPosicion().eliminarBomberman(b);//Elimino al bomberman de su celda acual
    	b.setPosicion(c);//Seteo en la nueva celda
    	c.setBomberman(b);//seteo al bomberman en la nueva celda
      	if(c.tieneEnemigos())
    		b.morir();
      	
    }
    public void Recibir(Celda c,Enemigo e){

    	e.getPosicion().eliminarEnemigoDeLaCelda(e);
    	e.setPosicion(c);
    	c.setEnemigo(e);
    	if(c.getBomberman()!=null)
    		c.getBomberman().morir();
      	
    }

    /**
     * @param c
     */
    public boolean  Destruir(Celda c){
        // TODO implement here
      	return true;
    }
 
   
}