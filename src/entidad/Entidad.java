package entidad;

import grafica.EntidadGrafica;
import tablero.*;
import visitor.*;


public abstract class Entidad {
	
	public static final int PIXEL = 64;
	
	protected Celda miCelda;
	protected Tablero miTablero;
	protected EntidadGrafica entidadgrafica;
	protected int x;
	protected int y;
	protected int golpe;
	protected int vida;
	
	protected Visitor miVisitor;
	
	public Entidad(Tablero tablero, Celda celda)
	{
		this.x = celda.getX();
		this.y = celda.getY();
		miCelda = celda;
		miTablero = tablero;
	}
	

	/**
	 * La entidad muere
	 */
	public void morir() {
		miTablero.getLogica().eliminarEntidad(this);
	}
	/**
	 * La entidad ejecuta una acci�n
	 */
	public abstract void ejecutar();

	/**
	 * La entidad se mueve
	 */
	public abstract void mover();
	
	public abstract void aceptar(Visitor visitor);

	public void setCelda(Celda c) 
	{
		miCelda = c;
	}

	public Celda getCelda() 
	{
		return miCelda;
	}


	public void setX(int x) 
	{
		this.x = x;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public int getX() 
	{
		return x;
	}

	public int getY() 
	{
		return y;
	}


	public void setGolpe(int golpe) 
	{
		this.golpe = golpe;
	}

	public int getGolpe() 
	{
		return golpe;
	}

	public int getVida() 
	{
		return vida;
	}

	public void setVida(int vida) 
	{
		this.vida = vida;
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return entidadgrafica;
	}

	public void setEntidadGrafica(EntidadGrafica e) {
		this.entidadgrafica = e;
	}
	
}
