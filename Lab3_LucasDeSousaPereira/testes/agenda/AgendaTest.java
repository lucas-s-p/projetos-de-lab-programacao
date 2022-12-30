package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
    Agenda agenda;
    @BeforeEach
    void preparaAgenda() {
        this.agenda = new Agenda();
    }
    @Test
    void testCadastraContatoPosVazia() {
        assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"));
    }
    
    @Test
    void testCadastraContatoPosExistente() {
        assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"));
        assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111"));
    }
    
    @Test
    void testCadastraContatoRepitido() {
        assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"));
        assertEquals("CONTATO JA CADASTRADO", this.agenda.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-0000"));
    }
    
    @Test
    void testCadastraContatoPosLimite() {
        assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000"));
    }
    
    @Test
    void testCadastraContatoPosAcima() {
        assertEquals("POSICAO INVALIDA", this.agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000"));
    }
    @Test
    void testCadastraContatoPosAbaixo() {
        assertEquals("POSICAO INVALIDA", this.agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000"));
    }
    
    @Test
    void testCadastraContatoFoneVazio() {
        assertEquals("CONTATO INVALIDO", this.agenda.cadastraContato(10, "Matheus", "Gaudencio", ""));
    }
    
    @Test
    void testCadastraContatoRepitidoPosAbaixo() {
        assertEquals("POSICAO INVALIDA", this.agenda.cadastraContato(0, "", "Gaudencio", "(83) 99999-0000"));
    } 
    
    @Test
    void testExibeContato() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals(this.agenda.getContato(1), "Matheus Gaudencio\n(83) 99999-0000");
    }
    
    @Test
    void testExibeContatoFoneVazio() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "");
        assertEquals(this.agenda.getContato(1), "POSICAO INVALIDA");
    }
    
    @Test
    void testExibeContatoSemCadastroLimSuperior() {
        assertEquals(this.agenda.getContato(100), "POSICAO INVALIDA");
    }
    
    @Test
    void testExibeContatoSemCadastroLimInferior() {
        assertEquals(this.agenda.getContato(1), "POSICAO INVALIDA");
    }
    
    @Test
    void testExibeContatoFavorito() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        this.agenda.adicionaFavorito(1, 1);
        assertEquals(this.agenda.getContato(1), "❤️ Matheus Gaudencio\n(83) 99999-0000");
    }
    @Test
    void testListaContatos() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        this.agenda.cadastraContato(2, "Jose", "Pedro", "4567-9083");
        this.agenda.cadastraContato(3, "Maria", "Virginia", "(83) 99999-0000");
        assertEquals(this.agenda.getContatos(), "1 - Matheus Gaudencio\n2 - Jose Pedro\n3 - Maria Virginia\n");
    }
    
    @Test
    void testListaContatosFavoritado() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        this.agenda.adicionaFavorito(1, 10);
        this.agenda.cadastraContato(2, "Jose", "Pedro", "4567-9083");
        assertEquals(this.agenda.getContatos(), "1 - Matheus Gaudencio\n2 - Jose Pedro\n");
    }
    
    @Test
    void testListaContatosPosIgual() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        this.agenda.cadastraContato(1, "Jose", "Pedro", "4567-9083");
        assertEquals(this.agenda.getContatos(), "1 - Jose Pedro\n");
    }
    
    @Test
    void testListaContatosPosLimites() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        this.agenda.cadastraContato(100, "Jose", "Pedro", "4567-9083");
        assertEquals(this.agenda.getContatos(), "1 - Matheus Gaudencio\n100 - Jose Pedro\n");
    }
    
    @Test
    void testListaContatosSobrenomeVazio() {
        this.agenda.cadastraContato(1, "Matheus", "", "(83) 99999-0000");
        this.agenda.cadastraContato(100, "Jose", "", "4567-9083");
        assertEquals(this.agenda.getContatos(), "1 - Matheus\n100 - Jose\n");
    }
    
    @Test
    void testAdicionaFavLimInferior() {
        this.agenda.cadastraContato(1, "Matheus", "", "(83) 99999-0000");
        assertEquals(this.agenda.adicionaFavorito(1, 1), "CONTATO FAVORITADO NA POSIÇÃO 1!");
    }
    
    @Test
    void testAdicionaFavLimSuperior() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals(this.agenda.adicionaFavorito(1, 10), "CONTATO FAVORITADO NA POSIÇÃO 10!");
    }
    
    @Test
    void testAdicionaFavRepitido() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        this.agenda.adicionaFavorito(1, 1);
        assertEquals(this.agenda.adicionaFavorito(1, 5), "CONTATO JA FAVORITADO!");
    }
    
    @Test
    void testAdicionaFavMesmaPos() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        this.agenda.adicionaFavorito(1, 10);
        this.agenda.cadastraContato(100, "Jose", "Pereira", "4567-9083");
        assertEquals(this.agenda.adicionaFavorito(100, 10), "CONTATO FAVORITADO NA POSIÇÃO 10!");
    }
    
    @Test
    void testListaFavoritosSobrenomeVazio() {
        this.agenda.cadastraContato(1, "Matheus", "", "(83) 99999-0000");
        this.agenda.adicionaFavorito(1, 1);
        assertEquals(this.agenda.favoritos(), "1 - Matheus\n");
    }
    
    @Test
    void testListaFavoritosLimSuperiorInferior() {
        this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        this.agenda.cadastraContato(100, "Jose", "Pereira", "4567-9083");
        this.agenda.adicionaFavorito(1, 1);
        this.agenda.adicionaFavorito(100, 10);
        assertEquals(this.agenda.favoritos(), "1 - Matheus Gaudencio\n10 - Jose Pereira\n");
    }
    
    @Test
    void testListaSemFavoritos() {;
        assertEquals(this.agenda.favoritos(), "");
    }
    
    @Test
    void removeFavoritosSuperior() {
        this.agenda.cadastraContato(100, "Jose", "Pereira", "4567-9083");
        this.agenda.adicionaFavorito(100, 10);
        boolean remove;
        try {
            this.agenda.removeFavorito(10);
            remove = true;
        } catch (Exception e) {
           remove = false;
        }
        assertTrue(remove);
    }

    @Test
    void removeFavoritosInferior() {
        this.agenda.cadastraContato(100, "Jose", "Pereira", "4567-9083");
        this.agenda.adicionaFavorito(100, 1);
        boolean remove;
        try {
            this.agenda.removeFavorito(1);
            remove = true;
        } catch (Exception e) {
           remove = false;
        }
        assertTrue(remove);
    }
}
