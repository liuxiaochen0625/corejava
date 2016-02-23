/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 3:18:21 PM 
 * @version 1.0 
 *
 */
package design.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {
	private Vector<Connection> pool;
	private String url = "jdbc:mysql://localhost:3306/test";
	private String username = "root";
	private String password = "mysql";
	private String driverClassName = "com.mysql.jdbc.Driver";
	private int poolSize = 10;
	Connection conn = null;
	public ConnectionPool(){
		pool = new Vector<Connection>();
		for(int i=0;i<poolSize;i++){
			try {
				Class.forName(driverClassName);
				conn = DriverManager.getConnection(url, username, password);
				pool.add(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void release(){
		pool.add(conn);
	}
	
	public synchronized Connection getConnection(){
		if(pool.size()>0){
			Connection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		}else {
			return null;
		}
	}
}
