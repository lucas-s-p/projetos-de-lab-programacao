package alunos;
import java.util.HashMap;

/**
 *  Cria um grupo.
 * 
 * @author lucas
 */
public class Grupo {
    private String grupo;
    private String tamanho;
    private HashMap<String, Aluno> alocaAluno;

    /**
     * Constrói um grupo a partir de um tamanho e um nome.
     * 
     * @param grupo Nome do grupo.
     * @param tamanho Tamanho do grupo.
     */
    public Grupo(String grupo, String tamanho) {
		if (grupo == null) {
			throw new NullPointerException("Grupo Inválido.");
		} else if (grupo.equals("")) {
			throw new IllegalArgumentException("Grupo Inválido.");
		} else if (!tamanho.equals("") && Integer.parseInt(tamanho) <= 0) {
			throw new IllegalArgumentException("Tamanho Inválido");
		}
        this.alocaAluno = new HashMap<>();
        this.grupo = grupo;
        this.tamanho = tamanho;
    }
    
    /**
     * Adiciona um aluno a um grupo.
     * 
     * @param alunos Aluno que vai entrar em um grupo.
     * @return Retorna se o aluno foi acoplado a um grupo ou não.
     */
    public boolean adicionaAluno(Aluno alunos) {
        if (tamanho.equals("")) {
            this.alocaAluno.put(alunos.getMatricula(), alunos);
        }else if (this.alocaAluno.size() >= Integer.parseInt(this.tamanho)) {
            return false;
        } else {
            this.alocaAluno.put(alunos.getMatricula(), alunos);
        }
        return true;
    }

    /**
     * Verifica se um aluno pertence a um grupo.
     * 
     * @param alunos Aluno para teste de verificação.
     * @return Retorna o pertencimento.
     */
    public boolean verificaPertinencia(Aluno alunos) {
        if (this.alocaAluno.containsValue(alunos)) {
            return true;
        }
        return false;
    }

    /**
     * Formata em texto um grupo em que um aluno participa.
     * 
     * @param aluno Aluno em questão.
     * @return Retorna a formatação em String, mostra o nome do grupo, quantidade de pessoas já participantes/ quantidade disponível.
     */
    public String mostraGrupos(Aluno aluno) {
        if (this.tamanho.equals("") && this.alocaAluno.containsValue(aluno)) {
            return "- " + this.grupo + " " + this.alocaAluno.size() + "/Tamanho Indefinido";
        }
        if (this.alocaAluno.containsValue(aluno)) {
            return "- " + this.grupo + " " + this.alocaAluno.size() + "/" + this.tamanho;
        } 
        return "";
    }
}
