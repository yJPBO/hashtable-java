import java.util.LinkedList;

public class HashTable {
    
    private LinkedList<String>[] tabela;
    private int tamanho;

    public HashTable(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<String>();
        }
    }

    private int hash(String str) {
        int hash = str.hashCode() % tamanho;
        return Math.abs(hash);
    }

    public void insere(String str) {
        int indice = hash(str);
        tabela[indice].addLast(str);
    }

    public boolean busca(String str) {
        LinkedList<String> pos = tabela[hash(str)];
        if (!pos.isEmpty()) {
            return pos.contains(str);
        }
        return false;
    }

    public void remove(String str) {
        if(busca(str)) {
            int indice = hash(str);
            for(String i : tabela[indice]) {
                if (i == str) {
                    tabela[indice].remove(i.indexOf(i));
                    return;
                }
            }
        }
    }

    public boolean tabelaVazia() {
        for(LinkedList<String> i : tabela) {
            if (!i.isEmpty()) return false;
        }
        return true;
    }

    public LinkedList<String>[] getTabela() {
        return tabela;
    }

    public int getTamanho() {
        return tamanho;
    }

    
}
