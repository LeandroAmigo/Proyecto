package logica;

import mapa.Escenario;


public class TiempoThread extends Thread {
	// Flag que indica cuando debe detenerse la ejecución del hilo.
	// Es volatile porque es accedida desde concurrentemente desde diferentes threads.
	private volatile boolean mDetener;
	private Escenario es;
	public TiempoThread(Escenario e) {
		mDetener=false;
		es=e;
		
	}
	
	@Override
	public void run() {
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
		while(!mDetener)
			try {
						Thread.sleep(1000);
						es.SumarUnSegundo();
				} catch (InterruptedException e) { }
	
	}
	
	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt(); 
		mDetener=true;
	}
	
	
}