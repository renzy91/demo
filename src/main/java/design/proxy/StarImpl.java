package design.proxy;

public class StarImpl implements Star{

	@Override
	public void sing() {
		System.out.println("真正的歌手唱歌");
	}

}
