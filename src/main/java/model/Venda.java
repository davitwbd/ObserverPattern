package model;

import java.util.ArrayList;
import java.util.List;

import listener.ObservadorDeFilmeLiberado;
import notifier.NotificadorDeFilmeLiberado;

/** O SETOR DE VENDAS DE INGRESSOS **/
public class Venda implements ObservadorDeFilmeLiberado {
	
	private List<Filme> filmesParaVenda;
	private NotificadorDeFilmeLiberado gerente;
	
	public Venda(NotificadorDeFilmeLiberado gerente) {
		this.gerente = gerente;
		this.gerente.registrarObservador(this);//-> O observador se registra no Notificador.
		this.filmesParaVenda = new ArrayList<Filme>();
	}
	
	public List<Filme> getFilmesParaVenda() {
		return filmesParaVenda;
	}
	public void setFilmesParaVenda(List<Filme> filmesParaVenda) {
		this.filmesParaVenda = filmesParaVenda;
	}
	
	@Override
	public void atualizar() {
		System.out.println("Notificação recebida no setor de VENDA DE INGRESSOS");
		System.out.println("Mensagem: Filme liberado para venda: " + this.gerente.getFilmeLiberado().getTitulo() + "\n");
		
		this.filmesParaVenda.add(this.gerente.getFilmeLiberado());
	}
	
	
}
