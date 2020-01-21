package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		String suffixExpression="3 4 + 5 * 6 - ";
		List<String> list = getListString(suffixExpression);
		//System.out.println(list);
		int res=cal(list);
		System.out.println("后缀表达式结果为="+res);
		
	}
	
	//将逆波兰表达式放入到ArrarList中
	public static List<String> getListString(String suffixExpression){
		String[] split = suffixExpression.split(" ");
		List<String> list=new ArrayList<String>();
		for (String string : split) {
			list.add(string);
		}
		return list;
	}
	
	public static int cal(List<String> list) {
		//创建一个栈
		Stack<String> stack=new Stack<String>();
		//遍历arraylist
		for (String string : list) {
			//如果是数字直接入栈
			if (string.matches("\\d+")) {
				stack.push(string);
			}else {
				//如果是运算符，弹出栈顶的两个数，计算后将结果入栈
				int num1=Integer.parseInt(stack.pop());
				int num2=Integer.parseInt(stack.pop());
				int res;
				if(string.equals("+")) {
					res=num2+num1;
				}else if(string.equals("-")){
					res=num2-num1;
				}else if(string.equals("*")){
					res=num2*num1;
				}else if(string.equals("/")){
					res=num2/num1;
				}else {
					throw new RuntimeException("表达式错误");
				}
				
				//将结果入栈
				stack.push(""+res);
			}
		}
		return Integer.parseInt(stack.pop());
		
	}

}
