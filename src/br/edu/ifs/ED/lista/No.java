package br.edu.ifs.ED.lista;

public class No<T>{

    public T dado;
    public No<T> proximo;

    public No(T elemento){
        this.dado = elemento;
        this.proximo = null;

    }
}
