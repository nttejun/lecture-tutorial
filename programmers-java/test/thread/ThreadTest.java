package thread;

public class ThreadTest {
    public static void main(String[] args){
        Thread1 thread1 = new Thread1("1번 스레드");
        Thread1 thread2 = new Thread1("2번 스레드");

        thread1.start();
        thread2.start();

        System.out.println("스레드 스타드 호출완료");
    }
}
