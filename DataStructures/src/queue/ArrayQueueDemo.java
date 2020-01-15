package queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		
		//创建一个队列
		ArrayQueue arrayQueue=new ArrayQueue(3);
		char key;
		Scanner scanner=new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println("s,显示队列");
			System.out.println("e,退出队列");
			System.out.println("a,添加数据到队列");
			System.out.println("g,从队列取出数据");
			System.out.println("h,查看队列头的数据");
			key=scanner.next().charAt(0);
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop=false;
				System.out.println("程序退出");
				break;
			case 'a':
				try {
					System.out.print("请输入一个数：");
					int data=scanner.nextInt();
					arrayQueue.addQueue(data);
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				break;
			case 'g':
				try {
					int res=arrayQueue.getQueue();
					System.out.println(res);
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res1=arrayQueue.headQueue();
					System.out.println(res1);
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

class ArrayQueue{
	int maxSize;//表示数组最大容量
	int front;//队列头
	int rear;//队列尾
	int[] arr;//存放数据
	
	//创建队列构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize=arrMaxSize;
		arr=new int[maxSize];
		front=-1;//指向队列头的前一个元素
		rear=-1;//指向队列尾的数据
		
	}
	
	//判断队列是否满
	public boolean isFull() {
		return rear==maxSize-1;
		
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return rear==front;
		
	}
	//添加数据到队列
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("queue is full");
		}else {
			rear++;
			arr[rear]=n;
		}
	}
	//出队列
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		}else {
			front++;
			return arr[front];
		}
		
	}
	
	//显示队列数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
		
		
	}
	
	//显示队列头数据
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		}
		return arr[front+1];
	}
	
	
	
	
	
}