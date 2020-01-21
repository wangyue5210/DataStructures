package stack;

public class Calculator {

	public static void main(String[] args) {
		//表达式
		String expression="7-2*6+4";
		//创建两个栈，一个数字栈，一个符号栈
		ArrayStack2 numStack=new ArrayStack2(10);
		ArrayStack2 operStack=new ArrayStack2(10);
		//定义所需的变量
		int num1,num2,res;
		int oper;//接收pop出的运算符
		char ch;//遍历得到的数据
		int index=0;//遍历变量
		String keepNum="";
		//开始循环扫描表达式
		while(index<expression.length()) {
			ch=expression.substring(index, index+1).charAt(0);
			//如果不是运算符,是数字就直接入栈
	
			if(!numStack.isOper(ch)) {
				//numStack.push(ch-48);//'1'=>1
				//处理多位数问题
				keepNum+=ch;
				
				//如果是最后一位直接入栈
				if (index==expression.length()-1) {
					numStack.push(Integer.parseInt(keepNum));
				}else {
					//判断下一位是不是操作符，如果是就把之前的拼接的字符串入栈
					if (operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						//清空keepNum
						keepNum="";
					}
				}
				
				
				
			}else {
				//如果是运算符，就分以下情况
				//如果当前符号栈为空，直接入栈
				if (operStack.isEmpty()) {
					operStack.push(ch);
				}else {
					//如果当前符号栈不为空，就比较符号优先级
					//如果当前操作符优先级大于栈顶操作符优先级，直接入栈
					if (operStack.priority(ch)>operStack.priority((char) operStack.peek())) {
						operStack.push(ch);
					}else {
						//如果当前操作符优先级小于等于栈顶操作符优先级
						//从数栈pop两个数
						num1=numStack.pop();
						num2=numStack.pop();
						//从符号栈pop一个运算符
						oper=operStack.pop();
						//进行运算,注意顺序
						res=numStack.cal(num1, num2, oper);
						//将得到的结果，入数栈
						numStack.push(res);
						//将当前操作符入符号栈
						operStack.push(ch);
					}
				}
			}
			//让index递增，往后扫描
			index++;
			
		}
		
		//表达式扫描完毕，就顺序的从数栈和符号栈pop，并运算
		while(!operStack.isEmpty()) {
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		
		System.out.printf("表达式计算：%s = %d",expression,numStack.pop());
		

	}

}

class ArrayStack2{
	public int maxSize;//栈的大小
	public int[] stack;
	public int top=-1;//栈顶初始化为-1
	
	public ArrayStack2(int maxSize) {
		this.maxSize=maxSize;
		stack=new int[maxSize];
	}
	
	//查看栈顶的值，不是出栈
	public int peek() {
		return stack[top];
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
	//比较操作符优先级,数字越大，优先级越高
	public int priority(char oper) {
		if (oper=='*'||oper=='/') {
			return 1;
		}else if (oper=='+'||oper=='-') {
			return 0;
		}else {
			return -1;
		}
	}
	
	//判断是不是一个运算符
	public boolean isOper(char val) {
		return val=='+'||val=='-'||val=='*'||val=='/';
	}
	//计算
	public  int cal(int num1,int num2,int oper) {
		int res=0;
		switch (oper) {
		case '+':
			res=num2+num1;
			break;
		case '-':
			res=num2-num1;
			break;
		case '*':
			res=num2*num1;
			break;
		case '/':
			res=num2/num1;
			break;

		default:
			break;
		}
		return res;
	}
}





