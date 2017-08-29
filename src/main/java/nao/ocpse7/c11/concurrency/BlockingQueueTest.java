package nao.ocpse7.c11.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Request {}

class Client implements Runnable {
    private BlockingQueue<Request> queue;

    Client(BlockingQueue<Request> queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            try {
                System.out.println(Thread.currentThread().getName() + " - Put in queue...");
                queue.put(new Request());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Server implements Runnable {
    BlockingQueue<Request> queue;

    public Server(BlockingQueue<Request> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " - Take from queue: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BlockingQueueTest {

    public static void test() {
        BlockingQueue<Request> queue = new ArrayBlockingQueue<>(3);

        Client client = new Client(queue);
        Server server = new Server(queue);

        new Thread(client).start();
        new Thread(server).start();
    }

}
