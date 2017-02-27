package design.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BeanFactory {
	private Properties properties= new Properties();
	private void init(){
		try {
			properties.load(new FileInputStream("src/main/java/design/factory/factory.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BeanFactory() {
		init();
	}
	public Object getBean(String beanName){
		String property = properties.getProperty(beanName);
		try {
			Class<?> clazz = Class.forName(property);
			Object newInstance = clazz.newInstance();
			return newInstance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
