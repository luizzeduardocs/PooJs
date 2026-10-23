# Essência do Poti — POO em Java

Projeto acadêmico da disciplina Programação Orientada a Objetos (UNIFSA), inspirado na perfumaria artesanal Essência do Poti, de Teresina-PI.

## Integrantes e módulos

> Preencha com os dados reais do grupo antes da entrega.

| Integrante | Usuário do GitHub | Módulo responsável |
|---|---|---|
| Nome completo 1 | @usuario1 | `produtos` |
| Nome completo 2 | @usuario2 | `producao` |
| Nome completo 3 | @usuario3 | `pessoas` |

## Requisitos e modelagem

- **Encapsulamento:** atributos são `private` ou `protected` quando o acesso herdado é necessário; validações são executadas antes de alterar o estado.
- **Herança:** `Perfume` é a superclasse abstrata de `Parfum`, `EauDeParfum`, `EauDeToilette` e `Colonia`. `Funcionario` é a superclasse abstrata de `PerfumistaJunior` e `PerfumistaSenior`.
- **Classes abstratas:** `Perfume` reúne características comuns, mas cada categoria calcula seu custo de forma própria; `Funcionario` representa um conceito genérico de funcionário.
- **Interfaces:** `Precificavel` representa produtos que calculam preço de venda; `Vendavel` representa itens que podem ser vendidos. São capacidades do negócio, não categorias de herança.
- **Imutabilidade:** o código de `Lote` e o volume de `Frasco` são definidos na construção e não têm setter.
- **Acesso `protected`:** `Perfume.concentracao` permite que as subclasses validem e utilizem a concentração sem duplicar o atributo; o acesso é restrito à hierarquia.
- **Validações:** as regras RN01–RN11 são demonstradas pela simulação. As tentativas inválidas devem ser recusadas sem corromper o estado dos objetos.

## Organização

- `src/br/edu/unifsa/perfumaria/produtos`: perfumes, fórmula, vela e difusor.
- `src/br/edu/unifsa/perfumaria/producao`: matérias-primas, lote, frasco, estoque e vendas.
- `src/br/edu/unifsa/perfumaria/pessoas`: funcionários, clientes e encomendas.
- `src/br/edu/unifsa/perfumaria/Simulacao.java`: roteiro de execução e testes das regras.
