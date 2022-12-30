package documin;

/**
 * cria um titulo. 
 * 
 * @author lucas
 */
public class Titulo implements Elementavel {
	/**
	 * Conteúdo a ser abordado no titulo.
	 */
	private String valor;
	/**
	 * Nivel de prioridade do elemento.
	 */
	private int prioridade;
	/**
	 * Nivel do titulo.
	 */
	private int nivel;
	/**
	 * Boolean indicando se é linkável.
	 */
	private boolean link;

	/**
	 * Constrói um titulo que fez contrato com a interface Elementavel. 
	 * 
	 * @param valor Conteúdo a ser abordado no titulo.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param nivel Nivel do titulo.
	 * @param link Boolean indicando se é linkável.
	 */
	public Titulo(String valor, int prioridade, int nivel, boolean link) {
		this.valor = valor;
		this.prioridade = prioridade;
		this.nivel = nivel;
		this.link = link;
	}

	/**
	 * Representação detalhada do título. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		if (this.link == false) {
			return this.nivel + ". " + this.valor;
		}
		return this.nivel + ". " + this.valor + " -- " +this.nivel + "-" + this.valor.toUpperCase().replaceAll(" ", "");

	}

	/**
	 * Representação resumida do título. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoResumida() {
		return this.nivel + ". " + this.valor;
	}
	
	/**
	 * Pega a prioridade. 
	 * 
	 * @return Inteiro com a prioridade.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}
}
