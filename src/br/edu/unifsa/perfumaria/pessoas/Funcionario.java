package br.edu.unifsa.perfumaria.pessoas;

public abstract class Funcionario {
    private final String nome;
    private final String matricula;

    protected Funcionario(String nome, String matricula) {
        if (nome == null || nome.isBlank() || matricula == null || matricula.isBlank())
            throw new IllegalArgumentException("Nome e matrícula são obrigatórios.");
        this.nome = nome; this.matricula = matricula;
    }
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public abstract boolean podeAssinarParfum();
    public void assinarCategoria(br.edu.unifsa.perfumaria.produtos.CategoriaPerfume categoria) {
        if (categoria == br.edu.unifsa.perfumaria.produtos.CategoriaPerfume.PARFUM && !podeAssinarParfum()) {
            throw new IllegalStateException("RN09: perfumista júnior não pode assinar fórmulas Parfum.");
        }
    }
    public String descrever() { return nome + " (matrícula " + matricula + ")"; }
    @Override public String toString() { return getClass().getSimpleName() + ": " + descrever(); }
}
