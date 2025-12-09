import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioFinanceiroMementoTest {

    @Test
    void deveArmazenarEstados() {
        RelatorioFinanceiroMemento relatorio = new RelatorioFinanceiroMemento();

        relatorio.setEstado(RelatorioEstadoRascunho.getInstance());
        relatorio.setEstado(RelatorioEstadoRevisado.getInstance());

        assertEquals(2, relatorio.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        RelatorioFinanceiroMemento relatorio = new RelatorioFinanceiroMemento();

        relatorio.setEstado(RelatorioEstadoRascunho.getInstance());
        relatorio.setEstado(RelatorioEstadoAprovado.getInstance());

        relatorio.restauraEstado(0);

        assertEquals(RelatorioEstadoRascunho.getInstance(), relatorio.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        RelatorioFinanceiroMemento relatorio = new RelatorioFinanceiroMemento();

        relatorio.setEstado(RelatorioEstadoRascunho.getInstance());
        relatorio.setEstado(RelatorioEstadoRevisado.getInstance());
        relatorio.setEstado(RelatorioEstadoRascunho.getInstance());
        relatorio.setEstado(RelatorioEstadoAprovado.getInstance());

        relatorio.restauraEstado(2);

        assertEquals(RelatorioEstadoRascunho.getInstance(), relatorio.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            RelatorioFinanceiroMemento relatorio = new RelatorioFinanceiroMemento();
            relatorio.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}