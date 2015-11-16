package bomba;


import java.util.*;

import personajes.Bomberman;
import grafica.BombaGrafica;
import mapa.Celda;

/**
 * 
 */
public class Bomba implements Runnable {

    

    /**
     * 
     */
    protected int Alcance;
    protected Bomberman b;

   /**
     * 
     */
    protected Celda miCelda;
    
    protected BombaGrafica miGrafica;
    /**
     * @param c 
     * @param alcance
     */
    public Bomba(Celda c, int alcance) {
        // TODO implement here
    	this.miCelda=c;
    	b=miCelda.getBomberman();
     	this.Alcance=alcance;
    	this.miGrafica = new BombaGrafica(c.getFila(), c.getColumna(),c.getEscenario().getGui());
    	
    	
    }

    /**
     * @return
     */
    public int GetAlcance() {
        // TODO implement here
        return Alcance;
    }

    /**
     * 
     */
    public void SetAlcance(int a) {
        // TODO implement here
    	Alcance=a;
    }

    /**
     * 
     */
    public void explotar(LinkedList<Celda> c1) {
     	for(int i=0; i<c1.size();i++)
    	{
    		c1.get(i).destruir();
    		    	    		
    	}
    	miCelda.destruir();
    	b.SetCantBombas(b.GetCantBombas()+1);
    	
    	
    }

    public void desaparecer(LinkedList<Celda> c1) {
   		
   	    miCelda.restaurar();	
    	for(int i=0; i<c1.size();i++)
    	{
    		Celda a=c1.get(i);
    		a.restaurar();   		
    	}
    
    }
   /**
     * @return
     */
    public Celda getCelda() {
        // TODO implement here
        return miCelda;
    }
    //CAMBIAR EN EL DIAGRAMA RETRASO POR RUN
    public void run() {
    	try {
    		LinkedList<Celda> c1=miCelda.getEscenario().getAdyacentes(miCelda,Alcance);
    		Thread.sleep(4000);
    		miGrafica.desaparecer();//Imagen de la bomba
    		explotar(c1);
    		Thread.sleep(1000); 
    		desaparecer(c1);
    		Thread.interrupted();
    		    		 
    	 	} catch (InterruptedException e) {
    	 		e.printStackTrace();
    	}
    }

}