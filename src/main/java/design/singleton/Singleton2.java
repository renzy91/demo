package design.singleton;
/**
 * 懒汉式单例模式
 * @ClassName: Singleton1 
 * @Description: 
 * @author renzy 
 * @date 2017年2月24日 下午4:54:15 
 *
 */
public class Singleton2 {
	private static Singleton2 instance;

	private Singleton2() {
	}
	
	public static synchronized Singleton2 getInstance(){
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
	
}
