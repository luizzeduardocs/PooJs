package br.edu.unifsa.perfumaria.produtos;

public abstract class Perfume implements Precificavel, Vendavel {
    private final String nome;
    private final Formula formula;
    protected final double concentracao;
    private final double custoBase;
    private double precoVenda;

    protected Perfume(String nome, Formula formula, double concentracao, double custoBase, double precoVenda) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome do perfume obrigatório.");
        if (formula == null) throw new IllegalArgumentException("Fórmula obrigatória.");
        if (custoBase < 0) throw new IllegalArgumentException("Custo não pode ser negativo.");
        this.nome = nome;
        this.formula = formula;
        this.concentracao = concentracao;
        validarConcentracao(concentracao);
        this.custoBase = custoBase;
        setPrecoVenda(precoVenda);
    }

    protected abstract double minimoConcentracao();
    protected abstract double maximoConcentracao();
    protected abstract String categoria();

    private void validarConcentracao(double valor) {
        if (valor < minimoConcentracao() || valor > maximoConcentracao()) {
            throw new IllegalArgumentException("RN01: concentração inválida para " + categoria()
                    + " (" + minimoConcentracao() + "% a " + maximoConcentracao() + "%).");
        }
    }

    public final void setPrecoVenda(double precoVenda) {
        if (precoVenda + 0.000001 < calcularPrecoMinimo()) {
            throw new IllegalArgumentException("RN06: preço deve ser no mínimo custo + 40% (R$ "
                    + String.format("%.2f", calcularPrecoMinimo()) + ").");
        }
        this.precoVenda = precoVenda;
    }

    public String getNome() { return nome; }
    public Formula getFormula() { return formula; }
    public double getConcentracao() { return concentracao; }
    public double getPrecoVenda() { return precoVenda; }
    public String getNomeComercial() { return nome + " (" + categoria() + ")"; }
    @Override public double calcularCustoProducao() { return custoBase; }
    @Override public double calcularPrecoMinimo() { return custoBase * 1.40; }

    @Override
    public String toString() {
        return categoria() + ": " + nome + ", concentração=" + concentracao + "%, custo=R$"
                + String.format("%.2f", custoBase) + ", preço=R$" + String.format("%.2f", precoVenda);
    }
}
