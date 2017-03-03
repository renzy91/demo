package design.mediator;

/**
 * 同事类接口
 * @ClassName: Department 
 * @Description: TODO
 * @author renzy 
 * @date 2017年3月3日 上午10:02:05 
 *
 */
public interface Department {
	void selfAction();//做本部门的事情
	void outAction(String dname);//向总经理发出申请
}
