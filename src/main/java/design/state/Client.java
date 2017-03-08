package design.state;

/**
 * 状态模式
 * @ClassName: Client 
 * @Description:
 * @author renzy 
 * @date 2017年3月6日 下午2:52:02 
 *
 */
public class Client {
	public static void main(String[] args) {
		Context context = new Context();
		context.setState(new FreeState());
	}
}
