/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 1, 2016 9:22:13 AM 
 * @version 1.0 
 *
 */
package util;
import interfaces.JsonCastable;
import interfaces.NeedToJson;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
 
@SuppressWarnings("rawtypes")
public class JsonUtil {
    /** 增加需要额外处理的对象toString */
    public Map<Class,JsonCastable> jsonCast = new HashMap<Class, JsonCastable>();
     
    /**
     * 根据参数类型 路由 获取 返回值字符串
     * @param o 待操作参数可以是 String:将直接进行特殊字符的replace; Number或者boolean:直接输出; 否则调用toJson
     * @return {String} json字符串
     */
    @SuppressWarnings("unchecked")
    public String toJson(Object o){
        if(null == o){
            return null;
        }else if(jsonCast.containsKey(o.getClass())){
            return toJson( jsonCast.get(o.getClass()).cast(o) );
        }else if(o instanceof String){
            return "\"" + ((String)o).replaceAll("\"", "\\\\\"").replaceAll("[\n\r]", "\\\\n").replaceAll("[\\s\\t]+", " ") + "\"";    // ① 双引号 replaceTo \" ; ②换行 replaceTo \n; ③多个空白 replaceTo 1个
        }else if(o instanceof Number || o instanceof Boolean){
            return o.toString();
        }else if( o instanceof Iterable ){
            return listToJson((Iterable<Object>) o);
        }else if( o instanceof Object[] ){
            return arrayToJson((Object[]) o);
        }else if( o instanceof Map){
            return mapToJson((Map<Object, Object>) o);
        }else{
            return ( o instanceof NeedToJson ) ? toJson(toMap(o)) : toJson(o.toString());   // NeedToJson 用来标示 在递归展开的时候需要展现的对象
        }
    }
 
    /**
     * 处理Map型数据
     * @param m
     * @return
     */
    private String mapToJson(Map<Object,Object> m){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (Map.Entry<Object, Object> e : m.entrySet()) {
            String key = e.getKey().toString().replaceAll("[\\W]", "");
            if(key.length()>0 && key.charAt(0)>='0' && key.charAt(0) <= '9'){
                throw new RuntimeException("json-key不要以数字开头");
            }
            sb.append("\"" + key + "\":");
            sb.append(toJson(e.getValue()));
            sb.append(",");
        }
        if( sb.lastIndexOf(",") == sb.length()-1 ){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("}");
        return sb.toString();
    }
 
    /**
     * 处理集合型数据
     * @param list
     * @return
     */
    private String listToJson(Iterable<Object> list){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Object o : list) {
            sb.append( toJson(o) );
            sb.append(",");
        }
        if( sb.lastIndexOf(",") == sb.length()-1 ){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }
 
    /**
     * 处理数组型数据
     * @param list
     * @return
     */
    private String arrayToJson(Object[] list){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (Object o : list) {
            sb.append( toJson(o) );
            sb.append(",");
        }
        if( sb.lastIndexOf(",") == sb.length()-1 ){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }
 
    /**
     * 对象转换为 Map   根据field的get方法
     * @param o   不得为null
     * @return
     */
    public Map<String, Object> toMap(Object o){
        Map<String, Object> map = new HashMap<String, Object>();
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String s = field.getName();
            Class<?> c = field.getType();
            String methodName = ( Boolean.TYPE.equals(c)  ? "is" : "get") +s.substring(0,1).toUpperCase()+s.substring(1);
            try {
                Method method = clazz.getMethod(methodName);
                Object result = method.invoke(o);
                map.put(s,result);
            } catch (Exception e) {
 
            }
        }
        return map;
    }
 
    /**
     * 仅用作标记是否对普通java对象根据field的get方法toMap 然后再 toJSON
     */
}