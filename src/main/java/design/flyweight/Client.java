package design.flyweight;

/**
 * 享元模式
 * 节约内存，时间换空间
 * @ClassName: Client 
 * @Description:
 * @author renzy 
 * @date 2017年3月2日 下午4:23:54 
 *
 */
public class Client {
	public static void main(String[] args) {
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("Black");
		System.out.println(chess1);
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("Black");
		System.out.println(chess2);
		
		System.out.println("增加外部状态处理");
		chess1.display(new Coordinate(10, 10));
		chess2.display(new Coordinate(10, 20));
	}
}
