package agenda;

/**
 * Recebe as informações dos contatos para poder auxiliar na criação de um array de objetos contendo os contatos e poder facilitar o acesso das informações.
 * 
 * @author lucas
 */ 
public class Contato {
    private String sobrenome;
    private String nome;
    private String telefone;
    private int posicao;

    /**
     * Retorna uma string com uma segunda identificação para um contato.
     * 
     * @return Sobrenome de um contato.
     */
    public String getSobrenome() {
        return this.sobrenome;
    }
    public int getPosicao() {
        return posicao;
    }
    /**
     * Retorna uma string com a primeira identificação para um contato.
     * 
     * @return Nome de um contato.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna o número de identificação de um contato.
     * 
     * @return Telefoene de um contato.
     */
    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Usado para manipular um nome de contato.
     * @param favoritadoNome Usado para adicionar um emoji ao contato favoritado.
     */
    public void setNome(String favoritadoNome) {
        this.nome = favoritadoNome;
    }

    /**
     * Cria um contato que contém nome sobrenome e telefone.
     * 
     * @param nome Nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefone Telefone do contato.
     */
    public Contato(int posicao, String nome, String sobrenome, String telefone) {
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.telefone = telefone;
        this.posicao = posicao;
    }
    
    public String toString() {
        if (sobrenome.equals("")) {
            return this.nome + "\n" + this.telefone;
        } else {
            return this.nome + " " + this.sobrenome + "\n" + this.telefone;
        }
    }

    public String exibeContatos(int i) {
        if (sobrenome.equals("")) {
            return (i + 1) + " - " + this.nome;
        } else {
            return (i + 1) + " - " + this.nome + " " + this.sobrenome;
        }
    }
}