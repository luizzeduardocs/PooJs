package br.edu.unifsa.perfumaria.produtos;

public final class EauDeToilette extends Perfume {
    public EauDeToilette(String nome, Formula formula, double concentracao, double custoBase, double precoVenda) {
        super(nome, formula, concentracao, custoBase, precoVenda);
    }
    @Override protected double minimoConcentracao() { return 5; }
    @Override protected double maximoConcentracao() { return 15; }
    @Override protected String categoria() { return "EDT"; }
    @Override public String toString() { return super.toString() + ", fórmula=" + getFormula().getNome(); }
}
