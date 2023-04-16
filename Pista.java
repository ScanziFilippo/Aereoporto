import java.util.concurrent.Semaphore;
public class Pista
{
    String nome;
    Semaphore semaforo = new Semaphore(0);
    public Pista(String nome)
    {
        this.nome = nome;
        semaforo.release();
    }
    public boolean richiediPista(){
        if(semaforo.availablePermits() >= 1){
            semaforo.tryAcquire();
            return true;
        }else{
            return false;
        }
    }
    public void liberaPista(){
        semaforo.release();
    }
}