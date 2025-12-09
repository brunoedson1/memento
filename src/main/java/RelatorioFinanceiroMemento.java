import java.util.ArrayList;
import java.util.List;

public class RelatorioFinanceiroMemento {

    private RelatorioEstado estado;
    private List<RelatorioEstado> memento = new ArrayList<>();

    public RelatorioEstado getEstado() {
        return this.estado;
    }

    public void setEstado(RelatorioEstado estado) {
        this.estado = estado;
        this.memento.add(this.estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.estado = this.memento.get(indice);
    }

    public List<RelatorioEstado> getEstados() {
        return this.memento;
    }
}