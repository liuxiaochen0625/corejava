/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 19, 2016 3:08:04 PM 
 * @version 1.0 
 *
 */
package database.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import database.model.DataBean;

public class Mysql {
	public static void main(String []args){
		DataBean dataBean = new DataBean();
		dataBean.setUser("root");
		dataBean.setPassword("mysql");
		dataBean.setIP("localhost");
		dataBean.setPort(3306);
		dataBean.setDatabase("jygl");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dataBean.getUrl(), dataBean.getUser(), dataBean.getPassword());
			String sql = "select * from jygl";
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
