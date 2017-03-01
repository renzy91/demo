package design.bridge;

/**
 * 桥接模式
 * 解决多层继承问题，后期扩展方便
 * @ClassName: Client 
 * @Description:
 * @author renzy 
 * @date 2017年3月1日 下午3:32:24 
 *
 */
public class Client {
	public static void main(String[] args) {
		Brand brand = new Lenovo();
		Product product = new Computer(brand);
		product.create();
	}
}
