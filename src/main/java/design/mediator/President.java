package design.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体中介者
 * @ClassName: President 
 * @Description: 
 * @author renzy 
 * @date 2017年3月3日 上午11:23:26 
 *
 */
public class President implements Mediator{
	
	private Map<String,Department> map = new HashMap<String,Department>();
	
	@Override
	public void register(String dname, Department d) {
		map.put(dname, d);
	}

	@Override
	public void commend(String dname) {
		map.get(dname).selfAction();
	}

}
