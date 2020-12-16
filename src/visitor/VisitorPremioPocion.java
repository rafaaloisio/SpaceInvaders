package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Entidad;
import entidad.Jugador;
import entidad.Premio;
import entidad.PremioPocion;

public class VisitorPremioPocion implements Visitor {

	protected PremioPocion miPremio;
	
	public VisitorPremioPocion(PremioPocion p) {
		miPremio = p;
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		
	}

	@Override
	public void visitJugador(Jugador j) {
		j.setVida(j.getVida() + miPremio.getGolpe());
		this.miPremio.getCelda().eliminarEntidad(this.miPremio);
		this.miPremio.morir();
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
