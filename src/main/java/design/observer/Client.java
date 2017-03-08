package design.observer;

public class Client {
	public static void main(String[] args) {
		//目标对象
		ConcreteSubject subject = new ConcreteSubject();
		
		//创建多个观察者
		ObserverA o1 = new ObserverA();
		ObserverA o2 = new ObserverA();
		ObserverA o3 = new ObserverA();
		//将观察者添加至subject对象的观察者
		subject.register(o1);
		subject.register(o2);
		subject.register(o3);
		//改变subject状态
		subject.setState(3000);
		
		System.out.println(o1.getMyState());
		System.out.println(o2.getMyState());
		System.out.println(o3.getMyState());
	}
}
