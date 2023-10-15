package br.edu.ifs.ED.lista;

public class Teste {
    public static void main(String[] args) throws Exception{

        ListaSimplesEncadeada<Integer> lista = new ListaSimplesEncadeada<>();


        System.out.println("Elementos da lista: ");
        lista.incluir(5);
        lista.incluir(10);
        lista.incluir(15);
        lista.exibir();

        // Teste 1
        System.out.println("Transformando a lista em vetor: ");
        try {

            Comparable[] vetor = lista.TransformarEmVetor();

            for (Comparable elemento : vetor) {
                System.out.print("[ " + elemento + " ]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n=================================================");

        // Teste2: retorna -1 se esta lista tiver menos elementos que a lista passada como parâmetro e 1 caso a ela
        // tenha mais elementos que a lista recebida como parâmetro. 0 se estiver na mesma ordem / tamanho igual
        System.out.println("Comparação de listas");
        ListaSimplesEncadeada<Integer> lista2 = new ListaSimplesEncadeada<>();

        lista2.incluir(1);
        lista2.incluir(2);
        lista2.incluir(3);
        lista2.incluir(4);

        lista.exibir();
        lista2.exibir();
        System.out.println("Resultado da comparação: " +lista.compareTo(lista2));
        System.out.println("Tmanho da lista: " + lista.getTamanho());
        System.out.println("Tamanho da lista 2 : " + lista2.getTamanho());
        System.out.println();

        // teste 3
        System.out.println("Buscar elemento por porsição: ");
        System.out.println("Elemento na posição 0: " + lista.get(0));
        System.out.println("Elemento na posição 2 : " + lista.get(2));

        // teste 4
        System.out.println("\nRetorna a posição do elemento: ");
        System.out.println("Posição do elemento 5: " + lista.getPosElemento(5));
        System.out.println("Posição do elemento 15: " + lista.getPosElemento(15));
        //System.out.println(lista.getPosElemento(70)); elemento não existe na lista

        // Teste 5
        System.out.println("\nLimpar lista");
        // lista.limpar();
        // System.out.println(lista.getTamanho());

        //teste 6
        System.out.println("\nVerificar se elemento existe na lisita: ");
        lista.exibir();
        //  System.out.println("Contem o elemto 30 ? " + lista.contem(30)); não existe na lista
        System.out.println("Contem o elemento 5? " + lista.contem(5));
        System.out.println("Contem o elemento 15? " + lista.contem(15));

        // Teste 7
        System.out.println("\nRemover elementos em determinada posição");
        lista.remover(0);
        lista.exibir();
        System.out.println("Tamanho da lista : " + lista.getTamanho());

    }
}
