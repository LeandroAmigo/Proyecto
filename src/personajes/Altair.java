package personajes;

import grafica.EntidadGrafica;

import java.util.*;

import javax.swing.ImageIcon;

import mapa.Celda;
import mapa.Escenario;

/**
 * 
 */
public class Altair extends Enemigo{

    
    /**
     * @param e
     */
    public Altair(Escenario e) {
        // TODO implement here
    	super(e);
    	miGrafica=new EntidadGrafica(this,4,320,320);
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/enemigo.png")));
    	
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
    public void mover() {
        // TODO implement here
    	Random rnd = new Random();
		int dir = rnd.nextInt(4);
		Celda aux=miCelda;
		switch (dir) {
			case 0 : //Movimiento arriba
				
				miEscenario.getLogica().MoverArriba(miCelda, this);
				System.out.println("Mover arriba: Fila: "+miCelda.getFila()+"Columna: "+miCelda.getColumna());
				
				break;
			case 1 ://movimiento abajo
					miEscenario.getLogica().MoverAbajo(miCelda, this);
					System.out.println("Mover abajo: Fila: "+miCelda.getFila()+"Columna: "+miCelda.getColumna());
					
				break;
			case 2 ://movimiento izquierda
					miEscenario.getLogica().MoverIzquierda(miCelda, this);
					System.out.println("Mover izquierda: Fila: "+miCelda.getFila()+"Columna: "+miCelda.getColumna());
				
					break;
			case 3 ://movimiento derecha
				
				miEscenario.getLogica().MoverDerecha(miCelda, this);
				System.out.println("Mover derecha: Fila: "+miCelda.getFila()+"Columna: "+miCelda.getColumna());
				
				break;
		}
		if(aux.getFila()!=miCelda.getFila() || aux.getColumna()!=miCelda.getColumna())
		{
			aux.eliminarEnemigoDeLaCelda();
			miCelda.setEnemigo();
			if(miCelda.getBomberman()!=null)
				miCelda.getBomberman().morir();
			
		}
		
		
    }

    /**
     * 
     */
    public void morir(){};
}