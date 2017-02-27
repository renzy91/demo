package design.singleton;

/**
 * 枚举单例模式
 * 线程安全 调用效率高 不能延时加载
 * 可以防反射和反序列化漏洞
 * @ClassName: Singleton5 
 * @Description: TODO
 * @author renzy 
 * @date 2017年2月27日 下午1:49:32 
 *
 */
public enum Singleton5 {
	INSTANCE("red",1);
	
	private String name;
	private Integer value;
	
	private Singleton5(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
