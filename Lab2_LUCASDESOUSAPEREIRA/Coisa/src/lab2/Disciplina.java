package lab2;
import java.util.Arrays;

/**
 * Representação detalhada de um aluno, especificamente trata-se das notas em provas, médias, 
 * horas e da disciplina que representa essas informações.
 * 
 * @author lucas
 */
public class Disciplina {
	/**
	 * Nome da disciplina. Identifica uma disciplina para trabalhar com informações dela.
	 */
    private String nomeDisciplina;
    /**
     * Horas dedicadas para a disciplina.
     */
    private int horas;
    /**
     * O array notas preenche todas as notas obtidas em um disciplina.
     */
    private double[] notas;
    /**
     * Constrói informações de uma disciplina a partir das características obtidas desta.
     * Transmitindo informações gerais de um aluno na disciplina x, referindo-se a nome, horas,
     * notas, e média.
     * 
     * @param nomeDisciplina nome da disciplina em questão.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];
    }
    /**
     * Recebe uma quantidade de horas já utilizadas para estudo daquela disciplina, por sua vez,
     * esta pode se acumular.
     * 
     * @param horas quantidade de horas utilizadas para estudar.
     */
    public void cadastraHoras(int horas) {
        this.horas += horas;
    }
    /**
     * Recebe a nota de uma prova x e está vai compor a média na disciplina.
     * 
     * @param nota identifica qual prova é o valorNota.
     * @param valorNota atribui valor a uma nota.
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }
    
    /**
     * Calcula a média de todas as notas recebidas de um arrray vetor, que são um total de 4 notas,
     * e a partir disso retorna a média.
     * 
     * @return média em formato double.
     */
    private double calculaMedia() {
        double somaNotas = 0;
        for (int i = 0; i < this.notas.length; i++) {
            somaNotas += this.notas[i];
        }
        return (somaNotas / this.notas.length);
    }
   /**
    * Verifica se o aluno foi aprovado ou não na disciplina especificada, média maior ou igual a
    * sete resulta em aprovação, ao contrário, reprovado.
    * 
    * @return aprovação em formato boolean.
    */
    public boolean aprovado() {
        if (calculaMedia() >= 7) {
            return true;
        }
        return false;
    }
    /**
    * Retorna uma representação da saída no monitor descrevedo o nome da disciplina, horas de
    * estudos, média e a representação das quatro notas.
    * 
    * @return formatação representativa de uma disciplina em formato string.
    */
        public String toString() {
        return this.nomeDisciplina + " " + this.horas + " " + calculaMedia() + " " + Arrays.toString(this.notas);
    }
}