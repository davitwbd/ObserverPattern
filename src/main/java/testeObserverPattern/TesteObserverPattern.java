package testeObserverPattern;

import model.Exibicao;
import model.Filme;
import model.Gerente;
import model.Publicidade;
import model.Venda;

/**Observer Pattern 
 * 
 * Define: uma depend�ncia um-para-muitos entre objetos, ent�o quando o 
 *         estado de um objeto muda, todos os seus dependentes ser�o 
 *         notificados e atualizados automaticamente.
 *         
 *        #Para exemplificar segue um exemplo hipot�tico:
 *         Cen�rio: Em um Shopping, quando o gerente responsavel pelo Cinema liberar 
 *                  um filme (para ser vendido e exibido) o setor de vendas de ingressos,
 *                  o setor de publicidade e o setor de exibi��es de filmes 
 *                  dever�o ser notificados. 
 *                  
 *         Nota: Esse Padr�o � muito �til quando a ocorr�ncia de um evento interessa a 
 *               varios outros componentes do sistema.**/
public class TesteObserverPattern {
	
	public static Gerente gerente;//->Notificador
	
	// >>Observadores<<
	public static Venda setorDeVenda;
	public static Publicidade setorDePublicidade;
	public static Exibicao setorDeExibicao;

	public static void main(String[] args) {
		
		gerente = new Gerente();
		setorDeVenda = new Venda(gerente);//-> Os observadores dependem do notificador.
		setorDePublicidade = new Publicidade(gerente);
		setorDeExibicao = new Exibicao(gerente);
		
		////////////////////////////////////
		System.out.println("Filme 1");
		
		Filme filme1 = new Filme();
		filme1.setTitulo("Piratas do Caribe - A Vingan�a de Salazar");
		filme1.setCategoria("Fic��o");
		gerente.liberarFilmeParaExibicao(filme1); //->O gerente autoriza o filme e todos s�o notificados.

		////////////////////////////////////
		System.out.println("Filme 2");
		
		Filme filme2 = new Filme();
		filme2.setTitulo("Velozes e Furiosos 8");
		filme2.setCategoria("Policial");
		gerente.liberarFilmeParaExibicao(filme2);
		
	}
}






