package design.observer2;

import java.util.Observable;

public class ConcreteSubject extends Observable{
	private int state;

	public void setState(int state) {
		this.state = state;
		//标识目标对象已经更改
		setChanged();
		//通知所有观察者
		notifyObservers(state);
	}

	public int getState() {
		return state;
	}
}
