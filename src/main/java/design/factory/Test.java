package design.factory;

public class Test {
	public static void main(String[] args) {
		BeanFactory beanFactory = new BeanFactory();
		User user = (User) beanFactory.getBean("user");
		user.setId("789");
		user.setName("name");
		user.setAge(798);
		System.out.println(user);
	}
}
