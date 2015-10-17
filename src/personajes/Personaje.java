package personajes;

import logica.Logica;
import mapa.Celda;
import mapa.Escenario;

public abstract class Personaje
{
	protected int velocidad=5;
	protected Celda miCelda;
	protected Logica miLogica;
	protected Escenario miEscenario;
	
	
	protected Personaje(Escenario e) 
	{
		this.miEscenario=e;
	}
	public void setPosicion(Celda c) {
		this.miCelda=c;
	}
	
	
	public Celda getPosicion() {
		return miCelda;
	}
	
	protected void mover(int dir){
		//Celda next = this.pos.getVecina(dir);
		//
		//if(next != null){
		//	this.pos = next;
		//	this.grafico.mover(dir);
		//}
	}
	
	
}
