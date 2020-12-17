package visitor;

import entidad.*;
import disparo.*;

public interface Visitor {

	public void visitEnemigoAlpha(EnemigoAlpha ea);
	public void visitEnemigoBeta(EnemigoBeta eb);
	public void visitJugador(Jugador j);
	public void visitDisparoJugador(DisparoJugador dj);
	public void visitDisparoEnemigo(DisparoEnemigo de);
	public void visitPremioPocion(PremioPocion p);
	public void visitPremioCongelamiento(PremioCongelamiento p);
	public void visitPremioSuperArma(PremioSuperArma p);
}
