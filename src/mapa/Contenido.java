package mapa;


import grafica.PanelEscenario;
import grafica.ParedGrafica;
import personajes.Personaje;

/**
 * 
 */
public abstract class Contenido {
	protected ParedGrafica miGrafica;	
	protected PanelEscenario miPanel;
    public abstract void Recibir(Celda c,Personaje p);
    public abstract void Destruir(Celda c);
       
}