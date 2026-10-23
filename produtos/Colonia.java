package br.edu.unifsa.perfumaria.produtos;

public final class Colonia extends Perfume {
    public Colonia(String nome, Formula formula, double concentracao, double custoBase, double precoVenda) {
        super(nome, formula, concentracao, custoBase, precoVenda);
    }
    @Override protected double minimoConcentracao() { return 2; }
    @Override protected double maximoConcentracao() { return 5; }
    @Override protected String categoria() { return "Colônia"; }
    @Override public String toString() { return super.toString() + ", fórmula=" + getFormula().getNome(); }
}
