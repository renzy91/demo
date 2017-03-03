package design.decorator;

/**
 * 具体装饰角色
 * @ClassName: SwinCar 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午5:57:34 
 *
 */
public class SwinCar extends SuperCar {

	public SwinCar(ICar car) {
		super(car);
	}
	
	public void swin() {
		System.out.println("车在水里游");
	}

	@Override
	public void move() {
		super.move();
		swin();
	}
	
	

}
