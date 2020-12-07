package disparo;

import mapa.*;
import entidad.*;


public abstract class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda, golpe);
		// TODO Auto-generated constructor stub
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
				Entidad [] entidadesArreglo = miTablero.getCelda(x, y+1).getArregloEntidades();
				int pos=0;
				while(entidadesArreglo[pos]!=null) {
					//entidadesArreglo[pos].aceptar(miVisitor);
                    pos++;					
				}
				miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y + 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
				
			}
		}
	}

	/*
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
	
	*/

}
