package design.adapter;

/**
 * 适配器(对象方式实现  组合方式)
 * (client与adaptee的转接口)
 * @ClassName: Adapter 
 * @Description:
 * @author renzy 
 * @date 2017年3月1日 上午9:53:38 
 *
 */
public class Adapter2 implements Target{
	private Adaptee adaptee;
	
	public Adapter2(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public void handleRequest() {
		adaptee.request();
	}

}
