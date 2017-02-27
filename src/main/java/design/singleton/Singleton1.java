package design.singleton;

import java.io.Serializable;

/**
 * 饿汉式单例模式
 * 调用效率高,不能延时加载
 * @ClassName: Singleton1 
 * @Description: 
 * @author renzy 
 * @date 2017年2月24日 下午4:54:15 
 *
 */
public class Singleton1 implements Serializable{
	private static Singleton1 instance = new Singleton1();

	private Singleton1() {
		//防止反射漏洞破解
		if (instance != null) {
			throw new RuntimeException("防止反射漏洞");
		}
	}
	
	public static Singleton1 getInstance() {
		return instance;
	}
	
	/**
	 * 此方法可以防止反序列化方式破坏单利模式
	 * @Title: readResolve
	 * @Description: 
	 * @param @return
	 * @return Object
	 * @throws
	 */
	private Object readResolve() {
		return instance;
	}
	
}
