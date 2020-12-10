package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Entidad;
import entidad.Jugador;
import entidad.Premio;

public class VisitorPremioPocion implements Visitor {

	protected Entidad miPremio;
	
	public VisitorPremioPocion(Premio p) {
		miPremio = p;
	}
	
	@Override
	public void visitEnemigo(Enemigo e) {
		
	}

	@Override
	public void visitJugador(Jugador j) {
		//Premio choca con jugador, por ende se aplica el efecto
		Premio p = (Premio) this.miPremio;
		j.setVida(p.getGolpe());
		
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		
	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		
	}

	@Override
	public void visitPremio(Premio p) {
		
	}

}
