package design.decorator;

/**
 * 真实(具体)构件
 * @ClassName: Car 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午5:57:34 
 *
 */
public class Car implements ICar {

	@Override
	public void move() {
		System.out.println("车在跑");
	}

}
