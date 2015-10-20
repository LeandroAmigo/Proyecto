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
    //protected Enemigo [] misEnemigos;

    protected int cantEnemigos;
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
    	//this.misEnemigos=new Enemigo[20];
    	this.cantEnemigos=0;
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
    	miContenido.Recibir(this, p);
    	    	
    }
  /*  
    public void Recibir(Bomberman b) {
        // TODO implement here
    	System.out.println("Bomberman ");
    	if(misEnemigos[0]==null)
    		miContenido.Recibir(this, b);
    	else
    		b.morir();
    }
*/
    /**
     * @param e
     */
 //   public void Recibir(Enemigo e) {
 //       // TODO implement here
 //   	System.out.println("Enemigo ");
 //   	
 //   }

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
    public boolean tieneEnemigos() {
        // TODO implement here
        return cantEnemigos!=0;
    }

    /**
     * @return
     */
    public Bomberman getBomberman() {
        // TODO implement here
        return miBomberman;
    }
    public void setBomberman(Bomberman b)
    {
    	miBomberman=b;
    }
    public void setEnemigo()
    {
    	cantEnemigos++;
    }
    public void eliminarEnemigoDeLaCelda()
    {
    	if(cantEnemigos!=0)
    	{
    		cantEnemigos--;
    	}	
    }

}