package learn.test;

public class HashCodeTest {
    public static void main(String[] args) {
        /*Object object = new Object();
        System.out.println(object.hashCode());

        int[] arr0 = new int[3];
        int[] arr1 = new int[3];
        System.out.println(arr0.hashCode());  // 触发arr0计算identity hash code
        System.out.println(arr1.hashCode()); // 触发arr1计算identity hash code

        // 试着交换下面两行
        System.out.println(arr1);
        System.out.println(arr0);*/

        String first = "first";
        String second = "second";

        Thread thread1 = new Thread(()->{
            synchronized (first) {
                System.out.println(Thread.currentThread().getName() + "get first");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (second) {
                    System.out.println(Thread.currentThread().getName() + "get second");
                }
            }

        });
        Thread thread2 = new Thread(()->{
            synchronized (second) {
                System.out.println(Thread.currentThread().getName() + "get second");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (first) {
                    System.out.println(Thread.currentThread().getName() + "get first");
                }
            }

        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
