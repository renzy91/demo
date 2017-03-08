package design.command;

/**
 * 命令调用者、发起者
 * @ClassName: Invoke 
 * @Description: TODO
 * @author renzy 
 * @date 2017年3月6日 上午9:54:27 
 *
 */
public class Invoke {
	private Command command; //也可以通过容器List<Command>容纳很多命令对象，进行批处理，数据库底层事务处理

	public Invoke(Command command) {
		super();
		this.command = command;
	}
	//业务方法，用于调用命令类的方法
	public void call() {
		command.excute();
	}
	
}
