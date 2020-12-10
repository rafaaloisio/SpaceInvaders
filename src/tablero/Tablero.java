package tablero;

import java.util.LinkedList;

import entidad.*;
import logica.Logica;

public class Tablero 
{
	protected Celda[][] tablero;
	protected int filas;
	protected int columnas;
	protected Jugador jugador;
	protected LinkedList<Enemigo> misEnemigos;
	protected Logica logica;
	
	public Tablero(Logica logica)
	{
		this.filas = 12;
		this.columnas = 7;
		this.logica = logica;
		misEnemigos = new LinkedList<Enemigo>();
		
		this.tablero = new Celda[columnas][filas];
		
		for (int i = 0; i < columnas;i++)
		{
			for (int j = 0; j < filas ; j++)
			{
				tablero[i][j] = new Celda(this,i,j);
				System.out.println("X: "+i+" Y: "+j);
				
				if(i==3 && j == 10) {
					this.jugador = new Jugador(this,tablero[i][j],100,50);
					logica.agregarEntidad(jugador, jugador.getCelda());
				}
				
				if((i==2 && j == 0))
				{
					Enemigo al = new EnemigoAlpha(this,tablero[i][j],150,60);
					logica.agregarEntidad(al, al.getCelda());
				}
				
				if((i==4 && j == 1))
				{
					Enemigo bet = new EnemigoBeta(this,tablero[i][j],300,30);
					logica.agregarEntidad(bet, bet.getCelda());
				}
				
				if((i==5 && j == 0))
				{
					Enemigo bet = new EnemigoBeta(this,tablero[i][j],300,30);
					logica.agregarEntidad(bet, bet.getCelda());
				}
				if ((i==1 && j== 1)) {
					Enemigo bet = new EnemigoBeta(this,tablero[i][j],300,30);
					logica.agregarEntidad(bet, bet.getCelda());
				}
				
				
			}
		}
		
		
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