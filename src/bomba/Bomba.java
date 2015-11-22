package bomba;


import java.util.*;

import personajes.Bomberman;
import grafica.BombaGrafica;
import grafica.Explotar;
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
    protected Celda miCelda;
    
    protected BombaGrafica miGrafica;
    protected Explotar ExplosionGrafica;
    /**
     * @param c 
     * @param alcance
     */
    public Bomba(Celda c, int alcance) {
        // TODO implement here
    	this.miCelda=c;
    	b=miCelda.getBomberman();
     	this.Alcance=alcance;
     	//ExplosionGrafica=new Explotar(c.getEscenario().getGui());
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
    public LinkedList<Celda> explotar(LinkedList<Celda> c1) {
     /*	for(int i=0; i<c1.size();i++)
    	{
    		c1.get(i).destruir();
    		    	    		
    	}
    */	
    	LinkedList<Celda> Destruidas=new LinkedList<Celda>();
    	boolean seguir=true;
    	int i=0;
    	while(seguir)//Celdas Arriba
    	{
    		if(c1.get(i)!=null)
    		{	
    			seguir=c1.get(i).destruir() && (i<Alcance-1);
    			
    			Destruidas.add(c1.get(i));
    			i++;
    		}else
    			seguir=false;
    	}
    	seguir=true;
    	i=Alcance;
    	while(seguir)//Celdas Abajo
    	{	
    		if(c1.get(i)!=null)
    		{	
    			seguir=c1.get(i).destruir() && (i<Alcance*2-1);
				Destruidas.add(c1.get(i));
				i++;
    		}else
    			seguir=false;
    	}
    	seguir=true;
    	i=Alcance*2;
    	while(seguir)//Celdas derecha
    	{
    		if(c1.get(i)!=null)
    		{	
    			seguir=c1.get(i).destruir() && (i<Alcance*3-1);
    			Destruidas.add(c1.get(i));
    			i++;
    		}else
    			seguir=false;
    	}
    	seguir=true;
    	i=Alcance*3;
    	while(seguir)//Celdas Izquierda
    	{
    		if(c1.get(i)!=null)
    		{	
    			seguir=c1.get(i).destruir() && (i<Alcance*4-1);
    			Destruidas.add(c1.get(i));
    			i++;
    		}else
    			seguir=false;
    	}
    		
    	miCelda.destruir();
    	b.SetCantBombas(b.GetCantBombas()+1);
    	Destruidas.add(miCelda);
    	
    	return Destruidas;
    	
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
    		c1=explotar(c1);//c1 pasa a ser solamentes las celdas destruidas
    		//ExplosionGrafica.explosionGrafica(c1);
    		Thread.sleep(1000); 
    		desaparecer(c1);
    		Thread.interrupted();
    		    		 
    	 	} catch (InterruptedException e) {
    	 		e.printStackTrace();
    	}
    }

}