package tablero;

import java.util.Random;
import java.util.Stack;

import entidad.*;
import fabrica.*;

public abstract class Nivel
{

	protected Tablero miTablero;
	protected Stack<Enemigo> primeraOleada;
	protected Stack<Enemigo> segundaOleada;
	protected FabricaEnemigo fa,fb;
	protected int cantEnemigosOleada;
	protected int oleadaActual;

	protected Nivel(Tablero miTablero) 
	{
		this.miTablero = miTablero;
		primeraOleada = new Stack<Enemigo>();
		segundaOleada = new Stack<Enemigo>();
		this.fa = new FabricaEnemigoAlpha(miTablero);
		this.fb = new FabricaEnemigoBeta(miTablero);
	}


	public void crearOleada(int cantEnemigos, Stack<Enemigo> oleada) 
	{
		
		for(int i = 0; i < cantEnemigos; i++) 
		{
			int valor = new Random().nextInt(2);
			
			if(valor == 1) 
				oleada.push(fa.crearEnemigo());
			else
				oleada.push(fb.crearEnemigo());		
		}
	}

	
	public Enemigo getEnemigo(int numOleada) 
	{
		
		Enemigo e = null;
		
		if(!primeraOleada.isEmpty() && numOleada ==1)
		{
			e = this.primeraOleada.pop();
			
		}else {
			
			if(!segundaOleada.isEmpty() && numOleada ==2) 
			{
				e = this.segundaOleada.pop();
			}
		}
		return e;
	}

	
	public Stack<Enemigo> getPrimeraOleada() 
	{
		return primeraOleada;
	}

	
	public Stack<Enemigo> getSegundaOleada()
	{
		return segundaOleada;
	}

	
	
	public abstract int getNivel();

	
	public int getCantEnemigosOleada() {
		return cantEnemigosOleada;
	}


	public void setCantEnemigosOleada(int cantEnemigosOleada) {
		this.cantEnemigosOleada = cantEnemigosOleada;
	}
	
	public int getOleadaActual() {
		return oleadaActual;
	}


	public void setOleadaActual(int oleadaActual) {
		this.oleadaActual = oleadaActual;
	}


}
