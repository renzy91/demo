package com.channelsoft.demo.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * <dl>
 * <dt>JedisPoolConfig</dt>
 * <dd>Description:jedis连接的配置信息获取</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * </dl>
 * 
 * @author lixianglin
 */
public class JedisFactory extends GenericObjectPoolConfig {
//	private static com.channelsoft.redis.JedisFactory config;
	private static JedisFactory config;
	private static JedisPool jedisPool ;
    protected static Log log = LogFactory.getLog(JedisFactory.class);
    public static String REDIS_IP;
    public static int REDIS_PORT;
    public static String REDIS_PASSWORD;
    public static int MAX_ACTIVE;
    public static int MAX_IDLE;
    public static long MAX_WAIT;
    public static boolean TEST_ON_BORROW;
    public static boolean TEST_ON_RETURN;

    static {
        initParam();
        initPool();
    }

    /**
     * 初始化连接池
     */
    private static void initPool() {
    	config=new JedisFactory();
//            config = new com.channelsoft.redis.JedisFactory();
            jedisPool =  new JedisPool(config, REDIS_IP,
                    REDIS_PORT, 10000,
                    REDIS_PASSWORD);
            log.debug("redis 单例pool初始化完毕...");
    }

    public static Jedis getJedis() {
            return jedisPool.getResource();
    }
    public static void returnJedis(Jedis jedis){
    	if(jedis == null){
            return;
        }
        jedis.close();
    }
    public JedisFactory() {
    	setTestWhileIdle(true);
    	setMinEvictableIdleTimeMillis(60000);
    	setTimeBetweenEvictionRunsMillis(30000);
    	setNumTestsPerEvictionRun(-1);
    	
		setMaxTotal(MAX_ACTIVE);
		setMaxIdle(MAX_IDLE);
		setMaxWaitMillis(MAX_WAIT);
		setTestOnBorrow(TEST_ON_BORROW);
		setTestOnReturn(TEST_ON_RETURN);
	}

    public static void initParam() {
        try {
        	REDIS_IP = ConfigUtil.getString(ConfigUtil.REDIS_IP);
        	REDIS_PORT = ConfigUtil.getInt(ConfigUtil.REDIS_PORT, 6379);
        	REDIS_PASSWORD = ConfigUtil.getString(ConfigUtil.REDIS_PASSWORD, "");
        	if(REDIS_PASSWORD!=null && REDIS_PASSWORD.isEmpty()){
        		REDIS_PASSWORD = null;
        	}
        	MAX_ACTIVE = ConfigUtil.getInt(ConfigUtil.REDIS_MAX_ACTIVE,600);
        	MAX_IDLE = ConfigUtil.getInt(ConfigUtil.REDIS_MAX_IDLE, 200);
        	MAX_WAIT = ConfigUtil.getInt(ConfigUtil.REDIS_MAX_WAIT, 1000);
        	TEST_ON_BORROW = Boolean.valueOf(ConfigUtil.getString(ConfigUtil.REDIS_TEST_ON_BORROW, "true"));
        	TEST_ON_RETURN = Boolean.valueOf(ConfigUtil.getString(ConfigUtil.REDIS_TEST_ON_RETURN, "true"));
        	log.debug("redis 参数初始化完毕...");
        } catch (Exception e) {
           log.error("redis 参数初始化失败"+e.getMessage(),e);
        }
    }
}