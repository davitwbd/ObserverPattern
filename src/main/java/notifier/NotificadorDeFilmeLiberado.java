package notifier;

import listener.ObservadorDeFilmeLiberado;
import model.Filme;

public interface NotificadorDeFilmeLiberado {

	public void registrarObservador(ObservadorDeFilmeLiberado setor);
	public void removerObservador(ObservadorDeFilmeLiberado setor);
	public void notificarObservadores();
	
	public Filme getFilmeLiberado();
	
}
