package br.edu.unifsa.perfumaria.produtos;

public final class Parfum extends Perfume {
    public Parfum(String nome, Formula formula, double concentracao, double custoBase, double precoVenda) {
        super(nome, formula, concentracao, custoBase, precoVenda);
    }
    @Override protected double minimoConcentracao() { return 20; }
    @Override protected double maximoConcentracao() { return 30; }
    @Override protected String categoria() { return "Parfum"; }
    @Override public String toString() { return super.toString() + ", fórmula=" + getFormula().getNome(); }
}
