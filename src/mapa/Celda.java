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
    protected Bomba miBomba;
    protected Contenido miContenido;
    protected PowerUp miPowerUp;
    protected Bomberman miBomberman;
    //protected LinkedList<Enemigo> enemigo;
    protected int cantEnemigos;
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
    		//this.enemigos = new LinkedList<Enemigo>();
    	this.cantEnemigos=0;
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
        
    	miContenido.Recibir(this, p);
    	    	
    }
    public void Recibir(Enemigo p) {
       
    	System.out.println("asda");
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
  
    public void SetBomba(Bomba b) {
       
    	miBomba=b;
    }
    public boolean tieneEnemigos() {
       
        return cantEnemigos!=0;
    }
    public Bomberman getBomberman() {
        
        return this.miBomberman;
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