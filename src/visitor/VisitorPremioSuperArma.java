package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Jugador;
import entidad.Premio;
import entidad.PremioSuperArma;

public class VisitorPremioSuperArma implements Visitor {
	
	private PremioSuperArma miPremio;
	
	public VisitorPremioSuperArma(PremioSuperArma p) {
		this.miPremio = p;
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitJugador(Jugador j) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPremio(Premio p) {
		// TODO Auto-generated method stub

	}

}
