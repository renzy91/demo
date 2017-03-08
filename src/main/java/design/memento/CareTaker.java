package design.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人类
 * 负责管理备忘录对象
 * @ClassName: CareTaker 
 * @Description:
 * @author renzy 
 * @date 2017年3月6日 下午4:54:50 
 *
 */
public class CareTaker {
	private EmpMemento empMemento;
	//可以储存多个备忘点
//	List<EmpMemento> list = new ArrayList<EmpMemento>();

	public EmpMemento getEmpMemento() {
		return empMemento;
	}

	public void setEmpMemento(EmpMemento empMemento) {
		this.empMemento = empMemento;
	}
}
