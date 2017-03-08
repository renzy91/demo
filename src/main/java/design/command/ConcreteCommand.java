package design.command;

/**
 * 具体命令类
 * @ClassName: ConcreteCommand 
 * @Description: 
 * @author renzy 
 * @date 2017年3月6日 上午10:05:44 
 *
 */
public class ConcreteCommand implements Command{
	private Receiver receiver;//命令执行者

	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void excute() {
		//命令真正执行前后，执行相关的处理
		receiver.action();
	}
	
	
}
