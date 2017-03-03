package design.mediator;

/**
 * 财务部
 * @ClassName: Finacial 
 * @Description: 
 * @author renzy 
 * @date 2017年3月3日 上午10:06:49 
 *
 */
public class Finacial implements Department{
	
	private Mediator m; //持有中介者(总经理)的引用
	
	public Finacial(Mediator m) {
		super();
		this.m = m;
		m.register("finacial", this);
	}

	@Override
	public void selfAction() {
		System.out.println("专心数钱");
	}

	@Override
	public void outAction(String dname) {
		System.out.println("财务部汇报工作");
		m.commend(dname);
	}

}
