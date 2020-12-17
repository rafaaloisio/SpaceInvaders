package entidad;

import java.awt.event.KeyEvent;
import java.util.Iterator;

import disparo.*;
import estrategia.MovimientoEnemigo;
import grafica.EntidadGraficaJugador;
import tablero.*;
import visitor.*;


public class Jugador extends Personaje{

	private final int MAXIMA_VIDA = 50000;
	private final int MAXIMO_GOLPE = 50;
	
	public Jugador(Tablero miTablero, Celda celda) {
		super(miTablero, celda);
		this.vida = MAXIMA_VIDA;
		this.golpe = MAXIMO_GOLPE;
		this.miVisitor = new VisitorJugador(this);
		entidadgrafica = new EntidadGraficaJugador("/recursos/jugador/nave.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);
		this.movimiento = new MovimientoEnemigo(this.miTablero, this.miCelda, this);
	}
	
	public void consumirPremio(Premio p) {
		p.hacerEfecto(this);
	}

	@Override
	public void morir() 
	{
		
		
		//detengo el hilo al perder
		miTablero.getLogica().setPerdi(true);
		
		this.vida = 0;
		super.morir();
		
		System.err.println("EL JUGADOR PERDIÓ.");
		
		
		
	}

	@Override
	public void ejecutar() 
	{
//		if(miTablero.getCelda(x, y).cantEntidades()>1)
//		{	
//			System.out.println("ME FIJE.");
//			
//			Entidad[] entidadesCelda = miTablero.getCelda(x, y).getArregloEntidades();
//			
//			for (int i=0; i < entidadesCelda.length; i++) {
//				if (entidadesCelda[i] != null) {
//					entidadesCelda[i].aceptar(miVisitor);
//				}
//			}
//		}	
	} 

	public void mover() 
	{

	}


	public void mover(int dir) 
	{

		switch (dir){
		case KeyEvent.VK_A : //Izquierda
			this.moverIzq();
			break;
		case KeyEvent.VK_D : //Derecha
			this.moverDer();
			break;
	/*		
		case KeyEvent.VK_W : //Arriba
			this.moverArr();
			break;
		case KeyEvent.VK_S : //Abajo
			this.moverAb();
			break;
	*/		
		case KeyEvent.VK_SPACE :
			this.disparar(this);
			break;
		}

	}

	public void moverIzq() 
	{
		if (miTablero.getCelda(x-1, y) != null) {
			
			if (miTablero.getCelda(x-1, y).cantEntidades() == 0) {
				
				miTablero.getCelda(x, y).eliminarEntidad(this);
				x = x - 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
				
			}else { //else aceptar visitor, porque tuvo una colosion

				Entidad[] entidadesCelda = miTablero.getCelda(x-1, y).getArregloEntidades();
				
				for (int i=0; i < entidadesCelda.length; i++) {
					
					if (entidadesCelda[i] != null) {
						System.err.println(entidadesCelda[i].toString());
						entidadesCelda[i].aceptar(miVisitor);
					}
				}
				
				//si no se hace esto,la nave queda en el lugar, pero impacta en el lugar al que se movió.
				miTablero.getCelda(x, y).eliminarEntidad(this);
				x = x - 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
				
			} 
		}
	}

	public void moverDer() 
	{
		if (miTablero.getCelda(x+1, y) != null) {
			
			if (miTablero.getCelda(x+1, y).cantEntidades() == 0) {
				
				miTablero.getCelda(x, y).eliminarEntidad(this);
				x = x + 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
				
			}else { //else aceptar visitor, porque tuvo una colosion

				Entidad[] entidadesCelda = miTablero.getCelda(x+1, y).getArregloEntidades();

				for (int i=0; i < entidadesCelda.length; i++) {
					if (entidadesCelda[i] != null) {
						System.err.println(entidadesCelda[i].toString());
						entidadesCelda[i].aceptar(miVisitor);
					}
				}
				
				//si no se hace esto,la nave queda en el lugar, pero impacta en el lugar al que se movió.

				miTablero.getCelda(x, y).eliminarEntidad(this);
				x = x + 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
				
				
				
			} 
		}

	}

	public void moverArr() 
	{
		if (miTablero.getCelda(x  , y - 1) != null) {
			if (miTablero.getCelda(x  , y - 1).cantEntidades() == 0) {
				miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y - 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}else { //else aceptar visitor, porque tuvo una colosi�n

				Entidad[] entidadesCelda = miTablero.getCelda(x, y-1).getArregloEntidades();

				for (int i=0; i < entidadesCelda.length; i++) {
					if (entidadesCelda[i] != null) {
						System.err.println(entidadesCelda[i].toString());
						entidadesCelda[i].aceptar(miVisitor);
					}
				}
			} 
		}

	}

	public void moverAb() 
	{
		if (miTablero.getCelda(x  , y + 1) != null) {
			if (miTablero.getCelda(x  , y + 1).cantEntidades() == 0) {
				miTablero.getCelda(x, y).eliminarEntidad(this);
				y = y + 1;
				miTablero.getCelda(x, y).agregarEntidad(this);
				miCelda = miTablero.getCelda(x, y);
				entidadgrafica.actualizar(miCelda);		
			}else { //else aceptar visitor, porque tuvo una colosi�n
				Entidad[] entidadesCelda = miTablero.getCelda(x, y+1).getArregloEntidades();

				for (int i=0; i < entidadesCelda.length; i++) {
					if (entidadesCelda[i] != null) {
						System.err.println(entidadesCelda[i].toString());
						entidadesCelda[i].aceptar(miVisitor);
					}
				}
			} 
		}
	}
	
	//crea disparo en la siguiente celda
	public Disparo crearDisparo() {

		//esto genera disparos fantasma cuando se disparan
//		return new DisparoJugador(miTablero,miTablero.getCelda(miCelda.getX(), miCelda.getY()-1),this.getGolpe());
		Disparo toReturn = new DisparoJugador(miTablero,miTablero.getCelda(miCelda.getX(), miCelda.getY()),this.getGolpe());
		if (this.golpe > this.MAXIMO_GOLPE) {
			this.golpe = this.MAXIMO_GOLPE;
		}
		return toReturn;
	}

	public void aceptar(Visitor visitor) {
		visitor.visitJugador(this);
	}


}
