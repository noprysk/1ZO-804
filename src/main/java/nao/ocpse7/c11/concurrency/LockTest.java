package nao.ocpse7.c11.concurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

class Rainbow {
    Lock lock = new ReentrantLock();

    static List<String> colors = new ArrayList<>();

    public void addColor(String color) {
        lock.lock();
        try {
            colors.add(color);
        } finally {
            lock.unlock();
        }
    }

    public List<String> getColors() {
        return colors;
    }
}

class Display implements Runnable {
    Map<Integer, String> colors;
    ReadWriteLock lock;

    public Display(Map<Integer, String> colors, ReadWriteLock lock) {
        this.colors = colors;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.readLock().lock();
        try {

            System.out.println("Display: " + colors.values());
        } finally {
            lock.readLock().unlock();
        }

    }
}

class ColorContainer implements Runnable {
    Map<Integer, String> colors;
    ReadWriteLock lock;

    public ColorContainer(Map<Integer, String> colors, ReadWriteLock lock) {
        this.colors = colors;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.writeLock().lock();
        try {
            System.out.println("Add colors...");
            colors.put(1, "red");
            colors.put(2, "blue");
            colors.put(3, "green");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            colors.put(4, "orange");
        } finally {
            lock.writeLock().unlock();
        }

    }
}

public class LockTest {

    public static void test() {
        Rainbow rainbow = new Rainbow();
        rainbow.addColor("red");
        rainbow.addColor("green");
        rainbow.addColor("black");
        System.out.println(rainbow.getColors());
    }

    public static void test2() {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Map<Integer, String> colors = new HashMap<>();

        Display display = new Display(colors, lock);
        ColorContainer container = new ColorContainer(colors, lock);

        new Thread(container).start();
        new Thread(display).start();
    }
}
