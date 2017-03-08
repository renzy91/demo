package design.command;

/**
 * 命令模式
 * @ClassName: Client 
 * @Description:
 * @author renzy 
 * @date 2017年3月6日 上午9:59:44 
 *
 */
public class Client {
	public static void main(String[] args) {
		Command c = new ConcreteCommand(new Receiver());
		Invoke i = new Invoke(c);
		i.call();
	}
}
