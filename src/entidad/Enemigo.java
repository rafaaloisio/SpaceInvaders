package entidad;

import java.util.Random;

import tablero.Celda;
import tablero.Tablero;
import visitor.*;

public abstract class Enemigo extends Personaje{
	
	
	private int tiempo;
	
	public Enemigo(Tablero tablero, Celda celda,int vida,int golpe) {
		super(tablero, celda);
		this.vida = vida;
		this.golpe = golpe;
		
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
			{ 
				Entidad[] entidadesCelda = miTablero.getCelda(x, y+1).getArregloEntidades();
				
				for (int i=0; i < entidadesCelda.length; i++) {
					if (entidadesCelda[i] != null) {
						entidadesCelda[i].aceptar(miVisitor);
					}
				}
				
			
				if (seguirMoviendo) {
	
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
	
	
	public void ejecutar()
	{
		if (tiempo == 5) {

		}
		
		tiempo--;
		
		if (tiempo == 0) {
			tiempo = 5;
			mover();
			disparar(this);
			setSeguirMoviendo(true);
		}
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visitEnemigo(this);
	}
	
	public void morir() {
		
		super.morir();
		
		//hay que ver bien como hacer para que no haya que poner muchos if's a la hora
		//de añadir mas premios
		//imagina que queres agregar un premio nuevo, habria que hacer otro if aca
		Random r = new Random();
		int n = 1; //r.nextInt(2);
		
		if (n == 1) {
			Premio p = new PremioPocion(this.miTablero, this.miCelda);
			miTablero.getLogica().agregarEntidad(p, miCelda);
			p.mover();
		}
	}

	
}
