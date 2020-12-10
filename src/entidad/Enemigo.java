package entidad;

import java.util.Random;

import tablero.Celda;
import tablero.Tablero;
import visitor.*;

public abstract class Enemigo extends Personaje{
	
	private boolean seguirMoviendo;
	private int tiempo;
	
	public Enemigo(Tablero tablero, Celda celda,int vida,int golpe) {
		super(tablero, celda);
		this.vida = vida;
		this.golpe = golpe;
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
			
			
			Entidad[] entidadesCelda = miTablero.getCelda(x, y+1).getArregloEntidades();
			
			for (int i=0; i < entidadesCelda.length; i++) {
				if (entidadesCelda[i] != null) {
					System.out.println("HAY ENTIDADES");
					entidadesCelda[i].aceptar(miVisitor);
				}
			}
			
			/*
			while(entidadesCelda.hasNext()) {
				System.out.println("HAY ENTIDADES");
				entidadesCelda.next().aceptar(miVisitor);		
			}
			*/
		
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
		visitor.visitEnemigo(this);
	}
	
	public void morir() {
		super.morir();
		
		Random r = new Random();
		int n = r.nextInt(2);
		
		if (n == 1) {
			Premio p = new PremioPocion(this.miTablero, this.miCelda);
			miTablero.getLogica().agregarEntidad(p, miCelda);
			p.mover();
		}
	}

	
}
