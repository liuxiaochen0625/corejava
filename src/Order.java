import java.util.List;


public class Order {
	private String order_by;
	private String order_cvector;

	//默认排序
	public String getDefaultOrder() {
		return "sale";
	}

	//有效排序字段
	public String[] getValidateOrderList() {
		return "sale_price~sale_num~sale_money~stock_num".split("~");
	}

	public String getOrderBy() {
		return order_by;
	}

	public String getOrderVector() {
		return order_cvector;
	}
	
	//升序或降序
	private void setOrderVector(String order_cvector){
		this.order_cvector = order_cvector;
	}
	
	//排序字段
	private void setOrderBy(String order_by){
		this.order_by = order_by;
	}

	//获取排序语句
	public String orderValidate()
	{
		String[] checkOrderList = null;
		String[] checkVectorList = null;
		
		//若不是第一个需要添加一个,
		boolean first = true;
		
		//最终排序语句
		String finalOrder = "";
		
		if(getDefaultOrder().length() > 20)
		{
			return " ";
		}
		
		if(getOrderBy() == null || "".equals(getOrderBy()) || getOrderVector() == null || "".equals(getOrderVector()))
		{
			return " order by " + getDefaultOrder() + " desc";
		}
		else
		{
			checkOrderList = getOrderBy().split("~");
			checkVectorList = getOrderVector().split("~");
			if(checkOrderList.length == 0 || checkOrderList.length != checkVectorList.length)
			{
				return " order by " + getDefaultOrder() + " desc";
			}
			else
			{
				for(int i=0;i < checkOrderList.length;i++)
				{
					for(int j=0;j < getValidateOrderList().length;j++)
					{
						if(getValidateOrderList()[j].length()>20) continue;
						if(getValidateOrderList()[j].equals(checkOrderList[i]))
						{
							if(!first)
							{
								finalOrder += ", ";
							}
							else first = false;
							finalOrder += getValidateOrderList()[j];
							if(checkVectorList[i].toLowerCase().equals("asc"))
								finalOrder+=" asc";
							else finalOrder+=" desc";
						}
					}
				}
			}
		}
		if(first && finalOrder.equals("")) finalOrder = getDefaultOrder() + " desc";
		return " order by " + finalOrder + " ";
	}
	
	public String wildCardSearch(String[] names, List<Object> values, String key)
	{
		String retStr = " and (";
		boolean first = true;
		for (String temp : names) {
			if(!first)
			{
				retStr += " or";
			}
			else first = false;
			retStr += " " + temp + " like ? ";
			values.add("%" + key + "%");
		};
		retStr += ") ";
		return retStr;
	}

	public static void main(String[] args) {
		Order order = new Order();
		order.setOrderBy("stock_num~sale_num");
		order.setOrderVector("desc~asc");
		System.out.println(order.orderValidate());

	}

}
