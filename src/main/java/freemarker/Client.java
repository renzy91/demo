package freemarker;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Client {
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();
//		String directory = "e:/freemarker/test1";
//		File file = new File(directory);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//		configuration.setDirectoryForTemplateLoading(file);
		configuration.setClassForTemplateLoading(Client.class, "");
		
		Template template = configuration.getTemplate("ftl/index.ftl");
		Map<String, Object> root = new HashMap<String, Object>();
		/*User user = new User();
		user.setId("1");
		user.setName("张三");
		user.setAge(60);
		user.setBir(new Date());*/
		List<Object> list = new ArrayList<>();
		list.add("星期一");
		list.add("星期二");
		list.add("星期三");
		list.add("星期四");
		list.add("星期五");
		root.put("list", list);
		
		FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/freemarker/index.html");
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		
		template.process(root, outputStreamWriter);
		outputStreamWriter.flush();
		outputStreamWriter.close();
		
		
	}
}
