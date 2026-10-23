package br.edu.unifsa.perfumaria.producao;

import java.time.LocalDate;

public final class MateriaPrima {
    private final String nome;
    private final LocalDate validade;
    private double quantidade;

    public MateriaPrima(String nome, LocalDate validade, double quantidade) {
        if (nome == null || nome.isBlank() || validade == null || quantidade < 0)
            throw new IllegalArgumentException("Dados inválidos para matéria-prima.");
        this.nome = nome; this.validade = validade; this.quantidade = quantidade;
    }
    public boolean estaVencida(LocalDate data) { return validade.isBefore(data); }
    public void consumir(double quantidade, LocalDate data) {
        if (estaVencida(data)) throw new IllegalStateException("RN08: matéria-prima vencida não pode ser utilizada.");
        if (quantidade <= 0 || quantidade > this.quantidade)
            throw new IllegalArgumentException("Quantidade de matéria-prima inválida ou insuficiente.");
        this.quantidade -= quantidade;
    }
    public String getNome() { return nome; }
    public double getQuantidade() { return quantidade; }
    @Override public String toString() { return nome + ", validade=" + validade + ", quantidade=" + quantidade; }
}
