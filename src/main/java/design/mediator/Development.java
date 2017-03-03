package design.mediator;

/**
 * 科研部
 * @ClassName: Development 
 * @Description: 
 * @author renzy 
 * @date 2017年3月3日 上午10:07:41 
 *
 */
public class Development implements Department{
	
	private Mediator m; //持有中介者(总经理)的引用
	
	public Development(Mediator m) {
		super();
		this.m = m;
		m.register("development", this);
	}

	@Override
	public void selfAction() {
		System.out.println("专心科研");
	}

	@Override
	public void outAction(String dname) {
		System.out.println("科研部汇报工作");
		m.commend(dname);
	}

}
