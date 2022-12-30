package documin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoControllerTest {

	DocumentosController controle;
	@BeforeEach
	void preparaSistema( ) {
		this.controle = new DocumentosController();
	}
	
	@Test
	void testAddDocumentoUmParametro() {
		assertEquals(true, this.controle.addDocumento("receitas"));
	}
	
	@Test
	void testAddDocumentoDoisParametros() {
		assertEquals(true, this.controle.addDocumento("livros", 2));
	}
	
	@Test
	void testAddDocumentoTituloVazioDoisParametros() {
		assertEquals(false, this.controle.addDocumento("", 2));
	}
	
	@Test
	void testAddDocumentoTituloVazioUmParametro() {
		assertEquals(false, this.controle.addDocumento(""));
	}
	
	@Test
	void testAddDocumentoUmParametroRepitido() {
		this.controle.addDocumento("receitas");
		assertEquals(false, this.controle.addDocumento("receitas"));
	}
	
	@Test
	void testAddDocumentoDoisParametroRepitido() {
		this.controle.addDocumento("receitas", 2);
		assertEquals(false, this.controle.addDocumento("receitas", 4));
	}
	
	@Test
	void testAddDocumentoTamanhoMenorOuIgualAZero() {
		boolean verifica;
		try {
			this.controle.addDocumento("receitas", 0);
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriaDocumentoEspacosVazios() {
		assertEquals(false, this.controle.addDocumento("     "));
	}
	
	@Test
	void testCriaDocumentoDoisParamentrosEspacosVazios() {
		assertEquals(false, this.controle.addDocumento("   ", 2));
	}
	
	@Test
	void testCriaTextoDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.cadastraTexto("receitas", "texto", 2);
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriaTextoTituloVazio() {
		boolean verifica;
		try {
			this.controle.cadastraTexto("", "texto", 2);
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriaTermoDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.cadastraTermo("receitas", "Lucas/Pereira", 2, "/", "Aleatórios");
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriaTermoTituloVazio() {
		boolean verifica;
		try {
			this.controle.cadastraTermo("", "Lucas/Pereira", 2, "/", "Aleatórios");
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriaListaDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.cadastraLista("receitas", "Macarrao|Arroz|Feijao", 1, "|", "-");
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriaListaTituloVazio() {
		boolean verifica;
		try {
			this.controle.cadastraLista("", "Macarrao|Arroz|Feijao", 1, "|", "-");
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriaTituloDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.cadastraTitulo("receitas", "Machado de Assis", 5, 99, false);
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testCriaTituloComTituloVazio() {
		boolean verifica;
		try {
			this.controle.cadastraTitulo("", "Machado de Assis", 5, 99, false);
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testRepresentacaoCompletaTituloVazio() {
		boolean verifica;
		try {
			this.controle.getRepresentacaoCompleta("", 3);
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testRepresentacaoCompletaDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.getRepresentacaoCompleta("receitas", 3);
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testRepresentacaoResumidaTituloVazio() {
		boolean verifica;
		try {
			this.controle.getRepresentacaoResumida("", 3);
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testRepresentacaoResumidaDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.getRepresentacaoResumida("receitas", 3);
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testApagaElementoTituloVazio() {
		boolean verifica;
		try {
			this.controle.apagaElemento("", 0);
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testApagaElementoDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.apagaElemento("receitas", 0);
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testMoveParaAcimaTituloVazio() {
		boolean verifica;
		try {
			this.controle.moverParaCima("", 0);;
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testMoveParaACimaDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.moverParaCima("receitas", 0);;
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testMoveParaBaixoTituloVazio() {
		boolean verifica;
		try {
			this.controle.moverParaBaixo("", 0);;
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testMoveParaBaixoDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.moverParaBaixo("receitas", 0);;
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testExibirDocumentoTituloVazio() {
		boolean verifica;
		try {
			this.controle.exibirDocumento("");;
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testExibirDocumentoDeUmDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.exibirDocumento("receitas");
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void tesContaElementosTituloVazio() {
		boolean verifica;
		try {
			this.controle.contarElementos("");
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testContaElementosDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.contarElementos("receitas");
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testRemoveDocumentoTituloVazio() {
		boolean verifica;
		try {
			this.controle.removeDocumentos("");;
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testRemoveDocumentoDeUmDocumentoInexistente() {
		boolean verifica;
		try {
			this.controle.removeDocumentos("receitas");;
			verifica = true;
		} catch (NoSuchElementException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
}
