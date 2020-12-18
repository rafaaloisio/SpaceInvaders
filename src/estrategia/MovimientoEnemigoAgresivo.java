package estrategia;

import entidad.*;
import tablero.*;

public class MovimientoEnemigoAgresivo extends MovimientoEnemigo {

	protected MovimientoEnemigoAgresivo(Tablero miTablero, Celda miCelda, Entidad e) {
		super(miTablero, miCelda, e);
	}
	
	
	/*
	public void desplazar() {
		this.posicion.setLocation((int)this.posicion.getX(),(int)this.posicion.getY() + super.getVelocidadEnemigo()*extra);
		if((int)this.posicion.getY() >= alturaFrame) {
			this.posicion.setLocation((int)this.posicion.getX(),0);
		}
	}
	
	*/
	
}
