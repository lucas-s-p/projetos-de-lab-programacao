package alunos;
import java.util.HashMap;

/**
 * Um controle de alunos, um sistema que manipula ações de alunos. Pode cadastrar alunos e grupos. 
 * 
 * @author lucas
 */
public class ControleAlunos {
    private HashMap<String, Aluno> matriculaAlunos;
    private HashMap<String, Grupo> grupos;
    
    /**
     * Constrói o sistema de alunos e inicializa atributos.
     */
    public ControleAlunos() {
        this.matriculaAlunos = new HashMap<>();
        this.grupos = new HashMap<>();
    }

    /**
     * Cadastra um aluno a partir de uma identificação, um nome e um curso.
     * 
     * @param matricula Matricula do aluno.
     * @param nome Nome do aluno.
     * @param curso Curso do aluno.
     * @return Retorna se o cadastro foi efetivado ou não.
     */
    public String cadastraAluno(String matricula, String nome, String curso) {
        Aluno meuAluno = new Aluno(matricula, nome, curso);
        if (this.matriculaAlunos.containsKey(matricula)) {
            return "MATRÍCULA JÁ CADASTRADA!";
        } else {
        	this.matriculaAlunos.put(matricula, meuAluno);
            return "CADASTRO REALIZADO!";
        }

    }

    /**
     * Exibe um aluno a partir da matricula do aluno.
     * 
     * @param matricula Matricula do aluno.
     * @return Retorna um texto formatado informando todos os atributos de um aluno e se não tiver aluno informa que o aluno não foi cadastrado.
     */
    public String getAluno(String matricula) {
	        if (this.matriculaAlunos.containsKey(matricula)) {
	            return matriculaAlunos.get(matricula).toString();
	        } else {
	            return "Matrícula: " + matricula + "\n\n" + "ALUNO NÃO CADASTRADO.";
	        }
    }

    /**
     * Cadastra um grupo, o grupo tem um nome e, por opção, pode ter ou não um tamanho limite para o grupo.
     * 
     * @param grupo Nome do grupo.
     * @param tamanho Tamanho do grupo.
     * @return Retorna se o cadastro foi bem sucedido ou mal sucedido.
     */
    public String cadastraGrupo(String grupo, String tamanho) {
        Grupo meuGrupo = new Grupo(grupo, tamanho);
        if (this.grupos.containsKey(grupo.toUpperCase())) {
            return "GRUPO JÁ CADASTRADO!";
        } else {
            this.grupos.put(grupo.toUpperCase(), meuGrupo); // Consertar.
            return "CADASTRO REALIZADO!";
        }
    }

    /**
     * Inscreve um aluno em um grupo. Um aluno pode participar de quantos grupos quiser, se o mesmo tiver sido cadastrado.
     * 
     * @param matricula Matricula do aluno.
     * @param grupo Nome do grupo.
     * @return Retorna informações sobre o alocamento do aluno ou se ainda não existe um grupo ou aluno cadastrado.
     */
    public String registraAlunosGrupo(String matricula, String grupo) {
        if (!(this.matriculaAlunos.containsKey(matricula))) {
            return "ALUNO NÃO CADASTRADO.";
        }
        if (!(this.grupos.containsKey(grupo.toUpperCase()))) {
            return "GRUPO NÃO CADASTRADO.";
        }
        if (this.grupos.get(grupo.toUpperCase()).adicionaAluno(this.matriculaAlunos.get(matricula))) {
            return "ALUNO ALOCADO!";
        } else {
            return "GRUPO CHEIO!";
        }

    }

    /**
     * Exibe os grupos em que um aluno esteja cadastrado.
     * 
     * @param idAluno Matricula do aluno.
     * @return Retorna a formatação exibindo os grupos e os limites para o mesmo.
     */
    public String getAlunos(String idAluno) {
        String grupos = "Grupos:\n";
        for (String grupo: this.grupos.keySet()) {
            Aluno aluno = this.matriculaAlunos.get(idAluno);
            if (!(this.grupos.get(grupo).mostraGrupos(aluno).equals(""))) {
                grupos += this.grupos.get(grupo).mostraGrupos(aluno) + "\n";
            }
        }
        return grupos;
    }

    /**
     * Verifica se um aluno pertence ou não a um grupo, ou se o grupo não está cadastrado.
     * 
     * @param grupo Nome do grupo.
     * @param matricula Matricula do aluno
     * @return Retorna se o aluno pertence ou se o grupo não está cadastrado.
     */
    public String ehPertecente(String grupo, String matricula) {
        if (!(this.grupos.containsKey(grupo.toUpperCase()))) {
            return "GRUPO NÃO CADASTRADO.";
        }
        if (this.grupos.get(grupo.toUpperCase()).verificaPertinencia(this.matriculaAlunos.get(matricula))) {
            return "ALUNO PERTENCE AO GRUPO.";
        } else {
            return "ALUNO NÃO PERTENCE AO GRUPO.";
        }
    }
}