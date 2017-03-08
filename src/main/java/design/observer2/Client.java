package design.observer2;

/**
 * 给予java.util的观察者模式
 * @ClassName: Client 
 * @Description:
 * @author renzy 
 * @date 2017年3月6日 下午4:34:39 
 *
 */
public class Client {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		
		ObserverA o1 = new ObserverA();
		ObserverA o2 = new ObserverA();
		ObserverA o3 = new ObserverA();
		
		subject.addObserver(o1);
		subject.addObserver(o2);
		subject.addObserver(o3);
		
		subject.setState(123);
		
		System.out.println(o1.getMyState());
		System.out.println(o2.getMyState());
		System.out.println(o3.getMyState());
	}
}
