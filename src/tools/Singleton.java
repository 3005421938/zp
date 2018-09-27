package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Singleton
{
	/**
	 * 全局唯一的：属性配置文件
	 */
	private static Properties properties;
	
	private Singleton() {
		properties = new Properties();
		String path = "info.properties";
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		try {
			properties.load(is);
		} catch (IOException e) {
			System.out.println("加载配置文件错误："+e);
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				System.out.println("关闭流异常："+e);
			}
		}
	}
	
	private static class SingletonHelper{
		private static final Singleton INSTANCE = new Singleton();
	}
	
	// 获取实例
	public static Singleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	// 文件属性
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
