package documin;

/**
 * cria uma lista.
 * 
 * 
 * @author lucas
 */
public class Lista implements Elementavel {
	/**
	 * Conteúdo a ser abordado na lista.
	 */
	private String valor;
	/**
	 * Nivel de prioridade do elemento.
	 */
	private int prioridade;
	/**
	 * Indica em que ponto é separado cada item da lista.
	 */
	private String separador;
	/**
	 * Caractere que sequencializa os itens.
	 */
	private String caractere;

	/**
	 * Constrói uma lista que fez contrato com a interface Elementavel. 
	 * 
	 * @param valor Conteúdo a ser abordado na lista.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param separador Indica em que ponto é separado cada item da lista.
	 * @param caractere Caractere que sequencializa os itens.
	 */
	public Lista(String valor, int prioridade, String separador, String caractere) {
		this.valor = valor;
		this.prioridade = prioridade;
		this.separador = separador;
		this.caractere = caractere;

	}
	
	/**
	 * Representação detalhada da lista. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		String completa = "";
		for (int i = 0; i < separaValor().length; i++) {
			completa += this.caractere + " " + separaValor()[i].trim() + "\n";
		}
		return completa;
	}

	/**
	 * Representação resumida da lista. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoResumida() {
		String[] lista = separaValor();
		String resumida = "";
		for (int i = 0; i < lista.length; i++) {
			if (i == (lista.length -1)) {
				resumida += lista[i].trim();
			} else if (i < lista.length) {
				resumida += lista[i].trim() + ", ";
			}
		}
		return resumida;
	}
	
	/**
	 * Separa a lista pelo atributo separador. 
	 * 
	 * @return Array com a lista separada.
	 */
	private String[] separaValor() {   
		if (this.separador.equals("|")) {
			this.separador = "[|]";
		}
		String[] lista = this.valor.split(this.separador); 
		return lista;
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
