import java.util.*;

public class Knapsack{
	
	public static int solve(int[] items, int index, int sum, int cap) {
		if (index > items.length - 1 || cap == 0) {
			return sum;
		}
		
		int currNo = items[index];
		if(currNo>cap){
		    return solve(items, index+1, sum, cap);
		}
		
		return solve(items, index + 1, sum+1, cap - currNo) +  solve(items, index+1, 0, cap);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] items = new int[num];
		for (int i = 0; i < num; i++) {
			items[i] = sc.nextInt();
		}
		int cap = sc.nextInt();
		
		System.out.println(solve(items, 0, 0, cap) + 1);

		// int cap = 6;
		// System.out.println(solve(new int[]{3,1,7,6,5,4}, 0, 0, cap) + 1);
	}

}