/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 18, 2015 3:14:42 PM 
 * @version 1.0 
 *
 */
package util;

import java.io.FileInputStream;
import java.io.InputStream;
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
	    rwb = Workbook.getWorkbook(stream);
	    Sheet sheet = rwb.getSheet(0);
	    for(int i=0; i<sheet.getRows(); i++){
	    	String[] str = new String[sheet.getColumns()];
	    	for(int j=0; j<sheet.getColumns(); j++){
	    		cell = sheet.getCell(j,i);    
	    	    str[j] = cell.getContents();
	    	}
	    	list.add(str);
	    }
	    for(int i=0;i<list.size();i++){
	        String[] str = (String[])list.get(i);
	        for(int j=0;j<str.length;j++){
	        	System.out.print(str[j]+"\t");
	        }
	        System.out.println();
	    }
	}

}
