package tablero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import entidad.Entidad;
import entidad.Premio;
import entidad.PremioPocion;

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
		

	  boolean agrego = entidades.add(e);
		
	  if(agrego){
			cantEntidades++;
			System.out.println("AGREGUE: Entidades en celda ("+x+","+y+") :"+cantEntidades);
		}
		
	
	}
	
	public void eliminarEntidad(Entidad entidad) 
	{
		
		boolean elimino = entidades.remove(entidad);
		
		if(elimino) {
			cantEntidades--;
			System.out.println("ELIMINE: Entidades en celda ("+x+","+y+") :"+cantEntidades);
		}
		else
			System.out.println("NO ELIMINO.ELEMENTOS: "+cantEntidades);
		
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
	
	public Iterator<Entidad> getIteratorEntidades()
	{
	
		return entidades.iterator();
		
	}
	

}
