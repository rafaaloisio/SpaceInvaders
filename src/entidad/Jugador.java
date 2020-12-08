package entidad;

import java.awt.event.KeyEvent;
import java.util.Iterator;

import disparo.*;
import grafica.EntidadGraficaJugador;
import tablero.*;
import visitor.*;


public class Jugador extends Personaje{


	public Jugador(Tablero miTablero, Celda celda, int vida, int golpe) {
		super(miTablero, celda);
		this.vida = vida;
		this.golpe = golpe;
		this.miVisitor = new VisitorJugador(this);
		entidadgrafica = new EntidadGraficaJugador("/recursos/jugador/nave.png");
		entidadgrafica.getImagen().setBounds(x, y, PIXEL, PIXEL);

	}

	@Override
	public void morir() 
	{
		//super.morir();
	}

	@Override
	public void ejecutar() 
	{

	} 

	public void mover() 
	{

	}


	public void mover(int dir) 
	{

		switch (dir){
		case KeyEvent.VK_A : //Izquierda
			this.moverIzq();
			System.out.println("izquierda!");
			break;
		case KeyEvent.VK_D : //Derecha
			this.moverDer();
			System.out.println("derecha!");
			break;
		case KeyEvent.VK_W : //Arriba
			this.moverArr();
			System.out.println("arriba!");
			break;
		case KeyEvent.VK_S : //Abajo
			this.moverAb();
			System.out.println("abajo!");
			break;
		case KeyEvent.VK_SPACE :
			System.out.println("Disparo!");
			this.disparar(this);
			break;
		}


	}

	public void moverIzq() 
	{

		//hace esta comprobaci�n para despues en el else, controlar la colisi�n



		if(x == 0)
			x = miTablero.getColumnas();


		if ( miTablero.getCelda(x - 1 , y).cantEntidades() == 0) {


			miTablero.getCelda(x-1, y).eliminarEntidad(this);

			if(x == 0)
				x = miTablero.getColumnas()-1;
			else
				x = x - 1;

			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.actualizar(miCelda);		
		}else { //else aceptar visitor, porque tuvo una colision
			System.out.println("Chocooooooo");

			Iterator<Entidad> entidadesCelda = miTablero.getCelda(x-1, y).getIteratorEntidades();
			while(entidadesCelda.hasNext()) {
				System.out.println("HAY ENTIDADES");
				entidadesCelda.next().aceptar(miVisitor);		
			}

			miTablero.getCelda(x-1, y).eliminarEntidad(this);

			if(x == 0)
				x = miTablero.getColumnas()-1;
			else
				x = x - 1;

			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);



		}


	}

	public void moverDer() 
	{


		if(x == miTablero.getColumnas()-1)
			x = -1;

		System.out.println("X: "+x);

		if (miTablero.getCelda(x + 1 , y).cantEntidades() == 0) {

			miTablero.getCelda(x+1, y).eliminarEntidad(this);

			if( x + 1 == miTablero.getColumnas() )
				x = 0;
			else
				x = x + 1;


			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.actualizar(miCelda);	

		}else { //else aceptar visitor, porque tuvo una colosi�n
			System.out.println("Chocooooooo");

			Iterator<Entidad> entidadesCelda = miTablero.getCelda(x+1, y).getIteratorEntidades();
			while(entidadesCelda.hasNext()) {
				System.out.println("HAY ENTIDADES");
				entidadesCelda.next().aceptar(miVisitor);		
			}

			miTablero.getCelda(x+1, y).eliminarEntidad(this);

			if( x + 1 == miTablero.getColumnas() )
				x = 0;
			else
				x = x + 1;

			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.getImagen().setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);


		}

	}

	public void moverArr() 
	{
		if (miTablero.getCelda(x  , y - 1).cantEntidades() == 0) {
			miTablero.getCelda(x, y).eliminarEntidad(this);
			y = y - 1;
			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.actualizar(miCelda);		
		}else { //else aceptar visitor, porque tuvo una colosi�n
			System.out.println("Chocooooooo");

			Iterator<Entidad> entidadesCelda = miTablero.getCelda(x, y-1).getIteratorEntidades();
			while(entidadesCelda.hasNext()) {
				System.out.println("HAY ENTIDADES");
				entidadesCelda.next().aceptar(miVisitor);		
			}
		} 

	}

	public void moverAb() 
	{
		if (miTablero.getCelda(x  , y + 1).cantEntidades() == 0) {
			miTablero.getCelda(x, y).eliminarEntidad(this);
			y = y + 1;
			miTablero.getCelda(x, y).agregarEntidad(this);
			miCelda = miTablero.getCelda(x, y);
			entidadgrafica.actualizar(miCelda);		
		}else { //else aceptar visitor, porque tuvo una colosi�n
			System.out.println("Chocooooooo");

			Iterator<Entidad> entidadesCelda = miTablero.getCelda(x, y+1).getIteratorEntidades();
			while(entidadesCelda.hasNext()) {
				System.out.println("HAY ENTIDADES");
				entidadesCelda.next().aceptar(miVisitor);		
			}
		} 

	}


	public Disparo crearDisparo() {

		return new DisparoJugador(miTablero,miCelda,this.getGolpe());
	}

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}


}
