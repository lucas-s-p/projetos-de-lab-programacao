package alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoTest {
	Grupo grupo;
	Aluno aluno;
	@BeforeEach
	void preparaGrupo() {
		this.grupo = new Grupo("Lista", "10");
		this.aluno = new Aluno("1", "Lucas", "Ciência da Computação");
	}
	
	@Test
	void testAdicionaAluno() {
		assertEquals(true, this.grupo.adicionaAluno(this.aluno));
	}
	
	@Test
	void testAdicionaAlunoSemRestricaoDeTamanho() {
		this.grupo = new Grupo("Lista", "");
		assertEquals(true, this.grupo.adicionaAluno(this.aluno));
	}
	
	@Test
	void testAdicionaAlunoPassouDoTamanhoLimite() {
		this.grupo = new Grupo("Lista", "1");
		assertEquals(true, this.grupo.adicionaAluno(this.aluno));
		this.aluno = new Aluno("2", "João", "Adm");
		assertEquals(false, this.grupo.adicionaAluno(this.aluno));
	}
}
