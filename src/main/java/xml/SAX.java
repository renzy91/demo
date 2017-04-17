package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * SAX解析DOM文档
 * @ClassName: SAX 
 * @author renzy 
 * @date 2017年3月31日 下午4:54:25 
 *
 */
public class SAX {
	public static void main(String[] args) throws Exception {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		MyHandler handler = new MyHandler();
		saxParser.parse(new File("src/main/java/xml/student.xml"), handler);
		List<Student> list = handler.getList();
		System.out.println(list);
	}
}

class MyHandler extends DefaultHandler {
	private Student student=null;
	private List<Student> list = new ArrayList<Student>();
	private String qName = null;
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("name".equals(qName)) {
			student.setName(new String(ch, start, length));
		}
		if("age".equals(qName)) {
			student.setAge(new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if("student".equals(qName)) {
			list.add(student);
		}
		this.qName = "";
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if("students".equals(qName)) {
			return ;
		}
		if("student".equals(qName)) {
			student = new Student();
			student.setId(attributes.getValue("id"));
		}
		this.qName = qName;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}
}
