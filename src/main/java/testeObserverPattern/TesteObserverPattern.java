package testeObserverPattern;

import model.Exibicao;
import model.Filme;
import model.Gerente;
import model.Publicidade;
import model.Venda;

/**Observer Pattern 
 * 
 * Define: uma dependência um-para-muitos entre objetos, então quando o 
 *         estado de um objeto muda, todos os seus dependentes serão 
 *         notificados e atualizados automaticamente.
 *         
 *        #Para exemplificar segue um exemplo hipotético:
 *         Cenário: Em um Shopping, quando o gerente responsavel pelo Cinema liberar 
 *                  um filme (para ser vendido e exibido) o setor de vendas de ingressos,
 *                  o setor de publicidade e o setor de exibições de filmes 
 *                  deverão ser notificados. 
 *                  
 *         Nota: Esse Padrão é muito útil quando a ocorrência de um evento interessa a 
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
		filme1.setTitulo("Piratas do Caribe - A Vingança de Salazar");
		filme1.setCategoria("Ficção");
		gerente.liberarFilmeParaExibicao(filme1); //->O gerente autoriza o filme e todos são notificados.

		////////////////////////////////////
		System.out.println("Filme 2");
		
		Filme filme2 = new Filme();
		filme2.setTitulo("Velozes e Furiosos 8");
		filme2.setCategoria("Policial");
		gerente.liberarFilmeParaExibicao(filme2);
		
	}
}






