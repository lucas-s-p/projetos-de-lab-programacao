package lab2;
/**
 * Representação da quantidade de tempo em que um aluno estuda de forma remota e pode-se a depender
 * do aluno dizer ou não o tempo esperado de estudo online. 
 * 
 * @author lucas
 */
public class RegistroTempoOnline {
	/**
	 * Identica uma disciplina de um aluno.
	 */
    private String nomeDisciplina;
    /**
     * Tempo, em horas, de estudo considerado ideal para uma disciplina.
     */
    private int tempoOnlineEsperado;
    /**
     * Tempo, em horas, que já foi utilizado para os estudos.
     */
    private int tempo;
    /**
     * Constrói o tempo online de um aluno em uma disciplina x e, além disso, passa-se o tempo que
     * é esperado de estudo online na mesma.
     * 
     * @param nomeDisciplina o nome da disciplina em questão.
     * @param tempoOnlineEsperado tempo de estudo esperado em uma disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }
    /**
     * Constrói o tempo de estudo online em uma disciplina, mas como padrão para disciplinas de
     * 4 créditos tem-se 120 horas esperadas.
     * 
     * @param nomeDisciplina o nome da disciplina em questão.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }
    /**
     * Recebe o tempo que estuda, sendo que este tempo pode ser adicionado n vezes e cocatenado
     * com tempo anteriores.
     * 
     * @param tempo tempo decorrido de estudo.
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempo += tempo;
    }
    /**
     * Verifica se o aluno atingiu a meta de tempo esperado para aquela dsiciplina.
     * 
     * @return verificação de meta retornando um boolean.
     */
    public boolean atingiuMetaTempoOnline() {
        return (this.tempo >= this.tempoOnlineEsperado);
    }
    /**
     * Aqui é estruturado uma mensagem de impressão na tela com o nome da disciplina, tempo decorrido
     * e tempo esperado.
     * 
     * @return Foramatação de informações de uma disciplina no formato string.
     */
    public String toString() {
        return this.nomeDisciplina + " " + this.tempo + "/" + this.tempoOnlineEsperado;
    }
}