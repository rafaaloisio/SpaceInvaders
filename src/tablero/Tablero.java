package tablero;

import java.util.LinkedList;
import java.util.List;

import entidad.*;
import logica.Logica;

public class Tablero 
{
	protected Celda[][] miTablero;
	protected int filas;
	protected int columnas;
	protected Jugador miJugador;
	protected List<Enemigo> misEnemigos;
	protected Logica miLogica;
	protected Nivel miNivel;
	protected int cantEnemigosOleada;

	public Tablero(Logica logica)
	{
		this.filas = 12;
		this.columnas = 7;
		this.miLogica = logica;
		misEnemigos = new LinkedList<Enemigo>();

		this.miTablero = new Celda[columnas][filas];

		for (int i = 0; i < columnas;i++) {

			for (int j = 0; j < filas ; j++) {

				miTablero[i][j] = new Celda(this,i,j);
				System.out.println("X: "+i+" Y: "+j);

				if(i==3 && j == 10) {
					this.miJugador = new Jugador(this,miTablero[i][j]);
					logica.agregarEntidad(miJugador, miJugador.getCelda());
				}				
			}
		}

		this.miNivel = new Nivel1(this,3);

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
			return this.miTablero[x][y];
		else
			return null;
	}

	public Logica getLogica() {
		return miLogica;
	}

	public void setLogica(Logica logica) {
		this.miLogica = logica;
	}

	public Jugador getJugador() {
		return miJugador;
	}

	public void setJugador(Jugador jugador) {
		this.miJugador = jugador;
	}

	public List<Enemigo> getEnemigos() {
		return misEnemigos;
	}

	public Nivel getMiNivel() {
		return miNivel;
	}

	public void setMiNivel(Nivel miNivel) {
		this.miNivel = miNivel;
	}

	public int getCantEnemigosOleada() {
		return cantEnemigosOleada;
	}

	public void setCantEnemigosOleada(int cantEnemigosOleada) {
		this.cantEnemigosOleada = cantEnemigosOleada;
	}



}
