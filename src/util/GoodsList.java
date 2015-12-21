/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 18, 2015 3:14:42 PM 
 * @version 1.0 
 *
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;





public class GoodsList {
	public static void main(String []args) throws Exception{
		List<Object> list = new ArrayList<Object>();
		Workbook rwb = null;
	    Cell cell = null;
	    InputStream stream = new FileInputStream("E:\\goodsList.xls");
	    PrintStream writer = new PrintStream(new File("product_id.txt"));
	    System.setOut(writer);
	    rwb = Workbook.getWorkbook(stream);
	    Sheet sheet = rwb.getSheet(0);
	    String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "root", "mysql");
		Statement sta = conn.createStatement();
	    for(int i=0; i<sheet.getRows(); i++){
	    	String[] str = new String[sheet.getColumns()];
	    	for(int j=0; j<sheet.getColumns(); j++){
	    		cell = sheet.getCell(j,i);    
	    	    str[j] = cell.getContents();
	    	}
	    	list.add(str);
	    }
	    for(int i=1;i<list.size();i++){
	        String[] str = (String[])list.get(i);
	        String sql = "insert into i_product values("+str[0];
	        for(int j=1;j<52;j++){
	        	sql = sql + ",'"+str[j]+"'";
	        }
	        sql = sql + ")";
	        try{
	        	sta.execute(sql);
	        }catch(Exception e){
	        	writer.println(str[0]);
	        	e.printStackTrace();
	        }
	    }
	    sta.close();
	    conn.close();
	}
}
