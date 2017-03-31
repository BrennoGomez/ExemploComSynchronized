/**
 * 
 * @author BRENO
 * Buffer classe que representa um Buffer a ser preenchido por itens pelo Produtor
 * Conteudo variavel que eh colocada pelo produtor
 * Disponivel booleano que indica quando o conteúdo esta disponivel.
 */

public class Buffer {
 
    private int conteudo;
    private boolean disponivel;
 
    /*
     * Através do método set o produtor coloca um produto em Conteudo, que carrega o
     * conteúdo e avisa para as outras thread que o produto está disponível.
     * Para dar acesso ao Consumidor, o Buffer oferece um método get, que devolve o
     * conteúdo e avisa para outras thread que o produto não está mais disponível.
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
     * No método get, o consumidor deve esperar enquanto não houver conteúdo disponível.
     * Quando o conteúdo estiver disponível novamente o consumidor consome o recurso e
     * notifica as outras threads que não há mais recurso disponivel.
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