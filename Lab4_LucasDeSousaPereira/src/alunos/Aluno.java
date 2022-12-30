package alunos;

/**
 * Cria um aluno.
 * 
 * @author lucas
 */
public class Aluno {
	private String matricula;
	private String nome;
	private String curso;

	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Constrói um aluno a partir de uma matricula, nome e curso.
	 * 
	 * @param matricula Matricula do aluno.
	 * @param nome Nome do aluno.
	 * @param curso Curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Matrícula Inválida.");
		} else if (matricula.equals("")) {
			throw new IllegalArgumentException("Matrícula Inválida.");
		} else if (nome == null) {
			throw new NullPointerException("Nome Inválido.");
		} else if (nome.equals("")) {
			throw new IllegalArgumentException("Nome Inválido.");
		}  else if (curso == null) {
			throw new NullPointerException("Curso Inválido.");
		}  else if (curso.equals("")) {
			throw new IllegalArgumentException("Curso Inválido.");
		}
        this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
    }
	
	/**
	 * Formata em texto a exibição de um aluno.
	 * 
	 * @return Formatação contendo a matricula - nome - curso.
	 */
	public String toString() {
		return "Matrícula: " + this.matricula + "\n\n" + "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso;
	}

}
