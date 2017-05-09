package weather;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.http.client.HttpClient;

public class HttpClientPool {
	private ThreadLocal<List<Cookie>> tl1 = null; 
	private ThreadLocal<HttpClient> tl2 = null;
	
	
}
