package design.memento;

/**
 * 备忘录模式
 * @ClassName: Client 
 * @Description:
 * @author renzy 
 * @date 2017年3月6日 下午5:04:36 
 *
 */
public class Client {
	public static void main(String[] args) {
		CareTaker careTaker = new CareTaker();
		
		Emp emp = new Emp("emp", 12, 1212D);
		System.out.println("第一次打印对象" +emp);
		
		//创建备份
		careTaker.setEmpMemento(emp.memento());
		
		emp.setAge(98);
		System.out.println("第二次打印对象" +emp);
		
		emp.recovery(careTaker.getEmpMemento());
		System.out.println("恢复后对象" +emp);
		
	}
}
