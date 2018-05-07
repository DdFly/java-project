package lianxi;

import java.util.Enumeration;
import java.util.Stack;

public class 栈 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Stack stack = new Stack();
		stack.push(new Integer(111111));
		stack.push(new Double(135.65));
		stack.push("[arwfa[pwrof[0j");
		printStack(stack);
		System.out.println("111111的位置："+stack.search(135.65));
		System.out.println("栈顶元素："+stack.peek());
		System.out.println("元素"+stack.pop()+"出栈");
		System.out.println("栈顶元素："+stack.peek());
		printStack(stack);
	}
	static void printStack(Stack s){
		if (s.empty()){
			System.out.println("空栈");
		}
		else{
			Enumeration items=s.elements();
			while(items.hasMoreElements()){
				System.out.println(items.nextElement()+" ");
			}
		}
		System.out.println();
	}
}
