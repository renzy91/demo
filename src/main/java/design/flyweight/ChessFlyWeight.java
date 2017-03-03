package design.flyweight;

/**
 * 享元类
 * @ClassName: ChessFlyWeight 
 * @Description:
 * @author renzy 
 * @date 2017年3月2日 下午4:04:39 
 *
 */
public interface ChessFlyWeight {
	void setColor(String color);
	String getColor();
	void display(Coordinate coordinate);
}


