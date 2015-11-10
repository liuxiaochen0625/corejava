package chapter.ch12.example;

public class ArrAlg {
	
	public static Pair<String> minmax(String []a){
		
		if(a == null|| a.length == 0)
			return null;
		String min = a[0];
		String max = a[0];
		for(int i=0;i<a.length;i++){
			if(min.compareTo(a[i])>0)
				min = a[i];
			if(max.compareTo(a[i])<0)
				max = a[i];
		}
		return new Pair<String>(min, max);
		
	}

	@SuppressWarnings("unchecked")
	public static <T> T getMiddle(T... a){
		if(a == null || a.length == 0)
			return null;
		return a[a.length/2];
	}
	
	public static <T extends Comparable<T>> T min(T []t){
		if(t == null || t.length == 0)
			return null;
		T smallest = t[0];
		for(int i=0;i<t.length;i++){
			if(smallest.compareTo(t[i])>0)
				smallest = t[i];
		}
		return smallest;
	}
	
	public static void main(String []args){
		String []str = new String[]{"mary","had","a","little","lamp"};
		Pair<String> pair = minmax(str);
		System.out.println(ArrAlg.min(str));
		System.out.println(ArrAlg.getMiddle(1));
		System.out.println(pair.getFirst());
		System.out.println(pair.getSecond());
	}
}
