package br.edu.unifsa.perfumaria.produtos;

public final class EauDeParfum extends Perfume {
    public EauDeParfum(String nome, Formula formula, double concentracao, double custoBase, double precoVenda) {
        super(nome, formula, concentracao, custoBase, precoVenda);
    }
    @Override protected double minimoConcentracao() { return 15; }
    @Override protected double maximoConcentracao() { return 20; }
    @Override protected String categoria() { return "EDP"; }
    @Override public String toString() { return super.toString() + ", fórmula=" + getFormula().getNome(); }
}
