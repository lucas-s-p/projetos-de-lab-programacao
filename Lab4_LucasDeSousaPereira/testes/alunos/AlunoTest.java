package alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	Aluno aluno;
	@BeforeEach
	void preparaAluno() {
		this.aluno = new Aluno("1", "Lucas", "Ciência da Computação");
	}
	@Test
	void testToString() {
		assertEquals("Matrícula: 1\n\nAluno: 1 - Lucas - Ciência da Computação", this.aluno.toString());
	}
}
