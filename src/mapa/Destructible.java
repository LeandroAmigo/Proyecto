package mapa;



import personajes.Bomberman;
import personajes.Enemigo;


/**
 * 
 */
public class Destructible extends Contenido{

   
	/**
     * 
     */
    public Destructible(int fila, int columna) {
       	
    	this.fila=fila;
    	this.columna=columna;
    	
    }

    /**
     * @param c 
     * @param p
     */
    public void Recibir(Celda c, Bomberman b) {
        // TODO implement here
    	if(b.atraviesaPared()){
    		b.getPosicion().eliminarBomberman(b);
    		b.setPosicion(c);
    		c.setBomberman(b);
    		if(c.tieneEnemigos())
    			b.morir();
    	}	
    }
    public void Recibir(Celda c, Enemigo e) {
        // TODO implement here
    	if(e.atraviesaPared())
    	{	
    		e.getPosicion().eliminarEnemigoDeLaCelda(e);
    		e.setPosicion(c);
    		c.setEnemigo(e);
    		if(c.getBomberman()!=null)
    			c.getBomberman().morir();
    
    	}
    }	

    /**
     * @param c
     */
    public boolean Destruir(Celda c) {
        // TODO implement here
    	c.setContenido(new Transitable(fila,columna));
    	c.getEscenario().sumarPuntos(10);    	  	
       	return false;
    }

	

   
}