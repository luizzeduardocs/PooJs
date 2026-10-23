package br.edu.unifsa.perfumaria.pessoas;

public final class EncomendaPersonalizada {
    private final Cliente cliente;
    private final String nomeGravado;
    private final boolean semDevolucao = true;

    public EncomendaPersonalizada(Cliente cliente, String nomeGravado) {
        if (cliente == null) throw new IllegalArgumentException("Cliente obrigatório.");
        if (nomeGravado == null || nomeGravado.isBlank()) throw new IllegalArgumentException("Gravação obrigatória.");
        if (nomeGravado.length() > 20) throw new IllegalArgumentException("RN11: gravação aceita no máximo 20 caracteres.");
        this.cliente = cliente; this.nomeGravado = nomeGravado;
    }
    public Cliente getCliente() { return cliente; }
    public String getNomeGravado() { return nomeGravado; }
    public boolean aceitaDevolucao() { return !semDevolucao; }
    public void registrarDevolucao() {
        throw new IllegalStateException("RN11: encomenda personalizada não admite devolução.");
    }
    @Override public String toString() { return "Encomenda personalizada de " + cliente.getNome() + ", gravação: " + nomeGravado; }
}
