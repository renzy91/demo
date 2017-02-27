package design.singleton;

/**
 * 双重检测所 单例模式
 * 由于编译器优化原因和jvm底层内部模型原因，偶尔出错
 * 不建议使用
 * @ClassName: Singleton3 
 * @Description:
 * @author renzy 
 * @date 2017年2月27日 上午10:23:08 
 * 
 */
public class Singleton3 {
	private static Singleton3 instance;
	
	public static Singleton3 getInstance() {
		if(instance == null) {
			Singleton3 sl;
			synchronized (Singleton3.class) {
				sl = instance;
				if (sl == null) {
					synchronized (Singleton3.class) {
						if (sl == null) {
							sl = new Singleton3();
						}
					}
					instance=sl;
				}
			}
		}
		return instance;
	}
	
	private Singleton3() {}
	
}
