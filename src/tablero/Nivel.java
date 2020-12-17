package tablero;

import java.util.Random;
import java.util.Stack;

import entidad.*;
import fabrica.*;

public abstract class Nivel
{

	protected Tablero miTablero;
	protected Nivel siguienteNivel;
	protected Stack<Entidad> primeraOleada = new Stack<Entidad>();
	protected Stack<Entidad> segundaOleada = new Stack<Entidad>();;


	public Nivel(Tablero miTablero) 
	{
		this.miTablero = miTablero;
	}
	

	protected void crearOleada(int cantEnemigos, Stack<Entidad> oleada) 
	{
		Enemigo e;
		Random ran = new Random();
		int valor;
		fabricaEnemigo fa = new fabricaEnemigoAlpha(miTablero);
		fabricaEnemigo fb = new fabricaEnemigoBeta(miTablero);
		for(int i = 0; i < cantEnemigos; i++) 
		{
			valor = ran.nextInt(2);
			if(valor % 2 == 0) 
			{
				e = fa.crearEnemigo();
				oleada.push(e);
			}else 
				{
					e = fb.crearEnemigo();
					oleada.push(e);
				}			
		}
	}
	

	public abstract Enemigo getEnemigo(int oleada);
	
	public Stack<Entidad> getPrimeraOleada() 
	{
		return primeraOleada;
	}


	public Stack<Entidad> getSegundaOleada()
	{
		return segundaOleada;
	}
	

}
