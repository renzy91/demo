package design.composite;

/**
 * 叶子节点，没有子节点
 * @ClassName: Leaf 
 * @Description: TODO 叶子节点也要实现add、remove方法是否不妥？？？？？
 * @author renzy 
 * @date 2017年3月1日 下午5:10:45 
 *
 */
public class Leaf extends Component{
	public Leaf(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {}

	@Override
	public void remove(Component component) {}

	@Override
	public void foreach() {
		System.out.println("叶子节点:"+this.name);
	}
	
	
}
