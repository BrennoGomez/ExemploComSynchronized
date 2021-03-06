
/**
 * 
 * @author BRENO
 * Consumidor classe que representa o consumidor
 * idConsumidor referÍncia para o Buffer
 * totalConsumir contador que vai indicar quanto deve ser consumido pelo consumidor.
 */

public class Consumidor extends Thread {
    private int idConsumidor;
    private Buffer pilha;
    private int totalConsumir;
 
    public Consumidor(int id, Buffer p, int totalConsumir) {
        idConsumidor = id;
        pilha = p;
        this.totalConsumir = totalConsumir;
    }
 
    public void run() {
        for (int i = 0; i < totalConsumir; i++) {
            pilha.get(idConsumidor);
        }
        System.out.println("Consumidor #" + idConsumidor + " concluido!");
    }
}