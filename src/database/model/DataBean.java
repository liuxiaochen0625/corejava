/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 19, 2016 3:06:41 PM 
 * @version 1.0 
 *
 */
package database.model;

public class DataBean {
	private String user;
	private String password;
	private String IP;
	private int port;
	private String database;
	
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return "jdbc:mysql://"+IP+":"+port+"/"+database;
	}
	
}
