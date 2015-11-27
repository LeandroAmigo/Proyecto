package personajes;

import grafica.EntidadGrafica;

import javax.swing.Icon;
import javax.swing.JLabel;

import logica.Logica;
import mapa.Celda;
import mapa.Escenario;

public abstract class Personaje
{	
	protected Thread miHilo;
	protected int velocidad;
	protected Celda miCelda;
	protected Escenario miEscenario;
	protected EntidadGrafica miGrafica;
	protected Personaje(Escenario e) 
	{
		this.miEscenario=e;
		this.velocidad=1;
			
	}
	
	public void setPosicion(Celda c) {
		this.miCelda=c;
	}
	
	
	public Celda getPosicion() {
		return miCelda;
	}
	public abstract void morir();
	
	
	protected void mover(int dir)
	{	}
	
	public EntidadGrafica getGraficos()
	{
		return miGrafica;
	}
	
	 public int getVelocidad()
	    {
	    	return this.velocidad;
	    }
	
	public boolean atraviesaPared()
	{
		return false;
	}
	
	public Thread getHilo(){return miHilo;}
	
}
