
public class staticVari {
	public static int static_vari = 0;
	public int sta = 0;
	
	public staticVari(){
		static_vari++;
		sta++;
		System.out.println("static_vari:"+static_vari+" "+"sta="+sta);
	}

	
	public static void main(String []args){
		for(int i=0;i<100;i++){
			new staticVari();
		}
	}
}
