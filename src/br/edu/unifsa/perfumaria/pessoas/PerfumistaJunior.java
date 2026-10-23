package br.edu.unifsa.perfumaria.pessoas;

public final class PerfumistaJunior extends Funcionario {
    public PerfumistaJunior(String nome, String matricula) { super(nome, matricula); }
    @Override public boolean podeAssinarParfum() { return false; }
    @Override public String descrever() { return super.descrever() + " — perfumista júnior"; }
    @Override public String toString() { return super.toString(); }
}
