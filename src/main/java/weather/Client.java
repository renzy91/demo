package weather;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

/**
 * 测试阿里天气接口
 * @ClassName: Client 
 * @Description: TODO
 * @author renzy 
 * @date 2017年2月28日 下午5:46:19 
 *
 */
public class Client {
	public static void main(String[] args) {
		String host = "http://jisutqybmf.market.alicloudapi.com";
	    String path = "/weather/query";
	    String method = "GET";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE 02e3dcbc5cf74df09b5150f20369e21a");
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("cityid", "1");
	    
	    try {
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	System.out.println(response.toString());
	    	
	    	String string = EntityUtils.toString(response.getEntity());
			System.out.println("..........."+string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
