package thread;

public class Thread1 extends Thread {

    String str;

    public Thread1(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 10; i++) {
            System.out.println(str);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
