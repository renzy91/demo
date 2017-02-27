package design.singleton;

/**
 * 静态内部类 单例模式 
 * 线程安全 懒加载 调用效率高 可以延时加载
 * @ClassName: Singleton4 
 * @Description: 
 * @author renzy 
 * @date 2017年2月27日 上午10:27:46 
 *
 */
public class Singleton4 {
	private static class SingletonClassInstance {
		private static final Singleton4 instance = new Singleton4();
	}
	
	public static Singleton4 getInstance() {
		return SingletonClassInstance.instance;
	}

	private Singleton4() {}
	
}
