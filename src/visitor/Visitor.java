package visitor;

import disparo.DisparoEnemigo;
import disparo.DisparoJugador;
import entidad.Enemigo;
import entidad.Jugador;
import entidad.Premio;

public interface Visitor {
	
	public void visitEnemigo(Enemigo e);
	public void visitJugador(Jugador j);
	public void visitDisparoJugador(DisparoJugador dj);
	public void visitDisparoEnemigo(DisparoEnemigo de);
	public void visitPremio(Premio p);
}
