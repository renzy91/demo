package design.composite;

/**
 * 组合模式，适用于树形结构
 * @ClassName: Client 
 * @Description: 
 * @author renzy 
 * @date 2017年3月1日 下午5:10:23 
 *
 */
public class Client {
	public static void main(String[] args) {
		Component c1 = new Composite("文件夹1");
		Component l1 = new Leaf("文本文件1.txt");
		Component l2 = new Leaf("文本文件2.txt");
		Component l3 = new Leaf("文本文件3.txt");
		c1.add(l1);
		c1.add(l2);
		c1.add(l3);
		
		Component c2 = new Composite("文件夹2");
		Component l4 = new Leaf("视频文件1.txt");
		Component l5 = new Leaf("视频文件2.txt");
		Component l6 = new Leaf("视频文件3.txt");
		c2.add(l4);
		c2.add(l5);
		c2.add(l6);
		
		c1.add(c2);
		
		c1.foreach();
		
	}
}
