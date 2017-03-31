/**
 * 
 * @author BRENO
 * Produtor classe que representa o produtor
 * idProdutor identificador referência para um Buffer
 * producaoTotal variavel que vai indicar quanto deve ser produzido pelo produtor
 *
 */
public class Produtor extends Thread {
    private int idProdutor;
    private Buffer pilha;
    private int producaoTotal;
 
    public Produtor(int id, Buffer p, int producaoTotal) {
        idProdutor = id;
        pilha = p;
        this.producaoTotal = producaoTotal;
    }
 
    public void run() {
        for (int i = 0; i < producaoTotal; i++) {
            pilha.set(idProdutor, i);
        }
        System.out.println("Produtor #" + idProdutor + " concluido!");
    }
}