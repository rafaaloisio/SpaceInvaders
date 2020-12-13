package entidad;

import tablero.Celda;
import tablero.Tablero;
import visitor.Visitor;
import visitor.VisitorPremioPocion;

public abstract class Premio extends Entidad {
	

	public Premio(Tablero tablero, Celda celda) {
		super(tablero, celda);
		this.miVisitor = new VisitorPremioPocion(this);
		
	}

	protected abstract void hacerEfecto(Jugador j);
	
	@Override
	public void ejecutar() {
		mover();
	}

	@Override
	//el premio se va a mover hacia abajo hasta desaparecer por debajo del mapa
	// o bien cuando colisione con el jugador (y ahi el jugador consume su efecto q va a depender del tipo de premio)
	public void mover() {
		
		if(y == 11) {
			
			miTablero.getCelda(x, y).eliminarEntidad(this);
			morir();
		}
		else {
			if(miTablero.getCelda(x , y+1).cantEntidades()==0 ) {
				
				miTablero.getCelda(x, y).eliminarEntidad(this);
				
				y = y + 1;
				
				miTablero.getCelda(x, y).agregarEntidad(this);
				
				entidadgrafica.actualizar(miTablero.getCelda(x, y));
				
			}
			else {


				Entidad[] entidadesCelda = miTablero.getCelda(x, y+1).getArregloEntidades();
				
				for (int i=0; i < entidadesCelda.length; i++) {
					if (entidadesCelda[i] != null) {
						entidadesCelda[i].aceptar(miVisitor);
					}
				}


				miTablero.getCelda(x, y).eliminarEntidad(this);
				
				if (seguirMoviendo) {	
					
					y = y + 1;
					miTablero.getCelda(x, y).agregarEntidad(this);
					
					entidadgrafica.actualizar(miTablero.getCelda(x, y));
				}
			}
		}
	}

	@Override
	public void aceptar(Visitor visitor) {
		visitor.visitPremio(this);
	}
}
