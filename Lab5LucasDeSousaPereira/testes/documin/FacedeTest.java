package documin;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacedeTest {
	Facade facade;
	@BeforeEach
	void preparaSistema() {
		this.facade = new Facade();
	}

	@Test
	void testCriarDocumentoString() {
		assertEquals(true, this.facade.criarDocumento("Receitas"));
	}

	@Test
	void testCriarDocumentoStringInt() {
		assertEquals(true, this.facade.criarDocumento("Receitas", 5));
	}

	@Test
	void testRemoverDocumento() {
		this.facade.criarDocumento("Receitas", 5);
		this.facade.criarDocumento("Lista Telefonica", 5);
		this.facade.removerDocumento("Receitas");
		boolean verifica;
		try {
			this.facade.exibirDocumento("Receitas");
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}

	@Test
	void testContarElementos() {
		this.facade.criarDocumento("Receitas", 5);
		this.facade.criarTexto("Receitas", "ola", 0);
		this.facade.criarTitulo("Receitas", "Documentos Texto", 4, 1, true);
		this.facade.criarLista("Receitas", "Exemplo | de uma lista | de 3 termos", 4, "|", "-");
		assertEquals(2, this.facade.contarElementos("Receitas"));
	}

	@Test
	void testExibirDocumento() {
		this.facade.criarDocumento("Receitas", 5);
		this.facade.criarTexto("Receitas", "ola", 0);
		this.facade.criarTitulo("Receitas", "Documentos Texto", 4, 1, true);
		this.facade.criarLista("Receitas", "Exemplo | de uma lista | de 3 termos", 4, "|", "-");
		assertEquals("[ola, 1. Documentos Texto -- 1-DOCUMENTOSTEXTO, - Exemplo\n- de uma lista\n- de 3 termos\n]", Arrays.toString(this.facade.exibirDocumento("Receitas")));
	}

	@Test
	void testCriarTexto() {
		this.facade.criarDocumento("Receitas", 5);
		assertEquals(0, this.facade.criarTexto("Receitas", "vermes", 0));
	}

	@Test
	void testCriarTitulo() {
		this.facade.criarDocumento("Receitas", 5);
		assertEquals(0, this.facade.criarTitulo("Receitas", "Lista Escolar", 3, 2, false));
	}

	@Test
	void testCriarLista() {
		this.facade.criarDocumento("Receitas", 5);
		assertEquals(0, this.facade.criarLista("Receitas", "ola > sou > rapper", 2, ">", "*"));
	}

	@Test
	void testCriarTermos() {
		this.facade.criarDocumento("Receitas", 5);
		assertEquals(0, this.facade.criarTermos("Receitas", "Nomes - pessoas - animais", 2, "-", "NENHUMA"));
	}
	
	@Test
	void testRepresentacaoCompletaTitulo() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTitulo("Receitas", "o viver", 0, 2, true);
		assertEquals("2. o viver -- 2-OVIVER", this.facade.pegarRepresentacaoCompleta("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoCompletaTexto() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "21 lições", 4);
		assertEquals("21 lições", this.facade.pegarRepresentacaoCompleta("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoCompletaTermoOrdemNenhuma() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTermos("Receitas", "biblioteca/livro/aluno", 2, "/", "NENHUM");
		assertEquals("Total termos: 3\n- biblioteca, livro, aluno", this.facade.pegarRepresentacaoCompleta("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoCompletaTermoOrdemTamanho() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTermos("Receitas", "biblioteca/livro/aluno", 2, "/", "TAMANHO");
		assertEquals("Total termos: 3\n- biblioteca, livro, aluno", this.facade.pegarRepresentacaoCompleta("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoCompletaTermoOrdemAlfabetica() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTermos("Receitas", "biblioteca/livro/aluno", 2, "/", "ALFABÉTICA");
		assertEquals("Total termos: 3\n- aluno, biblioteca, livro", this.facade.pegarRepresentacaoCompleta("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoCompletaLista() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarLista("Receitas", "bolo-fuba-milho-arroz", 3, "-", "*");
		assertEquals("* bolo\n* fuba\n* milho\n* arroz\n", this.facade.pegarRepresentacaoCompleta("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoResumidaTitulo() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTitulo("Receitas", "o viver", 0, 2, true);
		assertEquals("2. o viver", this.facade.pegarrepresentacaoResumida("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoResumidaTermoordemNenhuma() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTermos("Receitas", "biblioteca/livro/aluno", 2, "/", "NENHUM");
		assertEquals("biblioteca / livro / aluno", this.facade.pegarrepresentacaoResumida("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoResumidaTermoOrdemTamanho() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTermos("Receitas", "biblioteca/livro/aluno", 2, "/", "TAMANHO");
		assertEquals("biblioteca / livro / aluno", this.facade.pegarrepresentacaoResumida("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoResumidaTermoOrdemAlfabetica() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTermos("Receitas", "biblioteca/livro/aluno", 2, "/", "ALFABÉTICA");
		assertEquals("aluno / biblioteca / livro", this.facade.pegarrepresentacaoResumida("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoResumidaTermoTexto() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "21 lições", 4);
		assertEquals("21 lições", this.facade.pegarrepresentacaoResumida("Receitas", 0));
	}
	
	@Test
	void testRepresentacaoResumidaLista() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarLista("Receitas", "bolo-fuba-milho-arroz", 3, "-", "*");
		assertEquals("bolo, fuba, milho, arroz", this.facade.pegarrepresentacaoResumida("Receitas", 0));
	}
	
	@Test
	void testMoverParaCima() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "21 lições", 4);
		this.facade.criarLista("Receitas", "bolo-fuba-milho-arroz", 3, "-", "*");
		this.facade.criarTermos("Receitas", "biblioteca/livro/aluno", 2, "/", "ALFABÉTICA");
		this.facade.moverParaCima("Receitas", 1);
		assertEquals("* bolo\n* fuba\n* milho\n* arroz\n", this.facade.pegarRepresentacaoCompleta("Receitas", 0));
	}
	
	@Test
	void testMoverParaBaixo() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "21 lições", 4);
		this.facade.criarLista("Receitas", "bolo-fuba-milho-arroz", 3, "-", "*");
		this.facade.criarTermos("Receitas", "biblioteca/livro/aluno", 2, "/", "ALFABÉTICA");
		this.facade.moverParaBaixo("Receitas", 1);
		assertEquals("* bolo\n* fuba\n* milho\n* arroz\n", this.facade.pegarRepresentacaoCompleta("Receitas", 2));
	}
	
	@Test
	void testApagarElemento() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "ola", 0);
		this.facade.criarLista("Receitas", "Exemplo | de uma lista | de 3 termos", 4, "|", "-");
		this.facade.apagarElemento("Receitas", 1);
		assertEquals(0, this.facade.contarElementos("Receitas"));
	}

	@Test
	void testCriarAtalhoComExcecao() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarDocumento("listas");
		this.facade.criarDocumento("compras");
		boolean verifica;
		try {
			this.facade.criarAtalho("Receitas", "listas");
			this.facade.criarAtalho("listas", "compras");
			verifica = true;
		} catch (IllegalStateException e) {
    		verifica = false;
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriarAtalhoExcecaoJaTemAtalho() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarDocumento("listas");
		this.facade.criarDocumento("compras");
		boolean verifica;
		try {
			this.facade.criarAtalho("Receitas", "listas");
			this.facade.criarAtalho("compras", "Receitas");
			verifica = true;
		} catch (IllegalStateException e) {
    		verifica = false;
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriarAtalhoExcecaoJaEAtalho() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarDocumento("listas");
		this.facade.criarDocumento("compras");
		boolean verifica;
		try {
			this.facade.criarAtalho("Receitas", "listas");
			this.facade.criarAtalho("listas", "compras");
			verifica = true;
		} catch (IllegalStateException e) {
    		verifica = false;
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriarAtalhoRemovendoUmAtalho() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarDocumento("listas");
		this.facade.criarDocumento("compras");
		boolean verifica;
		try {
			this.facade.criarAtalho("Receitas", "listas");
			this.facade.apagarElemento("Receitas", 0);
			this.facade.criarAtalho("compras", "Receitas");
			verifica = true;
		} catch (IllegalStateException e) {
    		verifica = false;
    	} 
		assertTrue(verifica);
	}
	
	@Test
	void testCriarAtalhoRemovendoUmAtalhoAgrPossuiAtalhos() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarDocumento("listas");
		this.facade.criarDocumento("compras");
		boolean verifica;
		try {
			this.facade.criarAtalho("Receitas", "listas");
			this.facade.apagarElemento("Receitas", 0);
			this.facade.criarAtalho("compras", "Receitas");
			this.facade.criarAtalho("compras", "listas");
			verifica = true;
		} catch (IllegalStateException e) {
    		verifica = false;
    	} 
		assertTrue(verifica);
	}
	
	@Test
	void testCriaAtalhoRemovendoMaisDeUmAtalho() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarDocumento("listas");
		this.facade.criarDocumento("compras");
		boolean verifica;
		try {
			this.facade.criarAtalho("Receitas", "listas");
			this.facade.criarAtalho("Receitas", "compras");
			this.facade.apagarElemento("Receitas", 0);
			this.facade.criarAtalho("listas", "Receitas");
			verifica = true;
		} catch (IllegalStateException e) {
    		verifica = false;
    	}
		assertFalse(verifica);
	}
	
	@Test
	void testCriaAtalhoRemovendoAtalho() {
		this.facade.criarDocumento("Receitas");   
		this.facade.criarDocumento("listas");
		this.facade.criarDocumento("compras");
		boolean verifica;
		try {
			this.facade.criarAtalho("Receitas", "listas");
			this.facade.criarAtalho("Receitas", "compras");
			this.facade.apagarElemento("Receitas", 0);
			this.facade.apagarElemento("Receitas", 0);
			this.facade.criarAtalho("listas", "Receitas");  
			verifica = true; 
		} catch (IllegalStateException e) {
    		verifica = false;
    	}
		assertTrue(verifica);
	}
	
	@Test
	void testCriarVisaoCompleta() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "ola", 0);
		assertEquals(0, this.facade.criarVisaoCompleta("Receitas"));
	}

	@Test
	void testCriarVisaoResumida() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "ola", 0);
		this.facade.criarDocumento("escola");
		this.facade.criarLista("escola", "Exemplo | de uma lista | de 3 termos", 4, "|", "-");
		this.facade.criarVisaoCompleta("Receitas");
		assertEquals(1, this.facade.criarVisaoResumida("escola"));
	}

	@Test
	void testCriarVisaoPrioritaria() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "ola", 3);
		assertEquals(0, this.facade.criarVisaoPrioritaria("Receitas", 2));
	}

	@Test
	void testCriarVisaoTitulo() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTitulo("Receitas", "Documentos Texto", 4, 1, true);
		assertEquals(0, this.facade.criarVisaoTitulo("Receitas"));
	}

	@Test
	void testExibirVisaoCompleta() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "ola", 0);
		this.facade.criarTitulo("Receitas", "Documentos Texto", 4, 1, true);
		this.facade.criarLista("Receitas", "Exemplo | de uma lista | de 3 termos", 4, "|", "-");
		this.facade.criarVisaoCompleta("Receitas");
		assertEquals("[ola, 1. Documentos Texto -- 1-DOCUMENTOSTEXTO, - Exemplo\n- de uma lista\n- de 3 termos\n]", Arrays.toString(this.facade.exibirVisao(0)));
	}
	
	@Test
	void testExibirVisaoResumida() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "ola", 0);
		this.facade.criarTitulo("Receitas", "Documentos Texto", 4, 1, true);
		this.facade.criarLista("Receitas", "Exemplo | de uma lista | de 3 termos", 4, "|", "-");
		this.facade.criarVisaoResumida("Receitas");
		assertEquals("[ola, 1. Documentos Texto, Exemplo, de uma lista, de 3 termos]", Arrays.toString(this.facade.exibirVisao(0)));
	}
	
	@Test
	void testExibirVisaoPrioritaria() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "ola", 0);
		this.facade.criarTitulo("Receitas", "Documentos Texto", 4, 1, true);
		this.facade.criarLista("Receitas", "Exemplo | de uma lista | de 3 termos", 4, "|", "-");
		this.facade.criarVisaoPrioritaria("Receitas", 2);
		assertEquals("[1. Documentos Texto -- 1-DOCUMENTOSTEXTO, - Exemplo\n- de uma lista\n- de 3 termos\n]", Arrays.toString(this.facade.exibirVisao(0)));
	}
	
	@Test
	void testExibirVisaoTitulo() {
		this.facade.criarDocumento("Receitas");
		this.facade.criarTexto("Receitas", "ola", 0);
		this.facade.criarTitulo("Receitas", "Documentos Texto", 4, 1, true);
		this.facade.criarLista("Receitas", "Exemplo | de uma lista | de 3 termos", 4, "|", "-");
		this.facade.criarVisaoTitulo("Receitas");
		assertEquals("[1. Documentos Texto]", Arrays.toString(this.facade.exibirVisao(0)));
	}	
}
