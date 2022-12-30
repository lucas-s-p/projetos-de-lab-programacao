package documin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Um sistema de Documentos, um sistema que manipula documentos e elementos que fazem parte do documento. 
 * 
 * @author lucas
 */
public class DocumentosController {
	/**
	 * HashMap para armazenar documentos, tem como chave o titulo e valor um Documento.
	 */
	private HashMap<String, Documento> docs;
	/**
	 * ArrayList contendo um array de strings com visões de um documento.
	 */
	private ArrayList<String[]> visoes;
	
	/**
	 * Constrói o sistema de documentos e inicializa atributos.
	 */
	public DocumentosController() {
		this.docs = new HashMap<>();
		this.visoes = new ArrayList<>();
	}
	
	/**
	 * Adiciona um documento a partir de um identificador (Titulo) e um tamanho.
	 * 
	 * @param titulo Titulo do documento.
	 * @param tamanho Tamanho do documento. 
	 * @return Boolean confirmando se o cadastro do documento foi reallizado com sucesso.
	 */
	public boolean addDocumento(String titulo, int tamanho) { 
		if (this.docs.containsKey(titulo)) {
			return false;
		}
		if (titulo.trim().equals("")) {
			return false;
		}
		this.docs.put(titulo, new Documento(titulo, tamanho));
		return true;
	}
	
	/**
	 * Adiciona um documento a partir de um identificador (Titulo) e um tamanho indefinido.
	 * 
	 * @param titulo Titulo do documento.
	 * @return Boolean confirmando se o cadastro do documento foi reallizado com sucesso.
	 */
	public boolean addDocumento(String titulo){
		if (this.docs.containsKey(titulo)) {
			return false;
		}
		if (titulo.trim().equals("")) {
			return false;
		}
		this.docs.put(titulo, new Documento(titulo));
		return true;
	}
	
	/**
	 * Remove um documento a partir de um titulo.
	 * 
	 * @param titulo Titulo do documento.
	 */
	public void removeDocumentos(String titulo) {   //falta fazer testes
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		this.docs.remove(titulo);
	}

	/**
	 * Contabiliza a quantidade de elementos em um documento identificaco pelo titulo.
	 * 
	 * @param titulo Titulo do documento.
	 * @return Inteiro com a quantidade de elementos.
	 */
	public int contarElementos(String titulo) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		return this.docs.get(titulo).qtdElementos();
	}

	/**
	 * Cadastra um elemento do tipo Texto que contém valor e prioridade.
	 * 
	 * @param titulo Titulo do documento.
	 * @param valor Conteúdo a ser abordado no texto.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
	public int cadastraTexto(String titulo, String valor, int prioridade) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		return this.docs.get(titulo).criaTexto(valor, prioridade);
	}

	/**
	 * Cadastra um elemento do tipo Termo que contém valor, prioridade, separador e ordem.
	 * 
	 * @param titulo Titulo do documento.
	 * @param valor Conteúdo a ser abordado no termo.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param separador Indica em que ponto é separado cada termo.
	 * @param ordem Forma de ordenação do valor.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
	public int cadastraTermo(String titulo, String valor, int prioridade, String separador, String ordem) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		return this.docs.get(titulo).criaTermo(valor, prioridade, separador, ordem);
	}

	/**
	 * Cadastra um elemento do tipo Lista que contém valor, prioridade, separador e caractere.
	 * 
	 * @param titulo Titulo do documento.
	 * @param valor Conteúdo a ser abordado na lista.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param separador Indica em que ponto é separado cada item da lista.
	 * @param caractere Caractere que sequencializa os itens.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
	public int cadastraLista(String titulo, String valor, int prioridade, String separador, String caractere) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		return this.docs.get(titulo).criaLista(valor, prioridade, separador, caractere);
	}

	/**
	 * Cadastra um elemento do tipo Titulo que contém valor, prioridade, separador e caractere.
	 * 
	 * @param titulo Titulo do documento.
	 * @param valor Conteúdo a ser abordado no titulo.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param nivel Nivel do titulo.
	 * @param link Boolean indicando se é linkável.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
	public int cadastraTitulo(String titulo, String valor, int prioridade, int nivel, boolean link) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		return this.docs.get(titulo).criaTitulo(valor, prioridade, nivel, link);
	}
	
	/**
	 * Representação visual de um elemento com informações mais completas. 
	 * 
	 * @param titulo Titulo do documento.
	 * @param posElemento Posição do elemento no documento.
	 * @return Texto com a visualização do elemento.
	 */
	public String getRepresentacaoCompleta(String titulo, int posElemento) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		return this.docs.get(titulo).exibeElementoCompleto(posElemento);
	}
	
	/**
	 * Representação visual de um elemento com informações gerais e pouco amplas.
	 * 
	 * @param titulo Titulo do documento.
	 * @param posElemento Posição do elemento no documento.
	 * @return Texto com a visualização do elemento.
	 */
	public String getRepresentacaoResumida(String titulo, int posElemento) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		return this.docs.get(titulo).exibeElementoResumido(posElemento);
	}
	
	/**
	 * Remove um elemento de um documento pelo identificador (Titulo).
	 * 
	 * @param titulo Titulo do documento.
	 * @param elementoPosicao Posição do elemento no documento.
	 * @return Boolean informando se a remoção foi bem sucedida.
	 */
	public boolean apagaElemento(String titulo, int elementoPosicao) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		if (!this.docs.get(titulo).VerificaAtalhoRemovido(elementoPosicao).equals("")){
			String tituloAtalho = this.docs.get(titulo).VerificaAtalhoRemovido(elementoPosicao);
			this.docs.get(tituloAtalho).seteAtalho(false);
		}
		return this.docs.get(titulo).removeElemento(elementoPosicao);  // quando remover ?
	}
	
	/**
	 * Move um elemento uma posição a frente, ou seja, troca as posições.
	 * 
	 * @param titulo Titulo do documento.
	 * @param elementoPosicao Posição do elemento no documento.
	 */
	public void moverParaCima(String titulo, int elementoPosicao) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		this.docs.get(titulo).PosAcima(elementoPosicao);
	}
	
	/**
	 * Move um elemento uma posição abaixo, ou seja, troca as posições.
	 * 
	 * @param titulo Titulo do documento.
	 * @param elementoPosicao Posição do elemento no documento.
	 */
	public void moverParaBaixo(String titulo, int elementoPosicao) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		this.docs.get(titulo).PosAbaixo(elementoPosicao);
	}
	
	/**
	 * Exibe um documento com todos os seus elmentos em um array de strings.
	 * 
	 * @param titulo Titulo do documento.
	 * @return Representação do documento.
	 */
	public String[] exibirDocumento(String titulo) {
		if (temIrreguralidadeVazio(titulo) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(titulo) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
		return this.docs.get(titulo).exibeDocumentoCompleto();
	}
	
	/**
	 * Cria um atalho em um documento para outro documento com informações deste elemento que é atalho.
	 * 
	 * @param titulo Titulo do documento que possui o atalho.
	 * @param tituloDocReferenciado Titulo do documento que é atalho.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
    public int criarAtalho(String titulo, String tituloDocReferenciado) {
		if (tituloDocReferenciado.trim().equals("")) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		Documento doc = docs.get(titulo);
		Documento docAtalho = docs.get(tituloDocReferenciado);
		if (doc == null || docAtalho == null) {
			throw new NoSuchElementException("Documento inexistente");
		}
		if (doc.isAtalho() || docAtalho.PossuiAtalho()) {
			throw new IllegalStateException("Não é possível inserir esse atalho.");
		}
		return doc.AddDocumentoAtalho(docAtalho);
		
    }
	
	/**
	 * Cria uma representação completa de cada elemento do documento. 
	 * 
	 * @param tituloDoc Titulo do Documento.
	 * @return Inteiro informando a posição da visão.
	 */
    public int criarVisaoCompleta(String tituloDoc) {
		if (temIrreguralidadeVazio(tituloDoc) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(tituloDoc) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
    	visoes.add(this.docs.get(tituloDoc).visaoCompleta());
    	return (Integer) visoes.size() - 1;
    }
    
	/**
	 * Cria uma representação resumida de cada elemento do documento. 
	 * 
	 * @param tituloDoc Titulo do Documento.
	 * @return Inteiro informando a posição da visão.
	 */
    public int criarVisaoResumida(String tituloDoc) {
		if (temIrreguralidadeVazio(tituloDoc) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(tituloDoc) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
    	visoes.add(this.docs.get(tituloDoc).visaoResumida());
    	return (Integer) visoes.size() - 1;	
    }

	/**
	 * cria uma representação completa de cada elemento do documento que tenha prioridade maior ou igual que um determinado valor informado como parâmetro. 
	 * 
	 * @param tituloDoc Titulo do Documento.
	 * @param prioridade Prioridade desejada dos elementos para compor a visão.
	 * @return Inteiro informando a posição da visão.
	 */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		if (temIrreguralidadeVazio(tituloDoc) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(tituloDoc) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
    	visoes.add(this.docs.get(tituloDoc).visaoPrioritaria(prioridade));
    	return (Integer) visoes.size() - 1;
    }
    
	/**
	 * Cria uma representação resumida de cada elemento do tipo título.
	 * 
	 * @param tituloDoc Titulo do Documento.
	 * @return Inteiro informando a posição da visão.
	 */
    public int criarVisaoTitulo(String tituloDoc) {
		if (temIrreguralidadeVazio(tituloDoc) == true) {
			throw new IllegalArgumentException("Titulo Inválido");
		}
		if (temIrreguralidadeDocInexistente(tituloDoc) == true) {
			throw new NoSuchElementException("Documento inexistente");
		}
    	visoes.add(this.docs.get(tituloDoc).visaoTitulo());
    	return (Integer) visoes.size() - 1;
    	
    }
    
	/**
	 * Exibe uma visão pelo id que é retornado ao criar uma visão. 
	 * 
	 * @param visaoId Id da visão.
	 * @return Visão a ser exibida pelo id informado.
	 */
    public String[] exibirVisao(int visaoId) {
  		return this.visoes.get(visaoId);	
      }
    
	/**
	 * verifica se um documento possui o titulo vazio ou se é formado por espaços vazios.
	 * 
	 * @param titulo Titulo do documento.
	 * @return Boolean informando se possui irregularidade.
	 */
    private boolean temIrreguralidadeVazio(String titulo) {
		if (titulo.trim().equals("")) {
			return true;
		}
		return false;
    }
	
	/**
	 * Verifica se o titulo em questão já tem um titulo associado.
	 * 
	 * @param titulo Titulo do documento.
	 * @return Boolean informando se possui irregularidade. 
	 */
    private boolean temIrreguralidadeDocInexistente(String titulo) {
    	if (!this.docs.containsKey(titulo)) {
    		return true;
    	}
		return false;
    }
}