package design.template;

/**
 * 模板模式
 * @ClassName: Client 
 * @Description: TODO
 * @author renzy 
 * @date 2017年3月6日 上午11:02:04 
 *
 */
public class Client {
	public static void main(String[] args) {
		BankTemplateMethod b = new DrawMoney();
		b.process();
///////////////////////////////////////////
		BankTemplateMethod b2 = new BankTemplateMethod() {
			@Override
			public void transact() {
				System.out.println("存钱");
			}
		};
		
	}
}
