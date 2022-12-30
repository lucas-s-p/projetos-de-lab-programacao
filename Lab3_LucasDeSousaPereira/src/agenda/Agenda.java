package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. Pode favoritar um contato e removê-lo.
 * 
 * @author lucas
 */
public class Agenda {
	/**
	 * Array de objetos contendo o contato com os parâmetros: nome, sobrenome, telefone.
	 */
	private Contato[] contatos;
	private Contato[] favoritos;
	public Agenda() {
		this.contatos = new Contato[100];
		this.favoritos = new Contato[10];
	}
	
	/**
	 * Acessa a lista de contatos mantida. Retorna a formatação contendo posicão, nome e sobrenome de todos contatos cadastrados na agenda.
	 * 
	 * @return O array de contatos.
	 */
	public String getContatos() {
		String lista = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				lista += contatos[i].exibeContatos(i) + "\n";
			}
		}
		return lista;
	}

	/**
	 * Acessa os dados de um contato específico e exibe ele para o usuário, este conatato pode está ou não favoritado, ele estando é adicionado um emoji de coração.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição com o retorno de "POSIÇÃO INVÁLIDA".
	 */
	public String getContato(int posicao) {
		posicao -= 1;
		boolean ehFavorito = false;
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				if (favoritos[i].getPosicao() == contatos[posicao].getPosicao()) {
					ehFavorito = true;
				}
			}
		}
		if (this.contatos[posicao] != null) {
			if (ehFavorito) {
				return "❤️ " + contatos[posicao].toString();
			} else {
				return contatos[posicao].toString();
			}
		} else {
			return "POSICAO INVALIDA";
		}
	}
	
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. O cadastro é feito a partir da instância de um objeto contendo as informações necessárias de um contato e armazenando estes em um array do tipo Contato[] que tem o tamanho da agenda.
	 * 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @return String representando se o contato foi ou não cadastrado.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		Contato meuContato = new Contato(posicao, nome, sobrenome, telefone);
		String achouIrregularidade = "";
        for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null && this.contatos[i].getNome().equals(nome) && this.contatos[i].getSobrenome().equals(sobrenome)) {
				achouIrregularidade = "CONTATO JA CADASTRADO";
			}
		}
	    if (nome.equals("") || telefone.equals("")) {
	        achouIrregularidade = "CONTATO INVALIDO";
	    }
	    if (posicao < 1 || posicao > 100) {
	        achouIrregularidade = "POSICAO INVALIDA";
	    }
	    if (achouIrregularidade.equals("")) {
	        posicao --;
	        this.contatos[posicao] = meuContato;
	        achouIrregularidade = "CADASTRO REALIZADO";
	    }
		return achouIrregularidade;
	}

	/**
	 * Adiciona um contato da agenda em uma lista de favoritos que pode conter até 10 contatos, vale ressaltar que não poder colocar dois contatos iguais como favoritos e se colocar um contato na mesma posição como favorito o antigo sai da lista de favoritos.
	 * 
	 * @param favContato Contato a ser favoritado da agenda.
	 * @param favPos Posição em que o contato a ser favoritado irá ficar na lista de favoritos.
	 * @return String informando se o contato foi aceito como favorito.
	 */
	public String adicionaFavorito(int favContato, int favPos) {
    		favPos--;
    		favContato--;
    		for (int i = 0; i < favoritos.length; i++) {
    			if (contatos[favContato].equals(favoritos[i])) {
    				return "CONTATO JA FAVORITADO!";
    			}
    		}
    		this.favoritos[favPos] = contatos[favContato];
    		return "CONTATO FAVORITADO NA POSIÇÃO " + (favPos + 1) + "!";  	
	}

	/**
	 * Utiliza do array de favoritos para poder exibir os contatos favoritos para o usuário.
	 * 
	 * @return String com a formatação dos contatos favoritos.
	 */
    public String favoritos() { 
		String fav = "";
		for (int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				fav += favoritos[i].exibeContatos(i) + "\n";
			}
		}
		return fav;
    }

	/**
	 * Remove um contato que o usuário não deseja da lista de favoritos.
	 * 
	 * @param numContato Posição do contato a ser desfavoritado.
	 */
    public void removeFavorito(int posContato) {
		posContato--;
		this.favoritos[posContato] = null;
    }
}