package design.decorator;

public class Client {
	public static void main(String[] args) {
		ICar car = new Car();
		
		SuperCar flyCar = new FlyCar(car);
		
		flyCar.move();
		
	}
}
