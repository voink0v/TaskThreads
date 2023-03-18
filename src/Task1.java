import java.util.concurrent.ArrayBlockingQueue;

public class Task1 {
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(10);
        Thread thread1 = new Thread(new Runnable() {

            public void run() {
                double tmp;
                while (true) {
                    try {
                        tmp = Math.random() * 100;
                        Thread.sleep(100);
                        queue.put((int) tmp);

                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            public void run() {
                double tmp;
                while (true) {
                    try {
                        Thread.sleep(100);
                        tmp = Math.random() * 10;
                        System.out.println((int)tmp);
                        if ((int)tmp == 5) {
                            queue.remove(0);
                            System.out.println("удалено из за числа 5");
                        }
                    } catch (InterruptedException e  ) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}


