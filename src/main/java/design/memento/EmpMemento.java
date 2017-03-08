package design.memento;

/**
 * 备忘录类
 * @ClassName: EmpMemento 
 * @Description:
 * @author renzy 
 * @date 2017年3月6日 下午4:48:11 
 *
 */
public class EmpMemento {
	private String ename;
	private Integer age;
	private Double salary;
	public EmpMemento(Emp emp) {
		this.ename=emp.getEname();
		this.age=emp.getAge();
		this.salary=emp.getSalary();
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public EmpMemento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpMemento(String ename, Integer age, Double salary) {
		super();
		this.ename = ename;
		this.age = age;
		this.salary = salary;
	}
}
