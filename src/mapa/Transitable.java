package mapa;


import grafica.EntidadGrafica;
import grafica.CeldaGrafica;
import grafica.PanelEscenario;
import grafica.ParedGrafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import personajes.Personaje;

/**
 * 
 */
public class Transitable extends Contenido{
	 
	
 
    /**
     * 
     */
    public Transitable(PanelEscenario p,int fila,int col) {
        // TODO implement here
    	this.miPanel=p;
    	this.miGrafica=new ParedGrafica(fila,col,p,2);
    	
    }

    /**
     * @param c 
     * @param p
     */
    public void Recibir(Celda c, Personaje p) {
       
    	p.setPosicion(c);
    
    }

    /**
     * @param c
     */
    public void Destruir(Celda c){
        // TODO implement here
    }
 
   
}