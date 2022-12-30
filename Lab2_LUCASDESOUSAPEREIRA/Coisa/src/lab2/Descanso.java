package lab2;
/**
 * Representação do estado de um determinado aluno. Este auluno pode ter dois
 * estados: cansado e descansado. Por vez, isso depende da quantidade de horas
 * definidas para o aluno ser considerado descansado ou não.
 * 
 * @author lucas
 */
public class Descanso {
	/**
	 * Semanas decorridas em um determinado tempo de descanso.
	 */
    private int semana;
    /**
     * Tempo utilizado, em horas, para o descanso.
     */
    private int tempo;
    /**
     * Constrói o estado do aluno (descansado e cansado) à partir das horas
     * e semanas decorridas. A semana inicia em um e o tempo em zero. É
     * considerado como essencial 26 horas/semana para ser considerado
     * descansado.
     */
    public Descanso() {
        this.semana = 1;
        this.tempo = 0;
    }
    /**
     * Define a quantidade de horas de descanso de um aluno em um determinado
     * tempo para ao final poder dizer se ele está "descansado" ou "cansado".
     * 
     * @param tempo horas de descanso de um determinado aluno.
     */
    public void defineHorasDescanso(int tempo) {
        this.tempo = tempo;
    }
    /**
     * Constata-se quantas semanas foram decorridas no tempo que foi definido
     * pelo aluno.
     * 
     * @param semana quantidade de semanas decorridas no tempo de descanso definido pelo aluno.
     */
    public void defineNumeroSemanas(int semana) {
        this.semana = semana;
    }
    /**
     * Retorna a partir da divisão entre tempo e aluno : "descansado" ou 
     * "cansado".
     * 
     * @return estado do aluno em formato String.
     */
    public String getStatusGeral() {
        if (this.tempo / this.semana >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }
}