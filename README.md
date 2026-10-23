# Essência do Poti

Projeto acadêmico desenvolvido para a disciplina de Programação Orientada a Objetos (POO), do curso de Engenharia de Software da UNIFSA.

## Sobre o projeto

O Essência do Poti é um sistema desenvolvido em Java que simula atividades de uma perfumaria, incluindo perfumes, fórmulas, frascos, lotes, matérias-primas, funcionários, vendas e encomendas personalizadas. A classe `Simulacao` executa exemplos e validações das regras de negócio implementadas no sistema.

## Integrantes

| Integrante | GitHub | Módulo |
|---|---|---|
| Luiz Eduardo | @luizzeduardocs | Produtos |
| Davi Reis | @DaviReis500 | Produção |

## Organização do projeto

- `src/br/edu/unifsa/perfumaria/produtos`: perfumes, fórmulas, velas aromáticas, difusores e interfaces.
- `src/br/edu/unifsa/perfumaria/producao`: matérias-primas, lotes e frascos.
- `src/br/edu/unifsa/perfumaria/pessoas`: clientes, funcionários e encomendas personalizadas.
- `src/br/edu/unifsa/perfumaria/Simulacao.java`: classe principal utilizada para executar a simulação.
- `docs/diagrama-de-classes.png`: imagem do diagrama de classes.
- `docs/diagrama.dot`: arquivo-fonte Graphviz do diagrama, caso esteja presente no repositório.

## Decisões de modelagem

- `Perfume` é uma classe abstrata porque reúne características e comportamentos comuns às categorias Parfum, Eau de Parfum, Eau de Toilette e Colônia.
- `Funcionario` é uma classe abstrata porque reúne dados e comportamentos compartilhados pelos funcionários, especializados em perfumista júnior e sênior.
- A interface `Precificavel` define comportamentos relacionados ao cálculo de custos e preços mínimos.
- A interface `Vendavel` representa os produtos que podem ser comercializados.
- Os atributos são privados para proteger o estado dos objetos e permitir que as validações sejam realizadas pelos métodos. O atributo `concentracao` de `Perfume` é protegido (`protected`) para permitir o acesso pelas subclasses.
- O código do lote e o volume do frasco são definidos na criação dos objetos e não possuem métodos setters, preservando esses valores após a definição.

## Regras de negócio

A simulação contempla validações relacionadas à concentração dos perfumes, à composição das fórmulas, ao volume dos frascos, ao tempo de maceração, ao código dos lotes, ao preço mínimo, ao controle de estoque, à validade das matérias-primas, à autorização para assinar fórmulas, à composição de velas aromáticas, à quantidade de varetas dos difusores e às regras de gravação e devolução de encomendas personalizadas.

O comportamento dessas regras pode ser conferido no código-fonte e na saída da simulação.

## Observação sobre o desenvolvimento

**OBS: MEU NETBEANS NÃO RODOU COMO ESPERADO, POIS ESTOU SEM MEU NOTEBOOK HABITUAL E ESTOU UTILIZANDO UM MAIS FRACO DE EMERGÊNCIA. PORÉM, TODAS AS COMPETÊNCIAS FORAM ATENDIDAS, E ALGUMAS ETAPAS FORAM REALIZADAS COM O AUXÍLIO DO CMD QUANDO NECESSÁRIO.**

## Como compilar e executar

É necessário ter o JDK instalado. Abra o CMD na pasta `src` do projeto.

**1. Compilar o projeto:**

```bat
javac -encoding UTF-8 -d out -sourcepath . br\edu\unifsa\perfumaria\Simulacao.java br\edu\unifsa\perfumaria\pessoas\*.java br\edu\unifsa\perfumaria\producao\*.java br\edu\unifsa\perfumaria\produtos\*.java
```

**2. Executar a simulação:**

```bat
java -cp out br.edu.unifsa.perfumaria.Simulacao
```

## Finalidade acadêmica

Projeto desenvolvido para fins acadêmicos, com o objetivo de aplicar os conceitos de Programação Orientada a Objetos utilizando Java.
