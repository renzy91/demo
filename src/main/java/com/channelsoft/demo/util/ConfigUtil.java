package com.channelsoft.demo.util;


import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
	public final static String DATABASE="redis.database";
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
}
