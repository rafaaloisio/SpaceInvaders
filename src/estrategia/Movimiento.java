package estrategia;

import disparo.Disparo;
import entidad.Entidad;
import entidad.Premio;
import tablero.Celda;
import tablero.Tablero;

public abstract class Movimiento {

	protected int x, y;
	protected Tablero miTablero;
	protected Celda miCelda;
	protected Entidad miEntidad;
	
	protected Movimiento(Tablero tab, Celda c, Entidad e) {
		this.miEntidad = e;
		this.miTablero = tab;
		this.miCelda = c;
		this.x = c.getX();
		this.y = c.getY();
	}
	
	public abstract boolean puedeMoverse();
	
	public abstract void desplazar();

	public abstract void moverDerecha();

	public abstract void moverIzquierda();
	
	public abstract Disparo disparar();
	
	public abstract Premio generarPremio();
}
