package documin;

/**
 * Cria o sistema que organiza o controller.
 * 
 * @author lucas
 */
public class Facade {

    private DocumentosController documentoController;
    
  /**
     * Classe que organiza todos os controller.
     */
    public Facade() {
        this.documentoController = new DocumentosController();
    }

  /**
	 * Adiciona um documento a partir de um identificador (Titulo) e um tamanho indefinido.
	 * 
	 * @param titulo Titulo do documento.
	 * @return Boolean confirmando se o cadastro do documento foi reallizado com sucesso.
	 */
    public boolean criarDocumento(String titulo) {
        return this.documentoController.addDocumento(titulo);
    }
    
  /**
	 * Adiciona um documento a partir de um identificador (Titulo) e um tamanho.
	 * 
	 * @param titulo Titulo do documento.
	 * @param tamanhoMaximo Tamanho do documento. 
	 * @return Boolean confirmando se o cadastro do documento foi reallizado com sucesso.
	 */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
    	return this.documentoController.addDocumento(titulo, tamanhoMaximo);
    }

  /**
	 * Remove um documento a partir de um titulo.
	 * 
	 * @param titulo Titulo do documento.
	 */
    public void removerDocumento(String titulo) {
    	this.documentoController.removeDocumentos(titulo);
    }
    
  /**
	 * Contabiliza a quantidade de elementos em um documento identificaco pelo titulo.
	 * 
	 * @param titulo Titulo do documento.
	 * @return Inteiro com a quantidade de elementos.
	 */
    public int contarElementos(String titulo) {
		return this.documentoController.contarElementos(titulo);
    }
    
  /**
	 * Exibe um documento com todos os seus elmentos em um array de strings.
	 * 
	 * @param titulo Titulo do documento.
	 * @return Representação do documento.
	 */
    public String[] exibirDocumento(String titulo) {
		return this.documentoController.exibirDocumento(titulo);
    	
    }
    
  /**
	 * Cadastra um elemento do tipo Texto que contém valor e prioridade.
	 * 
	 * @param tituloDoc Titulo do documento.
	 * @param valor Conteúdo a ser abordado no texto.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	return this.documentoController.cadastraTexto(tituloDoc, valor, prioridade);
    }
    
  /**
	 * Cadastra um elemento do tipo Titulo que contém valor, prioridade, separador e caractere.
	 * 
	 * @param tituloDoc Titulo do documento.
	 * @param valor Conteúdo a ser abordado no titulo.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param nivel Nivel do titulo.
	 * @param linkavel Boolean indicando se é linkável.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	return this.documentoController.cadastraTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }
    
  /**
	 * Cadastra um elemento do tipo Lista que contém valor, prioridade, separador e caractere.
	 * 
	 * @param tituloDoc Titulo do documento.
	 * @param valorLista Conteúdo a ser abordado na lista.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param separador Indica em que ponto é separado cada item da lista.
	 * @param charLista Caractere que sequencializa os itens.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	return this.documentoController.cadastraLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }
    
  /**
	 * Cadastra um elemento do tipo Termo que contém valor, prioridade, separador e ordem.
	 * 
	 * @param tituloDoc Titulo do documento.
	 * @param valorTermos Conteúdo a ser abordado no termo.
	 * @param prioridade Nivel de prioridade do elemento.
	 * @param separador Indica em que ponto é separado cada termo.
	 * @param ordem Forma de ordenação do valor.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	return this.documentoController.cadastraTermo(tituloDoc, valorTermos, prioridade, separador, ordem);
    }
    
  /**
	 * Representação visual de um elemento com informações mais completas. 
	 * 
	 * @param tituloDoc Titulo do documento.
	 * @param elementoPosicao Posição do elemento no documento.
	 * @return Texto com a visualização do elemento.
	 */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.getRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }
    
  /**
	 * Representação visual de um elemento com informações gerais e pouco amplas.
	 * 
	 * @param tituloDoc Titulo do documento.
	 * @param elementoPosicao Posição do elemento no documento.
	 * @return Texto com a visualização do elemento.
	 */
    public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.getRepresentacaoResumida(tituloDoc, elementoPosicao);
    }
    
  /**
	 * Remove um elemento de um documento pelo identificador (Titulo).
	 * 
	 * @param tituloDoc Titulo do documento.
	 * @param elementoPosicao Posição do elemento no documento.
	 * @return Boolean informando se a remoção foi bem sucedida.
	 */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		return this.documentoController.apagaElemento(tituloDoc, elementoPosicao);
    	
    }
    
  /**
	 * Move um elemento uma posição a frente, ou seja, troca as posições.
	 * 
	 * @param tituloDoc Titulo do documento.
	 * @param elementoPosicao Posição do elemento no documento.
	 */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaCima(tituloDoc, elementoPosicao);
    }
    
  /**
	 * Move um elemento uma posição abaixo, ou seja, troca as posições.
	 * 
	 * @param tituloDoc Titulo do documento.
	 * @param elementoPosicao Posição do elemento no documento.
	 */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }
    
  /**
	 * Cria um atalho em um documento para outro documento com informações deste elemento que é atalho.
	 * 
	 * @param tituloDoc Titulo do documento que possui o atalho.
	 * @param tituloDocReferenciado Titulo do documento que é atalho.
	 * @return Inteiro informando a posição do elemento cadastrado.
	 */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
    	return this.documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
    }
    
   	/**
	 * Cria uma representação completa de cada elemento do documento. 
	 * 
	 * @param tituloDoc Titulo do Documento.
	 * @return Inteiro informando a posição da visão.
	 */
    public int criarVisaoCompleta(String tituloDoc) {
    	return this.documentoController.criarVisaoCompleta(tituloDoc);
    }
    
	/**
	 * Cria uma representação resumida de cada elemento do documento. 
	 * 
	 * @param tituloDoc Titulo do Documento.
	 * @return Inteiro informando a posição da visão.
	 */
    public int criarVisaoResumida(String tituloDoc) {
    	return this.documentoController.criarVisaoResumida(tituloDoc);
    }
    
	/**
	 * cria uma representação completa de cada elemento do documento que tenha prioridade maior ou igual que um determinado valor informado como parâmetro. 
	 * 
	 * @param tituloDoc Titulo do Documento.
	 * @param prioridade Prioridade desejada dos elementos para compor a visão.
	 * @return Inteiro informando a posição da visão.
	 */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
    	return this.documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
    } 
    
	/**
	 * Cria uma representação resumida de cada elemento do tipo título.
	 * 
	 * @param tituloDoc Titulo do Documento.
	 * @return Inteiro informando a posição da visão.
	 */
    public int criarVisaoTitulo(String tituloDoc) {
    	return this.documentoController.criarVisaoTitulo(tituloDoc);
    }
    
	/**
	 * Exibe uma visão pelo id que é retornado ao criar uma visão. 
	 * 
	 * @param visaoId Id da visão.
	 * @return Visão a ser exibida pelo id informado.
	 */
    public String[] exibirVisao(int visaoId) {
    	return this.documentoController.exibirVisao(visaoId);
    }
}