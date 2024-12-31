package org.example.itemEnhancement;

public class MultiThreadExam{
        private static final Object lock = new Object();

     static class Enhance extends Thread{
        public void run(){
            System.out.println("강화를 시작합니다");
            synchronized (lock){
                System.out.print("강화중");
                try {
                    for(int i=0; i<5; i++){
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    System.out.println();
                    lock.notify();
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
        }
    }

    static class EnhanceResult extends Thread{
         public int run(int weoponLevel, int probability){
             synchronized (lock){
                 int a = (int) (Math.random() * 100);
                 if(a>=probability){
                     try {
                         lock.wait();
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                     System.out.println("강화가 성공했습니다.");
                     weoponLevel++;
                     return weoponLevel;
                 }else {
                     try {
                         lock.wait();
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                     System.out.println("강화가 실패했습니다.");
                     weoponLevel--;
                     if(weoponLevel<0){
                         weoponLevel=0;
                     }
                     return weoponLevel;
                 }
             }
         }
    }

}
