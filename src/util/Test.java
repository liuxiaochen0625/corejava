/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 1, 2016 9:41:13 AM 
 * @version 1.0 
 *
 */
package util;

import interfaces.JsonCastable;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.Person;

public class Test {
	public static void main(String[] args) {
        JsonUtil util = new JsonUtil();
        util.jsonCast.put(Date.class, new JsonCastable<Date>() {
            @Override
        	public String cast(Date o) {
                return null == o ? null : new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(o);
            }
        });
        Person person = new Person();
        String result = util.toJson(person);
        System.out.println(result);
    }
}
