package disparo;

import entidad.*;
import grafica.EntidadGraficaJugador;
import tablero.*;
import visitor.*;

public class DisparoJugador extends Disparo {

	public DisparoJugador(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda, golpe);
		this.miVisitor = new VisitorDisparoJugador(this);
		entidadgrafica = new EntidadGraficaJugador("/recursos/jugador/disparo.png");
	}

	public void ejecutar() {
		mover();
	}

	public void mover() {

		if (y == 0) {
			miTablero.getCelda(x, y).eliminarEntidad(this);
			morir();
		} else {
			if (miTablero.getCelda(x, y-1).cantEntidades() == 0) {
				
				miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y - 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				entidadgrafica.actualizar(miTablero.getCelda(x, y));
				
			} else {

				System.out.println("COLISION DISPARO JUGADOR.");

				Entidad[] entidadesCelda = miTablero.getCelda(x, y-1).getArregloEntidades();
				for (int i=0; i < entidadesCelda.length; i++) {

					if (entidadesCelda[i] != null) {
						System.out.println("HAY ENTIDADES");
						entidadesCelda[i].aceptar(miVisitor);
					}
				}
			

				miTablero.getCelda(x, y).eliminarEntidad(this);

				if (seguirMoviendo) {
					y = y - 1;
					miTablero.getCelda(x, y).agregarEntidad(this);
					entidadgrafica.actualizar(miTablero.getCelda(x, y));
				}
			}
		}
	}



	public void setSeguirMoviendo(boolean b) {
		seguirMoviendo = b;
	}


	public void aceptar(Visitor visitor) {
		visitor.visitDisparoJugador(this);
	}



}