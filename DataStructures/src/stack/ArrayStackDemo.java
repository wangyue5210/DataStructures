package stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack arrayStack=new ArrayStack(3);
		
		boolean loop=true;
		String key;
		Scanner scanner=new Scanner(System.in);
		while(loop) {
			System.out.println("show:显示栈");
			System.out.println("exit:退出程序");
			System.out.println("push:入栈");
			System.out.println("pop:出栈");
			System.out.println("请输入你的操作：");
			key=scanner.next();
			switch (key) {
			case "show":
				arrayStack.show();
				break;
			case "exit":
				System.out.println("程序退出");
				break;
			case "push":
				System.out.println("请输入一个数：");
				int value=scanner.nextInt();
				arrayStack.push(value);
				break;
			case "pop":
				int data ;
				try {
					data = arrayStack.pop();
					System.out.println(data);
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				
				break;

			default:
				break;
			}
			
		}

	}

}

class ArrayStack{
	public int maxSize;//栈的大小
	public int[] stack;
	public int top=-1;//栈顶初始化为-1
	
	public ArrayStack(int maxSize) {
		this.maxSize=maxSize;
		stack=new int[maxSize];
	}
	//栈空
	public boolean isEmpty() {
		return top==-1;
	}
	//栈满
	public boolean isFull() {
		return top==maxSize-1;
	}
	//出栈
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("stack is empty...");
			
		}
		int value=stack[top];
		top--;
		return value;
	}
	//入栈
	public void push(int value) {
		if (isFull()) {
			System.out.println("stack is full...");
			return;
		}
		stack[++top]=value;
	}
	//显示栈的数据
	public void show() {
		if (isEmpty()) {
			System.out.println("stack is empty...");
		}
		
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
	
	
}