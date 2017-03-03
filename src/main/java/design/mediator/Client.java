package design.mediator;

/**
 * 中介者模式
 * @ClassName: Client 
 * @Description: TODO
 * @author renzy 
 * @date 2017年3月3日 上午11:22:42 
 *
 */
public class Client {
	public static void main(String[] args) {
		Mediator m = new President();
		
		Department development = new Development(m);
		Department finacial = new Finacial(m);
		
		development.selfAction();
		
		development.outAction("finacial");
		
	}
}
