import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner Sc = new Scanner(System.in);

        boolean parada = true;

        while (parada) {

            System.out.println("Digite o que deseja fazer.\n" +
                    "[1] Ler um arquivo .txt e criar um código comprimido.\n" +
                    "[2] Ler um código comprimido e descomprimir.\n" +
                    "[3] Sair do programa");

            String escolha = Sc.next();

            if (escolha.equalsIgnoreCase("1")) {

                File texto_Original = new File("C:\\Users\\fernando\\Desktop\\Ciencias da Comp\\Estrutura_Dados_AV3\\src\\texto_Original.txt");
                File text_Comprimido = new File("C:\\Users\\fernando\\Desktop\\Ciencias da Comp\\Estrutura_Dados_AV3\\src\\texto_Comprimido.txt");

                Fila fila = new Fila();
                Arquivos_L_G aq = new Arquivos_L_G();
                aq.lerArquivo(texto_Original, fila);

                Arvore arvore = new Arvore(fila);

                aq.comprimirArquivo(texto_Original, text_Comprimido, arvore);



            } else if (escolha.equalsIgnoreCase("2")) {

                File text_Comprimido = new File("C:\\Users\\fernando\\Desktop\\Ciencias da Comp\\Estrutura_Dados_AV3\\src\\texto_Comprimido2.txt");
                File texto_Descomprimido = new File("C:\\Users\\fernando\\Desktop\\Ciencias da Comp\\Estrutura_Dados_AV3\\src\\texto_Descomprimido.txt");


                Arquivos_L_G aq = new Arquivos_L_G();
                aq.descomprimirArquivo(text_Comprimido, texto_Descomprimido);

                System.out.println("Se deus quiser arquivo descomprimido com sucesso!");

            } else if (escolha.equalsIgnoreCase("3")) {
                parada=false;
            }else {
                System.out.println("Escolha invalida Gilson.");
            }
        }
        Sc.close();
    }
}