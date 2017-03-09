package design.prototype;

import java.util.Date;

/**
 * 原型模式
 * @ClassName: Client 
 * @author renzy 
 * @date 2017年3月9日 下午5:07:40 
 *
 */
public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date bir = new Date(123456789);
		User u1 = new User("zhang3", 12, bir);
		User u2 = (User) u1.clone();
		bir.setTime(456);
		
		System.out.println(u1);
		System.out.println(u2);
	}
}
