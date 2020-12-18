package tablero;

public class Nivel2 extends Nivel {

	protected final int nivel = 2;
	
	public Nivel2(Tablero miTablero, int cantEnemigosOleada) {
		super(miTablero);
		this.siguienteNivel = null;
		crearOleada(cantEnemigosOleada,this.primeraOleada);
		crearOleada(cantEnemigosOleada,this.segundaOleada);
	}

	
	@Override
	public int getNivel() {
		return nivel;
	}

}
