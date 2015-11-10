import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;


public class Config {
	private volatile static Map<String, String> config;
	
	private static String getProperty(String key){
		if(config == null)
			init();
		return config.get(key);
	}
	
	public synchronized static void init(){
		if(config != null)
			return;
		String runtimePath = System.getProperty("user.dir");
		String filename = runtimePath + "\\config.txt";
		Properties properties = new Properties();
		try{
			InputStream inputStream = new FileInputStream(filename);
			properties.load(inputStream);
		}catch(Exception e){
			System.out.println("未找到配置文件");
			System.exit(0);
		}
		Map<String, String> map = new ConcurrentHashMap<String, String>();
		for(String propertyName:properties.stringPropertyNames()){
			if(propertyName.startsWith("#"))
				continue;
			map.put(propertyName, (String) properties.get(propertyName));
		}
		config = map;
		map = null;
	}
	
	public static void main(String []args){
		System.out.println(Config.getProperty("itemList"));
	}
}
