package br.edu.unifsa.perfumaria.produtos;

public final class Formula {
    private final String nome;
    private final String notaTopo;
    private final String notaCoracao;
    private final String notaFundo;
    private final double percentualTopo;
    private final double percentualCoracao;
    private final double percentualFundo;

    public Formula(String nome, String notaTopo, String notaCoracao, String notaFundo,
                   double percentualTopo, double percentualCoracao, double percentualFundo) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome da fórmula obrigatório.");
        if (notaTopo == null || notaTopo.isBlank() || notaCoracao == null || notaCoracao.isBlank()
                || notaFundo == null || notaFundo.isBlank()) {
            throw new IllegalArgumentException("As três notas da fórmula são obrigatórias.");
        }
        validarPercentuais(percentualTopo, percentualCoracao, percentualFundo);
        this.nome = nome;
        this.notaTopo = notaTopo;
        this.notaCoracao = notaCoracao;
        this.notaFundo = notaFundo;
        this.percentualTopo = percentualTopo;
        this.percentualCoracao = percentualCoracao;
        this.percentualFundo = percentualFundo;
    }

    private void validarPercentuais(double topo, double coracao, double fundo) {
        if (topo <= 0 || coracao <= 0 || fundo <= 0
                || Math.abs((topo + coracao + fundo) - 100.0) > 0.000001) {
            throw new IllegalArgumentException("RN02: percentuais das notas devem ser positivos e somar 100%.");
        }
    }

    public String getNome() { return nome; }
    public String resumo() {
        return nome + " [topo=" + notaTopo + " " + percentualTopo + "%, coração=" + notaCoracao
                + " " + percentualCoracao + "%, fundo=" + notaFundo + " " + percentualFundo + "%]";
    }

    @Override
    public String toString() { return resumo(); }
}
