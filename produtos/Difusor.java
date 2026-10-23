package br.edu.unifsa.perfumaria.produtos;

public final class Difusor implements Precificavel, Vendavel {
    private final String nome;
    private final int quantidadeVaretas;
    private final double custo;
    private double precoVenda;

    public Difusor(String nome, int quantidadeVaretas, double custo, double precoVenda) {
        if (nome == null || nome.isBlank() || custo < 0) throw new IllegalArgumentException("Dados inválidos para difusor.");
        if (quantidadeVaretas < 4 || quantidadeVaretas > 10)
            throw new IllegalArgumentException("RN10: difusor deve usar de 4 a 10 varetas.");
        this.nome = nome; this.quantidadeVaretas = quantidadeVaretas; this.custo = custo;
        setPrecoVenda(precoVenda);
    }
    public void setPrecoVenda(double precoVenda) {
        if (precoVenda + 0.000001 < calcularPrecoMinimo())
            throw new IllegalArgumentException("RN06: preço deve ser no mínimo custo + 40%.");
        this.precoVenda = precoVenda;
    }
    @Override public double calcularCustoProducao() { return custo; }
    @Override public double calcularPrecoMinimo() { return custo * 1.40; }
    @Override public String getNomeComercial() { return nome; }
    @Override public double getPrecoVenda() { return precoVenda; }
    @Override public String toString() { return "Difusor " + nome + " (" + quantidadeVaretas + " varetas)"; }
}
