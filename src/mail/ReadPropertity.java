/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 1, 2016 2:37:54 PM 
 * @version 1.0 
 *
 */
package mail;

import java.io.IOException;
import java.util.Properties;
public class ReadPropertity {
        static Properties props = new Properties();
        static {
                try {
                        props.load(ReadPropertity.class.getClassLoader().getResourceAsStream(
                                        "utils.properties"));
                } catch (IOException e1) {
                        e1.printStackTrace();
                }
        }
        public static String getProperty(String key) {
                return props.getProperty(key);
        }
}
