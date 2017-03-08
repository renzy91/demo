package design.strategy;

/**
 * 管理算法
 * 负责和具体的策略类交互，具体算法和客户端调用分离
 * @ClassName: Context 
 * @Description: TODO
 * @author renzy 
 * @date 2017年3月6日 上午10:37:15 
 *
 */
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	
	public void pringPrice(Double s) {
		System.out.println("您该报价"+strategy.getPrice(s));
	}
	
}
