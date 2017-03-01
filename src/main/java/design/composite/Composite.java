package design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器类，有子节点
 * @ClassName: Composite 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午4:59:59 
 *
 */
public class Composite extends Component {
	//子节点
	private List<Component> child = new ArrayList<Component>();
	
	public Composite(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		child.add(component);
	}

	@Override
	public void remove(Component component) {
		child.remove(component);
	}

	@Override
	public void foreach() {
		System.out.println("容器节点:"+this.name);
		for (Component component : child) {
			component.foreach();
		}
	}

}
