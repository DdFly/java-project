package lianxi;

import java.util.Enumeration;
import java.util.Stack;

public class ջ {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Stack stack = new Stack();
		stack.push(new Integer(111111));
		stack.push(new Double(135.65));
		stack.push("[arwfa[pwrof[0j");
		printStack(stack);
		System.out.println("111111��λ�ã�"+stack.search(135.65));
		System.out.println("ջ��Ԫ�أ�"+stack.peek());
		System.out.println("Ԫ��"+stack.pop()+"��ջ");
		System.out.println("ջ��Ԫ�أ�"+stack.peek());
		printStack(stack);
	}
	static void printStack(Stack s){
		if (s.empty()){
			System.out.println("��ջ");
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
