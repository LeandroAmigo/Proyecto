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
public class Fatality extends PowerUp {

    /**
     * Default constructor
     */
    public Fatality(Celda c) {
    	miCelda=c;
    	this.miGrafica= new PowerUpGrafico(miCelda.getFila(),miCelda.getColumna(),miCelda.getEscenario().getGui());
    	Icon imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Fatality.png"));
    	miGrafica.setImagen(imagen);
    }
 
    /**
     * @param b
     */
    public void getPowerUp(Bomberman b){
    	 int alcance = b.GetAlcanceBomba() ;
         b.SetAlcanceBomba(alcance*2);
         miCelda.getEscenario().sumarPuntos(puntaje());
         miCelda.setPowerUp(null);
         miGrafica.desaparecer();
    }
    
public int puntaje(){ return 35;}
    
    

}