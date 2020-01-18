package linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode2 hero1=new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2=new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3=new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4=new HeroNode2(4, "林冲", "豹子头");
		
		//创建链表
		DoubleLinkedList doubleLinkedList =new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		doubleLinkedList.list();
		doubleLinkedList.delete(3);
		doubleLinkedList.list();


	}

}

class DoubleLinkedList{

	
	//初始化一个头结点，头节点不要动，不存放具体数据
	private HeroNode2 head =new HeroNode2(0, "", "");
	
	public HeroNode2 getHead() {
		return head;
	}
	
	
	//添加节点到双向链表，找到当前链表的最后节点，将最后节点的next域指向新的节点
	public void add(HeroNode2 heroNode) {
		//头结点不能动，需要一个辅助变量
		HeroNode2 temp=head;
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
		heroNode.pre=temp;
		
	}
	
	
	
	//根据no来修改节点
	public void update(HeroNode2 heroNode) {
		if (head.next==null) {
			System.out.println("链表为空");
			return;
		}
		
		//找到需要修改的节点位置，使用temp遍历
		HeroNode2 temp=head.next;
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
		if (head.next==null) {
			System.out.println("链表为空");
			return;
		}
		
		//找到需要删除的节点位置，使用temp遍历
		HeroNode2 temp=head.next;
		//表示是否找到该节点
		boolean flag=false;
		while (true) {
			if (temp==null) {
				break;
			}
			if (no==temp.no) {
				flag=true;
				break;
			}
			
			temp=temp.next;
		}
		
		if (flag) {
			temp.pre.next=temp.next;
			if (temp.next!=null) {
				temp.next.pre=temp.pre;
			}
			
		}else {
			System.out.println("没有找到节点");
		}
	}
	
	public void list() {
		//判断链表是否为空
		if (head.next==null) {
			System.out.println("链表为空...");
			return;
		}
		
		//头结点不能动，需要一个辅助变量遍历
		HeroNode2 temp=head.next;
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



class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;
	
	public HeroNode2(int no,String name,String nickname) {
		this.no=no;
		this.name=name;
		this.nickname=nickname;
	}

	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
	
}