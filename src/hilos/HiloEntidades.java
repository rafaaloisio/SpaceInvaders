package hilos;

import logica.Logica;

public class HiloEntidades extends Thread {
	protected Logica miLogica;
	protected boolean perder;
	
	public HiloEntidades(Logica miLogica) {
		super();
		this.miLogica = miLogica;
		perder = false;
	}
	
	/*
	 *  Cuando el jugador pierde la partida, finaliza la ejecucion del hilo.
	 */
	public void perder() {
		perder = true;
	}
	
	public void run() {
		while (!perder) {
			try {
				Thread.sleep(400);
				miLogica.ejecutarEntidades();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}