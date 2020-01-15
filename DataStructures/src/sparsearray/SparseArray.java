package sparsearray;

public class SparseArray {

	public static void main(String[] args) {
		//创建一个11*11的棋盘
		//0表示没有棋子，1表示黑子，2表示蓝子
		int[][] chessArr1=new int [11][11];
		chessArr1[1][2]=1;
		chessArr1[2][3]=2;
		//输出原始的稀疏数组
		System.out.println("原始的二维数组");
		for (int[] row : chessArr1) {
			for (int item : row) {
				System.out.printf("%d  ",item);
			}
			System.out.println();
		}
		
		//遍历二维数组得到有效的数据个数sum
		int sum=0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j]!=0) {
					sum++;
				}
			}
		}
		
		//根据sum创建稀疏数组
		int chessArr[][]=new int[sum+1][3];
		
		//将有效数据存入到稀疏数组中
		chessArr[0][0]=11;
		chessArr[0][1]=11;
		chessArr[0][2]=sum;
		int count=0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j]!=0) {
					count++;
					chessArr[count][0]=i;
					chessArr[count][1]=j;
					chessArr[count][2]=chessArr1[i][j];
				}
			}
		}
		
		//输出稀疏数组
				System.out.println("稀疏数组");
				for (int[] row : chessArr) {
					for (int item : row) {
						System.out.printf("%d  ",item);
					}
					System.out.println();
				}
		//将稀疏数组转成二维数组
			int[][] chessArr2=new int[chessArr[0][0]][chessArr[0][1]];
		//读取稀疏数组赋值给二维数组
			for (int i = 1; i < sum+1; i++) {
				
					chessArr2[chessArr[i][0]][chessArr[i][1]]=chessArr[i][2];
				
				
			}
			
		//输出原始的稀疏数组
			System.out.println("二维数组");
			for (int[] row : chessArr2) {
				for (int item : row) {
					System.out.printf("%d  ",item);
				}
				System.out.println();
			}

	}

}
