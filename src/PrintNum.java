public class PrintNum extends Thread {
    private int num;
    private int count;
    public PrintNum(int num, int count){
        this.num = num;
        this.count = count;
    }

    @Override
    public void run(){
        for(int i = 0; i < count; i++){
            System.out.println(num);
        }
    }
}