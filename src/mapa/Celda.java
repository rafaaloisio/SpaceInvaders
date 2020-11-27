package mapa;

import java.util.LinkedList;

import entidad.Entidad;

public class Celda 
{
	
	protected int x;
	protected int y;
	
	protected Tablero tablero;
	
	protected LinkedList<Entidad> entidades;
	protected int cantEntidades;
	
	public Celda (Tablero tablero, int x, int y) 
	{
		this.tablero = tablero;
		this.x = x;
		this.y = y;
		
		entidades = new LinkedList<Entidad>();
		cantEntidades=0;
		
	}
	
	public int getX() 
	{
		return this.x;
	}
	
	public int getY() 
	{
		return this.y;
	}

	public int cantEntidades() {
		return cantEntidades;
	}
	
	public void agregarEntidad(Entidad e) 
	{
	  entidades.add(e);
	  cantEntidades++;
	}
	
	public void eliminarEntidad(Entidad entidad) 
	{
		entidades.remove(entidad);
		cantEntidades--;
	}
	
	public LinkedList<Entidad> getEntidades()
	{
		return entidades;
	}
	
	public Entidad[] getArregloEntidades()
	{
		Entidad [] entidadesArreglo = new Entidad[100];
		int pos=0;
		
		for(Entidad e: entidades) {
		  entidadesArreglo[pos]=e;
		  pos++;
		}
		
		return entidadesArreglo;
	}
	

}
