package weather;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TicketYL {
	private static CookieStore cookieStore = null;
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
						try {
							go();
						} catch (Exception e) {
							e.printStackTrace();
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}).start();
		}
		
	}
	
	public static void go() {
		String pid = "252739727";
		String sd = "252742006,%5e4,1";
		start();
		login();
		isLogin(pid);
		checkPayLimit(pid, sd);//完成
		quickBy(pid, sd);
		Map<String, String> querys = toOrderSure(pid, sd);
		if(querys != null && !querys.isEmpty()){
			saveNewOrder(querys, pid, sd);
		}
	}
	
	public static void saveNewOrder(Map<String,String> querys,String pid,String sd) {
		System.out.println("saveNewOrder.....................................");
		Map<String, String> headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		headers.put("Origin", "http://www.228.com.cn");
		headers.put("Referer", "http://www.228.com.cn/cart/toOrderSure.html?pid="+pid+"&sd="+sd+"&quickBuyType=-1");
		headers.put("Upgrade-Insecure-Requests", "1");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
		try {
	    	HttpClient httpClient = new DefaultHttpClient();
	    	URIBuilder uriBuilder = new URIBuilder("http://www.228.com.cn/saveNewOrder");
	    	for (Map.Entry<String, String> query : querys.entrySet()) {
				uriBuilder.addParameter(query.getKey(), query.getValue());
			}
			URI url = uriBuilder.build();
	    	HttpGet httpPost = new HttpGet(url);
	    	for (Map.Entry<String, String> header : headers.entrySet()) {
	    		httpPost.addHeader(header.getKey(), header.getValue());
			}
	    	((AbstractHttpClient) httpClient).setCookieStore(cookieStore);
			HttpResponse response = httpClient.execute(httpPost);
			String string = EntityUtils.toString(response.getEntity());
			System.out.println(string);
			System.out.println("saveNewOrder成功.....................................");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Map<String,String> toOrderSure(String pid,String sd) {
		System.out.println("toOrderSure.....................................");
		Map<String, String> headers = new HashMap<String,String>();
		headers.put("Referer", "http://www.228.com.cn/ticket-"+pid+".html");
	    headers.put("Upgrade-Insecure-Requests", "1");
	    headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
		try {
	    	HttpClient httpClient = new DefaultHttpClient();
	    	URI url = new URIBuilder("http://www.228.com.cn/cart/toOrderSure.html?pid="+pid+"&sd="+sd+"&quickBuyType=-1")
			    	.build();
	    	HttpGet httpPost = new HttpGet(url);
	    	for (Map.Entry<String, String> header : headers.entrySet()) {
	    		httpPost.addHeader(header.getKey(), header.getValue());
			}
	    	((AbstractHttpClient) httpClient).setCookieStore(cookieStore);
			HttpResponse response = httpClient.execute(httpPost);
			String string = EntityUtils.toString(response.getEntity());
//			string = string.substring(string.indexOf("<form id=\"orderForm\""));
//			string = string.substring(0, string.indexOf("</form>")+7);
//			System.out.println(string);
			
			//处理参数
			Map<String,String> querys=new HashMap<String,String>();
			Document doc = Jsoup.parse(string);
			Element form = doc.getElementById("orderForm");
			Elements inputs = form.getElementsByTag("input");
			for (Element element : inputs) {
//				System.out.println(element.attr("name")+"-----------"+element.attr("value"));
				querys.put(element.attr("name"), element.attr("value"));
			}
			querys.put("discountdetailid", "2217200");
			querys.put("o['payid']", "2217200");
			querys.put("o['unionname']", "baidu");
			String purchases = "[{\"cityid\":1,\"tickets\":\""+sd.substring(0, sd.lastIndexOf(","))+"\",\"shipment\":1,\"insurance\":0,\"cashno\":\"0\",\"renewal\":\"0.00\"}]";
			querys.put("o['purchases']", purchases);
			
			Element orderSource = doc.getElementById("orderSourceVal");
			querys.put("o['orderSource']", orderSource.attr("value"));
			
			querys.put("o['addressid']","11657535");
			
			cookieStore = ((AbstractHttpClient) httpClient).getCookieStore();
			System.out.println("toOrderSure成功.....................................");
			return querys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static void checkPayLimit(String pid,String sd){
		System.out.println("checkPayLimit.....................................");
		Map<String, String> headers = new HashMap<String,String>();
		headers.put("Accept", "*/*");
	    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	    headers.put("Origin", "http://www.228.com.cn");
	    headers.put("Referer", "http://www.228.com.cn/ticket-"+pid+".html");
	    headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.8 Safari/537.36");
	    headers.put("X-Requested-With", "XMLHttpRequest");
	    try {
	    	HttpClient httpClient = new DefaultHttpClient();
	    	URI url = new URIBuilder("http://www.228.com.cn/ajax/checkPayLimit")
			    	.addParameter("sd", sd).build();
	    	HttpPost httpPost = new HttpPost(url);
	    	for (Map.Entry<String, String> header : headers.entrySet()) {
	    		httpPost.addHeader(header.getKey(), header.getValue());
			}
	    	((AbstractHttpClient) httpClient).setCookieStore(cookieStore);
			HttpResponse response = httpClient.execute(httpPost);
			String string = EntityUtils.toString(response.getEntity());
//			string = new String(string.getBytes("UTF-8"),"GBK");
			System.out.println(string);
			if(string.contains("{\"status\":1}")) {
				System.out.println("checkPayLimit可以购买");
			}
			cookieStore = ((AbstractHttpClient) httpClient).getCookieStore();
			System.out.println("checkPayLimit成功.....................................");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void quickBy(String pid,String sd) {
		System.out.println("quickBy.....................................");
		Map<String, String> headers = new HashMap<String,String>();
		headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
	    headers.put("Accept-Encoding", "gzip, deflate, sdch");
	    headers.put("Accept-Language", "zh-CN,zh;q=0.8");
	    headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
	    try {
	    	HttpClient httpClient = new DefaultHttpClient();
	    	URI url = new URIBuilder("http://www.228.com.cn/cart/quickbuy")
			    	.addParameter("pid", pid)
			    	.addParameter("sd", sd).build();
	    	HttpGet httpGet = new HttpGet(url);
	    	for (Map.Entry<String, String> header : headers.entrySet()) {
	    		httpGet.addHeader(header.getKey(), header.getValue());
			}
	    	((AbstractHttpClient) httpClient).setCookieStore(cookieStore);
			HttpResponse response = httpClient.execute(httpGet);
			String string = EntityUtils.toString(response.getEntity());
//			string = new String(string.getBytes("GBK"), "UTF-8");
//			System.out.println(string);
			cookieStore = ((AbstractHttpClient) httpClient).getCookieStore();
			System.out.println("quickBy成功.....................................");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void isLogin(String pid) {
		System.out.println("isLogin.....................................");
		Map<String, String> headers = new HashMap<String,String>();
		headers.put("Accept", "*/*");
		headers.put("Referer", "http://www.228.com.cn/ticket-"+pid+".html");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.8 Safari/537.36");
		headers.put("X-Requested-With", "XMLHttpRequest");
		try {
	    	HttpClient httpClient = new DefaultHttpClient();
	    	URI url = new URIBuilder("http://www.228.com.cn/ajax/isLogin").build();
	    	HttpGet httpGet = new HttpGet(url);
	    	for (Map.Entry<String, String> header : headers.entrySet()) {
				httpGet.addHeader(header.getKey(), header.getValue());
			}
	    	((AbstractHttpClient) httpClient).setCookieStore(cookieStore);
			HttpResponse response = httpClient.execute(httpGet);
			String string = EntityUtils.toString(response.getEntity(),"UTF-8");
			System.out.println(string);
			cookieStore = ((AbstractHttpClient) httpClient).getCookieStore();
			System.out.println("isLogin成功.....................................");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void login(){
		System.out.println("登录.....................................");
		Map<String, String> headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded");
	    headers.put("Origin", "http://www.228.com.cn");
	    headers.put("Referer", "http://www.228.com.cn/auth/login?logout");
	    headers.put("Upgrade-Insecure-Requests", "1");
	    headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
		
		try {
			HttpClient httpClient = new DefaultHttpClient();
	    	URI url = new URIBuilder("http://www.228.com.cn/auth/login?logout")
			    	.addParameter("username", "18515007604")
			    	.addParameter("password", "ren18515007604").build();
	    	HttpPost httpPost = new HttpPost(url);
	    	for (Map.Entry<String, String> header : headers.entrySet()) {
				httpPost.addHeader(header.getKey(), header.getValue());
			}
	    	((AbstractHttpClient) httpClient).setCookieStore(cookieStore);
	    	HttpResponse response = httpClient.execute(httpPost);
	    	String string = EntityUtils.toString(response.getEntity());
//			System.out.println("..........."+string);
			cookieStore = ((AbstractHttpClient) httpClient).getCookieStore();
			System.out.println("登录成功.....................................");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void start(){
		System.out.println("start.....................................");
		Map<String, String> headers = new HashMap<String,String>();
		headers.put("Upgrade-Insecure-Requests", "1");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.8 Safari/537.36");
		try {
			HttpClient httpClient = new DefaultHttpClient();
	    	URI url = new URIBuilder("http://www.228.com.cn/auth/login?logout").build();
	    	HttpGet httpGet = new HttpGet(url);
	    	for (Map.Entry<String, String> header : headers.entrySet()) {
				httpGet.addHeader(header.getKey(), header.getValue());
			}
	    	HttpResponse response = httpClient.execute(httpGet);
	    	String string = EntityUtils.toString(response.getEntity());
//			System.out.println("..........."+string);
			cookieStore = ((AbstractHttpClient) httpClient).getCookieStore();
			System.out.println("start成功.....................................");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
