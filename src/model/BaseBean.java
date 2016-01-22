package model;

import java.io.Serializable;

public abstract class BaseBean implements Cloneable {
	public Serializable getId() {
		return null;
	}
	//去空格
	public String trimStr(String str)
	{
		if(str!=null)
			return str.trim();
		return "";
	}
	//替换   n r 回车 和 空格
	public String replaceNR(String str)
	{
		if(str!=null){
			str=str.replaceAll("\n", "");
			str=str.replaceAll("\r", "");
			return str.trim();
		}		
		return null;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
