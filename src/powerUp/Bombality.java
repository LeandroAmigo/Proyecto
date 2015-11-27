package powerUp;

import grafica.PowerUpGrafico;

import java.util.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import mapa.Celda;
import personajes.Bomberman;

/**
 * 
 */
public class Bombality extends PowerUp
{

    /**
     * Default constructor
     */
    public Bombality(Celda c) {
    	miCelda=c;
    	this.miGrafica= new PowerUpGrafico(miCelda.getFila(),miCelda.getColumna(),miCelda.getEscenario().getGui());
    	Icon imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Bombality.png"));
    	miGrafica.setImagen(imagen);
    }

   
    /**
     * @param b
     */
    public void getPowerUp(Bomberman b) {
        // TODO implement here
    	int cant= b.GetCantBombas();
        b.SetCantBombas(++cant); 
        System.out.println("BOMBALITY: "+cant);
        miCelda.getEscenario().sumarPuntos(puntaje());
        miCelda.setPowerUp(null);
        miGrafica.desaparecer();
    }
    
    public int puntaje(){ return 35;}
      
}

