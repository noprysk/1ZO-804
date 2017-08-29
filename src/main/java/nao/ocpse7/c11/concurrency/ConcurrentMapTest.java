package nao.ocpse7.c11.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapTest {

    private static final ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();

    static {
        map.put(1, "test 1");
        map.put(2, "test 2");
        map.put(3, "test 3");
        map.put(4, "test 4");
        map.put(5, "test 5");
    }

    public static void replaceItem(int key, String value) {
        map.replace(key, value);
    }

    public static void test() {
        replaceItem(3, "test 333");
        replaceItem(1, "test 111");

        System.out.println(map);
    }
}
