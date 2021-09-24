package leetcode.editor.cn;

import java.util.concurrent.CountDownLatch;

public class MultiProcesses {
    public static int a,b;
    public static int x,y;

    public static void main(String[] args) throws InterruptedException {
        for(long i=0; i<Long.MAX_VALUE;i++){

            x=0;
            y=0;
            a=0;
            b=0;
            CountDownLatch countDownLatch = new CountDownLatch(2);

            Thread AA = new Thread(()->{
                a = 1;
                x = b;
                countDownLatch.countDown();
            },"AA");

            Thread BB = new Thread(()->{
                b = 1;
                y = a;
                countDownLatch.countDown();
            },"BB");

            AA.start();
            BB.start();

            countDownLatch.await();  

           // countDownLatch.await();
          //  for(int j=0; j<10000000; j++){}
            if(x == 0 && y ==0){
                System.out.println("在第" + i + "次达到了 x = 0; y = 0");
                break;
            }

        }






    }


}
