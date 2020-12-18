package tablero;

public class Nivel1 extends Nivel {

	protected final int nivel = 1;
	

	public Nivel1(Tablero miTablero, int cantEnemigosOleada) {
		super(miTablero);
		this.siguienteNivel = new Nivel2(miTablero,cantEnemigosOleada+1);
		crearOleada(cantEnemigosOleada,this.primeraOleada);
		crearOleada(cantEnemigosOleada,this.segundaOleada);
	}


	@Override
	public int getNivel() {
		return nivel;
	}

}
