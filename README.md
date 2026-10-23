# Essência do Poti

Projeto acadêmico desenvolvido para a disciplina de Programação Orientada a Objetos (POO), do curso de Engenharia de Software da UNIFSA.

## Sobre o projeto

O Essência do Poti é um sistema em Java que simula atividades de uma perfumaria, incluindo perfumes, fórmulas, frascos, lotes, matérias-primas, funcionários, vendas e encomendas personalizadas. A classe `Simulacao` executa exemplos e validações das regras de negócio.

## Integrantes

| Integrante | GitHub | Módulo |
|---|---|---|
| Luiz Eduardo | @luizzeduardocs | Produtos |
| Davi Reis | DaviReis500 | Produção |

> Antes da entrega, confirmem os nomes completos e os usuários do GitHub de todos os integrantes.

## Organização do projeto

- `src/br/edu/unifsa/perfumaria/produtos`: perfumes, fórmulas, velas aromáticas, difusores e interfaces.
- `src/br/edu/unifsa/perfumaria/producao`: matérias-primas, lotes e frascos.
- `src/br/edu/unifsa/perfumaria/pessoas`: clientes, funcionários e encomendas personalizadas.
- `src/br/edu/unifsa/perfumaria/Simulacao.java`: ponto de entrada para executar a simulação.
- `docs/diagrama-de-classes.png`: diagrama de classes.
- `docs/diagrama.dot`: fonte Graphviz do diagrama existente.

## Decisões de modelagem

- `Perfume` é abstrata porque reúne características e comportamentos comuns às categorias Parfum, Eau de Parfum, Eau de Toilette e Colônia.
- `Funcionario` é abstrata porque reúne dados e comportamentos comuns aos funcionários, especializados em perfumista júnior e sênior.
- `Precificavel` define comportamentos relacionados ao cálculo de custo e preço mínimo.
- `Vendavel` representa os produtos que podem ser comercializados.
- Os atributos são privados para proteger o estado dos objetos e permitir validações nos métodos. O atributo `concentracao` de `Perfume` é `protected` para permitir acesso pelas subclasses, evitando duplicação.
- O código do lote e o volume do frasco são definidos na criação dos objetos e não possuem setters, para preservar esses valores.

## Regras de negócio

A simulação contempla validações relacionadas à concentração dos perfumes, composição das fórmulas, volume dos frascos, tempo de maceração, código do lote, preço mínimo, estoque, validade das matérias-primas, autorização para assinar fórmulas, composição de velas, quantidade de varetas dos difusores e gravação/devolução de encomendas personalizadas. Consulte o código e a saída da simulação para verificar o comportamento de cada regra.



**OBS MEU NETBEANS NAO RODOU  COMO ESPERADO POIS ESTOU SEM MEU NOTEBOOK, ESTOU UTILIZANDO UM MAIS FRACO DE EMERGENCIA, POREM TODAS AS COMPETENCIAS FORAM ATENDIDAS, E FEITAS COM AJUDA DE PAINEL CMD EM ALGUNS DOS CASOS, QUANDO FOI NECESSARIO.**


## Como compilar e executar

É necessário ter um JDK instalado. Abra o terminal na pasta `src` do projeto.

**Windows (CMD):**

```bat
javac -encoding UTF-8 -d out -sourcepath . br\edu\unifsa\perfumaria\Simulacao.java
java -cp out br.edu.unifsa.perfumaria.Simulacao


