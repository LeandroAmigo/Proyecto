package mapa;

import grafica.CeldaGrafica;
import grafica.PanelEscenario;

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

    protected int fila;
    protected int columna;
    protected Escenario miEscenario;
   
    protected Contenido miContenido;
    protected PowerUp miPowerUp;
    protected Bomberman miBomberman;
    protected LinkedList<Personaje> personajes;
    
    protected CeldaGrafica miGrafico;
    /**
     * @param fila 
     * @param columna 
     * @param e 
     * @param c
     */
    public Celda(int fila, int columna, Escenario e, Contenido c,PanelEscenario panel) {
        // TODO implement here
    	this.fila=fila;
    	this.columna=columna;
    	this.miEscenario=e;
    	this.miContenido=c;
    	this.personajes = new LinkedList<Personaje>();
     	miGrafico=new CeldaGrafica(fila,columna,panel,c);
    	
 
    }

    public void setPowerUp(PowerUp p) {
       
    }

    public void setContenido(Contenido c) {
       
    }
    public Contenido getContenido()
    {
    	return this.miContenido;
    }

    public void Recibir(Personaje p) {
        //this.personajes.add(p);
    	miContenido.Recibir(this, p);
    	    	
    }
   
    public Boolean tienePowerUp() {
       
        return null;
    }
    public void getPowerUp(Bomberman b) {
       
    }
    public int getFila() {
       
        return fila;
    }
    public int getColumna() {
        
        return columna;
    }
    public Escenario getEscenario() {
        
        return this.miEscenario;
    }
    public void destruir() {
       
    }
   
    public boolean tieneEnemigos() {
    	System.out.println("personajes.size() "+personajes.size());
        return personajes.size()!=1;//es distinto de 1 porque ya posee al bomberman
    }
    public Bomberman getBomberman() {
        
        return this.miBomberman;
    }
    /**
     * b es nulo cuando bomberman se va de la celda ,sino,cuando entra a la celda b es el bomberman
     * @param b
     */
    public void setBomberman(Bomberman b)
    {	
    	personajes.add(b);
      	miBomberman=b;
    }
    public void eliminarBomberman(Bomberman b)
    {
    	personajes.remove(b);
      	miBomberman=null;;
    }
    
    
    public void setEnemigo(Enemigo e)
    {	
    	personajes.add(e);
    	//cantEnemigos++;
    }
    
    public void eliminarEnemigoDeLaCelda(Enemigo e)
    {
    	personajes.remove(e);
    //	if(cantEnemigos!=0)
    //	{
    //		cantEnemigos--;
    //	}	
    }
    
   
}