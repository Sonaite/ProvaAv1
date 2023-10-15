package br.edu.ifs.ED.lista;

public abstract class Lista < T extends  Comparable<T>> implements Comparable<Lista< T>> {

    protected No<T> primeiro;

    public void incluir(T elemento) throws Exception{

    }

    public abstract void remover(int posicao) throws Exception;

    public abstract int getTamanho();

    public abstract boolean contem(T elemento) throws Exception;

    public abstract T[] TransformarEmVetor();
}
