package design.flyweight;

/**
 * 外部状态UnSharedConcrete
 * 非共享享元类
 * @ClassName: Coordinate 
 * @Description:
 * @author renzy 
 * @date 2017年3月2日 下午4:03:17 
 *
 */
public class Coordinate {
	private int x,y;

	public Coordinate() {
		super();
	}

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
