package personajes;

import grafica.EntidadGrafica;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.Logica;
import mapa.Celda;
import mapa.Escenario;
import bomba.Bomba;

/**
 * 
 */
public class Bomberman extends Personaje{

   /**
     * 
     */
    protected int cantBombas;
 
    /**
     * 
     */
    protected Boolean inmune;
    /**
     * 
     */
    protected Set<Bomba> miBomba;

    /**
     * @param b
     */
    public Bomberman(Escenario e) {
    	// TODO implement here
    	super(e);
    	this.miGrafica=new EntidadGrafica(this,4,32,0);
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/bomberman.png")));
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/muerteBomberman.png")));
    	
    }

    /**
     * 
     */
    public void PonerBomba() {
        // TODO implement here
    }

    /**
     * 
     */
    public void SetVelocidad() {
        // TODO implement here
    }

    /**
     * @return
     */
    public int SetCantBombas() {
        // TODO implement here
        return 0;
    }

   
    /**
     * @return
     */
    public Bomba GetBomba() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int GetCantBombas() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public void morir() {
        // TODO implement here
    	System.out.println("Murio BOMBERMAN");
    	miGrafica.Morir();
    }

    /**
     * @return
     */
    public Boolean atraviesaPared() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void moverArriba() {
        // TODO implement here
    	Celda aux=miCelda;
    	miEscenario.getLogica().MoverArriba(miCelda, this);
    	System.out.println("Fila: "+miCelda.getFila()+"Columna: "+miCelda.getColumna());
    	if(aux.getFila()==miCelda.getFila() || aux.getColumna()!=miCelda.getColumna())//Si se movio se setea en la celda
    		miCelda.setBomberman(this);
    	if(miCelda.tieneEnemigos())
    		this.morir();
    	
    }
    

    /**
     * 
     */
    public void moverAbajo() {
        // TODO implement here
    	Celda aux=miCelda;
    	miEscenario.getLogica().MoverAbajo(miCelda, this);
    	System.out.println("Fila: "+miCelda.getFila()+"Columna: "+miCelda.getColumna());
    	if(aux.getFila()==miCelda.getFila() || aux.getColumna()!=miCelda.getColumna())//Si se movio se setea en la celda
    		miCelda.setBomberman(this);
    }

    /**
     * 
     */
    public void moverDerecha() {
        // TODO implement here
    	Celda aux=miCelda;
    	miEscenario.getLogica().MoverDerecha(miCelda, this);
    	System.out.println("Fila: "+miCelda.getFila()+"Columna: "+miCelda.getColumna());
    	if(aux.getFila()==miCelda.getFila() || aux.getColumna()!=miCelda.getColumna())//Si se movio se setea en la celda
    		miCelda.setBomberman(this);
    }

    /**
     * 
     */
    public void moverIzquierda() {
        // TODO implement here
    	Celda aux=miCelda;
    	miEscenario.getLogica().MoverIzquierda(miCelda, this);
    	System.out.println("Fila: "+miCelda.getFila()+"Columna: "+miCelda.getColumna());
    	if(aux.getFila()==miCelda.getFila() || aux.getColumna()!=miCelda.getColumna())//Si se movio se setea en la celda
    		miCelda.setBomberman(this);
    }
   
    
}