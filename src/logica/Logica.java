package logica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import GUI.*;
import entidad.*;
import hilos.*;
import tablero.*;

public class Logica {

	protected List<Entidad> misEntidades;
	protected HiloEntidades hiloEntidades;
	protected GUI miGrafica;
	protected Tablero miTablero;
	protected boolean perdi;
	protected boolean gane;
	protected boolean ganeOleada;
	protected Timer hiloOleadas;

	public Logica(GUI grafica) 
	{
		this.miGrafica = grafica;
		this.misEntidades = new ArrayList<Entidad>();
		this.miTablero = new Tablero(this);

		//this.oleadaActual = 1;

		perdi = false;

		gane = false;

		ganeOleada = false;

		crearHilos();
	}


	public void crearHilos() 
	{
		hiloEntidades = new HiloEntidades(this);
		hiloEntidades.start();
	}


	public void ejecutarEntidades() throws InterruptedException	{

		for (int i = 0; i<misEntidades.size();i++) {
			misEntidades.get(i).ejecutar();

		}

		Nivel miNivel = miTablero.getMiNivel();

		if((miTablero.getEnemigos().size() == 0) && (miNivel.getOleadaActual() == 1)) 
		{
			System.out.println("----COMIENZO DE LA PRIMER OLEADA---- NIVEL: "+miNivel.getNivel());

			while (!miNivel.getPrimeraOleada().isEmpty())
			{	
				Enemigo en = miNivel.getEnemigo(1);				
				agregarEntidad(en, en.getCelda());
				miTablero.getEnemigos().add(en);

			}

		}

		if((miTablero.getEnemigos().size() == 0) && (miNivel.getOleadaActual() == 1)) 
		{

			ganeOleada = true;

			//espero 3 segundos cuando gano una oleada
			Thread.sleep(3000);

			System.out.println("----FIN PRIMERA OLEADA---- NIVEL: "+miNivel.getNivel());

			miNivel.setOleadaActual(2);

			miNivel.crearOleada(miNivel.getCantEnemigosOleada(),miNivel.getSegundaOleada());

			System.out.println("----COMIENZO DE LA SEGUNDA OLEADA---- NIVEL: "+miNivel.getNivel());
		}


		if((miTablero.getEnemigos().size() == 0) && (miNivel.getOleadaActual() == 2) && (ganeOleada)) {

			while (!miNivel.getSegundaOleada().isEmpty())
			{	
				Enemigo en = miNivel.getEnemigo(2);				
				agregarEntidad(en, en.getCelda());
				miTablero.getEnemigos().add(en);

			}

			ganeOleada = false;

		}


		if((miTablero.getEnemigos().size() == 0) && (miNivel.getOleadaActual() == 2))
		{

			System.out.println("----FIN SEGUNDA OLEADA---- NIVEL: "+miNivel.getNivel());

			if(miNivel.getNivel() == 1) {

				//espero 5 segundos cuando gano un nuvel
				Thread.sleep(5000);
				miTablero.setMiNivel(new Nivel2(miTablero,5));		
			}
			else
			{
				System.out.println("----GANE!!!!---- ");
				miTablero.getLogica().setGane(true);
			}
		}

	}



	public void agregarEntidad(Entidad e, Celda celda) 
	{
		misEntidades.add(e);
		//celda.agregarEntidad(e); ahora lo agrega a la celda cuando la entidad es creada, por eso no es necesario esto
		e.setCelda(celda);
		miGrafica.graficarEntidad(e);

	}


	public void eliminarEntidad(Entidad e) 
	{

		miGrafica.eliminarEntidad(e);

		e.getCelda().eliminarEntidad(e);

		miTablero.getEnemigos().remove(e);

		misEntidades.remove(e);
	}


	public GUI getGrafica() 
	{
		return miGrafica;
	}


	public void setGrafica(GUI grafica) 
	{
		this.miGrafica = grafica;
	}


	public Tablero getTablero() 
	{
		return miTablero;
	}


	public void setTablero(Tablero tablero) 
	{
		this.miTablero = tablero;
	}

	public boolean isPerdi() {
		return perdi;
	}


	public void setPerdi(boolean perdi) {
		this.perdi = perdi;
	}

	public boolean isGane() {
		return gane;
	}


	public void setGane(boolean gane) {
		this.gane = gane;
	}

	public boolean isGaneOleada() {
		return ganeOleada;
	}


	public void setGaneOleada(boolean ganeOleada) {
		this.ganeOleada = ganeOleada;
	}


}
