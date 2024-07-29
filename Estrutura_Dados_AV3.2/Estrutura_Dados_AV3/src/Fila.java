public class Fila {
    private No primeiro;

    private No ultimo;

    private int contador;

    public Fila() {
    }
    public void adicionar(char letra, int ocorrencia) {
        No novo = new No(letra, ocorrencia);
        if (this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            No anterior = null;
            No atual = this.primeiro;
            while (atual != null && novo.compareTo(atual) >= 0) {
                anterior = atual;
                atual = atual.getProximo();
            }
            if (anterior == null) {
                novo.setProximo(this.primeiro);
                this.primeiro = novo;
            } else {
                anterior.setProximo(novo);
                novo.setProximo(atual);
                if (atual == null) {
                    this.ultimo = novo;
                }
            }
        }
        this.contador++;
    }

    public void adicionar(No novo_no) {
        No novo = new No(novo_no.getOcorrencia(),novo_no.getDireito(),novo_no.getEsquerdo());
        if (this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            No anterior = null;
            No atual = this.primeiro;
            while (atual != null && novo.compareTo(atual) >= 0) {
                anterior = atual;
                atual = atual.getProximo();
            }
            if (anterior == null) {
                novo.setProximo(this.primeiro);
                this.primeiro = novo;
            } else {
                anterior.setProximo(novo);
                novo.setProximo(atual);
                if (atual == null) {
                    this.ultimo = novo;
                }
            }
        }
        this.contador++;
    }

    public No removerNoInicio(){
        No inicio = this.primeiro;

        if(contador == 1){
            this.primeiro=null;
        }else{
            primeiro = primeiro.getProximo();
        }
        contador--;
        return inicio;
    }

    public  void imprimir(){
        No novo = this.primeiro;
        System.out.print("[");
        while (novo!=null){
            System.out.print(novo.getLetra()+":"+novo.getOcorrencia());
            novo =novo.getProximo();
            if(novo!=null){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}

