package design.adapter;

/**
 * 适配器(类适配器方式  继承)
 * (client与adaptee的转接口)
 * @ClassName: Adapter 
 * @Description:
 * @author renzy 
 * @date 2017年3月1日 上午9:53:38 
 *
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handleRequest() {
		request();
	}

}
