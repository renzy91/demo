package design.decorator;

/**
 * 装饰模式
 * @ClassName: Client 
 * @Description: 
 * @author renzy 
 * @date 2017年3月2日 下午2:37:31 
 *
 */
public class Client {
	public static void main(String[] args) {
		ICar car = new Car();
		SuperCar flyCar = new FlyCar(car);
		flyCar.move();
		
		System.out.println("-------------------------------");
		SuperCar swin = new SwinCar(flyCar);
		swin.move();
		
	}
}
