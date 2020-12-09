package entidad;

import java.util.Iterator;

import tablero.Celda;
import tablero.Tablero;
import visitor.*;

public abstract class Enemigo extends Personaje{
	
	
	boolean seguirMoviendo;
	int tiempo;
	
	public Enemigo(Tablero tablero, Celda celda,int vida,int golpe) {
		super(tablero, celda);
		seguirMoviendo = true;
		this.tiempo = 3;
		this.miVisitor = new VisitorEnemigo(this);
	}

	
	@Override
	public void mover()
	{
		if (miTablero.getCelda(x , y + 1).cantEntidades() == 0) {
		 	
			 
		 	miTablero.getCelda(x, y).eliminarEntidad(this);	
		 	
		 	if( y + 1 == miTablero.getFilas()-1 )
				y = 0;
			else
				y = y + 1;
		 	
			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.actualizar(miCelda);		
		}else
		{ //entonces hay una colision
			
			Iterator<Entidad> entidadesCelda = miTablero.getCelda(x, y+1).getIteratorEntidades();
			while(entidadesCelda.hasNext()) {
				System.out.println("HAY ENTIDADES");
				entidadesCelda.next().aceptar(miVisitor);		
			}
		
			if (seguirMoviendo) {
				//para que sigan moviendo todos los enemigos
				miTablero.getCelda(x, y).eliminarEntidad(this);	
				if( y + 1 == miTablero.getFilas()-1 )
					y = 0;
				else
					y = y + 1;
				
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}
		}
		
	}
	
	public void seguirMoviendo(boolean seguirMoviendo) {
		this.seguirMoviendo = seguirMoviendo;
	}
	
	public void ejecutar()
	{
		if (tiempo == 5) {
			/*
			
			
			if (x < miTablero.getColumnas()) {
				
				for (int i = 0; i < miTablero.getFilas() ; i++) {
					Entidad [] entidadesArreglo = miTablero.getCelda(miTablero.getColumnas() - i, y).getArregloEntidades();
					int pos=0;
					
					
					
					while(entidadesArreglo[pos]!=null) {
						entidadesArreglo[pos].aceptar(miVisitor);
		                pos++;					
					}
					
					
				}
			
			
			} */
		}
		
		tiempo--;
		
		if (tiempo == 0) {
			tiempo = 5;
			mover();
			disparar(this);
			this.seguirMoviendo(true);
		}
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

	
}
