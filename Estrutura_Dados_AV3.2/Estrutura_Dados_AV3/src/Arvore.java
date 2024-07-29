public class Arvore {

    private No raiz;

    private Tabela_Hash matriz_codigo;


    //==================================================================================================================
    public Arvore(Fila prioridade){

        this.matriz_codigo = new Tabela_Hash();

        while (prioridade.getContador()>1){
            No esquerdo = prioridade.removerNoInicio();
            No direito = prioridade.removerNoInicio();
            No concatenado = new No(direito.getOcorrencia()+esquerdo.getOcorrencia(),direito,esquerdo);
            prioridade.adicionar(concatenado);

        }



        raiz = prioridade.removerNoInicio();
        gerador_codigos(this.raiz, "");

        System.out.println("lista de letras e seus códigos:");
        imprimirCodigos();
        System.out.println("=====================================================================================");
        System.out.println();
        System.out.println("Arvore completa:");
        imprimirArvore(raiz,"");
        System.out.println("=====================================================================================");
        System.out.println();


    }

    private void gerador_codigos(No no, String codigo) {
        if(no == null){
            return ;
        }else{
            if(no.folha()){
                matriz_codigo.put(no.getLetra(), codigo);
            }else{
                gerador_codigos(no.getEsquerdo(),codigo + "0");
                gerador_codigos(no.getDireito(), codigo + "1");
            }
        }
    }

    //==================================================================================================================

    //==================================================================================================================
    private  String letra_binario(char letra){
        return String.format("%8s", Integer.toBinaryString(letra )).replace(' ', '0');    }

    public String codigo_arvore(No raiz){
        if(raiz == null){
            return "";
        }
        if(raiz.folha()){
            return "1" + letra_binario(raiz.getLetra());
        }else{
            return "0"+ codigo_arvore(raiz.getEsquerdo()) + codigo_arvore(raiz.getDireito());
        }
    }
    //==================================================================================================================

    //==================================================================================================================
    public static No reconstruirArvore(String str, int[] indice) {
        if (str.charAt(indice[0]) == '1') {
            indice[0]++;
            String letraBinario = str.substring(indice[0], indice[0] + 8);
            indice[0] += 8;
            char letra = (char) Integer.parseInt(letraBinario, 2);
            return new No(letra, 0); // 0 porque a ocorrência não importa na reconstrução
        } else {
            indice[0]++;
            No esquerdo = reconstruirArvore(str, indice);
            No direito = reconstruirArvore(str, indice);
            return new No(0, direito, esquerdo);
        }
    }

    public static String decodificarMensagem(String mensagemComprimida, No raiz) {
        StringBuilder mensagemDecodificada = new StringBuilder();
        No atual = raiz;
        for (int i = 0; i < mensagemComprimida.length(); i++) {
            atual = mensagemComprimida.charAt(i) == '0' ? atual.getEsquerdo() : atual.getDireito();//if e else diferenciado
            if (atual.folha()) {
                mensagemDecodificada.append(atual.getLetra());
                atual = raiz;
            }
        }
        return mensagemDecodificada.toString();
    }

    //==================================================================================================================


    //==================================================================================================================
    public void imprimirArvore(No no, String prefixo) {
        if (no != null) {
            System.out.println(prefixo + (no.getLetra() != '\0' ? no.getLetra() + ":" + no.getOcorrencia() : no.getOcorrencia()));
            imprimirArvore(no.getEsquerdo(), prefixo + "  ");
            imprimirArvore(no.getDireito(), prefixo + "  ");
        }

    }

    public void imprimirCodigos() {
        for (int i = 0; i < 256; i++) {
            String codigo = matriz_codigo.get((char) i);
            if (codigo != null) {
                System.out.println((char) i + ":" + codigo);
            }
        }
    }
    //==================================================================================================================

    //==================================================================================================================
    public No getRaiz() {
        return raiz;
    }

    public String getCodigo(char letra) {
        return matriz_codigo.get(letra);
    }
    //==================================================================================================================
}
