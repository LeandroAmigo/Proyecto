package personajes;

import java.util.*;

import mapa.Escenario;
import bomba.Bomba;

/**
 * 
 */
public class Bomberman extends Personaje{

   /**
     * 
     */
    protected int CantBombas;

    /**
     * 
     */
    protected Boolean Inmune;
    /**
     * 
     */
    protected Set<Bomba> MiBomba;

    /**
     * @param b
     */
    public Bomberman(Escenario e) {
    	super(e);
        // TODO implement here
    }

    /**
     * 
     */
    public void PonerBomba() {
        // TODO implement here
    }

    /**
     * 
     */
    public void SetVelocidad() {
        // TODO implement here
    }

    /**
     * @return
     */
    public int SetCantBombas() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int GetVelocidad() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Bomba GetBomba() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int GetCantBombas() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public void morir() {
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
    public void moverArriba() {
        // TODO implement here
    }

    /**
     * 
     */
    public void moverAbajo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void moverDerecha() {
        // TODO implement here
    }

    /**
     * 
     */
    public void moverIzquierda() {
        // TODO implement here
    }

}