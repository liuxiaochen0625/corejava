/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 28, 2016 3:56:55 PM 
 * @version 1.0 
 *
 */
package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import model.Person;

public class TestReflect {
	@SuppressWarnings("unchecked")
	public static void main(String []args) throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException{ 
		Class<Person> cls = Person.class;
		Person person = cls.newInstance();
		Field fields[] = cls.getDeclaredFields();
		for(Field f:fields){
			f.setAccessible(true);
			Object obj = f.get(person);
			System.out.println("name:"+f.getName()+"\t value = "+obj);
			String type = f.getType().toString();
			if(type.endsWith("String"))
				f.set(person, "Reus");
			if(type.endsWith("Integer"))
				f.set(person, 24);
		}
		Method methods[] = cls.getDeclaredMethods();
		for(Method m:methods){
			if(m.getName().equals("setName"))
				m.invoke(person, "lxq");
			if(m.getName().equals("setAge"))
				m.invoke(person, 21);
			System.out.println(m);
		}
		Constructor<Person> []constructors = (Constructor<Person>[]) cls.getConstructors();
		for(Constructor<Person> c:constructors){
			System.out.println(c);
		}
		System.out.println(person.toString());
		
		Constructor<Person> col = cls.getConstructor(String.class,Integer.class);
		Person p = col.newInstance("123",123);
		System.out.println(p.toString());
	}
}
