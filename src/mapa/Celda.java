package mapa;

import java.util.*;

import bomba.Bomba;
import personajes.Bomberman;
import personajes.Enemigo;
import personajes.Personaje;
import powerUp.PowerUp;

/**
 * 
 */
public class Celda {

   /**
     * 
     */
    protected int fila;

    /**
     * 
     */
    protected int columna;


    /**
     * 
     */
    protected Escenario miEscenario;


   
    /**
     * 
     */
    protected Bomba miBomba;





    /**
     * 
     */
    protected Contenido miContenido;

    /**
     * 
     */
    protected PowerUp miPowerUp;
    /**
     * 
     */
    protected Bomberman miBomberman;
    
    /**
     * 
     */
    protected Enemigo [] misEnemigos;

    /**
     * @param fila 
     * @param columna 
     * @param e 
     * @param c
     */
    public Celda(int fila, int columna, Escenario e, Contenido c) {
        // TODO implement here
    	this.fila=fila;
    	this.columna=columna;
    	this.miEscenario=e;
    	this.miContenido=c;
    	this.miBomba=null;
    	this.misEnemigos=new Enemigo[20];
    }

    /**
     * @param p
     */
    public void setPowerUp(PowerUp p) {
        // TODO implement here
    }

    /**
     * @param c
     */
    public void setContenido(Contenido c) {
        // TODO implement here
    }

    /**
     * @param p
     */
    public void setPersonaje(Personaje p) {
        // TODO implement here
    }

    /**
     * @param b
     */
    public void Recibir(Personaje p) {
        // TODO implement here
    	if(misEnemigos[0]==null)
    		miContenido.Recibir(this, p);
    	else
    		p.morir();
    }

    /**
     * @param e
     */
    public void Recibir(Enemigo e) {
        // TODO implement here
    	
    }

    /**
     * @return
     */
    public Boolean tienePowerUp() {
        // TODO implement here
        return null;
    }

    /**
     * @param b
     */
    public void getPowerUp(Bomberman b) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getFila() {
        // TODO implement here
        return fila;
    }

    /**
     * @return
     */
    public int getColumna() {
        // TODO implement here
        return columna;
    }

    /**
     * @return
     */
    public Escenario getEscenario() {
        // TODO implement here
        return this.miEscenario;
    }

   
    /**
     * 
     */
    public void destruir() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Boolean tieneBomba() {
        // TODO implement here
    	return (miBomba!=null);
    }

    /**
     * @param b
     */
    public void SetBomba(Bomba b) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Collection<Enemigo> getEnemigos() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Bomberman getBomberman() {
        // TODO implement here
        return null;
    }
    public void setBomberman(Bomberman b)
    {
    	miBomberman=b;
    }

}