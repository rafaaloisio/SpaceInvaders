package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.EnemigoAlpha;
import entidad.EnemigoBeta;
import entidad.Jugador;
import entidad.Premio;
import entidad.PremioCongelamiento;
import entidad.PremioPocion;
import entidad.PremioSuperArma;

public class VisitorPremioSuperArma implements Visitor {
	
	private PremioSuperArma miPremio;
	
	public VisitorPremioSuperArma(PremioSuperArma p) {
		this.miPremio = p;
	}


	//premio choca con jugador
	@Override
	public void visitJugador(Jugador j) {
		j.setGolpe(j.getGolpe() + this.miPremio.getGolpe());
		this.miPremio.getCelda().eliminarEntidad(this.miPremio);
		this.miPremio.morir();
	}

	@Override
	public void visitDisparoJugador(DisparoJugador dj) {

	}

	@Override
	public void visitDisparoEnemigo(DisparoEnemigo de) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPremioPocion(PremioPocion p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitPremioCongelamiento(PremioCongelamiento p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitPremioSuperArma(PremioSuperArma p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visitEnemigoAlpha(EnemigoAlpha ea) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visitEnemigoBeta(EnemigoBeta eb) {
		// TODO Auto-generated method stub
		
	}


}
