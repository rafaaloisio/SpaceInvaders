package hilos;

import logica.Logica;

public class HiloEntidades extends Thread {
	protected Logica miLogica;
	
	
	public HiloEntidades(Logica miLogica) {
		super();
		this.miLogica = miLogica;
	}
	
	/*
	 *  Cuando el jugador pierde la partida, finaliza la ejecucion del hilo.
	 */
	
	
	public void run() {
		while (!miLogica.isPerdi()) {
			try {
				Thread.sleep(250);
				miLogica.ejecutarEntidades();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}