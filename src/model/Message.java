package model;

import java.util.List;


/**
 *
 * 通用消息模版
 *
 */
public class Message<_Ty_Root,_Ty_List> extends BaseBean {
	private Integer code;
	private boolean success;
	private String message;
	private _Ty_Root root;
	private List<_Ty_List> list;
	private Integer totalProperty;
	public Message()
	{
		code = 1;
		message = "";
		root = null;
		list = null;
		totalProperty = 0;
		setSuccess(false);
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
		this.success=code==0?true:false;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public _Ty_Root getRoot() {
		return root;
	}
	public void setRoot(_Ty_Root root) {
		this.root = root;
	}
	public List<_Ty_List> getList() {
		return list;
	}
	public void setList(List<_Ty_List> list) {
		this.list = list;
		this.totalProperty = (list==null?0:list.size());
	}
	public Integer getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(Integer totalProperty) {
		this.totalProperty = totalProperty;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
