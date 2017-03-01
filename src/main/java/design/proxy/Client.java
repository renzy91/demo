package design.proxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		Star star = new StarImpl();
		StarHandler starHandler = new StarHandler(star);
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, starHandler);
		proxy.sing();
	}
}
