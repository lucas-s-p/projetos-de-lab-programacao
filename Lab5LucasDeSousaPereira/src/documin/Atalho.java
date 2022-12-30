package documin;

/**
 * Cria um atalho.
 * 
 * @author lucas
 */
public class Atalho implements Elementavel {
	/**
	 * Documento que é atalho.
	 */
	private Documento doc;
	/**
	 * Representação detalhada do atalho. 
	 */
	private String representacaoCompleta;
	/**
	 * Representação resumida do atalho. 
	 */
	private String representacaoResumida;
	/**
	 * Media das prioridades.
	 */
	private double prioridade;
	/**
	 * Título do documento.
	 */
	private String valor;
	
	/**
	 * Constrói um atalho para um documento. 
	 * 
	 * @param doc Documento a ser atalho.
	 */
	public Atalho(Documento doc) {		
		this.doc = doc;
		this.prioridade = this.doc.mediaPrioridades();
		this.valor = this.doc.getTitulo();
		this.representacaoCompleta = this.doc.cocatenaElementosCompleto();
		this.representacaoResumida = this.doc.cocatenaElementosResumido();
	}

	/**
	 * Pega o valor. 
	 * 
	 * @return Título do documento.
	 */
	public String getValor() {
		return this.valor;
	}
	
	/**
	 * Representação detalhada do atalho. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		return representacaoCompleta;
	}

	/**
	 * Representação resumida do atalho. 
	 * 
	 * @return String com a representação visual.
	 */
	@Override
	public String getRepresentacaoResumida() {
		return representacaoResumida;
	}

	/**
	 * Pega a prioridade. 
	 * 
	 * @return Inteiro com a prioridade.
	 */
	@Override
	public int getPrioridade() {
		return 0;
	}

	/**
	 * Media das prioridades. 
	 * 
	 * @return Double com a média das prioridades.
	 */
	public double MediaPrioridade() {
		return this.prioridade;
	}
	
	/**
	 * Pega o documento. 
	 * 
	 * @return Documento que é atalho.
	 */
	public Documento getDoc() {
		return this.doc;
	}
	
	/**
	 * Pega o título do documento. 
	 * 
	 * @return Titulo do documento que é atalho.
	 */
	public String getTitulo() {
		return this.doc.getTitulo();
	}
}
