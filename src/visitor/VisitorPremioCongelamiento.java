package visitor;

import java.util.LinkedList;

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

public class VisitorPremioCongelamiento implements Visitor {

	private PremioCongelamiento miPremio;
	
	public VisitorPremioCongelamiento(PremioCongelamiento p) {
		this.miPremio = p;
	}

	@Override
	public void visitJugador(Jugador j) {
		LinkedList<Enemigo> l = j.getTablero().getEnemigos();
		
		for (Enemigo e: l) {
			e.setTiempo(20);
		}
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
