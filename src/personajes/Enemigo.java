package personajes;

import mapa.Escenario;

public abstract class Enemigo extends Personaje {
	
	protected Enemigo(Escenario e){
		super(e);
	}
	public void mover(){};
	

}
