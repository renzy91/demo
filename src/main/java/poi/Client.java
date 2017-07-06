package poi;

import java.util.ArrayList;
import java.util.Date;

import poi.ExcelUtil.ExcelVersion;

public class Client {
	public static void main(String[] args) {
		User u1 = new User(1, "", new Date(), null);
		User u2 = new User(2, "zhang2", new Date(), "email");
		User u3 = new User(3, "zhang3", new Date(), null);
		ArrayList<User> content = new ArrayList<User>();
		content.add(u1);
		content.add(u2);
		content.add(u3);
		
		try {
			ExcelUtil.writeToDisk("e:/example", "user", ExcelVersion.EXCEL2007U, null, User.class);
//			ExcelUtil.writeToDisk("e:/example", "user", ExcelVersion.EXCEL2003L, content, User.class);
//			ExcelUtil.writeToDisk("e:/example", "user", ExcelVersion.EXCEL2003L, new String[]{"ID","姓名","生日"},content, User.class);
//			ExcelUtil.writeToDiskSplit("e:/example", "user", ExcelVersion.EXCEL2003L, new String[]{"ID","姓名","生日"},content, User.class,2);
			/*InputStream inputStream = new FileInputStream(new File("e:/example/user.xlsx"));
			List<List<String>> list = ExcelUtil.readExcel(inputStream , "user.xlsx");
			for (List<String> l : list) {
				System.out.println(l);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 class User {
	 @ColumnName("ID")
	 private Integer id;
	 @ColumnName("姓名")
	 private String name;
	 @ColumnName("生日")
	 private Date bir;
	 private String email;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, Date bir, String email) {
		super();
		this.id = id;
		this.name = name;
		this.bir = bir;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBir() {
		return bir;
	}
	public void setBir(Date bir) {
		this.bir = bir;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bir=" + bir + ", email=" + email + "]";
	}
 }