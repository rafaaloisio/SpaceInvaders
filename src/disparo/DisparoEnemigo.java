package disparo;

import java.util.Iterator;

import entidad.*;
import tablero.*;
import visitor.*;


public abstract class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda, golpe);
		this.miVisitor = new VisitorDisparoEnemigo(this);
	}

	public void morir() {
		miTablero.getLogica().eliminarEntidad(this);
	}

	public void ejecutar() {
		mover();
	}

	public void mover() {
		if(y == 11) {
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

				System.out.println("COLISION DISPARO ENEMIGO.");

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
					miCelda = miTablero.getCelda(x, y);
					entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
				}
			}
		}
	}

	public void aceptar(Visitor visitor) {
		visitor.visitDisparoEnemigo(this);
	}


}
