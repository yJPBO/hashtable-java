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
        System.out.println("Hash =" + Math.abs(hash));
        return Math.abs(hash);
    }

    public void insere(String str) {
        int indice = hash(str);
        tabela[indice].addLast(str);
        System.out.println("Inserido " + str);
    }

    public boolean busca(String str) {
        LinkedList<String> pos = tabela[hash(str)];
        if (!pos.isEmpty()) {
            for(String i : pos) {
                if (i == str) {
                    System.out.println("Achei " + str);
                    return true;
                }
            }
        }
        System.out.println("Nao achei " + str);
        return false;
    }

    public void remove(String str) {
        if(busca(str)) {
            int indice = hash(str);
            for(String i : tabela[indice]) {
                if (i == str) {
                    tabela[indice].remove(i.indexOf(i));
                    System.out.println("Removido " + str);
                    return;
                }
            }
        }
    }
}
