import java.util.concurrent.Semaphore;
public class Pista
{
    String nome;
    Semaphore semaforo = new Semaphore(0);
    public Pista(String nome)
    {
        this.nome = nome;
        semaforo.release();
        System.out.println(semaforo.availablePermits());
    }
    public void richiediPista(){
        semaforo.tryAcquire();
    }
}
