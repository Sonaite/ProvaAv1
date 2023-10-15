package br.edu.ifs.ED.lista;

public class ListaSimplesEncadeada<T extends Comparable<T>> extends Lista<T>{

    private No<T> primeiro;
    private No<T> ultimo;
    int tamanho;

    public ListaSimplesEncadeada() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;

    }
    @Override
    public void incluir(T elemento) throws Exception {

        if (elemento == null) {
            throw new Exception("Elemento não pode ser null");
        }
        No<T> novoNo = new No(elemento);

        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        }
        tamanho++;
    }

    public T get(int posicao) throws Exception {
        if (posicao < 0 || posicao > tamanho) {
            throw new Exception("Posição solicitada não existe na lista");

        }
        No<T> atual = primeiro;
        int contador = 0;

        while (contador < posicao) {
            atual = atual.proximo;
            contador++;
        }
        return atual.dado;
    }
    public int getPosElemento(T elemento) throws Exception {
        No atual = primeiro;
        int posicao = 0;

        while (atual != null) {
            if (atual.dado.equals(elemento)) {
                return posicao;
            }
            atual = atual.proximo;
            posicao++;
        }
        throw new Exception("Elemento não localizado");
    }

    @Override
    public void remover(int posicao) throws Exception {

        if (tamanho == 0) {
            throw new Exception("A lista já está vazia , não é possível remover elementos");
        }

        if (posicao < 0 || posicao > tamanho) {
            throw new Exception("Posição inválida");
        }
        if (posicao == 0) {
            primeiro = primeiro.proximo;
            tamanho--;
            return;
        }
        No<T> anterior = null;
        No<T> atual = primeiro;
        int contador = 0;

        while (primeiro != null && contador < posicao) {
            anterior = atual;
            atual = atual.proximo;
            contador++;
        }
        anterior.proximo = atual.proximo;
        tamanho--;
    }
    @Override
    public int getTamanho() {
        return tamanho;
    }
    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }
    @Override
    public boolean contem(T elemento) throws Exception {
        No atual = primeiro;

        while (atual != null) {
            if (atual.dado.equals(elemento)) {
                return true;
            }
            atual = atual.proximo;
        }

        throw new Exception("Elemento não encontrado");
    }
    public void exibir(){
        No<T> atual = primeiro;
        while (atual != null){
            System.out.print(atual.dado);
            if (atual.proximo != null){
                System.out.print(" -> ");
            }
            atual = atual.proximo;
        }
        System.out.println();
    }

    @Override
    public int compareTo(Lista<T> outraLista) {

        No<T> atual1 = this.primeiro;
        No<T> atual2 = outraLista.primeiro;

        int tamanho1 = this.getTamanho();
        int tamanho2 = outraLista.getTamanho();

        if (tamanho1 < tamanho2) {
            return -1;
        } else if (tamanho1 > tamanho2) {
            return 1;

        }
        while (atual1 != null && atual2 != null) {
            int comparacao = atual1.dado.compareTo(atual2.dado);
            if (comparacao != 0) {
                return comparacao;
            }
            atual1 = atual1.proximo;
            atual2 = atual2.proximo;
        }

        return 0;
    }
    @Override
    public T[] TransformarEmVetor() {
        return  TransformarEmVetorRecursivo(primeiro , tamanho);

    }
    private T[] TransformarEmVetorRecursivo(No<T> atual , int tamanhoLista){
        if (atual == null){
            return (T[]) new Comparable[0];
        } else if (tamanhoLista == 1) {
            T [] vetor = (T[]) new Comparable[1];
            vetor[0] = atual.dado;
            return  vetor;
        }else {
            T[] vetorRestante = TransformarEmVetorRecursivo(atual.proximo, tamanhoLista-1);

            T [] vetorFinal = (T[]) new Comparable[tamanhoLista];
            vetorFinal[0] = atual.dado;

            // aqui faz a cópia dos elementos do vetorRestante para o vetorFinal a partir da posição 1
            System.arraycopy(vetorRestante , 0, vetorFinal, 1,  tamanhoLista-1);

            return  vetorFinal;
        }
    }

}
