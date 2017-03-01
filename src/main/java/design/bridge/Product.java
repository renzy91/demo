package design.bridge;

/**
 * 抽象产品类
 * @ClassName: Product 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午3:33:12 
 *
 */
public abstract class Product {
	private Brand brand;
	public Product(Brand brand) {
		this.brand = brand;
	}
	public void create() {
		brand.create();
	}
}

/**
 * 电脑
 * @ClassName: Computer 
 * @Description: TODO
 * @author renzy 
 * @date 2017年3月1日 下午3:33:31 
 *
 */
class Computer extends Product{
	public Computer(Brand brand) {
		super(brand);
	}
	@Override
	public void create() {
		super.create();
		System.out.println("电脑");
	}
}

/**
 * 手机
 * @ClassName: Phone 
 * @Description: TODO
 * @author renzy 
 * @date 2017年3月1日 下午3:33:45 
 *
 */
class Phone extends Product{
	public Phone(Brand brand) {
		super(brand);
	}
	@Override
	public void create() {
		super.create();
		System.out.println("手机");
	}
}
