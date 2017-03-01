package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * star的代理
 * @ClassName: StarHandler 
 * @Description: TODO
 * @author renzy 
 * @date 2017年3月1日 上午11:37:52 
 *
 */
public class StarHandler implements InvocationHandler{
	private Star star;
	public StarHandler(Star star) {
		super();
		this.star = star;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("进入代理类");
		Object invoke = method.invoke(star, args);
		return invoke;
	}
	
}
