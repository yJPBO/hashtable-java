import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class HashTableTest {

    final HashTable tab = new HashTable(53);

    @Test // buscar um elemento que nunca foi inserido
    public void testBuscaNuncaInserido() {
        assertFalse(tab.busca("Ola mundo"));
        tab.insere("Ola mundo");
    }

    @Test // buscar um elemento que já foi inserido e removido
    public void testBuscaInseridoRemovido() {
        String s = "Ola mundo";
        tab.insere(s);
        tab.remove(s);
        assertFalse(tab.busca(s));
    }

    @Test // buscar um elemento existente que seja o primeiro da lista
    public void testPrimeiroLista() {
        String s = "ola mundo";
        tab.insere(s);
        assertTrue(tab.busca(s));
    }

    @Test // buscar um elemento existente que seja o último da lista e não seja o primeiro
    public void testUltimoLista() {
        // Strings tem o valor hash igual;
        String[] hashigual = {"6", "56", "163", "245", "299"};
        for (String i : hashigual) {
            tab.insere(i);
        }

        assertEquals(tab.getTabela()[1].getLast(), hashigual[hashigual.length-1]);
        assertTrue(tab.busca(hashigual[hashigual.length-1]));
    }

    @Test // remover todos os elementos de uma posição da tabela e voltar a inserir elementos novamente
    public void testRemoveTudoDepoisInsere() {
        // Strings tem o valor hash igual;
        String[] hashigual = {"6", "56", "163", "245", "299"};
        for (String i : hashigual) {
            tab.insere(i);
        }

        for (String i : hashigual) {
            tab.remove(i);
        }
        
        assertTrue(tab.tabelaVazia());
        
        tab.insere("6");
        tab.insere("56");
        assertTrue(tab.busca("6"));
        assertTrue(tab.busca("56"));
        
    }
}
