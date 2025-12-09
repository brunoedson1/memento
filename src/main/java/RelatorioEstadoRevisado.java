public class RelatorioEstadoRevisado implements RelatorioEstado {
    private RelatorioEstadoRevisado() {}
    private static RelatorioEstadoRevisado instance = new RelatorioEstadoRevisado();
    public static RelatorioEstadoRevisado getInstance() { return instance; }

    public String getNomeEstado() { return "Revisado"; }
}