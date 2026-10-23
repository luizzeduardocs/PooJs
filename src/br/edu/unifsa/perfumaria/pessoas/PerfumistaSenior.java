package br.edu.unifsa.perfumaria.pessoas;

public final class PerfumistaSenior extends Funcionario {
    public PerfumistaSenior(String nome, String matricula) { super(nome, matricula); }
    @Override public boolean podeAssinarParfum() { return true; }
    @Override public String descrever() { return super.descrever() + " — perfumista sênior"; }
    @Override public String toString() { return super.toString(); }
}
