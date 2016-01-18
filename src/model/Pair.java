/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 18, 2016 4:07:58 PM 
 * @version 1.0 
 *
 */
package model;

public class Pair <L,R>{
	private L left;
	private R right;
	public Pair(){
		this.left = null;
		this.right = null;
	}
	public Pair(L left,R right){
		this.left = left;
		this.right = right;
	}
	public L getLeft() {
		return left;
	}
	public void setLeft(L left) {
		this.left = left;
	}
	public R getRight() {
		return right;
	}
	public void setRight(R right) {
		this.right = right;
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Pair<L,R> other = (Pair<L,R>)obj;
		if(left == null){
			if(other.left != null)
				return false;
		}else if (!left.equals(other.left))
			return false;
		if(right == null){
			if(other.right != null)
				return false;
		}else if (!right.equals(other.right))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return "[left="+left+",right="+right+"]";
	}
}
