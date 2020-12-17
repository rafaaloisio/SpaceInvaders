package estrategia;

import tablero.Celda;
import tablero.Tablero;

public class MovimientoEnemigoAgresivo extends MovimientoEnemigo {

	protected MovimientoEnemigoAgresivo(Tablero tab, Celda c) {
		super(tab, c);
	}
	
	public void desplazar() {
		this.posicion.setLocation((int)this.posicion.getX(),(int)this.posicion.getY() + super.getVelocidadEnemigo()*extra);
		if((int)this.posicion.getY() >= alturaFrame) {
			this.posicion.setLocation((int)this.posicion.getX(),0);
		}
	}
	
}
