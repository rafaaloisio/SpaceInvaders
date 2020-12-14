package logica;

import java.util.ArrayList;


import GUI.GUI;
import entidad.Entidad;
import entidad.*;
import hilos.HiloEntidades;
import tablero.*;

public class Logica {

	protected ArrayList<Entidad> misEntidades;
	
	protected HiloEntidades hiloEntidades;
	protected GUI grafica;

	protected Tablero tablero;
	
	protected boolean perdi;

	public Logica(GUI grafica) 
	{
		this.grafica = grafica;
		misEntidades = new ArrayList<Entidad>();

		this.tablero = new Tablero(this);
		
		perdi = false;
		
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
		
		for (int i = 0; i<misEntidades.size();i++) {
			misEntidades.get(i).ejecutar();
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
		//cuando anden las oleadas, hay que eliminar de misEnemigos de tablero tambien
		
		grafica.eliminarEntidad(e);
		e.getCelda().eliminarEntidad(e);
		
		
		misEntidades.remove(e);
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
	
	public boolean isPerdi() {
		return perdi;
	}


	public void setPerdi(boolean perdi) {
		this.perdi = perdi;
	}
	
}
