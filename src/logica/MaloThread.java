package logica;

import personajes.Enemigo;



public class MaloThread extends Thread {
	
	// Logica que implementa al malo.
	private Enemigo enemigo;
	
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	// Es volatile porque es accedida desde concurrentemente desde diferentes threads.
	private volatile boolean mDetener;
	
	public MaloThread(Enemigo enemigo) {
		this.enemigo  = enemigo;
		this.mDetener = false;
	}
	
	@Override
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.mDetener){
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				
				
				// Realizo el movimiento
				this.enemigo.mover();
				
				Thread.sleep(2000);
				
			} catch (InterruptedException e) { }
		}
	}
	
	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt(); 
		
		// Seteamos el flag para detener su ejecución.
		this.mDetener = true;
	}
	public void dormir(int a) throws InterruptedException
	{
		this.sleep(a);
	}
	
}