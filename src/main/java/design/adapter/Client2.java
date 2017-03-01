package design.adapter;

/**
 * 客户端
 * (相当于笔记本，要使用adaptee，但不适配)
 * @ClassName: Client 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 上午9:51:22 
 *
 */
public class Client2 {
	public void test1(Target target) {
		target.handleRequest();
	}
	
	public static void main(String[] args) {
		Client2 client = new Client2();
		Adaptee adaptee = new Adaptee();
		Target target = new Adapter2(adaptee);
		client.test1(target);
		
	}

}
