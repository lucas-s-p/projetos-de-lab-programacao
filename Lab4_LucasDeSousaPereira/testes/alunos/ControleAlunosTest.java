package alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleAlunosTest {
	ControleAlunos controle;
	@BeforeEach
	void preparaSistema() {
		this.controle = new ControleAlunos();
		this.controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		this.controle.cadastraAluno("200", "Lili Camposh", "Computação");
		this.controle.cadastraAluno("202", "Angela Ziegler", "Medicina");
		this.controle.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
	}

	@Test
	void testCadastraGrupoSemRestricao() {
		assertEquals("CADASTRO REALIZADO!", this.controle.cadastraGrupo("Programação OO", ""));
	}
	
	@Test
	void testCadastraGrupoComRestricao() {
		assertEquals("CADASTRO REALIZADO!", this.controle.cadastraGrupo("listas", "12"));
	}
	
	@Test
	void testCadastraGrupoNomeExistente() {
		this.controle.cadastraGrupo("listas", "12");
		assertEquals("GRUPO JÁ CADASTRADO!", this.controle.cadastraGrupo("listas", "12"));
	}
	
	@Test
	void testCadastraGrupoNomeExistenteESemRestricao() {
		this.controle.cadastraGrupo("listas", "12");
		assertEquals("GRUPO JÁ CADASTRADO!", this.controle.cadastraGrupo("listas", ""));
	}
	
	@Test
	void testCadastraGrupoNomeExistenteLetrasDiferenciadas() {
		this.controle.cadastraGrupo("listas", "12");
		assertEquals("GRUPO JÁ CADASTRADO!", this.controle.cadastraGrupo("lIsTas", "32"));
	}
	
	@Test
	void testRegistraAlunosGrupo() {
		this.controle.cadastraGrupo("Programação OO", "12");
		assertEquals("ALUNO ALOCADO!", this.controle.registraAlunosGrupo("200", "Programação OO"));
		assertEquals("ALUNO ALOCADO!", this.controle.registraAlunosGrupo("202", "Programação OO"));
	}
	
	@Test
	void testRegistraAlunosGrupoAlunoJaAlocado() {
		this.controle.cadastraGrupo("Programação OO", "12");
		assertEquals("ALUNO ALOCADO!", this.controle.registraAlunosGrupo("200", "Programação OO"));
		assertEquals("ALUNO ALOCADO!", this.controle.registraAlunosGrupo("202", "Programação OO"));
		assertEquals("ALUNO ALOCADO!", this.controle.registraAlunosGrupo("200", "Programação OO"));
		assertEquals("Grupos:\n- Programação OO 2/12\n", this.controle.getAlunos("200"));
	}
	
	@Test
	void testRegistraAlunosGrupoAlunoInexistente() {
		this.controle.cadastraGrupo("Programação OO", "12");
		assertEquals("ALUNO NÃO CADASTRADO.", this.controle.registraAlunosGrupo("100", "Programação OO"));
	}
	
	@Test
	void testRegistraAlunosGrupoGrupoInexistente() {
		assertEquals("GRUPO NÃO CADASTRADO.", this.controle.registraAlunosGrupo("200", "Anatomia"));
	}
	
	@Test
	void testRegistraAlunosGrupoTamanho1() {
		this.controle.cadastraGrupo("listas", "1");
		assertEquals("ALUNO ALOCADO!", this.controle.registraAlunosGrupo("250", "listas"));
		assertEquals("GRUPO CHEIO!", this.controle.registraAlunosGrupo("202", "listas"));
	}
	
	@Test
	void testEhPertencente() {
		this.controle.cadastraGrupo("listas", "12");
		this.controle.registraAlunosGrupo("250", "listas");
		assertEquals("ALUNO PERTENCE AO GRUPO.", this.controle.ehPertecente("listas", "250"));
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO.", this.controle.ehPertecente("listas", "202"));
	}
	
	@Test
	void testEhPertencenteGrupoNaoCadastrado() {
		assertEquals("GRUPO NÃO CADASTRADO.", this.controle.ehPertecente("listas", "200"));
	}
	
	@Test
	void testEhPertencenteAlunoNaoCadastrado() {
		this.controle.cadastraGrupo("Programação OO", "12");  // ALUNO NÃO CADASTRADO ?
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO.", this.controle.ehPertecente("Programação OO", "100"));
	}
	
	@Test
	void testGetAlunosAlunoSemGupos() {
		assertEquals("Grupos:\n", this.controle.getAlunos("202"));
	}
	
	@Test
	void testGetAlunosAlunoComGrupos() {
		this.controle.cadastraGrupo("Programação OO", "10");
		this.controle.cadastraGrupo("Listas", "10");
		this.controle.registraAlunosGrupo("250", "Listas");
		this.controle.registraAlunosGrupo("250", "Programação OO");
		assertEquals("Grupos:\n- Programação OO 1/10\n- Listas 1/10\n", this.controle.getAlunos("250"));
	}
	
	@Test
	void testCadastraAlunoMatriculaNull() {
		boolean verifica;
		try {
			this.controle.cadastraAluno(null, "Lucas", "Ciência da Computação");
			verifica = true;
		} catch (NullPointerException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}
	
	@Test
	void testCadastraAlunoMatriculaVazia() {
		boolean verifica;
		try {
			this.controle.cadastraAluno("", "Lucas", "Ciência da Computação");
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}

	@Test
	void testCadastraAlunoNomeNull() {
		boolean verifica;
		try {
			this.controle.cadastraAluno("1", null, "Ciência da Computação");
			verifica = true;
		} catch (NullPointerException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}
	
	@Test
	void testCadastraAlunoNomeVazio() {
		boolean verifica;
		try {
			this.controle.cadastraAluno("1", "", "Ciência da Computação");
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}
	
	@Test
	void testCadastraAlunoCursoNull() {
		boolean verifica;
		try {
			this.controle.cadastraAluno("1", "lucas", null);
			verifica = true;
		} catch (NullPointerException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}
	
	@Test
	void testCadastraAlunoCursoVazio() {
		boolean verifica;
		try {
			this.controle.cadastraAluno("1", "lucas", "");
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}
	
	@Test
	void testCadastraGrupoVazio() {
		boolean verifica;
		try {
			this.controle.cadastraGrupo("", "2");
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}
	
	@Test
	void testCadastraGrupoNull() {
		boolean verifica;
		try {
			this.controle.cadastraGrupo(null, "2");
			verifica = true;
		} catch (NullPointerException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}
	
	@Test
	void testCadastraTamanhoIgualAZero() {
		boolean verifica;
		try {
			this.controle.cadastraGrupo("listas", "0");
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}
	
	@Test
	void testCadastraTamanhoMenorZero() {
		boolean verifica;
		try {
			this.controle.cadastraGrupo("listas", "-1");
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);

	}
}