package ds.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProduceConsumerProblem {
    static AtomicInteger counter=new AtomicInteger();
  static   BlockingQueue<Integer> blockingQueue    =new ArrayBlockingQueue<>(5);
    public static void main(String[] args) {

        final Runnable producer=()->{
            while (true){
                try{
                   int value= counter.incrementAndGet();
                    System.out.print("Producer "+value);
                    blockingQueue.put(value);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };
        final Runnable consumer=()->{
            while (true){
                try {
                    System.out.print("\tConsumer" + blockingQueue.take());
                    System.out.println("");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                }
        };

       new Thread(producer).start();
        new Thread(consumer).start();

    }




}
