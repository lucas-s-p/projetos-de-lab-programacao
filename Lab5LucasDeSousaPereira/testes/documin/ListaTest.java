package documin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaTest {

	Lista minhaLista;
	@BeforeEach
	void preparaSistema( ) {
		this.minhaLista = new Lista("Exemplo | de uma lista | de 3 termos", 4, "|", "-");
	}
	
	@Test
	void testRepresentacaoCompleta() {
		assertEquals("- Exemplo\n- de uma lista\n- de 3 termos\n", this.minhaLista.getRepresentacaoCompleta());
	}
	
	@Test
	void testRepresentacaoResumida() {
		assertEquals("Exemplo, de uma lista, de 3 termos", this.minhaLista.getRepresentacaoResumida());
	}
}
