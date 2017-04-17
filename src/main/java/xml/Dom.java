package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * DOM解析XML文档
 * @ClassName: Dom 
 * @author renzy 
 * @date 2017年3月31日 下午4:53:52 
 *
 */
public class Dom {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new File("src/main/java/xml/student.xml"));
		NodeList list = document.getElementsByTagName("student");
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
			String id = element.getAttribute("id");
			String name = element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
			String age = element.getElementsByTagName("age").item(0).getFirstChild().getNodeValue();
			System.out.println("id="+id+",name="+name+",age="+age);
		}
	}
}
