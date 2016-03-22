/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 22, 2016 9:50:32 AM 
 * @version 1.0 
 *
 */
package redis;

import redis.clients.jedis.Jedis;

public class RedisJava {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.3.175",6379);
		jedis.auth("admin");
		System.out.println("Connection to server sucessfully");
	    System.out.println("Server is running: "+jedis.ping());
	}

}
