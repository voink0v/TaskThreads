public class Clock {


    public static void main(String[] args) throws InterruptedException {

        ConsoleClock cc = new ConsoleClock();
        cc.start();
        Thread.sleep(3000);
        cc.interrupt();

    }
}
