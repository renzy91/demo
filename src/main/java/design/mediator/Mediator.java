package design.mediator;

/**
 * 中介者类接口
 * @ClassName: Mediator 
 * @Description: 
 * @author renzy 
 * @date 2017年3月3日 上午11:23:08 
 *
 */
public interface Mediator {
	void register(String dname,Department d);
	void commend(String dname);
}
