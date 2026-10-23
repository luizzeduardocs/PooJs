package br.edu.unifsa.perfumaria.pessoas;

public final class Cliente {
    private final String nome;
    public Cliente(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome do cliente obrigatório.");
        this.nome = nome;
    }
    public String getNome() { return nome; }
    @Override public String toString() { return "Cliente: " + nome; }
}
