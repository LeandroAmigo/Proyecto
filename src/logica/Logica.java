package logica;

import java.util.*;

import personajes.Bomberman;
import personajes.Enemigo;
import personajes.Personaje;
import mapa.Celda;
import mapa.Escenario;

/**
 * La clase logica es la encargada del movimiento de los personajes.
 */
public class Logica {
    /**
     * 
     */
    protected Escenario miEscenario;

    /**
     * @param e escenario principal
     */
    public Logica(Escenario e) {
        // TODO implement here
    	miEscenario=e;
    }

    /**
     * @param c Celda en la cual se encuentra el personaje
     * @param p personaje que se desea mover
     */
        
    public void MoverArriba(Celda c, Bomberman b)
    {  // TODO implement here
    	if(c.getFila()!=0) //Si es distinto del borde *Nunca va a llegar porque el borde es todo indestructible*
      	{	Celda ppos=miEscenario.getPosicion(c.getFila()-1, c.getColumna());//Almacena la posicion a la que se desea mover
	    	ppos.Recibir(b);
	    	//System.out.println("Fila: "+b.getPosicion().getFila()+" Columna: "+b.getPosicion().getColumna());	    	
	  	}
    }	

   
    public void MoverAbajo(Celda c, Bomberman b) {
        // TODO implement here
	    if(c.getFila()!=30)	//Si es distinto del borde *Nunca va a llegar porque el borde es todo indestructible*
	    {	Celda ppos=c.getEscenario().getPosicion(c.getFila()+1, c.getColumna());//Almacena la posicion a la que se desea mover
	    	ppos.Recibir(b);
	    	//System.out.println("Fila: "+b.getPosicion().getFila()+" Columna: "+b.getPosicion().getColumna());
	    	
	    	
	    }	
    }

   
    public void MoverDerecha(Celda c, Bomberman b) {
        // TODO implement here
    		Celda ppos=c.getEscenario().getPosicion(c.getFila(), c.getColumna()+1);//Almacena la posicion a la que se desea mover
    	   	ppos.Recibir(b);
    	   	//System.out.println("Fila: "+b.getPosicion().getFila()+" Columna: "+b.getPosicion().getColumna());
    	   	
    	   	
    } 
    
    
    
    public void MoverIzquierda(Celda c,Bomberman b) {
        // TODO implement here
    	if(c.getColumna()!=0)
    	{	
    		Celda ppos=c.getEscenario().getPosicion(c.getFila(), c.getColumna()-1);//Almacena la posicion a la que se desea mover
    		ppos.Recibir(b);
    		//System.out.println("Fila: "+b.getPosicion().getFila()+" Columna: "+b.getPosicion().getColumna());
    		
    		
    	}
    }
    
    
    
    public void MoverIzquierda(Celda c, Enemigo e)
    {   // TODO implement here
    	if(c.getColumna()!=0)
    	{	
    		Celda ppos=c.getEscenario().getPosicion(c.getFila(), c.getColumna()-1);//Almacena la posicion a la que se desea mover
    		ppos.Recibir(e);
    		//System.out.println("Fila: "+e.getPosicion().getFila()+" Columna: "+e.getPosicion().getColumna());
    		e.getGraficos().SetImagen(CONSTANTES.B_MirarIzquierda, e);
    		
    	}
    }
    public void MoverDerecha(Celda c, Enemigo e) {
        // TODO implement here
    	if(c.getColumna()!=30)
    	{	
    		Celda ppos=c.getEscenario().getPosicion(c.getFila(), c.getColumna()+1);//Almacena la posicion a la que se desea mover
    		ppos.Recibir(e);
    		//System.out.println("Fila: "+e.getPosicion().getFila()+" Columna: "+e.getPosicion().getColumna());
    		e.getGraficos().SetImagen(CONSTANTES.B_MirarDerecha, e);
    		
    	}
    }
    public void MoverArriba(Celda c, Enemigo e) {
        // TODO implement here
    	if(c.getFila()!=0)
    	{	
    		Celda ppos=c.getEscenario().getPosicion(c.getFila()-1, c.getColumna());//Almacena la posicion a la que se desea mover
    		ppos.Recibir(e);
    		//System.out.println("Fila: "+e.getPosicion().getFila()+" Columna: "+e.getPosicion().getColumna());
    		e.getGraficos().SetImagen(CONSTANTES.B_MirarArriba, e);
    		
    	}
    }
    public void MoverAbajo(Celda c, Enemigo e) {
        // TODO implement here
    	if(c.getFila()!=12)
    	{	
    		Celda ppos=c.getEscenario().getPosicion(c.getFila()+1, c.getColumna());//Almacena la posicion a la que se desea mover
    		ppos.Recibir(e);
    		//System.out.println("Fila: "+e.getPosicion().getFila()+" Columna: "+e.getPosicion().getColumna());
    		e.getGraficos().SetImagen(CONSTANTES.B_MirarAbajo, e);
    		
    	}
    }
    
    
    
   
}