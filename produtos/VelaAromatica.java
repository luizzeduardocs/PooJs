package br.edu.unifsa.perfumaria.produtos;

public final class VelaAromatica implements Precificavel, Vendavel {
    private final String nome;
    private final double pesoCeraGramas;
    private final double fragranciaGramas;
    private final double custo;
    private double precoVenda;

    public VelaAromatica(String nome, double pesoCeraGramas, double fragranciaGramas, double custo, double precoVenda) {
        if (nome == null || nome.isBlank() || pesoCeraGramas <= 0 || fragranciaGramas <= 0 || custo < 0)
            throw new IllegalArgumentException("Dados inválidos para vela.");
        if (fragranciaGramas / pesoCeraGramas * 100.0 > 10.0)
            throw new IllegalArgumentException("RN10: fragrância da vela não pode exceder 10% do peso da cera.");
        this.nome = nome; this.pesoCeraGramas = pesoCeraGramas; this.fragranciaGramas = fragranciaGramas; this.custo = custo;
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
    @Override public String toString() { return "Vela " + nome + " (" + pesoCeraGramas + "g de cera)"; }
}
