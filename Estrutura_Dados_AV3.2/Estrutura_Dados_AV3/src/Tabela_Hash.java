public class Tabela_Hash {
    private int tamanho;
    private ListaEncadeada[] tabela;

    public Tabela_Hash() {
        this.tamanho = 256;
        tabela = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }

    private int hash(char chave) {
        return chave % tamanho;
    }

    public void put(char chave, String valor) {
        int indice = hash(chave);
        tabela[indice].inserir(chave, valor);
    }

    public String get(char chave) {
        int indice = hash(chave);
        return tabela[indice].buscar(chave);
    }

    public void remove(char chave) {
        int indice = hash(chave);
        tabela[indice].remover(chave);
    }

    private class ParChaveValor {
        char chave;
        String valor;

        public ParChaveValor(char chave, String valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    private class ListaEncadeada {
        private No primeiro;

        public ListaEncadeada() {
            primeiro = null;
        }

        public void inserir(char chave, String valor) {
            ParChaveValor novoPar = new ParChaveValor(chave, valor);
            No novo = new No(novoPar);

            if (primeiro == null) {
                primeiro = novo;
            } else {
                novo.setProximo(primeiro);
                primeiro = novo;
            }
        }

        public String buscar(char chave) {
            No atual = primeiro;
            while (atual != null) {
                if (atual.getPar().chave == chave) {
                    return atual.getPar().valor;
                }
                atual = atual.getProximo();
            }
            return null;
        }

        public void remover(char chave) {
            No anterior = null;
            No atual = primeiro;

            while (atual != null) {
                if (atual.getPar().chave == chave) {
                    if (anterior == null) {
                        primeiro = atual.getProximo();
                    } else {
                        anterior.setProximo(atual.getProximo());
                    }
                    return;
                }
                anterior = atual;
                atual = atual.getProximo();
            }
        }
    }

    private class No {
        private ParChaveValor par;
        private No proximo;

        public No(ParChaveValor par) {
            this.par = par;
            this.proximo = null;
        }

        public ParChaveValor getPar() {
            return par;
        }

        public No getProximo() {
            return proximo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
    }
}
