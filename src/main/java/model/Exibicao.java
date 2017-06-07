package model;

import java.util.ArrayList;
import java.util.List;

import listener.ObservadorDeFilmeLiberado;
import notifier.NotificadorDeFilmeLiberado;

/** O SETOR DE EXIBIÇÃO DE FILMES **/
public class Exibicao implements ObservadorDeFilmeLiberado {

	private List<Filme> filmesParaExibicao;
	private NotificadorDeFilmeLiberado gerente;
	
	public Exibicao(NotificadorDeFilmeLiberado gerente) {
		this.gerente = gerente;
		this.gerente.registrarObservador(this);//-> O observador se registra no Notificador.
		this.filmesParaExibicao = new ArrayList<Filme>();
	}
	
	public List<Filme> getFilmesParaExibicao() {
		return filmesParaExibicao;
	}
	public void setFilmesParaExibicao(List<Filme> filmesParaExibicao) {
		this.filmesParaExibicao = filmesParaExibicao;
	}
	
	@Override
	public void atualizar() {
		System.out.println("Notificação recebida no setor de EXIBIÇÃO DE FILMES");
		System.out.println("Mensagem: Filme liberado para Exibição: " + this.gerente.getFilmeLiberado().getTitulo() + "\n");
		
		this.filmesParaExibicao.add(this.gerente.getFilmeLiberado());
	}
	
	
}
