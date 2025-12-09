public class RelatorioEstadoRascunho implements RelatorioEstado {
    private RelatorioEstadoRascunho() {}
    private static RelatorioEstadoRascunho instance = new RelatorioEstadoRascunho();
    public static RelatorioEstadoRascunho getInstance() { return instance; }

    public String getNomeEstado() { return "Rascunho"; }
}