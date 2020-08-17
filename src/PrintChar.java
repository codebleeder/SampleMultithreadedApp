class PrintChar implements Runnable {
    private char aChar;
    private int count;
    public PrintChar(char aChar, int count){
        this.aChar = aChar;
        this.count = count;
    }
    @Override
    public void run(){
        for(int i=0; i<count; i++){
            System.out.println(aChar);
        }
    }
}