import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 19, 2016 3:08:43 PM 
 * @version 1.0 
 *
 */

public class Construct {
	public static void main(String[] args){
//		Constructor[] cons = Console.class.getConstructors();
//		for(Constructor cor:cons)
//			System.out.println(cor);
		Calendar calendar = Calendar.getInstance();
		String addtablename = String.format("log_%d_%d", calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1);
		String ps = "create table if not exists %s("
				+ "   `logindex` bigint(20) NOT NULL,"
				+ "   `askip` varchar(32) DEFAULT NULL,"
				+ "   `servername` varchar(32) DEFAULT NULL,"
				+ "   `askLog` text,"
				+ "   `recievelog` mediumtext,"
				+ "   `asktime` datetime NOT NULL,"
				+ "   `token_id` varchar(100) DEFAULT NULL,"
				+ "   `user_id` varchar(100) DEFAULT NULL,"
				+ "   `dev_plat` varchar(100) DEFAULT NULL,"
				+ "   `dev_ver` varchar(100) DEFAULT NULL,"
				+ "   `dev_no` varchar(100) DEFAULT NULL,"
				+ "   `dev_model` varchar(100) DEFAULT NULL,"
				+ "   `soft_ver` varchar(100) DEFAULT NULL,"
				+ "   `push_id` varchar(100) DEFAULT NULL,"
				+ "   `ip_addr` varchar(100) DEFAULT NULL,"
				+ "   `askKey` varchar(100) DEFAULT NULL,"
				+ "   `ret_code` int(11) DEFAULT NULL,"
				+ "   `ret_msg` varchar(100) DEFAULT NULL,"
				+ "   PRIMARY KEY (`logindex`,`asktime`),"
				+ "   KEY `askKey` (`askKey`),"
				+ "   KEY `user_id` (`user_id`),"
				+ "   KEY `ret_code` (`ret_code`),"
				+ "   KEY `servername` (`servername`)"
				+ " ) ENGINE=MyISAM DEFAULT CHARSET=utf8"
				+ " PARTITION BY RANGE (to_days(asktime))"
				+ " (";
//				+ " PARTITION p1 VALUES IN (1) ENGINE = MyISAM,"
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.DAY_OF_MONTH, 1);
		int curMon = cl.get(Calendar.MONTH);
		boolean first = true;
		while (curMon == cl.get(Calendar.MONTH)) {
			int cnt = Integer.valueOf(DateFormatUtils.format(cl, "dd"));
			if (first)
				first = false;
			else
				ps += ",";
			ps += " PARTITION p" + cnt + " VALUES LESS THAN (TO_DAYS('"
					+ DateFormatUtils.format(cl, "yyyy-MM-dd") + "')) ENGINE = MyISAM";
			cl.add(Calendar.DATE, 1);
		}
		ps += " )";
		String sql = String.format(ps, addtablename);
		System.out.println(sql);
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jygl", "root", "mysql");
			DatabaseMetaData dmd = conn.getMetaData();
			ResultSet rs = dmd.getTables(null, null, addtablename, null);
			rs.next();
			System.out.println(rs.isFirst());
			System.out.println(rs.isLast());
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
