package design.singleton;

import java.lang.reflect.Constructor;

/**
 * 反射方式破坏单利模式
 *    解决方法，构造函数加判断条件 @Singleton1 示例
 *    enum是原始jvm实现，不存在反射、反序列化漏洞
 * @ClassName: Client1
 * @Description: TODO
 * @author renzy 
 * @date 2017年2月27日 下午3:15:55 
 *
 */
public class Client1 {
	public static void main(String[] args) {
		try {
			Class<Singleton1> sl1 = (Class<Singleton1>) Class.forName("design.singleton.Singleton1");
			
			Constructor<Singleton1> c = sl1.getDeclaredConstructor();
			c.setAccessible(true);
			
			Singleton1 s1 = c.newInstance();
			Singleton1 s2 = c.newInstance();
			
			System.out.println(s1);
			System.out.println(s2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
