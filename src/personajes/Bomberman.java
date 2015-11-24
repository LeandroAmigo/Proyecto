package personajes;

import grafica.EntidadGrafica;
import grafica.PanelEscenario;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.BombermanThread;
import logica.CONSTANTES;
import logica.Logica;
import logica.MaloThread;
import mapa.Celda;
import mapa.Escenario;
import bomba.Bomba;

public class Bomberman extends Personaje {

    protected int cantBombas;       
       
    protected boolean inmune; 
    
    protected int alcanceBomba;
    
    protected Thread miHilo;

    public Bomberman(Escenario e,int fila,int col){

    	super(e);
    	miHilo=new BombermanThread(this);
    	cantBombas=1;
    	inmune=false;
    	alcanceBomba=1;
    	this.miCelda=e.getPosicion(fila, col);
    	this.miGrafica=new EntidadGrafica(this,fila,col,e.getGui());
    	
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/bombermanDerecha.jpg")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/bombermanIzquierda.jpg")));
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/bombermanArriba.jpg"))); 
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/bombermanAbajo.jpg")));
    	
    	this.miGrafica.InicializarImagen(new ImageIcon(this.getClass().getResource("/Imagenes/muerteBomberman.png")));
    	
    }
    
    public void PonerBomba() {
        // TODO implement here
    	if(cantBombas>0)
    	{	
    		cantBombas--;
    	    Bomba b=new Bomba(miCelda,alcanceBomba);
    		Thread hilo = new Thread(b);
        	hilo.start();
           	   		
    	}	
    }
    
    public void SetVelocidad(int v) {
     
    	velocidad=v;
    }
    
    public boolean atraviesaPared()
    {
    	return inmune;
    }
    
    public void SetMasacrality(boolean m)
    {
    	inmune=m;
    }
    
    public void SetCantBombas(int cant) {
       
        cantBombas=cant;
    }

    public int GetAlcanceBomba() {
     
        return alcanceBomba;
    }
    public void SetAlcanceBomba(int a) {
       
        alcanceBomba=a;
    }
    

    public int GetCantBombas() {
       
        return cantBombas;
    }
    public void morir() {
        
    	System.out.println("Murio BOMBERMAN");
    	miCelda.eliminarBomberman(this);
    	miGrafica.Morir();
    }
    
    public void moverArriba()
    {	
    	
    		miEscenario.getLogica().MoverArriba(miCelda, this);   		
    		miGrafica.SetImagen(CONSTANTES.B_MirarArriba, this);
    		
    }
    
    public void moverAbajo() {
       
    	miEscenario.getLogica().MoverAbajo(miCelda, this);
    	miGrafica.SetImagen(CONSTANTES.B_MirarAbajo, this);
    	
    }
    public void moverDerecha() {
       
    	miEscenario.getLogica().MoverDerecha(miCelda, this);
    	miGrafica.SetImagen(CONSTANTES.B_MirarDerecha, this);
    	
    }
    public void moverIzquierda() {
        miEscenario.getLogica().MoverIzquierda(miCelda, this);
    	miGrafica.SetImagen(CONSTANTES.B_MirarIzquierda, this);
    	
    }
   
    
}