package Mapa;

import Entidad.Jugador;
import Logica.Logica;

public class Tablero 
{
	protected Celda[][] tablero;
	protected int filas;
	protected int columnas;
	protected Jugador jugador;


	protected Logica logica;
	
	public Tablero(Logica logica)
	{
		this.filas = 12;
		this.columnas = 7;
		this.logica = logica;
		
		this.tablero = new Celda[columnas][filas];
		
		for (int i = 0; i < columnas;i++)
		{
			for (int j = 0; j < filas ; j++)
			{
				tablero[i][j] = new Celda(this,i,j);
				System.out.println("X: "+i+" Y: "+j);
				
				if(i==3 && j == 11) {
					this.jugador = new Jugador(this,tablero[i][j],100);
					logica.agregarEntidad(jugador, jugador.getCelda());
				}
				
				/*
				if(i== j) {
					this.jugador = new Jugador(this,tablero[i][j],100);
					logica.agregarEntidad(jugador, jugador.getCelda());
				}
				*/
			}
		}
		
	/*
		
		this.jugador = new Jugador(this,tablero[11][3],100);
		
		logica.agregarEntidad(jugador, jugador.getCelda());
		
		*/
		
	}
	
	public int getFilas()
	{
		return this.filas;
	}
	
	public int getColumnas()
	{
		return this.columnas;
	}
	
	
	public Celda getCelda(int x, int y) 
	{
		if ((x < this.columnas) && (x >= 0) && (y < this.filas) && (y >= 0))
			return this.tablero[x][y];
		else
			return null;
	}
	
	public Logica getLogica() {
		return logica;
	}

	public void setLogica(Logica logica) {
		this.logica = logica;
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	

	
}
