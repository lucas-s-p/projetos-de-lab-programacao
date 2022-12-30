package documin;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Cria um documento e elementos do documento.
 * 
 * @author lucas
 */
public class Documento {
	/**
	 * Tamanho do documento.
	 */
	private int tamanho;
	/**
	 * Titulo do documento.
	 */
	private String titulo;
	/**
	 * Arraylist contendo todos os elementos do tipo Elementavel.
	 */
	private ArrayList<Elementavel> elementos;
	/**
	 * Verifica se o documento é um atalho.
	 */
	private boolean eAtalho;
	
	/**
	 * Constŕoi um documento baseado em um titulo e tamanho.
	 * 
	 * @param titulo Titulo do documento.
	 * @param tamanho Tamanho do documento.
	 */
	public Documento(String titulo, int tamanho) {
		this.elementos = new ArrayList<>();
		this.titulo = titulo;
		this.tamanho = tamanho;
		if (this.tamanho <= 0) {
			throw new IllegalArgumentException("Tamanho menor ou igual a zero");
		}
	}
	
	/**
	 * Constŕoi um documento baseado em um titulo e tamanho indefinido.
	 * 
	 * @param titulo Titulo do documento.
	 */
	public Documento(String titulo) {
		this.titulo = titulo;
		this.elementos = new ArrayList<>();
	}

	/**
	 * Pega o titulo do documento.
	 * 
	 * @return Retorna o titulo do documento.
	 */	
	public String getTitulo() {
		return this.titulo;
	}

	/**
	 * Cria um texto e adiciona em um um arraylist que contém elementos do tipo Elementavel.
	 * 
	 * @param valor Conteúdo a ser abordado no texto.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
	public int criaTexto(String valor, int prioridade) {  
		if (this.tamanho != 0 && (this.elementos.size() + 1) > this.tamanho) {
			throw new IllegalArgumentException("Documento cheio");
		}
		Elementavel meuTexto = new Texto(valor, prioridade);
		this.elementos.add(meuTexto);
		return (Integer) elementos.indexOf(meuTexto);

	}

	/**
	 * Cria um termo e adiciona em um um arraylist que contém elementos do tipo Elementavel.
	 * 
	 * @param valor Conteúdo a ser abordado no termo.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param separador Indica em que ponto é separado cada termo.
	 * @param ordem Forma de ordenação do valor.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
	public int criaTermo(String valor, int prioridade, String separador, String ordem) {
		if (this.tamanho != 0 && (this.elementos.size() + 1) > this.tamanho) {
			throw new IllegalArgumentException("Documento cheio");
		}
		Elementavel meuTermo = new Termo(valor, prioridade, separador, ordem);
		this.elementos.add(meuTermo);
		return (Integer) elementos.indexOf(meuTermo);

	}

	/**
	 * Cria uma lista e adiciona em um um arraylist que contém elementos do tipo Elementavel.
	 * 
	 * @param valor Conteúdo a ser abordado na lista.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param separador Indica em que ponto é separado cada item da lista.
	 * @param caractere Caractere que sequencializa os itens.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
	public int criaLista(String valor, int prioridade, String separador, String caractere) {
		if (this.tamanho != 0 && (this.elementos.size() + 1) > this.tamanho) {
			throw new IllegalArgumentException("Documento cheio");
		}
		Elementavel minhaLista = new Lista(valor, prioridade, separador, caractere);
		this.elementos.add(minhaLista);
		return (Integer) elementos.indexOf(minhaLista);

	}

	/**
	 *  Cria um titulo e adiciona em um um arraylist que contém elementos do tipo Elementavel.
	 * 
	 * @param valor Conteúdo a ser abordado na lista.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param nivel Nivel do titulo.
	 * @param link Boolean indicando se é linkável.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
	public int criaTitulo(String valor, int prioridade, int nivel, boolean link) {
		if (this.tamanho != 0 && (this.elementos.size() + 1) > this.tamanho) {
			throw new IllegalArgumentException("Documento cheio");
		}
		Elementavel meuTitulo = new Titulo(valor, prioridade, nivel, link);
		this.elementos.add(meuTitulo);
		return (Integer) elementos.indexOf(meuTitulo);

	}

	/**
	 * Representação detalhada de um elemento.
	 * 
	 * @param posElemento Posição do elemento no documento.
	 * @return Texto com a visualização do elemento.
	 */
	public String exibeElementoCompleto(int posElemento) {
		return this.elementos.get(posElemento).getRepresentacaoCompleta();
	}

	/**
	 *  Representação resumida de um elemento.
	 * 
	 * @param posElemento Posição do elemento no documento.
	 * @return Texto com a visualização do elemento.
	 */
	public String exibeElementoResumido(int posElemento) {
		return this.elementos.get(posElemento).getRepresentacaoResumida();
	}

	/**
	 * Remove um elemento do arraylist de elementos.
	 * 
	 * @param elementoPosicao Posição do elemento no documento.
	 * @return Boolean informando se a remoção foi bem sucedida.
	 */
	public boolean removeElemento(int elementoPosicao) {
		if (this.elementos.get(elementoPosicao) != null) {
			this.elementos.remove(elementoPosicao);
			return true;
		}
		return false;
	}

	/**
	 * Troca as posições do sucessor com antecedor no arraylist de elementos.
	 * 
	 * @param elementoPosicao Posição do elemento no documento.
	 */
	public void PosAbaixo(int elementoPosicao) { 
		Elementavel guardaPosicao = this.elementos.get(elementoPosicao + 1);
		if (this.elementos.contains(this.elementos.get(elementoPosicao + 1))) {
			this.elementos.add(elementoPosicao + 1, this.elementos.get(elementoPosicao));
			this.elementos.add(elementoPosicao, guardaPosicao);
		} 
	}

	/**
	 * Troca as posições do antecedor com o sucessor no arraylist de elementos.
	 * 
	 * @param elementoPosicao Posição do elemento no documento.
	 */
	public void PosAcima(int elementoPosicao) {
		Elementavel guardaPosicao = this.elementos.get(elementoPosicao - 1);
		if (elementoPosicao != 0) {
			this.elementos.add(elementoPosicao - 1, this.elementos.get(elementoPosicao));
			this.elementos.add(elementoPosicao, guardaPosicao);
		} 	
	}

	/**
	 * Conta a quantidade de elementos presente no arraylist.
	 * 
	 * @return Inteiro com o número de elementos em um documento.
	 */
	public int qtdElementos() {
		return this.elementos.size() - 1;
	}
	
	/**
	 * Cria um array contendo todos os elementos.
	 * 
	 * @return Array com a representação completa dos elementos.
	 */
	public String[] exibeDocumentoCompleto() {
		String[] exibeElementos = new String[this.elementos.size()];
		int i = 0;
		for (Elementavel e: this.elementos) {
			exibeElementos[i++] = e.getRepresentacaoCompleta();
		}
		return exibeElementos;
	}
	
	/**
	 * Adiciona um atalho para um documento no arraylist de elementos. 
	 * 
	 * @param doc Documento que é atalho
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
	public int AddDocumentoAtalho(Documento doc) {
		Elementavel meuAtalho = new Atalho(doc);
		this.elementos.add(meuAtalho);
		doc.seteAtalho(true);            
		return this.elementos.indexOf(meuAtalho);
	}
	/**
	 * Verifica se o elemento removido é um atalho.
	 * 
	 * @param index Index do elemento a ser removido.
	 * @return Retorna o titulo do documento que é atalho e será  removido.
	 */
	public String VerificaAtalhoRemovido(int index) {  
		for (int i = 0; i < this.elementos.size(); i ++) {
			if(elementos.get(index) instanceof Atalho) {
				return ((Atalho) this.elementos.get(index)).getTitulo();
			}
		}
		return "";
	}
	
	/**
	 * Verifica se um documento possui atalho. 
	 * 
	 * @return Boolean informando se existe atalho no documento.
	 */
	public boolean PossuiAtalho() {
		boolean result = false;
		for (Elementavel elemento: this.elementos) {
			if(elemento instanceof Atalho) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Verifica se um documento que será  atalho possui titulo. 
	 * @param titulo Titulo do documento.
	 * @return Boolean informando se o documento que será atalho já possui atalho.
	 */
	public boolean PossuiAtalho(String titulo) {
		boolean result = false;
		for (Elementavel elemento: this.elementos) {
			if(elemento instanceof Atalho) {
				if ( ((Atalho) elemento).getDoc().getTitulo().equals(titulo)) {
					result = true;
				}
			}
		}
		return result;
	}
	
	/**
	 * Busca o indíce do atalho no array de elementos. 
	 * 
	 * @param titulo Titulo do documento.
	 * @return Inteiro representando o indíce do atalho.
	 */
	public int getIndexAtalho(String titulo) {
		int result = -1;
		for (int i = 0; i < this.elementos.size(); i++) {
			if(elementos.get(i) instanceof Atalho) {
				if (((Atalho) elementos.get(i)).getDoc().getTitulo().equals(titulo)) {
					result = i;
				}
			}
		}
		return result;
	}
	
	/**
	 * Pega o atributo eAtalho. 
	 * 
	 * @return Boolean com o resultado do atributo.
	 */
	public boolean isAtalho() { 
		return eAtalho;
	}

	/**
	 * Modifica o estado do atributo eAtalho. 
	 * 
	 * @param eAtalho Atributo eAtalho a ser modificado.
	 */
	public void seteAtalho(boolean eAtalho) {
		this.eAtalho = eAtalho;
	}
	
	/**
	 * Calcula a média das prioridades presentes nos elementos. 
	 * 
	 * @return Double com a média das prioridades de um documento.
	 */
	public double mediaPrioridades() {
		double media = 0;
		for (Elementavel o: this.elementos) {
			media += o.getPrioridade();
		}
		
		return media / this.elementos.size();
	}
	
	/**
	 * Cocatena todos os elementos de forma completa de um documento que é atalho. 
	 * 
	 * @return String com a representação de todos os elementos.
	 */
	public String cocatenaElementosCompleto() {
		String cocatenado = "";
		for (Elementavel o: this.elementos) {
			if (o.getPrioridade() > 3) {
				cocatenado += o.getRepresentacaoCompleta() + " ";
			}
		}
		return cocatenado;
	}
	
	/**
	 * Cocatena todos os elementos de forma resumida de um documento que é atalho. 
	 * 
	 * @return String com a representação de todos os elementos.
	 */
	public String cocatenaElementosResumido() {
		String cocatenado = "";
		for (Elementavel o: this.elementos) {
			if (o.getPrioridade() > 3) {
				cocatenado += o.getRepresentacaoResumida() + " ";
			}
		}
		return cocatenado;
	}

	/**
	 * Cria um array com todos elementos na representação completa.
	 * 
	 * @return Array com a visão completa dos elementos.
	 */
	public String[] visaoCompleta() {
		String[] visao = new String[this.elementos.size()];
    	int i = 0;
    	for(Elementavel e: this.elementos) {
    		visao[i++]= e.getRepresentacaoCompleta();
    	}
    	return visao;
	}

	/**
	 * Cria um array com todos elementos na representação resumida.
	 * 
	 * @return Array com a visão resumida dos elementos.
	 */
	public String[] visaoResumida() {
    	String[] visao = new String[this.elementos.size()];
    	int i = 0;
    	for(Elementavel e: this.elementos) {
    		visao[i++] = e.getRepresentacaoResumida();
    	}
    	return visao;	
	}

	/**
	 * Cria uma visão a partir do parâmetro que é reccebido. 
	 * 
	 * @param prioridade Parâmetro que identifica os elementos desejáveis.
	 * @return Array com a visão prioritária dos elementos.
	 */
	public String[] visaoPrioritaria(int prioridade) {
		int tamanho = 0;
		for(Elementavel e: this.elementos) {
    		if (e.getPrioridade() >= prioridade) {
    			tamanho++;
    		}
    	}
    	String[] visao = new String[tamanho];
    	int i = 0;
    	for(Elementavel e: this.elementos) {
    		if (e.getPrioridade() >= prioridade) {
    			visao[i++] = e.getRepresentacaoCompleta();
    		}
    	}
    	return visao;	
	}

	/**
	 * Cria uma visão com elementos do tipo Titulo.
	 * 
	 * @return Array com a visão contendo elementos do tipo Titulo.
	 */
	public String[] visaoTitulo() {
		int tamanho = 0;
		for(Elementavel e: this.elementos) {
    		if (e instanceof Titulo) {
    			tamanho++;
    		}
    	}
    	String[] visao = new String[tamanho];
    	int i = 0;
    	for(Elementavel e: this.elementos) {
    		if (e instanceof Titulo) {
    			visao[i++] = e.getRepresentacaoResumida();
    		}
    	}
    	return visao;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(titulo, other.titulo);
	}
}
