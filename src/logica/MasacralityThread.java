package logica;

import personajes.Bomberman;
import personajes.Enemigo;



public class MasacralityThread extends Thread {
	
	// Logica que implementa al malo.
	private Bomberman bomberman;
	
	
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	// Es volatile porque es accedida desde concurrentemente desde diferentes threads.
	private volatile boolean mDetener;
	
	public MasacralityThread(Bomberman b) {
		this.bomberman  = b;
		mDetener=true;
		
		
	}
	
	@Override
	public void run() {
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
		while(mDetener)
			try {
						Thread.sleep(5000);
						bomberman.SetMasacrality(false);
						mDetener=false;
						System.out.println("Termino Masacrality");
							
			} catch (InterruptedException e) { }
	
	}
	
	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt(); 
		mDetener=true;
	}
	
	
}