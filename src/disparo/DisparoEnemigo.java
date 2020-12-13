package disparo;


import entidad.*;
import tablero.*;
import visitor.*;


public abstract class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(Tablero miTablero, Celda miCelda, int golpe) {
		super(miTablero, miCelda, golpe);
		this.miVisitor = new VisitorDisparoEnemigo(this);

	}

	public void morir() {
		
		seguirMoviendo = false;
		miTablero.getCelda(x, y).eliminarEntidad(this);
		
		miTablero.getLogica().eliminarEntidad(this);
	}

	public void ejecutar() {
		mover();
	}

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

	public void aceptar(Visitor visitor) {
		visitor.visitDisparoEnemigo(this);
	}


}
