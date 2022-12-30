package alunos;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular um sistema de alunos.
 * 
 * 
 * @author lucas
 */
public class MainAlunos {

	public static void main(String[] args) {
		ControleAlunos alunos = new ControleAlunos();

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, alunos, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n" + 
						"(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
						"(O)lhaí quais Grupos o Aluno Tá.\n" +
						"(S)im, quero Fechar o Programa!\n" + 
						"\n" + 
						"Opção> "); 
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param alunos  O sistema de alunos a ser manipulado.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, ControleAlunos alunos, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(alunos, scanner);
			break;
		case "E":
			exibeAluno(alunos, scanner);
			break;
		case "N":
			cadastraGrupo(alunos, scanner);
			break;
		case "A":
			registraAlunosGrupo(alunos, scanner);
			break;
		case "O":
			listarGrupos(alunos, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Cadastra um aluno ao sistema. 
	 * 
	 * @param alunos O sistema de alunos.
	 * @param scanner Scanner para pedir informações do aluno.
	 */
	private static void cadastraAluno(ControleAlunos alunos, Scanner scanner) {
        scanner.nextLine();
		System.out.print("\nMatrícula:  ");
		String matricula = scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Curso: ");
		String curso = scanner.nextLine();
		System.out.println(alunos.cadastraAluno(matricula, nome, curso));
		
	}

	/**
	 * Imprime os detalhes de um aluno do sistema. 
	 * 
	 * @param alunos O sistema de alunos.
	 * @param scanner Scanner para capturar o id do aluno.
	 */
	private static void exibeAluno(ControleAlunos alunos, Scanner scanner) {
        scanner.nextLine();
		System.out.print("\nMatricula: ");
		String matricula = scanner.nextLine();
		System.out.println(alunos.getAluno(matricula));
	
	}

	/**
	 * Cadastra um grupo ao sistema. 
	 * 
	 * @param alunos O sistema de alunos.
	 * @param scanner Scanner para pedir informações do cadastro de um grupo.
	 */
	private static void cadastraGrupo(ControleAlunos alunos, Scanner scanner) {
        scanner.nextLine();
		System.out.print("\nGrupo: ");
		String grupo = scanner.nextLine();
		System.out.print("Tamanho: ");
		String tamanho = scanner.nextLine();
		System.out.println(alunos.cadastraGrupo(grupo, tamanho));
		
	}

	/**
	 * Registra um aluno em um grupo.
	 * 
	 * @param alunos O sistema de alunos.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void registraAlunosGrupo(ControleAlunos alunos, Scanner scanner) {
        scanner.nextLine();
		System.out.print("\n(A)locar Aluno ou (P)ertinência a Grupo? ");
        String resposta = scanner.nextLine().toUpperCase();
        if (resposta.equals("A")) {
            System.out.print("\nMatrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Grupo: ");
            String grupo = scanner.nextLine();
            System.out.println(alunos.registraAlunosGrupo(matricula, grupo));
        } else if (resposta.equals("P")) {
            System.out.print("\nGrupo: ");
            String grupo = scanner.nextLine();
            System.out.print("Aluno: ");
            String aluno = scanner.nextLine();
            System.out.println(alunos.ehPertecente(grupo, aluno));
        } 
	}

	/**
	 * Lista os grupos que o aluno participa.
	 * 
	 * @param agenda O sistema de alunos.
     * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void listarGrupos(ControleAlunos alunos, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Aluno: ");
        String aluno = scanner.nextLine();
		System.out.println(alunos.getAlunos(aluno));
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.exit(0);
	}
}