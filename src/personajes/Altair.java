package personajes;

import java.util.*;

import javax.swing.ImageIcon;

import mapa.Escenario;

/**
 * 
 */
public class Altair extends Enemigo{

    
    /**
     * @param e
     */
    public Altair(Escenario e) {
        // TODO implement here
    	super(e);
    	
    	this.miGrafica.setImagen(new ImageIcon(this.getClass().getResource("/Imagenes/enemigo.png")));
    	
    }

    /**
     * @return
     */
    public Boolean atraviesaPared() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void mover() {
        // TODO implement here
    	Random rnd = new Random();
		int dir = rnd.nextInt(4);
		
		switch (dir) {
			case 0 : //Movimiento arriba
				//this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y - this.mVelocidad);
				miEscenario.getLogica().MoverArriba(miCelda, this);
				break;
			case 1 ://movimiento abajo
				//this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y + this.mVelocidad);
				miEscenario.getLogica().MoverAbajo(miCelda, this);
				break;
			case 2 ://movimiento izquierda
				//this.mPosicion.setLocation(this.mPosicion.x - this.mVelocidad, this.mPosicion.y);
				miEscenario.getLogica().MoverIzquierda(miCelda, this);
				break;
			case 3 ://movimiento derecha
				//this.mPosicion.setLocation(this.mPosicion.x + this.mVelocidad, this.mPosicion.y);
				miEscenario.getLogica().MoverDerecha(miCelda, this);
				break;
		}
		
		//super.mover(dir);
    }

    /**
     * 
     */
    public void morir(){};
}