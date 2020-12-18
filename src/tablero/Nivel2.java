package tablero;

public class Nivel2 extends Nivel {

	protected final int nivel = 2;
	
	public Nivel2(Tablero miTablero, int cantEnemigosOleada) 
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
