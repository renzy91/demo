package design.state;

/**
 * 预订状态
 * @ClassName: FreeState 
 * @Description: 
 * @author renzy 
 * @date 2017年3月6日 下午2:45:56 
 *
 */
public class BookedState implements State{

	@Override
	public void handle() {
		System.out.println("房间已预订");
	}

}
