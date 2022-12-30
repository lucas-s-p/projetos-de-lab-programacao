package documin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextoTest {
	Texto meuTexto;
	@BeforeEach
	void preparaSistema( ) {
		this.meuTexto = new Texto("Documentos Texto", 5);
	}
	
	@Test
	void representacaoCompleta() {
		assertEquals("Documentos Texto", this.meuTexto.getRepresentacaoCompleta());
	}
	
	@Test
	void representacaoResumida() {
		assertEquals("Documentos Texto", this.meuTexto.getRepresentacaoResumida());
	}

}
