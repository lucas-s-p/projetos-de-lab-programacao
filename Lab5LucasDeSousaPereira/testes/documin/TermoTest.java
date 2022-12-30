package documin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermoTest {
	
	Termo meuTermo;
	@BeforeEach
	void preparaSistema( ) {
		this.meuTermo = new Termo("Teste / termos / Aleatórios", 5, "/", "ALFABÉTICA");
	}
	
	@Test
	void testRepresentacaoResumidaOrdemAlfabetica() {
		assertEquals("Aleatórios / termos / Teste", this.meuTermo.getRepresentacaoResumida());
	}
	
	@Test
	void testRepresentacaoCompletaOrdemAlfabetica() {
		assertEquals("Total termos: 3\n- Aleatórios, termos, Teste", this.meuTermo.getRepresentacaoCompleta());
	}
	
	@Test
	void testRepresentacaoCompletaOrdemAlfabeticaM() { 
		this.meuTermo = new Termo("Teste / termos / Aleatórios / amor / viagem / lucas", 5, "/", "ALFABÉTICA");
		assertEquals("Total termos: 6\n- Aleatórios, amor, lucas, termos, Teste, viagem", this.meuTermo.getRepresentacaoCompleta());
	}
	
	@Test
	void testRepresentacaoCompletaOrdemTamanho() {
		this.meuTermo = new Termo("Teste / termos / Aleatórios", 5, "/", "TAMANHO");
		assertEquals("Total termos: 3\n- Aleatórios, termos, Teste", this.meuTermo.getRepresentacaoCompleta());
	}
	
	@Test
	void testRepresentacaoResumidaOrdemTamanho() {
		this.meuTermo = new Termo("Teste / termos / Aleatórios", 5, "/", "TAMANHO");
		assertEquals("Aleatórios / termos / Teste", this.meuTermo.getRepresentacaoResumida());
	}
	
	@Test
	void testRepresentacaoCompletaOrdemNenhum() {
		this.meuTermo = new Termo("Teste / termos / Aleatórios", 5, "/", "NENHUM");
		assertEquals("Total termos: 3\n- Teste, termos, Aleatórios", this.meuTermo.getRepresentacaoCompleta());
	}
	
	@Test
	void testRepresentacaoResumidaOrdemNenhum() {
		this.meuTermo = new Termo("Teste / termos / Aleatórios", 5, "/", "NENHUM");
		assertEquals("Teste / termos / Aleatórios", this.meuTermo.getRepresentacaoResumida());
	}
}
