package design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * @ClassName: ChessFlyWeightFactory 
 * @Description: 
 * @author renzy 
 * @date 2017年3月2日 下午4:11:51 
 *
 */
public class ChessFlyWeightFactory {
	//享元池
	private static Map<String,ChessFlyWeight> map=new HashMap<String,ChessFlyWeight>();
	
	public static ChessFlyWeight getChess(String color) {
		if(map.get(color) != null) {
			return map.get(color);
		}else{
			ChessFlyWeight cfw = new ConcreteChess(color);
			map.put(color, cfw);
			return cfw;
		}
	}
	
}
