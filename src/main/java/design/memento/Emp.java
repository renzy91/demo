package design.memento;

public class Emp {
	private String ename;
	private Integer age;
	private Double salary;
	
	//进行备忘操作，并返回备忘录对象
	public EmpMemento memento() {
		return new EmpMemento(this);
	}
	
	//进行数据恢复，恢复至指定备忘录对象的值
	public void recovery(EmpMemento empMemento) {
		this.ename=empMemento.getEname();
		this.age=empMemento.getAge();
		this.salary=empMemento.getSalary();
	}
	
	public Emp() {
		super();
	}
	public Emp(String ename, Integer age, Double salary) {
		super();
		this.ename = ename;
		this.age = age;
		this.salary = salary;
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

	@Override
	public String toString() {
		return "Emp [ename=" + ename + ", age=" + age + ", salary=" + salary + "]";
	}
	
}
