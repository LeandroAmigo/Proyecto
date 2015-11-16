package personajes;

import logica.MaloThread;
import mapa.Escenario;

public abstract class Enemigo extends Personaje {
	protected MaloThread miHilo;
	protected Enemigo(Escenario e){
		super(e);
	}
	public void mover(){};
	

}
