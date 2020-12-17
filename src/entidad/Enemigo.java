package entidad;

import java.awt.event.KeyEvent;
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
		this.tiempo = 4;
	}

	public void ejecutar()
	{
		if (tiempo == 4) {
			disparar(this);
		}
		
		tiempo--;
		
		if (tiempo == 0) {
			tiempo = 4;
			mover();
		}
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
	
	
	
	public void morir() {
		
		super.morir();
		
		//hay que ver bien como hacer para que no haya que poner muchos if's a la hora
		//de añadir mas premios
		//imagina que queres agregar un premio nuevo, habria que hacer otro if aca
		//asi que creo que hay que usar un patron de diseño
		
		
		//creo que con este switch se solucina lo descripto arriba
		int n = new Random().nextInt(10)+1;
		
		switch (n){
		
		case 1 : //premio pocion vida
			
			System.out.println("SOLTE PREMIO VIDA.");		
			Premio pv = new PremioPocion(this.miTablero, this.miCelda);
			miTablero.getLogica().agregarEntidad(pv, miCelda);
			pv.mover();
			break;
			
		case 2 : //premio pocion congelar
			
			System.out.println("SOLTE PREMIO CONGELAR.");		
			Premio pc = new PremioCongelamiento(this.miTablero, this.miCelda);
			miTablero.getLogica().agregarEntidad(pc, miCelda);
			pc.mover();
			break;

		case 3 : //premio pocion fuerza
			
			System.out.println("SOLTE PREMIO FUERZA.");		
			Premio pf = new PremioSuperArma(this.miTablero, this.miCelda);
			miTablero.getLogica().agregarEntidad(pf, miCelda);
			pf.mover();
			break;
			
		}
		
	}


	public int getTiempo() {
		return tiempo;
	}


	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	
}
