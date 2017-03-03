package design.flyweight;

/**
 * 具体享元类
 * @ClassName: ConcreteChess 
 * @Description: 
 * @author renzy 
 * @date 2017年3月2日 下午4:10:19 
 *
 */
public class ConcreteChess implements ChessFlyWeight{
	private String color;
	
	public ConcreteChess(String color) {
		this.color = color;
	}

	public ConcreteChess() {
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void display(Coordinate coordinate) {
		System.out.println("棋子颜色:"+color);
		System.out.println("棋子位置:"+coordinate.getX()+" , "+coordinate.getY());
	}

}
