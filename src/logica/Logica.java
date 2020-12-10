package logica;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedDeque;

import GUI.GUI;
import entidad.Entidad;
import entidad.*;
import hilos.HiloEntidades;
import tablero.*;

public class Logica {

	protected Collection<Entidad> misEntidades;
	
	protected HiloEntidades hiloEntidades;
	protected GUI grafica;

	protected Tablero tablero;
	

	public Logica(GUI grafica) 
	{
		this.grafica = grafica;
		misEntidades = new ConcurrentLinkedDeque<Entidad>();

		this.tablero = new Tablero(this);
		//cargarOleada();
		crearHilos();
	}
	
	
	public void crearHilos() 
	{
		hiloEntidades = new HiloEntidades(this);
		hiloEntidades.start();
	}
	
	
	public void ejecutarEntidades() 
	{
		for (Entidad e : misEntidades) {
			e.ejecutar();
		}
	}
	
	
	public void agregarEntidad(Entidad e, Celda celda) 
	{
		misEntidades.add(e);
		celda.agregarEntidad(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}

	
	public void eliminarEntidad(Entidad e) 
	{
		grafica.eliminarEntidad(e);
		e.getCelda().eliminarEntidad(e);
		Collection<Entidad> aremover = new ConcurrentLinkedDeque<Entidad>();
		aremover.add(e);
		misEntidades.removeAll(aremover);
		
//		Premio p = new PremioPocion(tablero, e.getCelda());
//		grafica.graficarEntidad(p);
	}

	
	public GUI getGrafica() 
	{
		return grafica;
	}
	
	
	public void setGrafica(GUI grafica) 
	{
		this.grafica = grafica;
	}
	
	
	public Tablero getTablero() 
	{
		return tablero;
	}

	
	public void setTablero(Tablero tablero) 
	{
		this.tablero = tablero;
	}
	
}
