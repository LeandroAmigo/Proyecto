package personajes;

import java.util.*;

import mapa.Escenario;

/**
 * 
 */
public abstract class Altair extends Enemigo{

    
    /**
     * @param e
     */
    public Altair(Escenario e) {
    	super(e);
        // TODO implement here
    }

    /**
     * @return
     */
    public Boolean atraviesaPared() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void morir() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mover(){};
}