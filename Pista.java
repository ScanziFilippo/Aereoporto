import java.util.concurrent.Semaphore;
/**
 * <p>Classe per le piste</p>
 */
public class Pista
{
    String nome;
    Semaphore semaforo = new Semaphore(0);
    /**
     * <p>Rende disponbile il semaforo binario della pista</p>
     */
    public Pista(String nome)
    {
        this.nome = nome;
        semaforo.release();
    }
    /**
     * <p>Risponde alla richiesta di un aereo per la pista in modo affermativo o negativo, ed eventualmente occupando il semaforo</p>
     */
    public boolean richiediPista(){
        if(semaforo.availablePermits() >= 1){
            semaforo.tryAcquire();
            return true;
        }else{
            return false;
        }
    }
    /**
     * <p>Segna la pista liberata se un aereo lo annuncia liberando il semaforo</p>
     */
    public void liberaPista(){
        semaforo.release();
    }
}