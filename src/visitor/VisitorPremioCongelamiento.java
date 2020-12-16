package visitor;

import java.util.LinkedList;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Jugador;
import entidad.Premio;
import entidad.PremioCongelamiento;

public class VisitorPremioCongelamiento implements Visitor {

	private PremioCongelamiento miPremio;
	
	public VisitorPremioCongelamiento(PremioCongelamiento p) {
		this.miPremio = p;
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		
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
	public void visitPremio(Premio p) {
	}

}
