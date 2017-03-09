package design.prototype;

import java.util.Date;

/**
 * 实现原型模式关键：继承Cloneable接口，覆盖clone方法
 * 有浅复制与深复制之分
 * @ClassName: User 
 * @author renzy 
 * @date 2017年3月9日 下午5:07:54 
 *
 */
public class User implements Cloneable{
	private String name;
	private Integer age;
	private Date bir;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, Integer age, Date bir) {
		super();
		this.name = name;
		this.age = age;
		this.bir = bir;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBir() {
		return bir;
	}
	public void setBir(Date bir) {
		this.bir = bir;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		User user = (User) super.clone();
		/*
		 * 实现深复制的关键
		 * 去掉此代码为浅复制
		 */
		user.bir = (Date) this.bir.clone();
		
		return user;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", bir=" + bir.getTime() + "]";
	}
}
