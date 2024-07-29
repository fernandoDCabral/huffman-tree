public class No implements Comparable<No> {
    private No esquerdo;
    private No direito;
    private char letra;
    private int ocorrencia;
    private No proximo;

    public No() {
    }

    public No(char letra, int ocorrencia) {
        this.letra = letra;
        this.ocorrencia = ocorrencia;
        this.direito = null;
        this.esquerdo = null;
        this.proximo = null;
    }

    public No(int ocorrencia, No direito, No esquerdo) {
        this.letra = '\0';
        this.ocorrencia = ocorrencia;
        this.direito = direito;
        this.esquerdo = esquerdo;
        this.proximo = null;
    }

    public boolean folha(){
        return esquerdo==null && direito==null;
    }


    @Override
    public int compareTo(No o) {
        if (this.ocorrencia != o.ocorrencia) {
            return Integer.compare(this.ocorrencia, o.ocorrencia);
        } else {
            if (this.letra == '\0' && o.letra != '\0') {
                return 1;
            } else if (this.letra != '\0' && o.letra == '\0') {
                return -1;
            } else {
                return Character.compare(this.letra, o.letra);
            }
        }
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(int ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
