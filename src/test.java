import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;








public class test {

	public static void main(String[] args) throws IOException, ParseException, SQLException, ClassNotFoundException {
//		String s = "ok";
//		StringBuilder sBuilder = new StringBuilder(s);
//		System.out.println(s.hashCode()+" "+sBuilder.hashCode());
//		String t = new String("ok");
//		StringBuilder tb = new StringBuilder(t);
//		System.out.println(t.hashCode()+" "+tb.hashCode());
//		//写文件
//		ArrayList<String> list = new ArrayList<String>();
//		for(int i=0;i<365000;i++)
//			list.add(String.valueOf(i));
//		File file = new File("E:\\test.txt");
//		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
//		for(String i:list)
//			bufferedWriter.write(i+"\r\n");
//		bufferedWriter.close();
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar c1 = Calendar.getInstance();
//		Calendar c2 = Calendar.getInstance();
//		c1.setTime(dateFormat.parse("2015-07-29 23:59:59"));
//		c2.setTime(new Date());
//		if(c1.before(c2))
//			System.out.println("Yes");
//		else
//			System.out.println("No");
//		
//		c1.setTime(dateFormat.parse("2015-08-04 15:51:40"));
//		c2.setTime(dateFormat.parse("2015-08-04 15:51:41"));
//		System.out.println(c2.getTime().getTime()-c1.getTimeInMillis());
//		System.out.println();
//		
//		System.out.println(String.format("%02d", 2));
//		String string = " and p.product_type_path like '0,"+2+",%'";
//		System.out.println(string);
//		
//		String string2 = "http://www.dada360.com/103836.html";
//		String string3 = "";
//		//System.out.println(string2);
//		if(string2.matches("http://www\\.dada360\\.com/[\\d]+\\.html")){
//			string3 = string2.replaceFirst("http://www.dada360.com/", "");
//			string3 = string3.replaceFirst("\\.html", "");
//		}
//		System.out.println(string3);
//		System.out.println(string2);
		
//		String time1 = "2015-07-05";
//		String time2 = "2015-09-01";
//		Calendar calendar1 = Calendar.getInstance();
//		Calendar calendar2 = Calendar.getInstance();
//		calendar1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(time1));
//		calendar2.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(time2));
//		int year = calendar1.get(Calendar.YEAR);
//		int month1 = calendar1.get(Calendar.MONTH);
//		int month2 = calendar2.get(Calendar.MONTH);
//		System.out.println(year);
//		System.out.println(month1);
//		System.out.println(month2);
//		calendar1.set(Calendar.YEAR, year);
//		calendar1.set(Calendar.MONTH, 7);
//		System.out.println(calendar1.getTime());
//		
//		System.out.println(calendar1.get(Calendar.DAY_OF_WEEK));
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-M-d");
//		System.out.println(dateFormat.format(calendar.getTime()));
//		calendar.set(Calendar.DAY_OF_MONTH, 1);
//		calendar.add(Calendar.MONTH, -1);
//		System.out.println(dateFormat.format(calendar.getTime()));
//		while(true){
//			int month1 = calendar.get(Calendar.MONTH);
//			calendar.add(Calendar.DAY_OF_YEAR, 1);
//			int month2 = calendar.get(Calendar.MONTH);
//			if(month1 != month2){
//				calendar.add(Calendar.DAY_OF_YEAR, -1);
//				break;
//			}
//		}
//		System.out.println(dateFormat.format(calendar.getTime()));
		
		
//		Calendar calendar = Calendar.getInstance();
//		System.out.println(calendar.getFirstDayOfWeek());
//		System.out.println(dateFormat.format(calendar.getTime()));
//		
//		int day_of_week1 = calendar.get(Calendar.WEEK_OF_YEAR)-1;
//		while(true){
//			calendar.add(Calendar.DAY_OF_YEAR, -1);
//			int day_of_week2 = calendar.get(Calendar.WEEK_OF_YEAR);
//			if((day_of_week1 == day_of_week2) && (calendar.get(Calendar.DAY_OF_WEEK) == 7))
//				System.out.println(dateFormat.format(calendar.getTime()));
//			if((day_of_week1 == day_of_week2) && (calendar.get(Calendar.DAY_OF_WEEK) == 1)){
//				System.out.println(dateFormat.format(calendar.getTime()));
//				break;
//			}
//		}
//		
		
		
//		Calendar calendar = Calendar.getInstance();
//        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
//        calendar.setTime(dateFormat.parse("2015-01-16"));
//        calendar.set(Calendar.DAY_OF_WEEK,calendar.getFirstDayOfWeek());
//        calendar.add(Calendar.DAY_OF_YEAR, -2);
//        System.out.println(dateFormat.format(calendar.getTime()));
//        calendar.add(Calendar.DAY_OF_YEAR, -6);
//        System.out.println(dateFormat.format(calendar.getTime()));
//		File file = new File("E:\\sql_.txt");
//		BufferedReader reader = null;
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/jygl";
//		try {
//			Class.forName(driver);
//			Connection conn = DriverManager.getConnection(url, "root", "mysql");
//			
//			Calendar calendar = Calendar.getInstance();
//			
//			String sql1 = "SELECT amount from jygl WHERE query_date BETWEEN '2015-09-05 00:00:00' and '2015-09-05 23:59:59'";
//			String sql2 = "SELECT amount from jygl WHERE query_date BETWEEN '2015-09-06 00:00:00' and '2015-09-06 23:59:59'";
//			//String sql3 = "update jygl set amount_by_delivery_time = where query_date BETWEEN '2015-09-02 00:00:00' and '2015-09-02 23:59:59'";
//			
//			Statement sta = conn.createStatement();
//			ResultSet rs1;
//			ResultSet rs2;
//			rs1 = sta.executeQuery(sql1);
//			rs1.next();
//			String amount1 = rs1.getString(1);
//			rs2 = sta.executeQuery(sql2);
//			rs2.next();
//			String amount2 = rs2.getString(1);
//			System.out.println(amount1);
//			System.out.println(amount2);
//			System.out.println(Double.parseDouble(amount1)+Double.parseDouble(amount2));
//			String amount = String.format("%.2f", Double.parseDouble(amount1)+Double.parseDouble(amount2));
//			String sql3 = "update jygl set amount = "+amount+"where query_date BETWEEN '2015-09-06 00:00:00' and '2015-09-06 23:59:59'";
//			sta.executeUpdate(sql3);
//			String sql = "update jygl set page_view=?,user_view=? ,transform_rate=? where query_date between ? and ?";
//			PreparedStatement psm = conn.prepareStatement(sql);
//			String string;
//			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
//			while((string = reader.readLine())!=null){
//				String []str = string.split("	");
//				Date date = dateFormat2.parse(str[0]);
//				psm.setInt(1, Integer.parseInt(str[1]));
//				psm.setInt(2, Integer.parseInt(str[2]));
//				psm.setString(3, String.format("%.2f%%", 100*Double.parseDouble(str[3])/Double.parseDouble(str[2])));
//				psm.setString(4, dateFormat.format(date)+" 00:00:00");
//				psm.setString(5, dateFormat.format(date)+" 23:59:59");
//				psm.addBatch();
// 			}
//			psm.executeBatch();
//			//conn.commit();
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
////		Calendar calendar1 = Calendar.getInstance();
//		calendar1.setTime(dateFormat.parse("2015-08-27 14:59:59"));
//		Calendar calendar2 = Calendar.getInstance();
//		calendar2.setTime(new Date());
//		if(calendar1.before(calendar2))
//			System.out.println("true");
//		else
//			System.out.println("false");
		
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.setFirstDayOfWeek(Calendar.SATURDAY);;
//		calendar.setTime(dateFormat.parse("2015-08-31"));
//		int now_week = calendar.get(Calendar.WEEK_OF_YEAR);
//		calendar.add(Calendar.WEEK_OF_YEAR, -1);
//		int last_week = calendar.get(Calendar.WEEK_OF_YEAR);
//		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
//		System.out.println(now_week);
//		System.out.println(last_week);
//		System.out.println(dateFormat.format(calendar.getTime()));
//		calendar.add(Calendar.DAY_OF_WEEK, 6);
//		System.out.println(dateFormat.format(calendar.getTime()));
//		calendar.setTime(dateFormat.parse("2014-01-26"));
//		//System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
//		System.out.println(calendar.get(Calendar.MONTH));
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
//		System.out.println(dateFormat.format(calendar.getTime()));
//		calendar.set(Calendar.DAY_OF_MONTH, 1);
//		System.out.println(dateFormat.format(calendar.getTime()));
		
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/jygl";
//		Class.forName(driver);
//		Connection conn = DriverManager.getConnection(url, "root", "mysql");
//		Statement sta = conn.createStatement();
//		ResultSet rs1;
//		ResultSet rs2;
//		String sql1 = "SELECT amount_by_delivery_time from jygl WHERE query_date BETWEEN '2015-09-01 00:00:00' and '2015-09-01 23:59:59'";
//		String sql2 = "SELECT amount_by_delivery_time from jygl WHERE query_date BETWEEN '2015-09-02 00:00:00' and '2015-09-02 23:59:59'";
//		String sql3 = "update jygl set amount_by_delivery_time = where query_date BETWEEN '2015-09-02 00:00:00' and '2015-09-02 23:59:59'";
		
//		for(int i=0;i<12;i++){
//			Calendar calendar = Calendar.getInstance();
//			calendar.set(Calendar.YEAR, 2015);
//			calendar.set(Calendar.MONTH, i);
//			calendar.set(Calendar.DAY_OF_MONTH, 1);
//			while(calendar.get(Calendar.MONTH) == i){
//				String sql1 = "SELECT amount from jygl WHERE query_date BETWEEN '"
//			+dateFormat.format(calendar.getTime())+" 00:00:00' and '"+dateFormat.format(calendar.getTime())+" 23:59:59'";
//				rs1 = sta.executeQuery(sql1);
//				rs1.next();
//				String amount1 = rs1.getString(1);
//				calendar.add(Calendar.DAY_OF_YEAR, 1);
//				if(calendar.get(Calendar.MONTH) != i)
//					break;
//				String sql2 = "SELECT amount from jygl WHERE query_date BETWEEN '"
//						+dateFormat.format(calendar.getTime())+" 00:00:00' and '"+dateFormat.format(calendar.getTime())+" 23:59:59'";
//				rs2 = sta.executeQuery(sql2);
//				rs2.next();
//				String amount2 = rs2.getString(1);
//				
//				String amount = String.format("%.2f", Double.parseDouble(amount1)+Double.parseDouble(amount2));
//				String sql3 = "update jygl set amount = "+amount+"where query_date BETWEEN '"
//				+dateFormat.format(calendar.getTime())+" 00:00:00' and '"+dateFormat.format(calendar.getTime())+" 23:59:59'";
//				sta.executeUpdate(sql3);
//			}
//		}
		
		
//		String str = "1,2,3,4,";
//		System.out.println(str.substring(0, str.length()-1));
		
		
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://42.96.171.147:3366/ebao_shop";
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\file.txt",true)));
//		try{
//			Class.forName(driver);
//			Connection conn = DriverManager.getConnection(url,"get_data","shop20150708");
//			Statement sta = conn.createStatement();
//			ResultSet rs;
//			for(int i=8;i<9;i++){
//				Calendar calendar = Calendar.getInstance();
//				calendar.set(Calendar.YEAR, 2015);
//				calendar.set(Calendar.MONTH, i);
//				calendar.set(Calendar.DAY_OF_MONTH, 1);
//				while(calendar.get(Calendar.DAY_OF_MONTH) < 22){
//					String sql = "SELECT SUM(market_price*sale_num) FROM so_order_pay sp LEFT JOIN so_order so on sp.order_pay_id=so.order_pay_id LEFT JOIN so_order_item oi on oi.order_id = so.order_id  WHERE sp.pay_state = 2 AND sp.pay_time BETWEEN '"+dateFormat.format(calendar.getTime())+" 00:00:00'"+" and '"+dateFormat.format(calendar.getTime())+" 23:59:59'";
//					rs = sta.executeQuery(sql);
//					rs.next();
//					System.out.println(rs.getDouble(1));
//					out.write(dateFormat.format(calendar.getTime())+" 00:00:00 "+rs.getDouble(1)+"\r\n");
//					calendar.add(Calendar.DAY_OF_YEAR, 1);
//				}
//			}
//			out.flush();
//			out.close();
//			conn.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://42.96.167.36:3306/jygl";
//		BufferedReader reader = null;
//		try{
//			Class.forName(driver);
//			Connection conn = DriverManager.getConnection(url, "root", "mysql2015");
//			Statement sta = conn.createStatement();
//			ResultSet rs;
//			reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\file.txt"),"UTF-8"));
//			String str;
//			while((str = reader.readLine())!=null){
//				String []strs = str.split(" ");
//				String date = strs[0]+" "+strs[1];
//				double sell_profit = 0.0;
//				double profit_percent = 0.0;
//				String sql = "select amount_by_chargetime from jygl where query_date = '"+date+"'";
//				rs = sta.executeQuery(sql);
//				rs.next();
//				sell_profit = Double.parseDouble(rs.getString(1))-Double.parseDouble(strs[2]);
//				profit_percent = sell_profit/Double.parseDouble(rs.getString(1));
//				if(sell_profit>0){
//					String update = "update jygl set sell_profit = "+String.format("%.2f", sell_profit)+",profit_percent = '"+String.format("%.2f%%", profit_percent*100)+"' where query_date = '"+date+"'";
//					sta.executeUpdate(update);
//					//conn.commit();
//				}
//				System.out.println(date+" "+sell_profit+" "+profit_percent);
//			}
//			reader.close();
//			conn.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		Integer.valueOf("we");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2015);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
//		
//		
	}
}
