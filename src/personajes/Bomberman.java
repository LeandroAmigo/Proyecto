package personajes;

import grafica.EntidadGrafica;
import grafica.PanelEscenario;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.Logica;
import mapa.Celda;
import mapa.Escenario;
import bomba.Bomba;

public class Bomberman extends Personaje{

    protected int cantBombas;       
       
    protected boolean inmune; 

    public Bomberman(Escenario e,int fila,int col,PanelEscenario panel){

    	super(e);
    	inmune=false;
    	this.miCelda=e.getPosicion(fila, col);
    	this.miGrafica=new EntidadGrafica(this,fila,col,panel);
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/bombermanAbajo.jpg")));
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/bombermanArriba.jpg")));    	
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/bombermanDerecha.jpg")));
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/bombermanIzquierda.jpg")));
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/muerteBomberman.png")));
    	
    }
    public void PonerBomba() {
        // TODO implement here
    }
    public void SetVelocidad() {
        // TODO implement here
    }
    public boolean atraviesaPared()
    {
    	return inmune;
    }
    public void SetMasacrality(boolean m)
    {
    	inmune=m;
    }
    public int SetCantBombas() {
        // TODO implement here
        return 0;
    }

    public Bomba GetBomba() {
        // TODO implement here
        return null;
    }

    public int GetCantBombas() {
        // TODO implement here
        return 0;
    }
    public void morir() {
        // TODO implement here
    	System.out.println("Murio BOMBERMAN");
    	miCelda.eliminarBomberman(this);
    	miGrafica.Morir();
    }
    
    public void moverArriba()
    {
        // TODO implement here
    	miCelda.eliminarBomberman(this);//Se va de la celda    	
    	System.out.print("Bomberman ");
    	miEscenario.getLogica().MoverArriba(miCelda, this);
    	miCelda.setBomberman(this);//entra en la celda
    	if(miCelda.tieneEnemigos())
    		this.morir();
    		
    	
    }
    
    public void moverAbajo() {
        // TODO implement here
    	miCelda.eliminarBomberman(this);
    	System.out.print("Bomberman ");
    	miEscenario.getLogica().MoverAbajo(miCelda, this);
   		miCelda.setBomberman(this);
    	if(miCelda.tieneEnemigos())
    		this.morir();
    }
    public void moverDerecha() {
        // TODO implement here
    	miCelda.eliminarBomberman(this);
    	System.out.print("Bomberman ");
    	miEscenario.getLogica().MoverDerecha(miCelda, this);
    	miCelda.setBomberman(this);    	
    	if(miCelda.tieneEnemigos())
    		this.morir();
    }
    public void moverIzquierda() {
        // TODO implement here
    	miCelda.eliminarBomberman(this);
    	System.out.print("Bomberman ");
    	miEscenario.getLogica().MoverIzquierda(miCelda, this);
   		miCelda.setBomberman(this);
       	if(miCelda.tieneEnemigos())
    		this.morir();
    }
   
    
}