Huffman Tree

Implementação em Java da árvore de Huffman, algoritmo de codificação usado em compressão de dados. Projeto desenvolvido na disciplina de Estrutura de Dados (avaliação AV3).

O que é a codificação de Huffman

É uma técnica de compressão sem perdas que dá códigos mais curtos aos símbolos que aparecem com mais frequência e códigos mais longos aos mais raros. Com isso, o texto codificado ocupa menos espaço que o original.

Como o algoritmo funciona
Conta quantas vezes cada símbolo aparece no texto.
Cria um nó para cada símbolo, com sua frequência, e coloca todos em uma fila de prioridade (menor frequência primeiro).
Retira os dois nós de menor frequência e cria um novo nó pai com a soma das frequências deles.
Repete o passo 3 até sobrar um único nó, a raiz da árvore.
Percorre a árvore da raiz até cada folha: ir para a esquerda vale 0 e ir para a direita vale 1. O caminho até a folha é o código do símbolo.

O que o projeto faz
Lê um texto, monta a árvore, mostra a tabela de códigos.
Codifica e decodifica uma mensagem.

Estrutura do repositório:
huffman-tree/
├── Estrutura_Dados_AV3.2/
│   └── Estrutura_Dados_AV3/    # código-fonte
├── Estrutura_Dados_AV3.iml
├── LICENSE
└── README.md

Tecnologias
Java 
IntelliJ IDEA (arquivo de módulo .iml incluído no repositório)

Como rodar:
bash
git clone https://github.com/fernandoDCabral/huffman-tree.git
cd huffman-tree

Abra a pasta no IntelliJ IDEA (ou outra IDE Java) e execute a classe principal.

Exemplo:

Entrada:
texto de exemplo

Saída:
tabela de códigos ou texto codificado

