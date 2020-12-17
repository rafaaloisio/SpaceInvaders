package entidad;

import tablero.Celda;
import tablero.Tablero;
import visitor.Visitor;

public abstract class Premio extends Entidad {
	

	protected Premio(Tablero tablero, Celda celda) {
		super(tablero, celda);
	}

	protected abstract void hacerEfecto(Jugador j);
	
	@Override
	public void ejecutar() {
		mover();
	}

	@Override
	public void mover() {
		
		if(y == miTablero.getFilas()-1) {
			morir();
		}
		else {
			if(miTablero.getCelda(x , y+1).cantEntidades()==0 ) {
				miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y + 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL,PIXEL,PIXEL);
			}
			else {
				Entidad[] entidadesCelda = miTablero.getCelda(x, y+1).getArregloEntidades();
				for (int i=0; i < entidadesCelda.length; i++) {
					if (entidadesCelda[i] != null) {
						System.err.println(entidadesCelda[i].toString());
						entidadesCelda[i].aceptar(miVisitor);
					}
				}

				miTablero.getCelda(x, y).eliminarEntidad(this);
				if (seguirMoviendo) {	
					y = y + 1;
					miTablero.getCelda(x, y).agregarEntidad(this);
					miCelda = miTablero.getCelda(x, y);
					entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
				}
			}
		}
	}

}
