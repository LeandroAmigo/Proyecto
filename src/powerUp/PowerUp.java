package powerUp;

import personajes.Bomberman;
import mapa.Celda;

public abstract class PowerUp
{	
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
	abstract void getPowerUp(Bomberman b);
	
}
