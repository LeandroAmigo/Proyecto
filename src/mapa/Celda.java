package mapa;

import grafica.ParedGrafica;

import java.util.*;

import logica.CONSTANTES;
import personajes.Bomberman;
import personajes.Enemigo;
import personajes.Personaje;
import powerUp.PowerUp;

/**
 * 
 */
public class Celda {

    protected int fila;
    protected int columna;
    protected Escenario miEscenario;
    protected ParedGrafica miGrafica;
    protected Contenido miContenido;
    protected PowerUp miPowerUp;
    protected Bomberman miBomberman;
    protected LinkedList<Personaje> personajes;
   
  
    /**
     * @param fila ubicacion en la que se encuentra dentro de la matriz 
     * @param columna ubicacion en la que se encuentra dentro de la matriz 
     * @param e escenario principal
     * @param c Contenido de la celda
     * @param panel Panel del Escenario en el que se encuentra la celda
     */
    public Celda(int fila, int columna, Escenario e, Contenido c) {
        // TODO implement here
    	this.fila=fila;
    	this.columna=columna;
    	this.miEscenario=e;
    	this.miContenido=c;
    	this.personajes = new LinkedList<Personaje>();
    	this.miGrafica=new ParedGrafica(fila,columna,e.getGui());
     	
    }

    public void setPowerUp(PowerUp p) {
       miPowerUp= p;
    }

    public void setContenido(Contenido c) {
    	miContenido=c;
       
    }
    /**
     * 
     * @return el contenido de la celda
     */
    public Contenido getContenido()
    {
    	return this.miContenido;
    }
/**
 * Controla si puede recibir el personaje pasado por parametro
 * @param p personaje
 */
    public void Recibir(Bomberman b) {
        
    	miContenido.Recibir(this, b);
    	    	
    }
    public void Recibir(Enemigo e)
    {
    	miContenido.Recibir(this, e);
    }
   
    public Boolean tienePowerUp() {
       
        return null;
    }
    public void getPowerUp(Bomberman b) {
       
    }
    /**
     * 
     * @return la fila en la que se encuentra la celda dentro de la matriz
     */
    public int getFila() {
       
        return fila;
    }
    /**
     * 
     * @return la columna en la que se encuentra la celda dentro de la matriz
     */
    public int getColumna() {
        
        return columna;
    }
    /**
     * 
     * @return escenario
     */
    public Escenario getEscenario() {
        
        return this.miEscenario;
    }
    
    public void destruir() {
    	
    	miGrafica.setGrafico(CONSTANTES.B_Explosion);
    	
    	if(!personajes.isEmpty())
    	{    		
    		for(int i=0;i<personajes.size();i++)
    		{
    			personajes.get(i).morir();
      		}
      	}
      	miContenido.Destruir(this);
      	
   
    }
    public void restaurar()
    {
      		miGrafica.Restaurar();
   
    }
   /**
    * 
    * @return retorna si existen enemigos en la celda
    */
    public boolean tieneEnemigos() {
    	  return personajes.size()!=1;//es distinto de 1 porque ya posee al bomberman
    }
    /**
     * 
     * @return si se encuentra el bomberman en la celda lo retorna, sino retorna null
     */
    public Bomberman getBomberman() {
        
        return this.miBomberman;
    }
    /**
     * setea el bomberman en la celda
     * @param b bomberman
     */
    public void setBomberman(Bomberman b)
    {	
    	personajes.add(b);
      	miBomberman=b;
    }
    /**
     * elimina el bomberman de la celda
     * @param b bomberman
     */
    public void eliminarBomberman(Bomberman b)
    {
    	personajes.remove(b);
      	miBomberman=null;;
    }
    
    /**
     * setea enemigo en la celda 
     * @param e enemigo
     */
    public void setEnemigo(Enemigo e)
    {	
    	personajes.add(e);
    	
    }
    /**
     * elimina enemigo de la celda
     * @param e enemigo
     */
    public void eliminarEnemigoDeLaCelda(Enemigo e)
    {
    	personajes.remove(e);
   
    }
    public ParedGrafica getGrafica()
    {
    	return this.miGrafica;
    }
     
    
}    