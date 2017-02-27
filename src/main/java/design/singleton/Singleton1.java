package design.singleton;

/**
 * 饿汉式单例模式
 * @ClassName: Singleton1 
 * @Description: 
 * @author renzy 
 * @date 2017年2月24日 下午4:54:15 
 *
 */
public class Singleton1 {
	private static Singleton1 instance = new Singleton1();

	private Singleton1() {
	}
	
	public static Singleton1 getInstance() {
		return instance;
	}
	
}
