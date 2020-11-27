package Logica;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedDeque;

import Entidad.Entidad;
import GUI.Grafica;
import Hilos.HiloEntidades;
import Mapa.*;

public class Logica {

	protected Collection<Entidad> misEntidades;
	protected HiloEntidades hiloEntidades;
	protected Grafica grafica;

	protected Tablero tablero;
	
	


	public Logica(Grafica grafica) {
		this.grafica = grafica;
		misEntidades = new ConcurrentLinkedDeque<Entidad>();

		this.tablero = new Tablero(this);
		//cargarOleada();
		crearHilos();
	}
	
	public void crearHilos() {
		hiloEntidades = new HiloEntidades(this);
		hiloEntidades.start();
	}
	
	public void ejecutarEntidades() {
		for (Entidad e : misEntidades) {
			e.ejecutar();
		}
	}
	
	public void agregarEntidad(Entidad e, Celda celda) {
		misEntidades.add(e);
		celda.agregarEntidad(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}

	public void eliminarEntidad(Entidad e) {
		Celda celda = e.getCelda();
		grafica.eliminarEntidad(e);
		celda.eliminarEntidad(e);
		misEntidades.remove(e);
	}

	public Grafica getGrafica() {
		return grafica;
	}
	
	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}
	
	
	
	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
}
