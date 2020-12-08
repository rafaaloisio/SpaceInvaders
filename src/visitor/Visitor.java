package visitor;

import disparo.*;
import entidad.Enemigo;
import entidad.Jugador;
import entidad.Premio;

public interface Visitor {

	public void visit(Enemigo e);
	public void visit(Jugador j);
	public void visit(DisparoJugador dj);
	public void visit(DisparoEnemigo de);
	public void visit(Premio p);
}
