package documin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoTest {

	Documento docs;
	@BeforeEach
	void preparaSistema( ) {
		this.docs = new Documento("receitas");
	}
	
	@Test
	void cadastraTextoEmDocumentoComTamanho() {
		this.docs = new Documento("receitas", 2);
		assertEquals(0, this.docs.criaTexto("O texto de Machado", 2));
	}
	
	@Test
	void cadastraTextoEmDocumentoSemTamanho() {
		assertEquals(0, this.docs.criaTexto("O texto de Machado", 3));
	}
		
	@Test
	void cadastraTermoEmDocumentoComTamanho() {
		this.docs = new Documento("receitas", 2);
		assertEquals(0, this.docs.criaTermo("Lucas/Pereira", 2, "/", "Aleatórios"));
	}
	
	@Test
	void cadastraTermoEmDocumentoSemTamanho() {
		assertEquals(0, this.docs.criaTermo("Lucas/Pereira", 2, "/", "Aleatórios"));
	}
	
	@Test
	void cadastraTituloEmDocumentoComTamanho() {
		this.docs = new Documento("receitas", 2);
		assertEquals(0, this.docs.criaTitulo("Machado de Assis", 5, 99, false));
	}
	
	@Test
	void cadastraTituloEmDocumentoSemTamanho() {
		assertEquals(0, this.docs.criaTitulo("Machado de Assis", 5, 99, false));
	}
	
	@Test
	void cadastraListaEmDocumentoComTamanho() {
		this.docs = new Documento("receitas", 2);
		assertEquals(0, this.docs.criaLista("Macarrao|Arroz|Feijao", 1, "|", "-"));
	}
	
	@Test
	void cadastraListaEmDocumentoSemTamanho() {
		assertEquals(0, this.docs.criaLista("Macarrao|Arroz|Feijao", 1, "|", "-"));
	}
	
	@Test
	void testCadastraMisturaDeElementos() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, false);
		this.docs.criaTexto("O texto de Machado", 2);
		this.docs.criaTermo("Lucas/Pereira", 5, "/", "Aleatórios");
		assertEquals(3, this.docs.criaLista("Macarrao|Arroz|Feijao", 1, "|", "-"));
	}
	
	@Test
	void testExcecaoExcedeuTamanhoDoDocumento() {
		boolean verifica;
		try {
			this.docs = new Documento("receitas", 2);
			this.docs.criaTexto("O texto de Machado", 3);
			this.docs.criaTermo("Lucas/Pereira", 2, "/", "Aleatórios");
			this.docs.criaTitulo("Machado de Assis", 5, 99, false);
			verifica = true;
		} catch (IllegalArgumentException e) {
    		verifica = false;
    		
    	} 
		assertFalse(verifica);
	}
	
	@Test
	void testExibeUmElementoCompleto() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, false);
		assertEquals("99. Machado de Assis", this.docs.exibeElementoCompleto(0));
	}
	
	@Test
	void testExibeDoisElementosCadastradosCompleto() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, false);
		this.docs.criaTexto("O texto de Machado", 2);
		assertEquals("O texto de Machado", this.docs.exibeElementoCompleto(1));
	}
	
	@Test
	void testExibeElementosResumido() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, false);
		this.docs.criaTexto("O texto de Machado", 2);
		assertEquals("O texto de Machado", this.docs.exibeElementoResumido(1));
	}
	
	@Test
	void testApagaElementoTrue() {
		this.docs.criaTexto("O texto de Machado", 2);
		assertEquals(true, this.docs.removeElemento(0));
	}
	
	@Test
	void testApagaElementoEverificaPosComNovoElemento() {
		this.docs.criaLista("Macarrao|Arroz|Feijao", 1, "|", "-");
		this.docs.criaTitulo("Machado de Assis", 5, 99, false);
		this.docs.criaTexto("O texto de Machado", 2);
		assertEquals(true, this.docs.removeElemento(0));
		assertEquals("99. Machado de Assis", this.docs.exibeElementoCompleto(0));
	}
	
	@Test
	void testMoveParaBaixo() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, false);
		this.docs.criaTexto("O texto de Machado", 2);
		this.docs.criaLista("Macarrao|Arroz|Feijao", 1, "|", "-");
		this.docs.PosAbaixo(1);
		assertEquals("O texto de Machado", this.docs.exibeElementoCompleto(2));
		assertEquals("- Macarrao\n- Arroz\n- Feijao\n", this.docs.exibeElementoCompleto(1));
	}
	
	@Test
	void testMoveParaCima() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, true);
		this.docs.criaTexto("O texto de Machado", 2);
		this.docs.PosAcima(1);
		assertEquals("O texto de Machado", this.docs.exibeElementoCompleto(0));
		assertEquals("99. Machado de Assis -- 99-MACHADODEASSIS", this.docs.exibeElementoCompleto(1));
	}
	
	@Test
	void testContaElementosUmElemento() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, true);
		assertEquals(0, this.docs.qtdElementos());
	}
	
	@Test
	void testContaElementosMaisElementos() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, true);
		this.docs.criaTexto("O texto de Machado", 2);
		this.docs.criaLista("Macarrao|Arroz|Feijao", 1, "|", "-");
		assertEquals(2, this.docs.qtdElementos());
	}
	
	@Test
	void testMediaPrioridades() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, true);
		this.docs.criaTexto("O texto de Machado", 2);
		this.docs.criaLista("Macarrao|Arroz|Feijao", 2, "|", "-");
		assertEquals(3.0, this.docs.mediaPrioridades());
	}
	
	@Test
	void testCocatenacaoCompleta() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, false);
		this.docs.criaTexto("O texto de Machado", 4);
		assertEquals("99. Machado de Assis O texto de Machado ", this.docs.cocatenaElementosCompleto());
	}
	
	@Test
	void testCocatenacaoResumida() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, false);
		this.docs.criaTexto("O texto de Machado", 4);
		assertEquals("99. Machado de Assis O texto de Machado ", this.docs.cocatenaElementosResumido());
	}
	
	@Test
	void testExibeCompleto() {
		this.docs.criaTitulo("Machado de Assis", 5, 99, false);
		this.docs.criaTexto("O texto de Machado", 4);
		assertEquals("[99. Machado de Assis, O texto de Machado]" , Arrays.toString(this.docs.exibeDocumentoCompleto()));
	}
}
