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
import logica.MasacralityThread;
import mapa.Celda;
import mapa.Escenario;
import bomba.Bomba;

public class Bomberman extends Personaje {

    protected int cantBombas;       
       
    protected boolean inmune; 
    
    protected int alcanceBomba;
    
    protected BombermanThread miHilo;

    public Bomberman(Escenario e,int fila,int col){

    	super(e);
    	velocidad=1;
    	miHilo=new BombermanThread(this);
    	miHilo.start();
    	
    	cantBombas=1;
    	inmune=false;
    	alcanceBomba=1;
    	this.miCelda=e.getPosicion(fila, col);
    	this.miGrafica=new EntidadGrafica(this,fila,col,e.getGui());
    	
    	miGrafica.setHilo(miHilo);
    	
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
    		System.out.println("BOMBAS: "+cantBombas);
    	    Bomba b=new Bomba(miCelda,alcanceBomba);
    		Thread hilo = new Thread(b);
        	hilo.start();
           	   		
    	}	
    }
    
    public void SetVelocidad(int v) {
     
    	velocidad=v;
    	System.out.println("VELOCIDAD: "+v );
    }
    
    public boolean atraviesaPared()
    {
    	return inmune;
    }
    
    public void SetMasacrality(boolean m)
    {
    	inmune=m;
    	if(m==true)
    	{	
    		MasacralityThread masacrality=new MasacralityThread(this);
    		masacrality.start();
    		masacrality.detener();
    	}	
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
       if (!inmune)
       {   
    	   System.out.println("Murio BOMBERMAN");
    	   miCelda.eliminarBomberman(this);
    	   miHilo.detener();
    	   //miGrafica.Morir();
    	   miEscenario.getGui().TERMINARJUEGO();
       }
    }
    
    public void moverArriba()
    {	if(miHilo.puedeMoverse())
		{
     	    miEscenario.getLogica().MoverArriba(miCelda, this);  
     	    miHilo.Setdireccion(CONSTANTES.B_MirarArriba);
     	    miHilo.moverse(true);
		}    
    		//miGrafica.SetImagen(CONSTANTES.B_MirarArriba, this);
    		
    }
    
    public void moverAbajo() {
    	if(miHilo.puedeMoverse())
    	{
    		miEscenario.getLogica().MoverAbajo(miCelda, this);
    	    miHilo.Setdireccion(CONSTANTES.B_MirarAbajo);
    	    miHilo.moverse(true);
    	}//miGrafica.SetImagen(CONSTANTES.B_MirarAbajo, this);
    	
    }
    public void moverDerecha() {
       
    	if(miHilo.puedeMoverse())
    	{	
    		miEscenario.getLogica().MoverDerecha(miCelda, this);    	
    		miHilo.Setdireccion(CONSTANTES.B_MirarDerecha);
    		miHilo.moverse(true);
    	}	
    	//miGrafica.SetImagen(CONSTANTES.B_MirarDerecha, this);
    	
    }
    public void moverIzquierda() {
    	if(miHilo.puedeMoverse())
    	{
    		miEscenario.getLogica().MoverIzquierda(miCelda, this);
       	    miHilo.Setdireccion(CONSTANTES.B_MirarIzquierda);
       	    miHilo.moverse(true);
    	}
    	//miGrafica.SetImagen(CONSTANTES.B_MirarIzquierda, this);
    	
    }
    
   
    
}