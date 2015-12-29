/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 29, 2015 5:28:26 PM 
 * @version 1.0 
 *
 */
package main;

import java.util.concurrent.atomic.AtomicReference;
public class ConcurrentStack<T> {
	private AtomicReference<Node<T>>	stacks	= new AtomicReference<Node<T>>();
	public T push(T e) {
		Node<T> oldNode, newNode;
		for (;;) { // 这里的处理非常的特别，也是必须如此的。
			oldNode = stacks.get();
			newNode = new Node<T>(e, oldNode);
			if (stacks.compareAndSet(oldNode, newNode)) {
				return e;
			}
		}
	}	
	public T pop() {
		Node<T> oldNode, newNode;
		for (;;) {
			oldNode = stacks.get();
			newNode = oldNode.next;
			if (stacks.compareAndSet(oldNode, newNode)) {
				return oldNode.object;
			}
		}
	}	
	private static final class Node<T> {
		private T		object;		
		private Node<T>	next;		
		private Node(T object, Node<T> next) {
			this.object = object;
			this.next = next;
		}
	}	
}
