/**
 * 
 * @author BRENO
 * Buffer classe que representa um Buffer a ser preenchido por itens pelo Produtor
 * Conteudo variavel que eh colocada pelo produtor
 * Disponivel booleano que indica quando o conte�do esta disponivel.
 */

public class Buffer {
 
    private int conteudo;
    private boolean disponivel;
 
    /*
     * Atrav�s do m�todo set o produtor coloca um produto em Conteudo, que carrega o
     * conte�do e avisa para as outras thread que o produto est� dispon�vel.
     * Para dar acesso ao Consumidor, o Buffer oferece um m�todo get, que devolve o
     * conte�do e avisa para outras thread que o produto n�o est� mais dispon�vel.
     */
    
    public synchronized void set(int idProdutor, int valor) {
        while (disponivel == true) {
            try {
                System.out.println("Produtor #" + idProdutor + " esperando...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        conteudo = valor;
        System.out.println("Produtor #" + idProdutor + " colocou " + conteudo);
        disponivel = true;
        notifyAll();
    }
 
    /*
     * No m�todo get, o consumidor deve esperar enquanto n�o houver conte�do dispon�vel.
     * Quando o conte�do estiver dispon�vel novamente o consumidor consome o recurso e
     * notifica as outras threads que n�o h� mais recurso disponivel.
     */
    
    public synchronized int get(int idConsumidor) {
        while (disponivel == false) {
            try {
                System.out.println("Consumidor #" + idConsumidor + " esperado...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumidor #" + idConsumidor + " consumiu: " + conteudo);
        disponivel = false;
        notifyAll();
        return conteudo;
    }
}