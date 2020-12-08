package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Jugador;
import entidad.Premio;

public class VisitorJugador implements Visitor {

	protected Jugador miJugador;
	
	public VisitorJugador(Jugador j)
	{
		this.miJugador = j;
	}
	
	@Override
	public void visit(Enemigo e) {
		System.out.println("YO JUGADOR CHOQUE CONTRA ENEMIGO");				
	}

	@Override
	public void visit(Jugador j) {
		System.out.println("YO JUGADOR CHOQUE CONTRA JUGADOR");				
		
	}

	@Override
	public void visit(DisparoJugador dj) {
		System.out.println("YO JUGADOR CHOQUE CONTRA DISPARO JUGADOR");				
		
	}

	@Override
	public void visit(DisparoEnemigo de) {
		System.out.println("YO JUGADOR CHOQUE CONTRA DISPARO ENEMIGO");				
		
	}
	
	public void visit(Premio p) {
		
		System.out.println("YO JUGADOR CHOQUE CONTRA PREMIO");
		//consumo del efecto del premio
		
	}

}
