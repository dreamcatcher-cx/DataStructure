package concurrent;

/**
 * Created by chengxiao on 2016/12/13.
 */
public class ThreadLocalTest {
    private static SuperMarket market = new SuperMarket();
    public static ThreadLocal<SuperMarket> marketContext = new ThreadLocal<SuperMarket>() {
        @Override
        protected SuperMarket initialValue() {
            return market;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    SuperMarket market = ThreadLocalTest.marketContext.get();
                    for (int i = 0; i < 1000; i++) {
                        try {
                            market.sale();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ",当前count=" + market.productCount);
                }
            }.start();
        }
        while(Thread.activeCount()>2){
            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println("最终结果："+market.productCount);
        }
    }

class SuperMarket {
    int productCount = 10000;

    public void sale() throws InterruptedException {
        if (productCount > 0) {
            Thread.sleep(400);
            productCount--;
        }
    }
}