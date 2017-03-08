package design.strategy;

/**
 * 策略模式
 * @ClassName: Client 
 * @Description: 
 * @author renzy 
 * @date 2017年3月6日 上午10:47:42 
 */
public class Client {
	public static void main(String[] args) {
		NewCustomerManyStrategy newCustomerManyStrategy = new NewCustomerManyStrategy();
		Context context = new Context(newCustomerManyStrategy);
		context.pringPrice(998D);
	}
}
