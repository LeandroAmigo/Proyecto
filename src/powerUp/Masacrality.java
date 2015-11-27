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
public class Masacrality extends PowerUp{

    /**
     * Default constructor
     */
    public Masacrality(Celda c) {
    	miCelda=c;
    	this.miGrafica= new PowerUpGrafico(miCelda.getFila(),miCelda.getColumna(),miCelda.getEscenario().getGui());
    	Icon imagen = new ImageIcon(this.getClass().getResource("/Imagenes/Masacrality.png"));
    	miGrafica.setImagen(imagen);
    
    }
    /**
     * @param b
     */
    public void getPowerUp(Bomberman b){
    	System.out.println("MASACRALITY");
    	miCelda.getEscenario().sumarPuntos(50);
    	miCelda.setPowerUp(null);
    	
    	b.SetMasacrality(true);    	
    	miGrafica.desaparecer();
    }
    
}