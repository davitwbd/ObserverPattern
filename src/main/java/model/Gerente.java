package model;

import java.util.ArrayList;
import java.util.List;

import listener.ObservadorDeFilmeLiberado;
import notifier.NotificadorDeFilmeLiberado;

/**O Notificador pode possui v�rios observadores(listeners)**/
public class Gerente implements NotificadorDeFilmeLiberado{

	private List<ObservadorDeFilmeLiberado> setores;//-> Conjunto de observadores (interface dos observadores).
	private Filme filmeLiberado;
	
	public Gerente() {
		setores = new ArrayList<ObservadorDeFilmeLiberado>();
	}

	public void registrarObservador(ObservadorDeFilmeLiberado setor) {
		setores.add(setor);
	}

	public void removerObservador(ObservadorDeFilmeLiberado setor) {
		setores.remove(setor);
	}

	public void notificarObservadores() {
		setores.forEach(setor -> {
			setor.atualizar();
		});
	}

	public void liberarFilmeParaExibicao(Filme filme){
		this.filmeLiberado = filme;
		/** Os observadores s�o informados de acordo com a mudan�a dos estados do notificador. 
		 *  Nesse caso foi a autoriza��o de um novo filme liberado para a exibi��o.**/
		
		this.notificarObservadores();
	}
	
	public Filme getFilmeLiberado() {
		return this.filmeLiberado;
	}
	
	
}
