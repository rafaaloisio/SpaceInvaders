package tablero;

import java.util.LinkedList;

import entidad.*;
import logica.Logica;
import fabrica.*;

public class Tablero 
{
	protected Celda[][] miTablero;
	protected int filas;
	protected int columnas;
	protected Jugador miJugador;
	protected LinkedList<Enemigo> misEnemigos;
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
		
		miNivel = new Nivel1(this,cantEnemigosOleada);
	
		miNivel.crearOleada(6, miNivel.getPrimeraOleada());

		
		while (!miNivel.getPrimeraOleada().isEmpty())
		{	
			Enemigo e = miNivel.getEnemigo(1);				
			logica.agregarEntidad(e, e.getCelda());
			this.misEnemigos.add(e);
		
		}
		
		
		/*
		
		FabricaEnemigo fa = new FabricaEnemigoAlpha(this);
		FabricaEnemigo fb = new FabricaEnemigoBeta(this);


		Enemigo alpha = fa.crearEnemigo();
		logica.agregarEntidad(alpha, alpha.getCelda());
		this.misEnemigos.add(alpha);

		Enemigo alpha1 = fa.crearEnemigo();
		logica.agregarEntidad(alpha1, alpha1.getCelda());
		this.misEnemigos.add(alpha1);

		Enemigo beta = fb.crearEnemigo();
		logica.agregarEntidad(beta, beta.getCelda());
		this.misEnemigos.add(beta);

		Enemigo beta1 = fb.crearEnemigo();
		logica.agregarEntidad(beta1, beta1.getCelda());
		this.misEnemigos.add(beta1);


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

	public LinkedList<Enemigo> getEnemigos() {
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
