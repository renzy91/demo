package design.composite;

/**
 * 抽象构建：定义了叶子和容器构件的共同点
 * @ClassName: Component 
 * @Description:
 * @author renzy 
 * @date 2017年3月1日 下午4:57:16 
 *
 */
public abstract class Component {
	String name;

	public Component(String name) {
		this.name = name;
	}
	
	public abstract void add(Component component);
	public abstract void remove(Component component);
	public abstract void foreach();
}
