package mail;


import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * properties配置文件读取
 * @ClassName: ConfigUtil 
 * @author renzy 
 * @date 2017年4月27日 下午2:51:59 
 *
 */
public class ConfigUtil {
	private static Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
	//配置文件路径名称
	private static String CONFIG_FILE = "config.properties";
	
	private static Properties properties = null;
	static {
		loadProperties();
	}

	private static void loadProperties() {
		InputStream istream = null;
		try {
			istream = ConfigUtil.class.getResourceAsStream(CONFIG_FILE);
			properties = new Properties();
			properties.load(istream);
		} catch (Exception e) {
			logger.error("读取属性文件["+CONFIG_FILE+"]失败.", e);
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
		return properties.getProperty(key).trim();
	}

	public static String getString(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue).trim();
	}

	public static int getInt(String key) {
		return Integer.parseInt(getString(key).trim());
	}

	public static int getInt(String key, int defaultValue) {
		return Integer.parseInt(getString(key, String.valueOf(defaultValue)).trim());
	}

	public static long getLong(String key, long defaultValue) {
		return Long.parseLong(getString(key, String.valueOf(defaultValue)).trim());
	}

	public static Date getDate(String key, Date defaultValue) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return df.parse(getString(key).trim());
		} catch (ParseException e) {
			return defaultValue;
		} catch (NullPointerException e) {
			return defaultValue;
		}
	}

	public static Properties getProperties() {
		return properties;
	}

}
