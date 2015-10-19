package personajes;

import grafica.EntidadGrafica;

import javax.swing.Icon;
import javax.swing.JLabel;

import logica.Logica;
import mapa.Celda;
import mapa.Escenario;

public abstract class Personaje
{
	protected int velocidad=5;
	protected Celda miCelda;
	//protected Logica miLogica;
	protected Escenario miEscenario;
	protected EntidadGrafica miGrafica;
	protected Personaje(Escenario e) 
	{
		this.miEscenario=e;
		this.velocidad=15;
		miGrafica=new EntidadGrafica(this,4);
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
	
	
	
	
}
