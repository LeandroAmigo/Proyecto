package mapa;

import grafica.GUI;

import java.awt.Color;
import java.util.*;

import javax.swing.ImageIcon;

import logica.Logica;
import logica.MaloThread;
import personajes.Altair;
import personajes.Bomberman;
import personajes.Rugulos;
import personajes.Sirius;

/**
 * 
 */
public class Escenario {

    /**
     * 
     */
	Logica miLogica;
	/**
	 * 
	 */
	MaloThread[] hilo;
    /**
     * 
     */
    protected int puntos;

    /**
     * 
     */
    protected Celda miMatriz[][];

   /**
     * 
     */
    protected Bomberman bomberman;

   /**
     * 
     */
    protected Sirius [] misSirius;

    /**
     * 
     */
    protected Altair [] misAltair;


    /**
     * 
     */
    protected Rugulos [] misRugulos;

    /**
     * 
     */
    protected GUI gui;
    /**
     * 
     */
    public Escenario(GUI gui) {
    	   
    	// TODO implement here
       Inicializar(gui);
    /*	miMatriz=new Celda[31] [31];
    	for(int fila=0;fila<miMatriz.length;fila++)
    		for(int columna=0;columna<miMatriz[fila].length;columna++)
    			{
    				miMatriz[fila][columna]=new Celda(fila,columna,this,new Transitable());//Inicialice todas transitables!!
    				
    			}
    			
    	
    	
    	//Inicializo bomberman
    	this.bomberman=new Bomberman(this);
    	this.bomberman.setPosicion(miMatriz[0][0]);
    	gui.add(this.bomberman.getGraficos().getGrafico());
    */	
    }

    /**
     * @param int fila 
     * @param int columna 
     * @param Celda c
     */
    public void setPosicion(int fila,int columna,Celda c) {
        // TODO implement here
    }

    /**
     * @param int fila 
     * @param int columna 
     * @return
     */
    public Celda getPosicion( int fila,  int columna) {
        // TODO implement here
    	
        return miMatriz[fila][columna];
    }

    /**
     * @return
     */
    public Collection<Sirius> getSirius() {
        // TODO implement here
        return null;
    }

    /**
     * @param s 
     * @return
     */
    public Sirius getSirius(Sirius s) {
        // TODO implement here
        return null;
    }

    /**
     * @param s
     */
    public void eliminarSirius(Sirius s) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Collection<Altair> getAltair() {
        // TODO implement here
        return null;
    }

    /**
     * @param a 
     * @return
     */
    public Altair getAltair(Altair a) {
        // TODO implement here
        return null;
    }

    /**
     * @param a
     */
    public void eliminarAltair(Altair a) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Collection<Rugulos> getRugulos() {
        // TODO implement here
        return null;
    }

    /**
     * @param r 
     * @return
     */
    public Rugulos getRugulos(Rugulos r) {
        // TODO implement here
        return null;
    }

    /**
     * @param r
     */
    public void eliminarRugulos(Rugulos r) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Bomberman getBomberman() {
        // TODO implement here
        return this.bomberman;
    }

    /**
     * @param p
     */
    public void sumarPuntos(int p) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Inicializar(GUI gui) {
        // TODO implement here
    	miLogica=new Logica(this);
    	//Inicializo matriz
    	miMatriz=new Celda[31] [31];
    	for(int fila=0;fila<miMatriz.length;fila++)
    		for(int columna=0;columna<miMatriz[fila].length;columna++)
    			{
    				miMatriz[fila][columna]=new Celda(fila,columna,this,new Transitable());//Inicialice todas transitables!!
    				
    			}
    			
    	
    	
    	//Inicializo bomberman
    	this.bomberman=new Bomberman(this);
    	this.bomberman.setPosicion(miMatriz[0][0]);
    	gui.add(this.bomberman.getGraficos().getGrafico());
    	
    	//Inicializo altair
    	misAltair=new Altair[2];
    	hilo=new MaloThread[2];
      for(int i=0; i<misAltair.length;i++)
    	{
    		misAltair[i]=new Altair(this);
    		misAltair[i].setPosicion(miMatriz[i*10][i*10]);//cualquier posicion 
    		this.hilo[i]=new MaloThread(misAltair[i]);
    		gui.add(misAltair[i].getGraficos().getGrafico());
    		this.hilo[i].start();
    	}
     	
   // Creo los malos y agrego a la gui su grafico.
  	/*	this.mMalos = new MaloThread[3];
  		for(int i = 0; i < this.mMalos.length; i++){
  			Random r = new Random();
  			
  			Malo malo = new Malo(10, r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32));
  			this.mMalos[i] = new MaloThread(malo);
  			gui.add(malo.getGrafico());
  			
  			this.mMalos[i].start();
  		}
  	*/	
    	
    	this.gui=gui;
    }
    public Logica getLogica()
    {
    	return miLogica;
    }

}