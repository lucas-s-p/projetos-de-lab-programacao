package documin;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtalhoTest {
	Documento doc;
	Documento doc2;
	Documento doc3;
	DocumentosController controler;
	@BeforeEach
	void preparaSistema( ) {
		this.doc = new Documento("Receita");
		this.doc2 = new Documento("listas", 2);
		this.doc3 = new Documento("compras", 4);
		this.controler = new DocumentosController();
	}
	
	@Test
	void testAtalho( ) {
		assertEquals(0, this.doc.AddDocumentoAtalho(doc2));
	}
}
