package documin;

/**
 * cria um texto.
 * 
 * @author lucas
 */
public class Texto implements Elementavel {
	/**
	 * Nivel de prioridade do elemento.
	 */
	private int prioridade;
	/**
	 * Conteúdo a ser abordado no texto.
	 */
	private String valor;

	/**
	 * Constrói um termo que fez contrato com a interface Elementavel.
	 * 
	 * @param valor Conteúdo a ser abordado no texto.
	 * @param prioridade Nivel de prioridade do elemento.
	 */
	public Texto(String valor, int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
	}

	/**
	 * Representação detalhada do texto. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		return this.valor;
	}

	/**
	 * Representação resumida do texto. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoResumida() {
		return this.valor;
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
