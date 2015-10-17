package mapa;

import java.util.*;

import bomba.Bomba;
import personajes.Bomberman;
import personajes.Enemigo;
import personajes.Personaje;
import powerUp.PowerUp;

/**
 * 
 */
public class Celda {

    /**
     * Default constructor
     */
    public Celda() {
    }

    /**
     * 
     */
    protected int fila;

    /**
     * 
     */
    protected int columna;


    /**
     * 
     */
    protected Escenario miEscenario;


    /**
     * 
     */
    protected Escenario MiEscenario;


    /**
     * 
     */
    protected Bomba MiBomba;





    /**
     * 
     */
    protected Contenido MiContenido;

    /**
     * 
     */
    protected PowerUp miPowerUp;
    /**
     * 
     */
    protected Bomberman MiBomberman;
    
    /**
     * 
     */
    protected Set<Enemigo> misEnemigos;

    /**
     * @param fila 
     * @param columna 
     * @param e 
     * @param c
     */
    public Celda(int fila, int columna, Escenario e, Contenido c) {
        // TODO implement here
    }

    /**
     * @param p
     */
    public void setPowerUp(PowerUp p) {
        // TODO implement here
    }

    /**
     * @param c
     */
    public void setContenido(Contenido c) {
        // TODO implement here
    }

    /**
     * @param p
     */
    public void setPersonaje(Personaje p) {
        // TODO implement here
    }

    /**
     * @param b
     */
    public void Recibir(Bomberman b) {
        // TODO implement here
    }

    /**
     * @param e
     */
    public void Recibir(Enemigo e) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Boolean tienePowerUp() {
        // TODO implement here
        return null;
    }

    /**
     * @param b
     */
    public void getPowerUp(Bomberman b) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getFila() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getColumna() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Escenario getEscenario() {
        // TODO implement here
        return null;
    }

   
    /**
     * 
     */
    public void destruir() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Boolean tieneBomba() {
        // TODO implement here
        return null;
    }

    /**
     * @param b
     */
    public void SetBomba(Bomba b) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Collection<Enemigo> getEnemigos() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Bomberman getBomberman() {
        // TODO implement here
        return null;
    }

}