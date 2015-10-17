package mapa;

import java.util.*;

import personajes.Personaje;

/**
 * 
 */
public abstract class Contenido {

    public abstract void Recibir(Celda c,Personaje p);
    public abstract void Destruir(Celda c);
    

}