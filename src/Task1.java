import java.util.ArrayDeque;
import java.util.Deque;

public class Task1 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(10);
        Thread thread1 = new Thread() {
            public void run() {
                double tmp;
                while (true) {
                    try {
                        Thread.sleep(100);
                        tmp = Math.random() * 100;
                        deque.addLast((int) tmp);
                        if (deque.size() > 10) {
                            deque.removeFirst();
                            System.out.println("удалено");
                        }
                        System.out.println(deque);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                double tmp;
                while (true) {
                    try {
                        Thread.sleep(100);
                        tmp = Math.random() * 10;
                        System.out.println((int)tmp);
                        if ((int)tmp == 5) {
                            deque.removeFirst();
                            System.out.println("удалено из за числа 5");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}


