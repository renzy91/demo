package design.bridge;

/**
 * 品牌接口
 * @ClassName: Brand 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午2:29:52 
 *
 */
public interface Brand {
	void create();
}

/**
 * 联想
 * @ClassName: Lenovo 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午3:34:00 
 *
 */
class Lenovo implements Brand {
	@Override
	public void create() {
		System.out.println("联想品牌");
	}
}

/**
 * DELL
 * @ClassName: Dell 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午3:34:06 
 *
 */
class Dell implements Brand {
	@Override
	public void create() {
		System.out.println("DELL品牌");
	}
}