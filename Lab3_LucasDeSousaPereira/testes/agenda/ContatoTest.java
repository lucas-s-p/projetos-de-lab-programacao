package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {
    Contato contatos;
    @BeforeEach
    void preparaContatos() {
        this.contatos = new Contato(1, "lucas", "pereira", "(73) 98883-5364");
    }
    
    @Test
    void testContatoToString() {
        assertEquals(this.contatos.toString(), "lucas pereira\n(73) 98883-5364");
    }
    
    @Test
    void testContatoToStringSobrenomeVazio() {
        this.contatos = new Contato(1, "lucas", "", "(73) 98883-5364");
        assertEquals(this.contatos.toString(), "lucas\n(73) 98883-5364");
    }
 
    @Test
    void testExibeContatos() {
        assertEquals(this.contatos.exibeContatos(0), "1 - lucas pereira");
    }

    @Test
    void testExibeContatosSup() {
        this.contatos = new Contato(100, "lucas", "pereira", "(73) 98883-5364");
        assertEquals(this.contatos.exibeContatos(99), "100 - lucas pereira");
    }
    
    @Test
    void testExibeContatosSobrenomeVazio() {
        this.contatos = new Contato(100, "lucas", "", "(73) 98883-5364");
        assertEquals(this.contatos.exibeContatos(99), "100 - lucas");
    }
}
