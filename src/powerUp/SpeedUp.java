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
public class SpeedUp extends PowerUp{

    /**
     * Default constructor
     */
    public SpeedUp(Celda c) 
    {
    	miCelda=c;
    	this.miGrafica= new PowerUpGrafico(miCelda.getFila(),miCelda.getColumna(),miCelda.getEscenario().getGui());
    	Icon imagen = new ImageIcon(this.getClass().getResource("/Imagenes/SpeedUp.png"));
    	miGrafica.setImagen(imagen);
    }

    /**
     * @param b
     */
    public void getPowerUp(Bomberman b){
    	int v= b.getVelocidad();
    	b.SetVelocidad(2*v);
    	miCelda.getEscenario().sumarPuntos(puntaje());
        miCelda.setPowerUp(null);
        miGrafica.desaparecer();
    }
    
    public int puntaje(){return 30;}

}


