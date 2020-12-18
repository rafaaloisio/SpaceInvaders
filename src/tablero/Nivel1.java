package tablero;

public class Nivel1 extends Nivel {

	protected final int nivel = 1;	

	public Nivel1(Tablero miTablero, int cantEnemigosOleada) 
	{
		super(miTablero);
		this.cantEnemigosOleada = cantEnemigosOleada;
		crearOleada(cantEnemigosOleada,this.primeraOleada);
	}


	@Override
	public int getNivel() 
	{
		return nivel;
	}

}
