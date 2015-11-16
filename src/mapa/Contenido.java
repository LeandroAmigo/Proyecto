package mapa;



import personajes.Bomberman;
import personajes.Enemigo;


/**
 * 
 */
public abstract class Contenido {
	
	protected int fila;
	protected int columna;
	/**
	 * Controla si el personaje puede ser recibido en la celda, si puede se setea la posicion de la celda al personaje.
	 * @param c celda
	 * @param p personaje
	 */
    public abstract void Recibir(Celda c,Bomberman b);
    
    public abstract void Recibir(Celda c,Enemigo e);
    /**
     * 
     * false si es transitable, true en caso contrario.
     * @param c celda
     */
    public abstract boolean Destruir(Celda c);
       
}