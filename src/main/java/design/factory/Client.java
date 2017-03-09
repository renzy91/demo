package design.factory;

/**
 * 工厂方法
 * @ClassName: BeanFactory 
 * @author renzy 
 * @date 2017年3月9日 下午4:13:52 
 *
 */
public class Client {
	public static void main(String[] args) {
		BeanFactory beanFactory = new BeanFactory();
		User user = (User) beanFactory.getBean("user");
		user.setId("789");
		user.setName("name");
		user.setAge(798);
		System.out.println(user);
	}
}
