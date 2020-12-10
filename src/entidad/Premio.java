package entidad;

import tablero.Celda;
import tablero.Tablero;
import visitor.Visitor;
import visitor.VisitorPremioPocion;

public abstract class Premio extends Entidad {
	
	protected boolean seguirMoviendo;

	public Premio(Tablero tablero, Celda celda) {
		super(tablero, celda);
		seguirMoviendo = true;
		this.miVisitor = new VisitorPremioPocion(this);
		
	}

	protected abstract void hacerEfecto(Jugador j);
	
	@Override
	public void ejecutar() {
//		hacerEfecto();
	}

	@Override
	//el premio se va a mover hacia abajo hasta desaparecer por debajo del mapa
	// o bien cuando colisione con el jugador (y ahi el jugador consume su efecto q va a depender del tipo de premio)
	//para hacer este metodo me basé en el de Enemigo
	public void mover() {
		if (miTablero.getCelda(x, y+1).cantEntidades() == 0) {
			
			miTablero.getCelda(x, y).eliminarEntidad(this);
			
			if (y+1 != miTablero.getFilas()-1) {
				y= y+1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);
			}
			else {
				morir();
			}
			
		}
		else {
			//colision
			Entidad[] entidadesCelda = miTablero.getCelda(x, y+1).getArregloEntidades();
			
			for (int i=0; i < entidadesCelda.length; i++) {
				if (entidadesCelda[i] != null) {
					entidadesCelda[i].aceptar(miVisitor);
				}
			}
			
			if (seguirMoviendo) {
				//para que sigan moviendo todos los premios
				miTablero.getCelda(x, y).eliminarEntidad(this);	
				if (y+1 != miTablero.getFilas()-1) {
					y= y+1;
					miTablero.getCelda(x, y).agregarEntidad(this);
					miCelda = miTablero.getCelda(x, y);
					entidadgrafica.actualizar(miCelda);
				}		
			}
		}
	}

	@Override
	public void aceptar(Visitor visitor) {
		visitor.visitPremio(this);
	}
}
