package br.edu.unifsa.perfumaria;

import br.edu.unifsa.perfumaria.produtos.*;
import br.edu.unifsa.perfumaria.producao.*;
import br.edu.unifsa.perfumaria.pessoas.*;
import java.time.LocalDate;

public class Simulacao {
    private static final LocalDate HOJE = LocalDate.now();

    private static void testar(String regra, String descricao, Runnable acao) {
        try {
            acao.run();
            System.out.println("[" + regra + "] " + descricao + ": ACEITO");
        } catch (RuntimeException e) {
            System.out.println("[" + regra + "] " + descricao + ": RECUSADO — " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== UM DIA NA ESSÊNCIA DO POTI ===");
        PerfumistaJunior junior = new PerfumistaJunior("Ana Lima", "P001");
        PerfumistaSenior senior = new PerfumistaSenior("Rafael Sousa", "P002");
        MateriaPrima bergamota = new MateriaPrima("Óleo de bergamota", HOJE.plusMonths(6), 500);
        MateriaPrima oleoVencido = new MateriaPrima("Óleo vencido", HOJE.minusDays(1), 100);
        System.out.println(junior);
        System.out.println(senior);
        System.out.println("Matéria-prima: " + bergamota);

        Formula fresca = new Formula("Brisa do Poti", "limão", "jasmim", "âmbar", 30, 40, 30);
        Formula amadeirada = new Formula("Madeiras do Poti", "bergamota", "rosa", "cedro", 25, 35, 40);
        Parfum parfum = new Parfum("Poti Intenso", amadeirada, 25, 100, 150);
        EauDeParfum edp = new EauDeParfum("Brisa EDP", fresca, 18, 80, 120);
        EauDeToilette edt = new EauDeToilette("Brisa EDT", fresca, 10, 50, 75);
        Colonia colonia = new Colonia("Colônia Solar", fresca, 4, 30, 45);
        System.out.println("\nFórmulas cadastradas: " + fresca + " | " + amadeirada);
        System.out.println("Perfumes: " + parfum + " | " + edp + " | " + edt + " | " + colonia);

        Lote loteEdp = new Lote(edp, HOJE.minusDays(50), 20);
        loteEdp.envasar(new Frasco(50), HOJE.minusDays(5));
        loteEdp.vender(3);
        System.out.println("\nVenda realizada: 3 unidades de " + edp.getNome());
        System.out.println("Encomenda: " + new EncomendaPersonalizada(new Cliente("Maria"), "Maria"));

        System.out.println("\n=== TESTES DE REGRAS DE NEGÓCIO ===");
        testar("RN01", "Concentração inválida para Parfum", () -> new Parfum("Inválido", fresca, 10, 100, 150));
        testar("RN02", "Notas somando 90%", () -> new Formula("Erro", "limão", "rosa", "cedro", 30, 30, 30));
        testar("RN03", "Frasco de 75 ml", () -> new Frasco(75));
        testar("RN04", "Envase de EDP após 20 dias", () -> {
            Lote l = new Lote(edp, HOJE.minusDays(20), 2);
            l.envasar(new Frasco(30), HOJE);
        });
        testar("RN05", "Código do lote imutável", () -> {
            Lote l = new Lote(edp, HOJE.minusDays(50), 1);
            if (l.getCodigo() == null || l.getCodigo().isBlank()) throw new IllegalStateException("Código ausente");
            System.out.println("  Código gerado: " + l.getCodigo() + " (sem setter)");
        });
        testar("RN06", "Preço menor que custo + 40%", () -> new EauDeParfum("Preço baixo", fresca, 18, 100, 120));
        testar("RN07", "Venda maior que estoque", () -> loteEdp.vender(100));
        testar("RN08", "Usar matéria-prima vencida", () -> oleoVencido.consumir(1, HOJE));
        testar("RN09", "Perfumista júnior assinar Parfum", () ->
                junior.assinarCategoria(CategoriaPerfume.PARFUM));
        testar("RN10", "Vela com fragrância acima de 10%", () -> new VelaAromatica("Vela forte", 100, 15, 10, 20));
        testar("RN10", "Difusor com 12 varetas", () -> new Difusor("Difusor", 12, 20, 30));
        testar("RN11", "Gravação com mais de 20 caracteres", () ->
                new EncomendaPersonalizada(new Cliente("João"), "Nome muito comprido para frasco"));
        testar("RN11", "Devolução de encomenda personalizada", () ->
                new EncomendaPersonalizada(new Cliente("João"), "João").registrarDevolucao());
        testar("RN02", "Fórmula válida com três notas", () ->
                System.out.println(new Formula("Válida", "limão", "rosa", "baunilha", 20, 30, 50)));
        testar("RN05", "Criar lote com código vazio", () ->
                new Lote("", colonia, HOJE, 4));
        testar("RN05", "Criar lote com código próprio", () ->
                System.out.println(new Lote(colonia, HOJE, 4)));

        System.out.println("\n=== ESTOQUE FINAL ===");
        System.out.println(loteEdp);
        System.out.println("Estoque do lote EDP: " + loteEdp.getQuantidadeEstoque());
        System.out.println("=== FIM DA SIMULAÇÃO ===");
    }
}
