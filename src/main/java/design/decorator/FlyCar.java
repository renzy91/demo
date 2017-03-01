package design.decorator;

/**
 * 具体装饰角色
 * @ClassName: Car 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午5:57:34 
 *
 */
public class FlyCar extends SuperCar {

	public FlyCar(ICar car) {
		super(car);
	}
	
	public void fly() {
		System.out.println("车在飞");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
	
	

}
