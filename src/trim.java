import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class trim {
	public static void main(String []args) throws ParseException{
		String str = " Hello World! ";
		System.out.println(str.length());
		System.out.println(str.trim().length());
		System.out.println(str.length());
		try{
			@SuppressWarnings("unused")
			int i = 3/0;
		}catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			
		}
		
		String string = new String[]{"1","2","3"}[1];
		System.out.println(string);
		int day = 0;
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2015-05-15");
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2015-07-18");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);
		while(c1.before(c2)){
			day++;
			c1.add(Calendar.DAY_OF_YEAR, 1);
		}
		System.out.println(day);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime()));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(c2.getTime()));
		
		
		System.out.println(String.format("%.2f%%",((double)3/7)*100));
		String date = "2015-12-41-01:00:00";
		String iSaid = "亲爱的，2014年4月25 15时36分21秒， 我会在世贸天阶向你求婚！等到2015年6月25日，我们就结婚。";

		// 匹配时间串
		String answer = matchDateString(iSaid);

		// 输出：
		// 问：请问我们什么时候结婚？
		// 答：2014年4月25 15时36分21秒
		System.out.println("问：请问我们什么时候结婚？");
		System.out.println("答：" + answer);
		
		String str3 = "[1-9][0-9]{0,3}-(0[1-9]{1}|1[0-2]{1})-(0[1-9]{1}|1[0-9]{1}|2[0-9]{1}|3[0-1]{1}))";//-(0[0-9]{1}|1[0-9]{1}|2[0-3]{1}):(0[0-9]{1}|[1-5]{1}[0-9]{1}):(0[0-9]{1}|[1-5]{1}[0-9]{1})";
		System.out.println(date.matches(str3));
	}
	
	/**
	 * (1)能匹配的年月日类型有：
	 *    2014年4月19日
	 *    2014年4月19号
	 *    2014-4-19
	 *    2014/4/19
	 *    2014.4.19
	 * (2)能匹配的时分秒类型有：
	 *    15:28:21
	 *    15:28
	 *    5:28 pm
	 *    15点28分21秒
	 *    15点28分
	 *    15点
	 * (3)能匹配的年月日时分秒类型有：
	 *    (1)和(2)的任意组合，二者中间可有任意多个空格
	 * 如果dateStr中有多个时间串存在，只会匹配第一个串，其他的串忽略
	 * @param text
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static String matchDateString(String dateStr) {
        try {
            List matches = null;
            Pattern p = Pattern.compile("(\\d{1,4}[-|\\/|年|\\.]\\d{1,2}[-|\\/|月|\\.]\\d{1,2}([日|号])?(\\s)*(\\d{1,2}([点|时])?((:)?\\d{1,2}(分)?((:)?\\d{1,2}(秒)?)?)?)?(\\s)*(PM|AM)?)", Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
            Matcher matcher = p.matcher(dateStr);
            if (matcher.find() && matcher.groupCount() >= 1) {
                matches = new ArrayList();
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    String temp = matcher.group(i);
                    matches.add(temp);
                }
            } else {
                matches = Collections.EMPTY_LIST;
            }           
            if (matches.size() > 0) {
                return ((String) matches.get(0)).trim();
            } else {
            }
        } catch (Exception e) {
            return "";
        }
        
		return dateStr;
    }
}
