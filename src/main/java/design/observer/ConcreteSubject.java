package design.observer;

public class ConcreteSubject extends Subject{
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		//主题对象(目标对象)值发生变化通知所有观察者
		this.notifyAllObservers();
	}
	
}
