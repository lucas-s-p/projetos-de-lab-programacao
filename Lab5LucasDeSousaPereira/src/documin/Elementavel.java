package documin;

/**
 * Cria uma interface.
 * 
 * @author lucas
 */
public interface Elementavel {
	
	/**
	 * Representação detalhada de um elemento. 
	 * 
	 * @return String com a representação visual.
	 */
	public String getRepresentacaoCompleta();

	/**
	 * Representação resumida de um elemento. 
	 * 
	 * @return String com a representação visual.
	 */
	public String getRepresentacaoResumida();

	/**
	 * Pega a prioridade. 
	 * 
	 * @return Inteiro com a prioridade.
	 */
	public int getPrioridade();
}
