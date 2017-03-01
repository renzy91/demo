package design.decorator;

/**
 * 抽象装饰角色
 * @ClassName: SuperCar 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午5:57:34 
 *
 */
public class SuperCar implements ICar {
	private ICar car;
	public SuperCar(ICar car) {
		this.car = car;
	}
	
	@Override
	public void move() {
		car.move();
	}

}
