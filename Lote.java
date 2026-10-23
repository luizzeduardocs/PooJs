package br.edu.unifsa.perfumaria.producao;

import br.edu.unifsa.perfumaria.produtos.Perfume;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public final class Lote {
    private final String codigo;
    private final Perfume perfume;
    private final LocalDate dataProducao;
    private LocalDate dataEnvase;
    private Frasco frasco;
    private int quantidadeEstoque;

    public Lote(Perfume perfume, LocalDate dataProducao, int quantidadeInicial) {
        this(UUID.randomUUID().toString().substring(0, 8).toUpperCase(), perfume, dataProducao, quantidadeInicial);
    }
    public Lote(String codigo, Perfume perfume, LocalDate dataProducao, int quantidadeInicial) {
        if (codigo == null || codigo.isBlank() || perfume == null || dataProducao == null || quantidadeInicial < 0)
            throw new IllegalArgumentException("Dados inválidos para lote.");
        this.codigo = codigo; this.perfume = perfume; this.dataProducao = dataProducao;
        this.quantidadeEstoque = quantidadeInicial;
    }
    public void envasar(Frasco frasco, LocalDate dataEnvase) {
        if (frasco == null || dataEnvase == null || dataEnvase.isBefore(dataProducao))
            throw new IllegalArgumentException("Dados de envase inválidos.");
        long dias = ChronoUnit.DAYS.between(dataProducao, dataEnvase);
        int minimo = diasMinimos(perfume);
        if (dias < minimo) throw new IllegalStateException("RN04: maceração insuficiente. Necessário " + minimo + " dias.");
        if (this.frasco != null) throw new IllegalStateException("Lote já envasado.");
        this.frasco = frasco; this.dataEnvase = dataEnvase;
    }
    private int diasMinimos(Perfume p) {
        String s = p.getClass().getSimpleName();
        if (s.equals("Parfum")) return 60;
        if (s.equals("EauDeParfum")) return 45;
        if (s.equals("EauDeToilette")) return 30;
        return 15;
    }
    public void vender(int quantidade) {
        if (frasco == null) throw new IllegalStateException("O lote precisa ser envasado antes da venda.");
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade de venda deve ser positiva.");
        if (quantidade > quantidadeEstoque) throw new IllegalStateException("RN07: estoque insuficiente.");
        quantidadeEstoque -= quantidade;
    }
    public String getCodigo() { return codigo; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public Perfume getPerfume() { return perfume; }
    @Override public String toString() {
        return "Lote " + codigo + " — " + perfume.getNome() + ", frasco=" + (frasco == null ? "não envasado" : frasco)
                + ", estoque=" + quantidadeEstoque;
    }
}
