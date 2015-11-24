package powerUp;

import grafica.PowerUpGrafico;
import personajes.Bomberman;
import mapa.Celda;

public abstract class PowerUp
{	PowerUpGrafico miGrafica;
	Celda miCelda;
	protected PowerUp(){};
	public Celda getCelda()
	{
		return miCelda;
	}
	public void  setCelda(Celda c)
	{
		this.miCelda=c;
	}
	
	public abstract void getPowerUp(Bomberman b);
	
	public PowerUpGrafico getGrafico()
    {
		if(miGrafica==null)
			System.out.println("GRAFICA NULA EN POWER UP");
		return miGrafica;
		
	} 
	
	
}
