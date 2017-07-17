package jiandan_zhuceji;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Client {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost post = new HttpPost("http://www.jd100.com/service/user/");
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("do", "existname"));  
        formparams.add(new BasicNameValuePair("un", "werewsdw"));
		UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
        post.setEntity(urlEncodedFormEntity);
        CloseableHttpResponse execute = httpClient.execute(post);
        
        HeaderIterator it = execute.headerIterator();
        while (it.hasNext()) {
			Header nextHeader = it.nextHeader();
			System.out.println(nextHeader.getName()+"---"+nextHeader.getValue());
			
		}
        
        System.out.println("===================================");
        
        HttpEntity entity = execute.getEntity();
		System.out.println("---------------------------");
		System.out.println(entity);
		System.out.println("===========================");
		String str = EntityUtils.toString(entity,"unicode");
		System.out.println(str);
        
	}
}
