package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import GUI.*;
import entidad.*;
import hilos.*;
import tablero.*;

public class Logica {

	protected ArrayList<Entidad> misEntidades;
	protected HiloEntidades hiloEntidades;
	protected GUI miGrafica;
	protected Tablero miTablero;
	protected boolean perdi;
	protected boolean gane;
	protected boolean ganeNivel;
	protected Timer hiloOleadas;
	protected int mutex;

	
	public Logica(GUI grafica) 
	{
		this.miGrafica = grafica;
		this.misEntidades = new ArrayList<Entidad>();
		this.miTablero = new Tablero(this);
		
		//this.oleadaActual = 1;
		
		perdi = false;
		
		gane = false;
		
		ganeNivel = false;
		
		cargarOleada();
		
		crearHilos();
	}
	

	public void crearHilos() 
	{
		hiloEntidades = new HiloEntidades(this);
		hiloEntidades.start();
	}
	
	
	public void ejecutarEntidades()	{
		
		for (int i = 0; i<misEntidades.size();i++) {
			misEntidades.get(i).ejecutar();
		}
		
	}
	
	public void desplazarEntidades() {
		for (Entidad e: misEntidades) {
			if (!e.equals(this.miTablero.getJugador())) {
				e.getMovimiento().desplazar();
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
	
	public int getMutex() {
		return mutex;
	}


	public void setMutex(int mutex) {
		this.mutex = mutex;
	}
	
	private void cargarOleada() {
	
		Nivel miNivel = miTablero.getMiNivel();
		
		miNivel.setOleadaActual(1);
		
		mutex = 0;
				
		System.out.println("----COMIENZO DE LA PRIMER OLEADA---- NIVEL: "+miNivel.getNivel());
		
		while (!miNivel.getPrimeraOleada().isEmpty() && mutex == 0)
		{	
			Enemigo en = miNivel.getEnemigo(1);				
			agregarEntidad(en, en.getCelda());
			miTablero.getEnemigos().add(en);
		
		}
		
		System.out.println("CANT ENEMIGOS: "+miTablero.getEnemigos().size()+" NIVEL: "+miNivel.getNivel());
		
		
		mutex = 1;
		
		hiloOleadas = new Timer(250, new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
				
				
				if(miTablero.getEnemigos().size() == 0 )
				{
					if(mutex == 1) {
						System.out.println("----FIN PRIMERA OLEADA---- NIVEL: "+miNivel.getNivel());
						
						miNivel.setOleadaActual(2);
						System.out.println("----COMIENZO DE LA SEGUNDA OLEADA---- NIVEL: "+miNivel.getNivel());
						
						miNivel.crearOleada(miNivel.getCantEnemigosOleada(),miNivel.getSegundaOleada());
						
						mutex = 0;
						
						while (!miNivel.getSegundaOleada().isEmpty())
						{	
							Enemigo ene = miNivel.getEnemigo(2);
							agregarEntidad(ene, ene.getCelda());
							miTablero.getEnemigos().add(ene);
						
						}
					}else {
					
				
							if(miTablero.getEnemigos().size() == 0)
							{
								System.out.println("----FIN SEGUNDA OLEADA---- NIVEL: "+miNivel.getNivel());
								ganeNivel = true;
								hiloOleadas.stop();
								
								if(miNivel.getNivel() == 1) {
									
									miTablero.setMiNivel(new Nivel2(miTablero,4));
									
									cargarOleada();
									
								}else
								{
									
									miTablero.getLogica().setGane(true);
									
									System.out.println("----GANE!!!!---- ");
								}
							}
						
					}
					
				}
			}
			
			
		});
		
		hiloOleadas.start();
		
		
	}

	
}
