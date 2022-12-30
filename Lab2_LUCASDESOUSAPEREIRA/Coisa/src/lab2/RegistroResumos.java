package lab2;
/**
 * Representação de textos que armazena informações vistas pelo aluno como úteis e que, ademais,
 * pode ser revista pelo mesmo para algum fim. Ademais, verifica se o aluno já guardou ou não alguma
 * informação.
 * 
 * @author lucas
 */
public class RegistroResumos {
	/**
	 * Identifica a capacidade suportada para armazenar informações.
	 */
    private int numeroDeResumos;
    /**
     * Preenche espaços de um array no formato: tema + ": " + resumo.
     */
    private String[] resumos;
    /**
     * Acopla os temas em posições de um array para depois verificar se ele está cadastrado.
     */
    private  String[] recebeTemas;
    /**
     * Posicao é utilizado para identificar a posição de um array e serve como um contador de resumos registrados.
     */
    private int posicao;
    /**
     * Imprime os temas dos resumos, no formato: Tema1 | Tema 2 ...
     */
    private String vizualizaResumos;
    /**
     * O cont auxilia para saber se o array necessita ou não ser resetado para poder receber
     * novos resumos.
     */
    private int cont;
    /**
     * Constrói um armazenamento de dados que, a posteriori, será impressa no monitor para vizualização
     * do aluno. É definida uma quantidade limitada de resumos que é definida pelo usuário.
     * 
     * @param numeroDeResumos define a quantidade possível de resumos para ser registrado.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        this.resumos = new String[numeroDeResumos];
        this.recebeTemas = new String[numeroDeResumos];
        this.posicao = 0;
    }
    /**
     * Recebe um tema e um resumo que contém informações sobre tema. Este é guardado em um array
     * que tem uma capacidade de resumos definida.
     * 
     * @param tema usuário informa um tema a ser registrado.
     * @param resumo usuário passa informações a serem registradas sobre o tema.
     */
    public void adiciona(String tema, String resumo) {
    	if (this.cont >= this.numeroDeResumos) {
    		cont = 0;
    	}
    	if (this.posicao < this.numeroDeResumos) {
    		this.resumos[this.posicao] = tema + ": " + resumo;
        	this.recebeTemas[this.posicao] = tema;
        	this.posicao++;
    	}else if (this.posicao == this.numeroDeResumos) {
            this.resumos[this.posicao - this.numeroDeResumos + cont] = tema + ": " + resumo;
            this.recebeTemas[this.posicao - this.numeroDeResumos + cont] = tema;
            cont++;
        }
    }
    /**
     * Retorna um array formatado com a cocatenação do tema e do resumo.
     * 
     * @return array de resumos no formato String[].
     */
    public String[] pegaResumos() {
        return this.resumos;
    }
    /**
     * Retorna a quantidade de resumos registrados.
     * 
     * @return números de resumos registrados no formato int.
     */
    public int conta() {
        return this.posicao;
    }
    /**
     * Retorna a verificação de um determinado tema que pode ou não já ter sido registrado.
     * 
     * @param temaAnalisado recebe um tema para verificação de registro.
     * @return analisação de um tema no formato boolean.
     */
    public boolean temResumo(String temaAnalisado) {
        for (int i = 0; i < this.posicao; i++) {
            if (this.recebeTemas[i].equals(temaAnalisado)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Retorna todos os temas já cadastrados, assim como, a quantidade de resumos registrados.
     * 
     * @return formatação de informações de quantidade e temas no formato String.
     */
    public String imprimeResumos() {
        this.vizualizaResumos = "- ";
        for (int i = 0; i < this.posicao; i++) {
            if (i != this.posicao - 1) {
                this.vizualizaResumos += this.recebeTemas[i] + " | ";
            } else if (i == this.posicao - 1) {
                this.vizualizaResumos += this.recebeTemas[i];
            }
        }
        return "- " + this.posicao + " resumo(s) cadastrado(s)" + "\n" + this.vizualizaResumos;
    }
}