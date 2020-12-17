package estrategia;

import disparo.Disparo;
import entidad.Entidad;
import entidad.Premio;
import tablero.Celda;
import tablero.Tablero;

public class MovimientoEnemigo extends Movimiento {

	public MovimientoEnemigo(Tablero tab, Celda c, Entidad e) {
		super(tab, c, e);
	}

	@Override
	public boolean puedeMoverse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void desplazar() {
		if (miTablero.getCelda(x , y + 1).cantEntidades() == 0) {


			miTablero.getCelda(x, y).eliminarEntidad(this.miEntidad);	

			if( y + 1 == miTablero.getFilas()-1 )
				y = 0;
			else
				y = y + 1;

			miTablero.getCelda(x, y).agregarEntidad(this.miEntidad);
			miCelda = miTablero.getCelda(x, y);
			this.miEntidad.getEntidadGrafica().actualizar(miCelda);		
		}
		else
		{
			Entidad[] entidadesCelda = miTablero.getCelda(x, y+1).getArregloEntidades();

			for (int i=0; i < entidadesCelda.length; i++) {
				if (entidadesCelda[i] != null) {
					entidadesCelda[i].aceptar(this.miEntidad.getVisitor());
				}
			}


//			if (seguirMoviendo) {
//
//				miTablero.getCelda(x, y).eliminarEntidad(this);	
//
//				if( y + 1 == miTablero.getFilas()-1 )
//					y = 0;
//				else
//					y = y + 1;
//
//				miTablero.getCelda(x, y).agregarEntidad(this);
//				miCelda = miTablero.getCelda(x, y);
//				entidadgrafica.actualizar(miCelda);		
//
			}
		}

		@Override
		public void moverDerecha() {
			// TODO Auto-generated method stub

		}

		@Override
		public void moverIzquierda() {
			// TODO Auto-generated method stub

		}

		@Override
		public Disparo disparar() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Premio generarPremio() {
			// TODO Auto-generated method stub
			return null;
		}

	}
