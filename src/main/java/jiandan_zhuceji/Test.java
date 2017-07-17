package jiandan_zhuceji;

import java.util.ArrayList;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Test {

	public static void main(String[] args) throws Exception {
		
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://www.jd100.com/service/user/");
		ArrayList<NameValuePair> data = new ArrayList<NameValuePair>();
				data.add(new BasicNameValuePair("do", "register"));
				data.add(new BasicNameValuePair("un", "werewsdw"));
				data.add(new BasicNameValuePair("pwd", "123123"));
				data.add(new BasicNameValuePair("grade", "高三"));
				data.add(new BasicNameValuePair("subject", ""));
				data.add(new BasicNameValuePair("email", "123123@qq.com"));
				data.add(new BasicNameValuePair("figure", "4"));
				data.add(new BasicNameValuePair("qq", ""));
				data.add(new BasicNameValuePair("treaty", "true"));
				data.add(new BasicNameValuePair("ic", ""));
				data.add(new BasicNameValuePair("forward", ""));
				data.add(new BasicNameValuePair("rurl", ""));
				data.add(new BasicNameValuePair("tgrade", ""));
				data.add(new BasicNameValuePair("realname", ""));
				data.add(new BasicNameValuePair("school", "北京市昌平区前锋学校"));
				data.add(new BasicNameValuePair("district", "北京"));
				data.add(new BasicNameValuePair("subdistrict", "昌平区"));
				data.add(new BasicNameValuePair("province", "北京"));
				data.add(new BasicNameValuePair("tel", ""));
				data.add(new BasicNameValuePair("mobile", "18328597069"));
				data.add(new BasicNameValuePair("detail", "1"));
				data.add(new BasicNameValuePair("gradetype", "0"));
		
		UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(data,"UTF-8");
		
		post.setEntity(urlEncodedFormEntity);
		post.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		
		CloseableHttpResponse resp = httpClient.execute(post);
		
		System.out.println(resp.getStatusLine());
		
		HeaderIterator it = resp.headerIterator();
		while (it.hasNext()) {
			Header nextHeader = it.nextHeader();
			System.out.println(nextHeader.getName()+"---"+nextHeader.getValue());
			if(nextHeader.getName().equals("Location")) {
				post.releaseConnection();
				HttpPost httpPost = new HttpPost(nextHeader.getValue());
				CloseableHttpResponse execute = httpClient.execute(httpPost);
				System.out.println("------"+execute.getStatusLine());
			}
		}
		
		HttpEntity entity = resp.getEntity();
		System.out.println("---------------------------");
		System.out.println(entity);
		System.out.println("===========================");
		String str = EntityUtils.toString(entity);
		System.out.println(str);
	}

}
