public class RelatorioEstadoAprovado implements RelatorioEstado {
    private RelatorioEstadoAprovado() {}
    private static RelatorioEstadoAprovado instance = new RelatorioEstadoAprovado();
    public static RelatorioEstadoAprovado getInstance() { return instance; }

    public String getNomeEstado() { return "Aprovado"; }
}