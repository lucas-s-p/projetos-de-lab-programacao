package documin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TituloTest {

	Titulo meuTitulo;
	@BeforeEach
	void preparaSistema( ) {
		this.meuTitulo = new Titulo("Documentos Texto", 4, 1, true);
	}
	
	@Test
	void testRepresentacaoCompletaLinkTrue() {
		assertEquals("1. Documentos Texto -- 1-DOCUMENTOSTEXTO", this.meuTitulo.getRepresentacaoCompleta());
	}
	
	@Test
	void testRepresentacaoCompletaLinkFalse() {
		this.meuTitulo = new Titulo("Documentos Texto", 4, 1, false);
		assertEquals("1. Documentos Texto", this.meuTitulo.getRepresentacaoCompleta());
	}
	
	@Test
	void testRepresentacaoResumida() {
		this.meuTitulo = new Titulo("Documentos Texto", 4, 3, false);
		assertEquals("3. Documentos Texto", this.meuTitulo.getRepresentacaoResumida());
	}
}
