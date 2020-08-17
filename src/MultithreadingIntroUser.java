import java.util.concurrent.*;
public class MultithreadingIntroUser {

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintNum(5, 500));
        Thread t2 = new Thread(new PrintChar('c', 400));
        t1.run();
        t2.run();
    }

}

