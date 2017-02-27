package design.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试5种单例模式执行效率
 * @ClassName: Client3 
 * @Description: TODO
 * @author renzy 
 * @date 2017年2月27日 下午3:56:06 
 *
 */
public class Client3 {
	public static void main(String[] args) throws Exception {
		int threadNum = 100;
		//CountDownLatch 在完成一组正在其他线程中执行的操作前 它允许一个或多个线程一直等待
		final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < threadNum; i++) {

			new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 1000000; j++) {
						Object instance = Singleton1.getInstance();
					}
					//每个线程执行完 countDownLatch 减一
					countDownLatch.countDown();
				}
			}).start();
		}
		
		//等待所有线程执行完 再执行main函数
		countDownLatch.await();
		
		long end = System.currentTimeMillis();
		System.out.println("总用时："+(end - start));
	}
}
