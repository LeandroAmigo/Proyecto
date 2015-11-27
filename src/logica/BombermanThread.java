package logica;

import personajes.Bomberman;
import personajes.Enemigo;



public class BombermanThread extends Thread {
	
	// Logica que implementa al malo.
	private Bomberman bomberman;
	private boolean mover;
	private int direccion;
	
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	// Es volatile porque es accedida desde concurrentemente desde diferentes threads.
	private volatile boolean mDetener;
	
	public BombermanThread(Bomberman b) {
		this.bomberman  = b;
		this.mover = false;
		direccion=1;
	}
	
	@Override
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.mDetener){
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				if(mover)
				{
					switch (direccion) {
					case CONSTANTES.B_MirarArriba : //Movimiento arriba
					   		
						bomberman.getGraficos().SetImagen(CONSTANTES.B_MirarArriba, bomberman);
						
						
						break;
					case CONSTANTES.B_MirarAbajo ://movimiento abajo
						
				    	bomberman.getGraficos().SetImagen(CONSTANTES.B_MirarAbajo, bomberman);
				    	
							
							
						break;
					case CONSTANTES.B_MirarIzquierda ://movimiento izquierda
						
						bomberman.getGraficos().SetImagen(CONSTANTES.B_MirarIzquierda, bomberman);
							
						
							break;
					case CONSTANTES.B_MirarDerecha ://movimiento derecha
						
						bomberman.getGraficos().SetImagen(CONSTANTES.B_MirarDerecha, bomberman);
						
						
						break;
				}
				mover=false;
				}
				else
					Thread.sleep(50);
							
			} catch (InterruptedException e) { }
		}
	}
	
	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt(); 
		
		// Seteamos el flag para detener su ejecución.
		this.mDetener = true;
	}
	
	public void moverse(boolean m)
	{
		mover=m;
	}
	public void Setdireccion(int dir)
	{
		direccion=dir;
	}
	public boolean puedeMoverse()
	{
		return !mover;
	}
}