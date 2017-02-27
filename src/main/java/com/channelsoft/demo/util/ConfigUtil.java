package com.channelsoft.demo.util;


import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;


public class ConfigUtil {
	private static Logger log = LoggerFactory.getLogger(ConfigUtil.class);
	private static Properties properties = null;
	public final static String REDIS_IP="redis.ip";
	public final static String REDIS_PORT = "redis.port";
	public final static String REDIS_PASSWORD = "redis.password";
	public final static String REDIS_MAX_ACTIVE = "redis.pool.maxActive";
	public final static String REDIS_MAX_IDLE = "redis.pool.maxIdle";
	public final static String REDIS_MAX_WAIT = "redis.pool.maxWait";
	public final static String REDIS_TEST_ON_BORROW = "redis.pool.testOnBorrow";
	public final static String REDIS_TEST_ON_RETURN = "redis.pool.testOnReturn";
	public final static String APP_KEY="appkey";
	public final static String WEB_URL="web.url";
	public final static String CHAT_TOPIC="chat.topic";
	public final static String TOPIC="topic";
	static {
		loadProperties();
	}

	private static void loadProperties() {
		InputStream istream = null;
		try {
			istream = ConfigUtil.class.getResourceAsStream("/config.properties");
			properties = new Properties();
			properties.load(istream);
		} catch (Exception e) {
			log.error("读取属性文件[config.properties]失败.", e);
			return;
		} finally {
			if (istream != null) {
				try {
					istream.close();
				} catch (Exception ignore) {
				}
			}
		}
	}

	public static void reloadProperties() {
		loadProperties();
	}

	private ConfigUtil() {
	}

	public static String getString(String key) {
		return properties.getProperty(key);
	}

	public static String getString(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public static int getInt(String key) {
		return Integer.parseInt(getString(key));
	}

	public static int getInt(String key, int defaultValue) {
		return Integer.parseInt(getString(key, String.valueOf(defaultValue)));
	}

	public static long getLong(String key, long defaultValue) {
		return Long.parseLong(getString(key, String.valueOf(defaultValue)));
	}

	public static Date getDate(String key, Date defaultValue) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return df.parse(getString(key));
		} catch (ParseException e) {
			return defaultValue;
		} catch (NullPointerException e) {
			return defaultValue;
		}
	}
	/**
	 * 
	 * TODO(作用).登录红云接口参数 <br/>
	 * @author lixl
	 * @return
	 * @since JDK 1.6
	 * CreateDate: 2016-12-26
	 */
	public static String loginParamter(){
		Map<String, Object> mapParamter=new HashMap<String, Object>();
		mapParamter.put("cmd_name","butelUserLogin");
		Map<String, String> argParamter=new HashMap<>();
		mapParamter.put("parameter", argParamter);
		String uid=UUID.randomUUID().toString();
		String cmd_id=UUID.randomUUID().toString();
		argParamter.put("uid",uid);
		argParamter.put("appkey",ConfigUtil.getString(ConfigUtil.APP_KEY));
		argParamter.put("nickname","systemManager");
		argParamter.put("nube","");
		argParamter.put("token","");
		argParamter.put("user_type","0");
		argParamter.put("extra_info","");
		argParamter.put("cmd_id",cmd_id);
		return JSON.toJSONString(mapParamter);
	}
	/**
	 * 
	 * TODO(作用). 关注聊天主题接口参数<br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.6
	 * CreateDate: 2016-12-26
	 */
	public static String followChatTopic(){
		Map<String, Object> mapParamter=new HashMap<String, Object>();
		mapParamter.put("cmd_name","butelFollowTopic");
		Map<String, Object> argParamter=new HashMap<>();
		mapParamter.put("parameter", argParamter);
		String cmd_id=UUID.randomUUID().toString();
		argParamter.put("cmd_id",cmd_id);
		argParamter.put("flow_limited",true);
		argParamter.put("subscribe_flag",false);
		argParamter.put("cache_msg_num","10");
		argParamter.put("topic_id",ConfigUtil.getString(ConfigUtil.CHAT_TOPIC));
		return JSON.toJSONString(mapParamter);
	}
	/**
	 * 
	 * TODO(作用). 关注主播主题接口参数<br/>
	 * @author lixl
	 * @return
	 * @since JDK 1.6
	 * CreateDate: 2016-12-26
	 */
	public  static String followAnchorTopic(){
		Map<String, Object> mapParamter=new HashMap<String, Object>();
		mapParamter.put("cmd_name","butelFollowTopic");
		Map<String, Object> argParamter=new HashMap<>();
		mapParamter.put("parameter", argParamter);
		String cmd_id=UUID.randomUUID().toString();
		argParamter.put("cmd_id",cmd_id);
		argParamter.put("flow_limited",false);
		argParamter.put("subscribe_flag",false);
		argParamter.put("cache_msg_num","0");
		argParamter.put("topic_id",ConfigUtil.getString(ConfigUtil.TOPIC));
		
		return JSON.toJSONString(mapParamter);
	}
	/**
	 * 
	 * TODO(作用). 获取topn接口参数<br/>
	 * @author Administrator
	 * @return
	 * @since JDK 1.6
	 * CreateDate: 2016-12-26
	 */
	public static String getTopN(){
		Map<String, Object> mapParamter=new HashMap<String, Object>();
		mapParamter.put("cmd_name","butelGetTopN");
		Map<String, String> argParamter=new HashMap<>();
		mapParamter.put("parameter", argParamter);
		String cmd_id=UUID.randomUUID().toString();
		argParamter.put("cmd_id",cmd_id);
		argParamter.put("topic_id",ConfigUtil.getString(ConfigUtil.CHAT_TOPIC));
		return JSON.toJSONString(mapParamter);
	}
	/**
	 * 
	 * TODO(作用). 获取消息接口参数<br/>
	 * @author lixl
	 * @return
	 * @since JDK 1.6
	 * CreateDate: 2016-12-26
	 */
	public  static String getMsg(){
		Map<String, Object> mapParamter=new HashMap<String, Object>();
		mapParamter.put("cmd_name","butelGetMsg");
		Map<String, String> argParamter=new HashMap<>();
		mapParamter.put("parameter", argParamter);
		String cmd_id=UUID.randomUUID().toString();
		argParamter.put("cmd_id",cmd_id);
		argParamter.put("localLatestMsgTime","0");
		return JSON.toJSONString(mapParamter);
	}
	/**
	 * 
	 * TODO(作用).登出接口参数 <br/>
	 * @author lixl
	 * @return
	 * @since JDK 1.6
	 * CreateDate: 2016-12-27
	 */
	public static String getLogout(){
		Map<String, Object> mapParamter=new HashMap<String, Object>();
		mapParamter.put("cmd_name","butelUserLogout");
		Map<String, String> argParamter=new HashMap<>();
		mapParamter.put("parameter", argParamter);
		String cmd_id=UUID.randomUUID().toString();
		argParamter.put("cmd_id",cmd_id);
		return JSON.toJSONString(mapParamter);
	}
}
