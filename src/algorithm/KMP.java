/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 1, 2016 5:15:39 PM 
 * @version 1.0 
 *
 */
package algorithm;

public class KMP {
	public static int[] makeNext(final char P[],int next[])
	{
		next = new int[P.length];
	    int q,k;
	    int m = P.length;
	    next[0] = 0;
	    for (q = 1,k = 0; q < m; ++q)
	    {
	        while(k > 0 && P[q] != P[k])
	            k = next[k-1];
	        if (P[q] == P[k])
	        {
	            k++;
	        }
	        next[q] = k;
	    }
	    return next;
	}

	public static int kmp(final char T[],final char P[],int next[])
	{
	    int n,m;
	    int i,q;
	    n = T.length;
	    m = P.length;
	    next = makeNext(P,next);
	    for (i = 0,q = 0; i < n; ++i)
	    {
	        while(q > 0 && P[q] != T[i])
	            q = next[q-1];
	        if (P[q] == T[i])
	        {
	            q++;
	        }
	        if (q == m){
	        	return i-m+1;
	        }
	    }
	    return -1;
	}

	public static void main(String []args)
	{
		final char []T = new char[]{'B','B','C',' ','A','B','C','D','A','B',' ','A','B','C','D','A','B',
				'C','D','A','B','D','E'}; 
		final char []P = new char[]{'A','B','C','D','A','B','D'}; 
		System.out.println(kmp(T,P,new int[]{}));
	}
}
