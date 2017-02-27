package design.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 反序列化方式破坏单利模式
 * 	     解决方法，readResolve()  @Singleton1 示例
 * 	  enum是原始jvm实现，不存在反射、反序列化漏洞
 * @ClassName: Client2 
 * @Description: TODO
 * @author renzy 
 * @date 2017年2月27日 下午3:30:10 
 *
 */
public class Client2 {
	public static void main(String[] args) throws Exception {
		//对象序列化写入文件
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
		Singleton1 s1 = Singleton1.getInstance();
		oos.writeObject(s1);
		oos.close();
		
		//读取文件中对象
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
		Singleton1 s2 = (Singleton1) ois.readObject();
		ois.close();
		
		//打印s1、s2，其为两个对象
		System.out.println(s1);
		System.out.println(s2);
		
	}
}
