package linkedlist;

public class Joseph {

	public static void main(String[] args) {
		CircleSigleList circleSigleList = new CircleSigleList();
		circleSigleList.add(5);
		circleSigleList.showBoy();
		circleSigleList.countBoy(1, 2, 5);

	}

}


class CircleSigleList{
	public Boy first= null;
	
	public void add(int nums) {
		if (nums<1) {
			System.out.println("nums的值不正确");
			return;
		}
		
		//遍历变量
		Boy temp=null;
		
		//使用for循环创建环形链表
		for (int i = 1; i <=nums; i++) {
			Boy boy=new Boy(i);
			
			if (i==1) {
				first=boy;
				first.next=first;
				temp=first;
			}else {
				temp.next=boy;
				boy.next=first;
				temp=boy;
			}
		}
	}
	
	
	//遍历环形链表
	public void showBoy() {
		if (first==null) {
			System.out.println("链表为空");
			return;
		}
		Boy temp=first;
		
		do {
			System.out.println("编号为："+temp.no);
			temp=temp.next; 
		} while (temp!=first);
	}
	/**
	 * 
	 * @param startNo从第几个小孩开始
	 * @param countNo数几下
	 * @param nums一共有多少小孩
	 */
	
	//根据用户输入，计算出队顺序
	public void countBoy(int startNo,int countNo,int nums) {
		if (first==null||startNo<1||countNo>nums) {
			System.out.println("参数输入有误");
			return;
		}
		//创建辅助指针，指向环形链表的最后一个节点
		Boy temp=first;
		while (temp.next!=first) {
			
			temp=temp.next;
		}
		
		//小孩报数前，移动到开始报数的位置
		for (int i = 0; i < startNo-1; i++) {
			first=first.next;
			temp=temp.next;
		}
		
		//小孩报数时，同时移动countNo-1次
		
		while(temp!=first) {//当圈中不只有一个节点，移动
			for (int i = 0; i < countNo-1; i++) {
				first=first.next;
				temp=temp.next;
			}
			System.out.println("编号为"+first.no+"出圈");
			first=first.next;
			temp.next=first;
		}
		System.out.println("最后一个编号为："+first.no);
		
		
	}
}

//创建一个boy类表示一个节点
class Boy{
	public int no;
	public Boy next;
	public Boy(int no) {
		this.no=no;
	}
}




