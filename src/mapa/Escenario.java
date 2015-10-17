package mapa;

import java.util.*;

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
    protected int puntos;

    /**
     * 
     */
    protected Celda MiMatriz[][];

   /**
     * 
     */
    protected Bomberman bomberman;

   /**
     * 
     */
    protected Sirius misSirius;

    /**
     * 
     */
    protected Altair misAltair;


    /**
     * 
     */
    protected Rugulos misRugulos;


    /**
     * 
     */
    public Escenario() {
        // TODO implement here
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
        return null;
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
        return null;
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
    public void Inicializar() {
        // TODO implement here
    }

}