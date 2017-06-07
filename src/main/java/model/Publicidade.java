package model;

import java.util.ArrayList;
import java.util.List;

import listener.ObservadorDeFilmeLiberado;
import notifier.NotificadorDeFilmeLiberado;

/** O SETOR DE PUBLICIDADE **/
public class Publicidade implements ObservadorDeFilmeLiberado {
	
	private List<Filme> filmesParaDivulgacao;
	private NotificadorDeFilmeLiberado gerente;
	
	public Publicidade(NotificadorDeFilmeLiberado gerente) {
		this.gerente = gerente;
		this.gerente.registrarObservador(this);//-> O observador se registra no Notificador.
		this.filmesParaDivulgacao = new ArrayList<Filme>();
	}
	
 	public List<Filme> getFilmesParaDivulgacao() {
		return filmesParaDivulgacao;
	}
	public void setFilmesParaDivulgacao(List<Filme> filmesParaDivulgacao) {
		this.filmesParaDivulgacao = filmesParaDivulgacao;
	}
	
	@Override
	public void atualizar() {
		System.out.println("Notificação recebida no setor de PUBLICIDADE");
		System.out.println("Mensagem: Filme liberado para Publicidade: " + this.gerente.getFilmeLiberado().getTitulo() 
				            + ", Categoria: " + this.gerente.getFilmeLiberado().getCategoria() +"\n");
		
		this.filmesParaDivulgacao.add(this.gerente.getFilmeLiberado());
	}
 	
 	
}
