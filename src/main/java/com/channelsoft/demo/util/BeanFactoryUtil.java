package com.channelsoft.demo.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * <dl>
 * <dt>BeanFactoryUtil</dt>
 * <dd>Description:bean加载对象</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * </dl>
 * 
 */
public class BeanFactoryUtil implements ServletContextListener {
	private static Log logger = LogFactory.getLog(BeanFactoryUtil.class);
	private static ApplicationContext context;

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent event) {
		logger.info("初始化BeanFactory....");
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		logger.info("初始化BeanFactory....OK.");
	}
	
	/**
	 * 获取Spring中的Bean
	 * 
	 * @param beanName
	 *            Bean的名称
	 * @return 如果成功则反回Bean对象，如果失败则抛出异常.
	 */
	public static Object getBean(String beanName) throws Exception {
		if (context == null) {
			logger.warn("ApplicationContext 没有初始化！您无法获得业务处理对象，系统无法正常运行");
			throw new Exception("ApplicationContext 没有初始化！您无法获得业务处理对象，系统无法正常运行");
		}
		try {
			return context.getBean(beanName);
		} catch (BeansException exp) {
			logger.error("读取[" + beanName + "]失败！", exp);
			throw new Exception("读取[" + beanName + "]失败！", exp);
		}
	}
}
