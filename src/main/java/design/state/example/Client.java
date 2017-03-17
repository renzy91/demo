package design.state.example;

/**
 * 上班时间状态
 * @ClassName: Client 
 * @author renzy 
 * @date 2017年3月17日 下午5:29:18 
 *
 */
public class Client {
	public static void main(String[] args) {
		WorkContext workContext = new WorkContext();
		workContext.setHour(21);
		workContext.setFinashed(false);
		workContext.handle();
	}
}
