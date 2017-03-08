package design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题对象
 * @ClassName: Subject 
 * @Description:
 * @author renzy 
 * @date 2017年3月6日 下午4:14:04 
 *
 */
public class Subject {
	protected List<Observer> list = new ArrayList<Observer>();
	
	public void register(Observer observer) {
		list.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		list.remove(observer);
	}
	
	//通知所有的观察者更新状态
	public void notifyAllObservers() {
		for (Observer observer : list) {
			observer.update(this);
		}
	}
	
}
