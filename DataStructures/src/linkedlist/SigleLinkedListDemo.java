package linkedlist;

import java.beans.Beans;
import java.util.Stack;

public class SigleLinkedListDemo {
	
	//1）	求单链表有效节点的个数
	public static  int getLength(HeroNode head) {
		
		if (head.next==null) {
			return 0;
		}
		
		int count=0;
		HeroNode temp=head.next;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		
		return count;
	}
	
	//2）	查找单链表的倒数第k个节点
	public static HeroNode getLastIndexNode(HeroNode head,int index) {
		//链表为空，返回null
		if (head.next==null) {
			return null;
		}
		int size=getLength(head);
		if (index<=0||index>size) {
			return null;
		}
		HeroNode temp=head.next;
		
		for(int i=0;i<size-index;i++) {
			temp=temp.next;
		}
		
		return temp;
		
	}
	
	//3）	单链表的反转
	//头插法
	public static void reverseList(HeroNode head) {
		if (head.next==null) {
			System.out.println("链表为空...");
			return;
		}
		//遍历传入链表的遍历变量
		HeroNode temp=head.next;
		HeroNode reverseHead=new HeroNode(0, "", "");
		while (temp!=null) {
			HeroNode insertNode=temp;//此处注意java引用的复制，指向堆中同一地址，下面的修改导致temp变为空
			//所以在修改之前先移动temp
			//链表后移
			temp=temp.next;
			//头插法
			insertNode.next=reverseHead.next;
			reverseHead.next=insertNode;
			
		}
		head.next=reverseHead.next;
		
	}
	
	//4）	从尾到头打印单链表
	public static void reversePrint(HeroNode head) {
		if (head.next==null) {
			return;
		}
		Stack<HeroNode> stack=new Stack<HeroNode>();
		HeroNode temp=head.next;
		while(temp!=null) {
			stack.push(temp);
			temp=temp.next;
		}
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
		
		
	}

	public static void main(String[] args) {
		//创建节点
		HeroNode hero1=new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2=new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3=new HeroNode(3, "吴用", "智多星");
		HeroNode hero4=new HeroNode(4, "林冲", "豹子头");
		
		//创建链表
		SigleLinkedList sigleLinkedList=new SigleLinkedList();
//		sigleLinkedList.add(hero1);
//		sigleLinkedList.add(hero3);
//		sigleLinkedList.add(hero2);
//		sigleLinkedList.add(hero4);
		
		System.out.println("按照编号添加：");
		sigleLinkedList.addByOrder(hero1);
		sigleLinkedList.addByOrder(hero3);
		sigleLinkedList.addByOrder(hero2);
		sigleLinkedList.addByOrder(hero4);
		sigleLinkedList.list();
//		
//		sigleLinkedList.update(new HeroNode(4, "林chong", "豹子头"));
//		System.out.println("按照编号修改后：");
//		sigleLinkedList.list();
//		//sigleLinkedList.update(new HeroNode(5, "林chong", "豹子头"));
//		System.out.print("有效节点个数为：");
//		System.out.println(getLength(sigleLinkedList.getHead()));
//		System.out.print("倒数第k个节点为：");
//		System.out.println(getLastIndexNode(sigleLinkedList.getHead(), 2));
		System.out.println("从尾到头打印单链表：");
		reversePrint(sigleLinkedList.getHead());
		System.out.println("反转链表为：");
		reverseList(sigleLinkedList.getHead());
		sigleLinkedList.list();
	}

}

class SigleLinkedList{
	
	//初始化一个头结点，头节点不要动，不存放具体数据
	private HeroNode head =new HeroNode(0, "", "");
	
	public HeroNode getHead() {
		return head;
	}
	
	
	//添加节点到单向链表，找到当前链表的最后节点，将最后节点的next域指向新的节点
	public void add(HeroNode heroNode) {
		//头结点不能动，需要一个辅助变量
		HeroNode temp=head;
		//遍历链表，找到最后
		while(true) {
			if(temp.next==null) {
				break;
			}else {
				temp=temp.next;
			}
		}
		
		//将最后这个节点的next指向新的节点
		temp.next=heroNode;
		
	}
	
	public void addByOrder(HeroNode heroNode) {
		HeroNode temp=head;
		boolean flag=false;
		while(true) {
			if(temp.next==null) {
				break;
			}
			if (temp.next.no>heroNode.no) {
				//找到插入位置
				
				break;
			}else if(temp.next.no==heroNode.no){
				flag=true;
				break;
			}
			temp=temp.next;
		}
		
		if (flag) {
			System.out.println("编号已经存在");
		}else {
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
		
	}
	
	//根据no来修改节点
	public void update(HeroNode heroNode) {
		if (head.next==null) {
			System.out.println("链表为空");
			return;
		}
		
		//找到需要修改的节点位置，使用temp遍历
		HeroNode temp=head.next;
		//表示是否找到该节点
		boolean flag=false;
		while (true) {
			if (temp==null) {
				break;
			}
			if (heroNode.no==temp.no) {
				flag=true;
				break;
			}
			
			temp=temp.next;
		}
		
		if (flag) {
			temp.name=heroNode.name;
			temp.nickname=heroNode.nickname;
		}else {
			System.out.println("没有找到节点");
		}
	}
	
	//删除节点
	public void delete(int no) {
		//通过辅助变量找到待删除节点的前一个节点
		
	}
	
	public void list() {
		//判断链表是否为空
		if (head.next==null) {
			System.out.println("链表为空...");
			return;
		}
		
		//头结点不能动，需要一个辅助变量遍历
		HeroNode temp=head.next;
		while(true) {
			if (temp==null) {
				break;
			}else {
				//输出节点信息
				System.out.println(temp);
				//节点后移
				temp=temp.next;
			}
		}
	}
	
	
	
}


class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	
	public HeroNode(int no,String name,String nickname) {
		this.no=no;
		this.name=name;
		this.nickname=nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
	
}







